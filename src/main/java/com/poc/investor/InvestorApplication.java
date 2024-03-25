package com.poc.investor;

import com.poc.investor.models.entities.Investor;
import com.poc.investor.services.InvestorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InvestorApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvestorApplication.class, args);
	}
	@Bean
	CommandLineRunner start(InvestorService investorService){
		return args->{
			investorService.save(new Investor(1,"Smail","EL FATHI"));

		};
	}

}
