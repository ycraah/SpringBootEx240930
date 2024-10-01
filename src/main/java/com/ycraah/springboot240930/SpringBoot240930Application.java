package com.ycraah.springboot240930;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringBoot240930Application {

  public static void main(String[] args) {
    SpringApplication.run(SpringBoot240930Application.class, args);
  }
}

