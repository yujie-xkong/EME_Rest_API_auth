package com.primeeme.restapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.primeeme.restapi.mapper"})
public class RestapiauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiauthApplication.class, args);
	}
}
