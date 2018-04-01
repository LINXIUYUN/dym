package cn.linxiuyun.dym.service.impl;

import cn.linxiuyun.dym.base.BaseMapper;
import cn.linxiuyun.dym.base.BaseResponse;
import cn.linxiuyun.dym.base.BaseServiceImpl;
import cn.linxiuyun.dym.cache.Cache;
import cn.linxiuyun.dym.conf.ReturnCode;
import cn.linxiuyun.dym.util.LoginUtil;
import cn.linxiuyun.dym.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.linxiuyun.dym.mapper.UserAuthenticMapper;
import cn.linxiuyun.dym.model.UserAuthentic;
import cn.linxiuyun.dym.service.UserAuthenticService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service("userAuthenticService")
public class UserAuthenticServiceImpl extends BaseServiceImpl<UserAuthentic> implements UserAuthenticService {

	private static final String LOGIN_CACHE_KEY_PREFIX = "LOGIN_93882_";
	private static final int DEFAULT_LOGIN_DURATION_TIME = 30*60;

	@Autowired
	private UserAuthenticMapper mapper;

	@Autowired
	private Cache cache;

	@Override
	public BaseResponse loginVerify(String username, String password, int userType) {
		BaseResponse response;

		UserAuthentic userAuthentic =getUser(username,userType);

		if(userAuthentic==null){
			response = new BaseResponse(ReturnCode.VERIFY_FAIL);
			response.setDetailMsg("用户名不存在");
		}else{
			if(Md5Util.verify(password,userAuthentic.getPassword())){
				loginSuccess(userAuthentic);
				response = new BaseResponse(ReturnCode.OK);
				response.setDetailMsg("登陆成功");
			}else{
				response = new BaseResponse(ReturnCode.VERIFY_FAIL);
				response.setDetailMsg("密码错误");
			}
		}

		return response;
	}

	@Override
	public BaseResponse registerUser(String username, String password, int userType) {
		BaseResponse response;

		UserAuthentic userAuthentic =getUser(username,userType);

		if(userAuthentic!=null){
			response = new BaseResponse(ReturnCode.VERIFY_FAIL);
			response.setDetailMsg("用户已存在");
		}else{
			userAuthentic = new UserAuthentic();
			userAuthentic.setUsername(username);
			userAuthentic.setPassword(Md5Util.getMd5(password));
			userAuthentic.setUserType(userType);
			int id = save(userAuthentic);
			if(id>0){
				response = new BaseResponse(ReturnCode.OK);
				response.setDetailMsg("注册成功");
			}else {
				response = new BaseResponse(ReturnCode.FAIL);
				response.setDetailMsg("注册失败,请与管理员联系");
			}
		}
		return  response;
	}

	public BaseResponse doLogout(){
		cache.delete(LoginUtil.getLoginUsername());
		BaseResponse response = new BaseResponse(ReturnCode.OK);
		response.setDetailMsg("退出成功");
		return response;
	}

	private void loginSuccess(UserAuthentic userAuthentic){
		userAuthentic.setPassword(null);
		String uuid = UUID.randomUUID().toString();
		String suffix = Md5Util.getMd5(uuid+Long.toString(System.currentTimeMillis()));
		cache.set(LOGIN_CACHE_KEY_PREFIX+suffix,userAuthentic,DEFAULT_LOGIN_DURATION_TIME);
		LoginUtil.setLoginCookie(LOGIN_CACHE_KEY_PREFIX+suffix);
	}

	private UserAuthentic getUser(String username,int userType){
		Map<String,Object> selectParam = new HashMap<String,Object>(2);
		selectParam.put("username",username);
		selectParam.put("userType",userType);
		return mapper.getOne(selectParam);
	}

	@Override
	public BaseMapper<UserAuthentic> getMapper() {
		return this.mapper;
	}

}
