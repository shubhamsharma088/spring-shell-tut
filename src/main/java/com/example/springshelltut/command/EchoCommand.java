package com.example.springshelltut.command;

import com.example.springshelltut.customizer.ProgressBar;
import com.example.springshelltut.customizer.ProgressCounter;
import com.example.springshelltut.customizer.ShellHelper;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class EchoCommand {

  private ProgressCounter progressCounter;
  private ProgressBar progressBar;

  public EchoCommand(ProgressCounter progressCounter,
      ProgressBar progressBar, ShellHelper shellHelper) {
    this.progressCounter = progressCounter;
    this.progressBar = progressBar;
    this.shellHelper = shellHelper;
  }

  private ShellHelper shellHelper;


  @ShellMethod("Displays greeting message to the user whose name is supplied")
  public String echo(@ShellOption({"-N", "--name"}) String name) {

    String message = String.format("Hello %s!", name);
    shellHelper.print(message.concat(" (Default style message)"));
    shellHelper.printError(message.concat(" (Error style message)"));
    shellHelper.printWarning(message.concat(" (Warning style message)"));
    shellHelper.printInfo(message.concat(" (Info style message)"));
    shellHelper.printSuccess(message.concat(" (Success style message)"));

    String output = shellHelper.getSuccessMessage(message);
    return output.concat(" You are running spring shell cli-demo.");
  }

  @ShellMethod("Displays progress counter (with spinner)")
  public void progressCounter() throws InterruptedException {
    for (int i = 1; i <= 100; i++) {
      progressCounter.display(i, "Processing");
      Thread.sleep(100);
    }
    progressCounter.reset();
  }

  @ShellMethod("Displays progress bar")
  public void progressBar() throws InterruptedException {
    for (int i = 1; i <= 100; i++) {
      progressBar.display(i);
      Thread.sleep(100);
    }
    progressBar.reset();
  }
}
