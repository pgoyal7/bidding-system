package com.cars24.biddingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ServletComponentScan
public class BiddingSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(BiddingSystemApplication.class, args);
	}
}
