package cn.linxiuyun.dym.service;

import cn.linxiuyun.dym.base.BaseResponse;
import cn.linxiuyun.dym.base.BaseService;
import cn.linxiuyun.dym.model.OrganizationalRelationship;

public interface OrganizationalRelationshipService extends BaseService<OrganizationalRelationship> {
	
    BaseResponse applyRelation(OrganizationalRelationship organizationalRelationship);

    OrganizationalRelationship getCurrentRelation();
}
