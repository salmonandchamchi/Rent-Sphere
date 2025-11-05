package com.niit.lease.web.app.service.impl;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.niit.lease.web.app.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private Client client;

    @Override
    public void sendCode(String phone, String code) {

//        String randomCode = String.format("%06d", new Random().nextInt(999999));
//        System.out.println("短信验证码已发送至" + phone +", 验证码为： " + code);

        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(phone);
        request.setSignName("阿里云短信测试");
        request.setTemplateCode("SMS_154950909");
        request.setTemplateParam("{\"code\":\"" + code + "\"}");

        try {
            client.sendSms(request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
