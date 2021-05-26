package com.example.springshelltut.command;

import com.example.springshelltut.customizer.ShellHelper;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class EchoCommand {

  public EchoCommand(ShellHelper shellHelper) {
    this.shellHelper = shellHelper;
  }

  private ShellHelper shellHelper;

//  @ShellMethod("Displays greeting message to the user whose name is supplied")
//  public String echo(@ShellOption({"-N", "--name"}) String name) {
//    return String.format("Hello %s! You are running spring shell cli-demo.", name);
//  }


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

}