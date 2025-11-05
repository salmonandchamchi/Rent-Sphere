package com.niit.lease.web.app.service;

import com.niit.lease.model.entity.ViewAppointment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.niit.lease.web.app.vo.appointment.AppointmentDetailVo;
import com.niit.lease.web.app.vo.appointment.AppointmentItemVo;

import java.util.List;

/**
* @author liubo
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service
* @createDate 2023-07-26 11:12:39
*/
public interface ViewAppointmentService extends IService<ViewAppointment> {

    // 获取用户预约看房信息
    List<AppointmentItemVo> listItemByUserId(Long userId);

    // 获取预约看房信息详情
    AppointmentDetailVo getDetailById(Long id);
}
