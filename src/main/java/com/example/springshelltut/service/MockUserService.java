package com.example.springshelltut.service;

import com.example.springshelltut.customizer.ProgressUpdateEvent;
import com.example.springshelltut.model.CliUser;
import java.util.Observable;
import java.util.Observer;


public class MockUserService extends Observable implements UserService {

  private Observer observer;

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

  @Override
  public long updateAll() {
    long numberOfUsers = 2000;
    for (long i = 1; i <= numberOfUsers; i++) {
      // do some operation ...
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      // notify observer of the change
      if (observer != null) {
        String message = "";
        if (i < numberOfUsers) {
          message = ":: please WAIT update operation in progress";
        }
        observer.update(
            this,
            new ProgressUpdateEvent(i, numberOfUsers, message)
        );
      }
    }
    return numberOfUsers;
  }


  public Observer getObserver() {
    return observer;
  }

  public void setObserver(Observer observer) {
    this.observer = observer;
  }
}
