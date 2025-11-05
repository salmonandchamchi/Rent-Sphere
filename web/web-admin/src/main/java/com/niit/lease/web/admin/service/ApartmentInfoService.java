package com.niit.lease.web.admin.service;

import com.niit.lease.model.entity.ApartmentInfo;
import com.niit.lease.web.admin.vo.apartment.ApartmentDetailVo;
import com.niit.lease.web.admin.vo.apartment.ApartmentItemVo;
import com.niit.lease.web.admin.vo.apartment.ApartmentQueryVo;
import com.niit.lease.web.admin.vo.apartment.ApartmentSubmitVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author liubo
* @description 针对表【apartment_info(公寓信息表)】的数据库操作Service
* @createDate 2023-07-24 15:48:00
*/
public interface ApartmentInfoService extends IService<ApartmentInfo> {

    // 保存或更新公寓信息
    void saveOrUpdateApartment(ApartmentSubmitVo apartmentSubmitVo);

    // 获取公寓分页列表
    IPage<ApartmentItemVo> pageItem(Page<ApartmentItemVo> page, ApartmentQueryVo queryVo);

    // 获取公寓详情
    ApartmentDetailVo getDetailById(Long id);

    // 删除公寓信息
    void removeByApartmentId(Long id);
}
