package cn.linxiuyun.dym;

import cn.linxiuyun.dym.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DymApplicationTests {

	@Autowired
	private UserInfoService userInfoService;

	@Test
	public void contextLoads() {
		userInfoService.count(null);
	}

}
