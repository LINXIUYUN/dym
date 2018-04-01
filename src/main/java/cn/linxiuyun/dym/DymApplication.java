package cn.linxiuyun.dym;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

  @MapperScan("cn.linxiuyun.dym.mapper")
@SpringBootApplication
public class DymApplication {

	public static void main(String[] args) {
		SpringApplication.run(DymApplication.class, args);
	}

}
