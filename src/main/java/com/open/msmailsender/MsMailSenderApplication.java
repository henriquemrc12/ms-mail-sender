package com.open.msmailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class MsMailSenderApplication {

	public static void main(String[] args) {
		SpringApplication.un(MsMailSenderApplication.class, args);
	}

}
