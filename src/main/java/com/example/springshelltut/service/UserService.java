package com.example.springshelltut.service;

import com.example.springshelltut.model.CliUser;

public interface UserService {

  boolean exists(String username);

  CliUser create(CliUser user);

  CliUser update(CliUser user);

  long updateAll();
}
