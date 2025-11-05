package com.niit.lease.web.admin.mapper;

import com.niit.lease.model.entity.SystemPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author liubo
* @description 针对表【system_post(岗位信息表)】的数据库操作Mapper
* @createDate 2023-07-24 15:48:00
* @Entity com.niit.lease.model.SystemPost
*/
@Mapper
public interface SystemPostMapper extends BaseMapper<SystemPost> {

}




