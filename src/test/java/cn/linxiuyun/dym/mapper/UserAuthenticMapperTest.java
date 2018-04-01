package cn.linxiuyun.dym.mapper;

import cn.linxiuyun.dym.DymApplicationTests;
import cn.linxiuyun.dym.model.UserAuthentic;
import org.junit.Test;

import javax.annotation.Resource;

public class UserAuthenticMapperTest extends DymApplicationTests{

    @Resource
    private UserAuthenticMapper userAuthenticMapper;

    @Test
    public void queryTest(){
        UserAuthentic userAuthentic = userAuthenticMapper.find(1);
        System.out.println(userAuthentic);
    }

    @Test
    public void insertTest(){
        UserAuthentic userAuthentic = new UserAuthentic();
        userAuthentic.setUsername("admin");
        userAuthentic.setPassword("admin");
        userAuthentic.setUserType(UserAuthentic.ADMINISTRATORS);

        Integer id = userAuthenticMapper.save(userAuthentic);
        System.out.println(id);
    }
}
