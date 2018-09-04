package com.udemy;

import com.udemy.entity.CustomerEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class CrmSystemApplication {

  public static void main(String[] args) {
    SpringApplication.run(CrmSystemApplication.class, args);
  }
}
