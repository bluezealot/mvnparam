package com.hoperun.java2ets.java2ets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Java2etsApplication {

	public static void main(String[] args) {
		log.info("args: "+args.length);
		String evnCallBackPort = System.getenv("CALLBACK_PORT");
		log.info("CALLBACK_PORT: "+evnCallBackPort);
		System.exit(SpringApplication.exit(SpringApplication.run(Java2etsApplication.class, args)));
	}

	// @Bean
	// JedisConnectionFactory jedisConnectionFactory() {
	// 	JedisConnectionFactory jedisConFactory
	// 	= new JedisConnectionFactory();
	// 	jedisConFactory.setHostName("10.50.10.51");
	// 	jedisConFactory.setPort(6379);
	// 	return jedisConFactory;
	// }

	@Bean(name="redisTemplate")
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(factory);
		return template;
	}
}

