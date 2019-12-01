package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("com.example.demo.mapper")
@EnableAutoConfiguration
public class SpringBootMybatisDemoApplication {
	
	@RequestMapping("/") String home() {
        return "Hello World!"; }

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisDemoApplication.class, args);
		//不让banner出现，例如springboot控制台的字样
		/*SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringBootMybatisDemoApplication.class);
		SpringApplication build = builder.build();
		build.setBannerMode(Banner.Mode.OFF);
		build.run(args);*/
	}
}
