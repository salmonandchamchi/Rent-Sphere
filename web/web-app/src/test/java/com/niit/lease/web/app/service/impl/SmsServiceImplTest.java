package com.niit.lease.web.app.service.impl;

import com.niit.lease.web.app.service.SmsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SmsServiceImplTest {

    @Autowired
    SmsService smsService;
    @Test
    void sendCode() {
        SmsServiceImpl smsService = new SmsServiceImpl();
        smsService.sendCode("15043338072", "123456");
    }
}