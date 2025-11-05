package com.niit.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.niit.lease.common.constant.RedisConstant;
import com.niit.lease.common.exception.LeaseException;
import com.niit.lease.common.result.ResultCodeEnum;
import com.niit.lease.common.utils.JwtUtil;
import com.niit.lease.model.entity.SystemUser;
import com.niit.lease.model.enums.BaseStatus;
import com.niit.lease.web.admin.mapper.SystemUserMapper;
import com.niit.lease.web.admin.service.LoginService;
import com.niit.lease.web.admin.vo.login.CaptchaVo;
import com.niit.lease.web.admin.vo.login.LoginVo;
import com.niit.lease.web.admin.vo.system.user.SystemUserInfoVo;
import com.wf.captcha.SpecCaptcha;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired private StringRedisTemplate stringRedisTemplate;
    @Autowired private SystemUserMapper systemUserMapper;

    @Override
    public CaptchaVo getCaptcha() {

        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);

        String code = specCaptcha.text().toLowerCase();
        String key = RedisConstant.ADMIN_LOGIN_PREFIX + UUID.randomUUID();

        stringRedisTemplate.opsForValue().set(key, code, RedisConstant.ADMIN_LOGIN_CAPTCHA_TTL_SEC, TimeUnit.SECONDS);

        return new CaptchaVo(specCaptcha.toBase64(),  key);
    }

    @Override
    public String login(LoginVo loginVo) {
        //判断输入的验证码是否为空
        if (loginVo.getCaptchaCode() == null){
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_NOT_FOUND);
        }
        String code = stringRedisTemplate.opsForValue().get(loginVo.getCaptchaKey());
        //判断redis中的验证码是否为空或者过期
        if(code == null){
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_EXPIRED);
        }
        //判断输入验证码与redis中的验证码是否一致
        if (!code.equals(loginVo.getCaptchaCode().toLowerCase())){
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_ERROR);
        }

        SystemUser systemUser = systemUserMapper.selectOneByUsername(loginVo.getUsername());

        if (systemUser == null){
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_NOT_EXIST_ERROR);
        }

        if (systemUser.getStatus() == BaseStatus.DISABLE){
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_DISABLED_ERROR);
        }

        if (!systemUser.getPassword().equals(DigestUtils.md5Hex(loginVo.getPassword()))){
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_ERROR);
        }
        return JwtUtil.createJwt(systemUser.getId(), systemUser.getUsername());
    }

    @Override
    public SystemUserInfoVo getLoginUserInfoById(Long userId) {
        SystemUser systemUser = systemUserMapper.selectById(userId);
        SystemUserInfoVo systemUserInfoVo = new SystemUserInfoVo();
        systemUserInfoVo.setName(systemUser.getName());
        systemUserInfoVo.setAvatarUrl(systemUser.getAvatarUrl());
        return systemUserInfoVo;
    }
}
