package com.example.playergame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PlayerGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerGameApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
