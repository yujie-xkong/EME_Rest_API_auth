package com.primeeme.restapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan({"com.primeeme.restapi.mapper"})
@EnableCaching
public class RestapiauthApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestapiauthApplication.class, args);
	}
}
