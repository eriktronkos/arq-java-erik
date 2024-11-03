package br.edu.infnet.erik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ErikApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErikApplication.class, args);
	}

}
