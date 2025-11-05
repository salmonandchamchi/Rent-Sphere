package com.niit.lease.web.admin.mapper;

import com.niit.lease.model.entity.RoomAttrValue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author liubo
* @description 针对表【room_attr_value(房间&基本属性值关联表)】的数据库操作Mapper
* @createDate 2023-07-24 15:48:00
* @Entity com.niit.lease.model.RoomAttrValue
*/
@Mapper
public interface RoomAttrValueMapper extends BaseMapper<RoomAttrValue> {

}




