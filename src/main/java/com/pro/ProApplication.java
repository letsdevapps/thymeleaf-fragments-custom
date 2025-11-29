package com.pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class ProApplication {
	public static void main(String[] args) {
		log.info("----- Thymeleaf Fragments Custom | Main -----");
		SpringApplication.run(ProApplication.class, args);
	}
}