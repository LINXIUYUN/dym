package cn.linxiuyun.dym.service.impl;

import cn.linxiuyun.dym.base.BaseMapper;
import cn.linxiuyun.dym.base.BaseResponse;
import cn.linxiuyun.dym.base.BaseServiceImpl;
import cn.linxiuyun.dym.conf.ReturnCode;
import cn.linxiuyun.dym.model.ApplyTransfer;
import cn.linxiuyun.dym.model.UserInfo;
import cn.linxiuyun.dym.service.ApplyTransferService;
import cn.linxiuyun.dym.util.LoginUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.linxiuyun.dym.mapper.OrganizationalRelationshipMapper;
import cn.linxiuyun.dym.model.OrganizationalRelationship;
import cn.linxiuyun.dym.service.OrganizationalRelationshipService;
import sun.rmi.runtime.Log;

import java.util.Date;

@Service("organizationalRelationshipService")
public class OrganizationalRelationshipServiceImpl extends BaseServiceImpl<OrganizationalRelationship> implements OrganizationalRelationshipService {

	@Autowired
	private OrganizationalRelationshipMapper mapper;

	@Autowired
	private ApplyTransferService applyTransferService;

	@Override
	public BaseResponse applyRelation(OrganizationalRelationship organizationalRelationship) {
		boolean tpFlag = StringUtils.isNotBlank(organizationalRelationship.getTurnOutProvince());
		boolean tcFlag = StringUtils.isNotBlank(organizationalRelationship.getTurnOutCity());
		boolean tdFlag = StringUtils.isNotBlank(organizationalRelationship.getTurnOutDistrict());
		if(tpFlag&&tcFlag&&tdFlag){
			ApplyTransfer applyTransfer = new ApplyTransfer();
			applyTransfer.setApplyDate(new Date());
			applyTransfer.setTransferArea("");
			applyTransfer.setIsApply(1);
			//applyTransferService.save(applyTransfer);
		}

		return new BaseResponse(saveOrUpdate(organizationalRelationship));
	}


	private ReturnCode saveOrUpdate(OrganizationalRelationship organizationalRelationship){
		organizationalRelationship.setUserAuthenticId(LoginUtil.getLoginUserId());

		OrganizationalRelationship queryParam = new OrganizationalRelationship();
		queryParam.setUserAuthenticId(LoginUtil.getLoginUserId());
		OrganizationalRelationship result = getOne(queryParam);

		if(result==null){
			save(organizationalRelationship);
		}else {
			System.out.println("=============");
			organizationalRelationship.setId(result.getId());
			update(organizationalRelationship);
		}

		System.out.println("123");
		return ReturnCode.OK;
	}

	@Override
	public OrganizationalRelationship getCurrentRelation() {
		int id = LoginUtil.getLoginUserId();
		OrganizationalRelationship queryResult = null;
		if(id>0){
			OrganizationalRelationship queryParam = new OrganizationalRelationship();
			queryParam.setUserAuthenticId(id);
			queryResult = getOne(queryParam);
		}
		return queryResult;
	}

	@Override
	public BaseMapper<OrganizationalRelationship> getMapper() {
		return this.mapper;
	}

}
