package br.com.webfilmes.challengeweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ChallengewebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengewebApplication.class, args);
	}

}
