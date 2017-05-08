package br.com.montreal.ws.controller;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * 
 * @author Horacio
 *
 */
@EntityScan(basePackages = "br.com.montreal.ws.model")
@EnableJpaRepositories(basePackages = "br.com.montreal.ws.model")
@SpringBootApplication(scanBasePackages = "br.com.montreal.ws")

public class StartApplication {
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(StartApplication.class, args);
    }

}
