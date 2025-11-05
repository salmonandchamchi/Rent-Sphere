package com.niit.lease.web.admin.service;

import com.niit.lease.web.admin.vo.login.CaptchaVo;
import com.niit.lease.web.admin.vo.login.LoginVo;
import com.niit.lease.web.admin.vo.system.user.SystemUserInfoVo;

public interface LoginService {

    // 获取图形验证码
    CaptchaVo getCaptcha();

    // 登录
    String login(LoginVo loginVo);

    // 获取登录用户信息
    SystemUserInfoVo getLoginUserInfoById(Long userId);
}
