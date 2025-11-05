package com.niit.lease.web.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niit.lease.model.entity.RoomInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.niit.lease.web.app.vo.room.RoomDetailVo;
import com.niit.lease.web.app.vo.room.RoomItemVo;
import com.niit.lease.web.app.vo.room.RoomQueryVo;

/**
* @author liubo
* @description 针对表【room_info(房间信息表)】的数据库操作Service
* @createDate 2023-07-26 11:12:39
*/
public interface RoomInfoService extends IService<RoomInfo> {

    // 房间列表
    IPage<RoomItemVo> pageRoomItemByQuery(Page<RoomItemVo> page, RoomQueryVo queryVo);

    // 房间详情
    RoomDetailVo getDetailById(Long id);

    // 根据公寓id查询房间列表
    IPage<RoomItemVo> pageItemByApartmentId(IPage<RoomItemVo> page, Long id);
}
