package com.loiane.springcloudhello.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Configuration
@PropertySource("classpath:application.yml")
@EnableConfigurationProperties
@ConfigurationProperties
public class yamlconfig {
  
    private String name;
    private String environment;
    private List<String> servers = new ArrayList<>();
    
    @Value("${value.from.file}")
    private String valueFromFile;
 
    // standard getters and setters
 
}