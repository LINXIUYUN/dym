package cn.linxiuyun.dym.service.impl;

import cn.linxiuyun.dym.base.BaseMapper;
import cn.linxiuyun.dym.base.BaseResponse;
import cn.linxiuyun.dym.base.BaseServiceImpl;
import cn.linxiuyun.dym.conf.ReturnCode;
import cn.linxiuyun.dym.model.UserAuthentic;
import cn.linxiuyun.dym.service.UserAuthenticService;
import cn.linxiuyun.dym.util.LoginUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.linxiuyun.dym.mapper.UserInfoMapper;
import cn.linxiuyun.dym.model.UserInfo;
import cn.linxiuyun.dym.service.UserInfoService;

import java.util.HashMap;
import java.util.Map;

@Service("userInfoService")
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo> implements UserInfoService {

	private final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

	@Autowired
	private UserInfoMapper mapper;

	@Autowired
	private UserAuthenticService userAuthenticService;

	@Autowired
	private UserInfoService userInfoService;

	@Override
	public BaseResponse saveOrUpdate(UserInfo userInfo) {
		BaseResponse response;

		if(!saveOrUpdateParamCheck(userInfo)){
			response = new BaseResponse(ReturnCode.PARAM_FAILURE);
			return response;
		}

		try{
			int id = LoginUtil.getLoginUserId();
			if(id>0){
				userInfo.setUserAuthenticId(id);
				UserInfo queryParam = new UserInfo();
				queryParam.setUserAuthenticId(id);
				UserInfo queryResult = userInfoService.getOne(queryParam);
				if(	queryResult==null){
					save(userInfo);
				}else {
					userInfo.setId(queryResult.getId());
					update(userInfo);
				}
				response = new BaseResponse(ReturnCode.OK);
				response.setDetailMsg("保存成功");
			}else{
				response = new BaseResponse(ReturnCode.PROHIBITION);
				response.setDetailMsg("权限不足,请重新登陆");
			}
		}catch (Exception e){
			response = new BaseResponse(ReturnCode.EXCEPTION);
			response.setDetailMsg("系统故障,请与管理员联系.");
			logger.error("数据库异常",e);
		}

		return response;
	}

	@Override
	public BaseMapper<UserInfo> getMapper() {
		return this.mapper;
	}


	@Override
	public UserInfo getCurrentUserInfo() {
		int id = LoginUtil.getLoginUserId();
		UserInfo queryResult = null;
		if(id>0){
			UserInfo queryParam = new UserInfo();
			queryParam.setUserAuthenticId(id);
			queryResult = userInfoService.getOne(queryParam);
		}

		return queryResult;
	}

	/**
	 * 用户信息参数检查
	 */
	private boolean saveOrUpdateParamCheck(UserInfo userInfo){
		if(userInfo.getIsPartyMember()==0){
			if(userInfo.getPartyTime() == null){
				return false;
			}else if(StringUtils.isBlank(userInfo.getPartyProvince())){
				return false;
			}else if(StringUtils.isBlank(userInfo.getPartyCity())){
				return false;
			}else if(StringUtils.isBlank(userInfo.getPartyDistrict())){
				return false;
			}
			return true;
		}else {
			if(userInfo.getPartyTime()!=null){
				return false;
			}else if(StringUtils.isNotBlank(userInfo.getPartyProvince())){
				return false;
			}else if(StringUtils.isNotBlank(userInfo.getPartyCity())){
				return false;
			}else if(StringUtils.isNotBlank(userInfo.getPartyDistrict())){
				return false;
			}
			return true;
		}
	}

}
