package cn.linxiuyun.dym.service;

import cn.linxiuyun.dym.base.BaseResponse;
import cn.linxiuyun.dym.base.BaseService;
import cn.linxiuyun.dym.model.UserInfo;

public interface UserInfoService extends BaseService<UserInfo> {
	
    BaseResponse saveOrUpdate(UserInfo userInfo);

    UserInfo getCurrentUserInfo();
}
