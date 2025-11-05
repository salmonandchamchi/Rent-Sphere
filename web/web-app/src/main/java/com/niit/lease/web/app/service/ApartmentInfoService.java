package com.niit.lease.web.app.service;

import com.niit.lease.model.entity.ApartmentInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.niit.lease.web.app.vo.apartment.ApartmentDetailVo;
import com.niit.lease.web.app.vo.apartment.ApartmentItemVo;

/**
 * @author liubo
 * @description 针对表【apartment_info(公寓信息表)】的数据库操作Service
 * @createDate 2023-07-26 11:12:39
 */
public interface ApartmentInfoService extends IService<ApartmentInfo> {

    // 查询公寓信息
    ApartmentItemVo selectApartmentItemVoById(Long apartmentId);

    // 查询公寓详情
    ApartmentDetailVo getApartmentDetailById(Long id);
}
