package br.com.m4rc310.cb;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import jakarta.annotation.PostConstruct;

@SpringBootApplication()
@ComponentScan(basePackages = "br.com.m4rc310.cb")
@PropertySource(ignoreResourceNotFound = true, value = "classpath:/security.properties")
public class CbApplication {

	public static void main(String[] args) {
		SpringApplication.run(CbApplication.class, args);
	}

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
	}
}
