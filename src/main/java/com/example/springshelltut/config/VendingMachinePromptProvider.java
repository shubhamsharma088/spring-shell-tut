package com.example.springshelltut.config;

import static org.jline.utils.AttributedStyle.BLUE;
import static org.jline.utils.AttributedStyle.DEFAULT;

import org.jline.utils.AttributedString;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

@Component
public class VendingMachinePromptProvider implements PromptProvider {

  @Override
  public AttributedString getPrompt() {
    return new AttributedString("vending-machine:>",
        DEFAULT.foreground(BLUE)
    );
  }
}
