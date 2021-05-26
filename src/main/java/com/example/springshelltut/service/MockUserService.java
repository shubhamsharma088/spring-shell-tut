package com.example.springshelltut.service;

import com.example.springshelltut.model.CliUser;
import org.springframework.stereotype.Service;

@Service
public class MockUserService implements UserService {

  @Override
  public boolean exists(String username) {
    return "admin".equals(username);
  }

  @Override
  public CliUser create(CliUser user) {
    user.setId(10000L);
    return user;
  }

  @Override
  public CliUser update(CliUser user) {
    return user;
  }
}
