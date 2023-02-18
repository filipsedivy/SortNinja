package com.filipsedivy.services.console;

final public class Arguments {

  private final String input;

  private final String output;

  public Arguments(String input, String output) {
    this.input = input;
    this.output = output;
  }

  public String getInput() {
    return input;
  }

  public String getOutput() {
    return output;
  }
}
