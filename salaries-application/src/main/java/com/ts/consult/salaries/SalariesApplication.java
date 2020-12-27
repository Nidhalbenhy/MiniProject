package com.ts.consult.salaries;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ts.consult.salaries.model.Salaries;
import com.ts.consult.salaries.repository.SalariesRepository;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

public class SalariesApplication extends SpringBootServletInitializer implements ApplicationRunner {
	
	@Autowired
	private SalariesRepository salariesRepository;

	public static void main(String[] args) {
		SpringApplication.run(SalariesApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		salariesRepository.deleteAll();
		salariesRepository.save(new Salaries("nidhal001", "bhy", "Nidhal", new Date(), "Poissy"));
		
	}
	
	

}
