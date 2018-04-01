package cn.linxiuyun.dym.service;

import cn.linxiuyun.dym.base.BaseResponse;
import cn.linxiuyun.dym.base.BaseService;
import cn.linxiuyun.dym.model.UserAuthentic;

public interface UserAuthenticService extends BaseService<UserAuthentic> {

    /**
     * 登陆验证
     */
    BaseResponse loginVerify(String username,String password,int userType);

    /**
     * 用户注册
     */
    BaseResponse registerUser(String username,String password,int userType);

    /**
     * 用户退出
     */
    BaseResponse doLogout();

}
