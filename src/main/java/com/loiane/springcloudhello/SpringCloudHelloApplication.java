package com.loiane.springcloudhello;

import com.loiane.springcloudhello.config.yamlconfig;
import com.loiane.springcloudhello.model.Contact;
import com.loiane.springcloudhello.repository.ContactRepository;

import lombok.Data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;


@SpringBootApplication
public class SpringCloudHelloApplication {

	
	
    
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHelloApplication.class, args);
	}

	
	

	
}
