package com.example.springshelltut.config;

import com.example.springshelltut.customizer.ProgressUpdateObserver;
import com.example.springshelltut.service.MockUserService;
import com.example.springshelltut.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceConfig {

  @Bean
  public UserService userService(ProgressUpdateObserver observer) {
    MockUserService userService = new MockUserService();
    userService.setObserver(observer);
    return userService;
  }

}
