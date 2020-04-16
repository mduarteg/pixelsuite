package com.mx.pixelsoft.pixelsuite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@SpringBootApplication
public class PixelsuiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PixelsuiteApplication.class, args);
	}

}
