package com.sample.restApi.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages ={"com.sample.restApi", "com.sample.services.*"})
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}