package com.filipsedivy.services.console;

import java.io.File;
import java.nio.file.Path;

public final class ConsoleArguments implements IConsoleArguments {

  private final String inputValue;

  private final String outputValue;

  private final boolean skipValue;

  public ConsoleArguments(String inputValue, String outputValue, boolean skipValue) {
    this.inputValue = inputValue;
    this.outputValue = outputValue;
    this.skipValue = skipValue;
  }

  @Override
  public Path getInputPath() {
    return new File(this.getInputValue()).toPath();
  }

  @Override
  public Path getOutputPath() {
    return new File(this.getOutputValue()).toPath();
  }

  @Override
  public String getInputValue() {
    return this.inputValue;
  }

  @Override
  public String getOutputValue() {
    return this.outputValue;
  }

  @Override
  public boolean getSkipValue() {
    return this.skipValue;
  }
}
