package com.filipsedivy.services.console;

public class ConsoleValidator implements ConsoleValidatorInterface {

  @Override
  public boolean validate(Arguments arguments) {
    System.err.println("Err");
    return false;
  }
}
