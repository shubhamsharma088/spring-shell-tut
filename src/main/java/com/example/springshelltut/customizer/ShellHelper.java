package com.example.springshelltut.customizer;

import static com.example.springshelltut.customizer.PromptColor.*;
import static com.example.springshelltut.customizer.PromptColor.valueOf;
import static org.jline.utils.AttributedStyle.DEFAULT;

import org.jline.terminal.Terminal;
import org.jline.utils.AttributedStringBuilder;
import org.springframework.beans.factory.annotation.Value;

public class ShellHelper {

  @Value("${shell.out.info}")
  public String infoColor;

  @Value("${shell.out.success}")
  public String successColor;

  @Value("${shell.out.warning}")
  public String warningColor;

  @Value("${shell.out.error}")
  public String errorColor;

  private Terminal terminal;

  public ShellHelper(Terminal terminal) {
    this.terminal = terminal;
  }

  public String getColored(String message, PromptColor color) {
    return (new AttributedStringBuilder())
        .append(
            message,
            DEFAULT.foreground(color.toJLineAttributedStyle())
        )
        .toAnsi();
  }

  public String getInfoMessage(String message) {
    return getColored(message, valueOf(infoColor));
  }

  public String getSuccessMessage(String message) {
    return getColored(message, valueOf(successColor));
  }

  public String getWarningMessage(String message) {
    return getColored(message, valueOf(warningColor));
  }

  public String getErrorMessage(String message) {
    return getColored(message, valueOf(errorColor));
  }

  /**
   * Print message to the console in the default color.
   *
   * @param message message to print
   */
  public void print(String message) {
    print(message, null);
  }

  /**
   * Print message to the console in the success color.
   *
   * @param message message to print
   */
  public void printSuccess(String message) {
    print(message, valueOf(successColor));
  }

  /**
   * Print message to the console in the info color.
   *
   * @param message message to print
   */
  public void printInfo(String message) {
    print(message, valueOf(infoColor));
  }

  /**
   * Print message to the console in the warning color.
   *
   * @param message message to print
   */
  public void printWarning(String message) {
    print(message, valueOf(warningColor));
  }

  /**
   * Print message to the console in the error color.
   *
   * @param message message to print
   */
  public void printError(String message) {
    print(message, valueOf(errorColor));
  }

  /**
   * Generic Print to the console method.
   *
   * @param message message to print
   * @param color   (optional) prompt color
   */
  public void print(String message, PromptColor color) {
    String toPrint = message;
    if (color != null) {
      toPrint = getColored(message, color);
    }
    terminal.writer().println(toPrint);
    terminal.flush();
  }
}