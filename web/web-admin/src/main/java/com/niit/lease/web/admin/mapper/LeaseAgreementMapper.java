package com.niit.lease.web.admin.mapper;

import com.niit.lease.model.entity.LeaseAgreement;
import com.niit.lease.web.admin.vo.agreement.AgreementQueryVo;
import com.niit.lease.web.admin.vo.agreement.AgreementVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;

/**
* @author liubo
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Mapper
* @createDate 2023-07-24 15:48:00
* @Entity com.niit.lease.model.LeaseAgreement
*/
@Mapper
public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {

    IPage<AgreementVo> pageAgereementByQuery(IPage<AgreementVo> page, AgreementQueryVo queryVo);
}




