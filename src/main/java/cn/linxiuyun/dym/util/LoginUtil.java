package cn.linxiuyun.dym.util;

import cn.linxiuyun.dym.cache.Cache;
import cn.linxiuyun.dym.model.UserAuthentic;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class LoginUtil {

    private static final String LOGIN_COOKIE_KEY = Md5Util.getMd5("LOGIN_COOKIE_KEY_DJ99123");

    private static Cache cache;

    public static boolean isLogin(){
        UserAuthentic userAuthentic = getLoginUserInfo();
        return userAuthentic.getUsername()!=null;
    }

    public static int getLoginUserId(){
        Integer id = getLoginUserInfo().getId();
        if(id!=null){
            return id;
        }else{
            return -1;
        }
    }

    public static int getLoginUserType(){
        Integer userType = getLoginUserInfo().getUserType();
        if(userType!=null){
            return userType;
        }else{
            return -1;
        }
    }

    public static String getLoginUsername(){
        return getLoginUserInfo().getUsername();
    }

    public static void setLoginCookie(String value){
        Cookie[] cookies = getRequest().getCookies();
        Cookie cookie = new Cookie(LOGIN_COOKIE_KEY,value);
        cookie.setPath("/");
        getResponse().addCookie(cookie);
    }

    private static UserAuthentic getLoginUserInfo(){
        HttpServletRequest request = getRequest();
        Cookie[] cookies = request.getCookies();
        UserAuthentic userAuthentic = null;

        for(Cookie cookie : cookies){
            if(StringUtils.equals(LOGIN_COOKIE_KEY,cookie.getName())){
                String cacheKey = cookie.getValue();
                userAuthentic = (UserAuthentic)cache.get(cacheKey);
            }
        }

        if(userAuthentic!=null){
            return userAuthentic;
        }else {
            return new UserAuthentic();
        }
    }

    private static HttpServletResponse getResponse(){
        ServletRequestAttributes ra= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return ra.getResponse();
    }

    private static HttpServletRequest getRequest(){
        ServletRequestAttributes ra= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return ra.getRequest();
    }

    @Autowired
    private void setCache(Cache cache){
        LoginUtil.cache = cache;
    }
}
