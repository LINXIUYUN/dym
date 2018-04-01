package cn.linxiuyun.dym.controller;

import cn.linxiuyun.dym.base.BaseResponse;
import cn.linxiuyun.dym.conf.ReturnCode;
import cn.linxiuyun.dym.service.UserAuthenticService;
import cn.linxiuyun.dym.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserAuthenticService userAuthenticService;

    @PostMapping(value = "/do")
    public BaseResponse doLogin(String username, String password, Integer userType){

        BaseResponse baseResponse;

        baseResponse = baseParamCheck(username,password,userType);
        if(baseResponse==null){
            baseResponse = userAuthenticService.loginVerify(username,password,userType);
        }
        return baseResponse;
    }

    public BaseResponse register(String username,String password, Integer userType){
        BaseResponse baseResponse;

        baseResponse = baseParamCheck(username,password,userType);
        if(baseResponse==null){
            baseResponse = userAuthenticService.registerUser(username,password,userType);
        }

        return baseResponse;
    }

    public BaseResponse logout(){
        return userAuthenticService.doLogout();
    }

    private BaseResponse baseParamCheck(String username,String password,Integer userType){
        BaseResponse baseResponse = null;
        if(username==null){
            baseResponse = new BaseResponse(ReturnCode.PARAM_FAILURE);
            baseResponse.setDetailMsg("用户名不能为空");
        }else if(password==null){
            baseResponse = new BaseResponse(ReturnCode.PARAM_FAILURE);
            baseResponse.setDetailMsg("密码不能为空");
        }else if(userType==null ){
            baseResponse = new BaseResponse(ReturnCode.PARAM_FAILURE);
            baseResponse.setDetailMsg("用户类型不能为空");
        }
        return baseResponse;
    }

}

