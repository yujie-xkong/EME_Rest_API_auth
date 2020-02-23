package com.primeeme.restapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class RestapiauthApplicationTests {

	@Autowired
	StringRedisTemplate stringRedisTemplate; //操作 k-v 字符串

	@Autowired
	RedisTemplate redisTemplate;  //k- v 都是对象

	@Test
	void contextLoads() {
		stringRedisTemplate.opsForValue().append("StringKey", "字符串数值");
		String value = stringRedisTemplate.opsForValue().get("StringKey");
		System.out.println(value);
	}

}
