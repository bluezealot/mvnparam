package com.hoperun.java2ets.java2ets;

import java.time.Duration;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class Java2etsApplicationTests {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Test
	void contextLoads() {
		TestObj obj = new TestObj();
		obj.setValue1("11111");
		obj.setValue2("2222");
		var value3 = new ArrayList<String>();
		value3.add("content");
		obj.setValue3(value3);
		var operate = redisTemplate.opsForValue();
		operate.setIfAbsent("TestRedis", obj, Duration.ofMinutes(5L));
		var savedData = operate.get("TestRedis");
		System.out.println(savedData);
	}

}
