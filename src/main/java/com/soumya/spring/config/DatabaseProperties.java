package com.soumya.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Data
@Configuration
@PropertySource("classpath:db.properties")
public class DatabaseProperties {
	@Value("${database.url}")
	String url;
	@Value("${database.password}")
	String password;
	@Value("${database.username}")
	String username;
	@Value("${database.driver-class-name}")
	String driverClassName;
}
