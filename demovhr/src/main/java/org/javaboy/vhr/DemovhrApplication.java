package org.javaboy.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = "org.javaboy.vhr.mapper")
public class DemovhrApplication {
//public class DemovhrApplication extends SpringBootServletInitializer{

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DemovhrApplication.class);
	}*/

	public static void main(String[] args) {
		SpringApplication.run(DemovhrApplication.class, args);
	}

}
