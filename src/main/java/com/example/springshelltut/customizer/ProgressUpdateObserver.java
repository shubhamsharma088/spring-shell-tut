package com.example.springshelltut.customizer;

import java.util.Observable;
import java.util.Observer;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ProgressUpdateObserver implements Observer {


  private ProgressBar progressBar;
  private ShellHelper shellHelper;

  public ProgressUpdateObserver(ProgressBar progressBar,
      ShellHelper shellHelper) {
    this.progressBar = progressBar;
    this.shellHelper = shellHelper;
  }

  @Override
  public void update(Observable observable, Object event) {

    ProgressUpdateEvent upe = (ProgressUpdateEvent) event;
    int currentRecord = upe.getCurrentCount().intValue();
    int totalRecords = upe.getTotalCount().intValue();

    if (currentRecord == 0) {
      // just in case the previous progress bar was interrupted
      progressBar.reset();
    }

    String message = null;
    int percentage = currentRecord * 100 / totalRecords;
    if (StringUtils.hasText(upe.getMessage())) {
      message = shellHelper.getWarningMessage(upe.getMessage());
      progressBar.display(percentage, message);
    }

    progressBar.display(percentage, message);
    if (percentage == 100) {
      progressBar.reset();
    }
  }
}
