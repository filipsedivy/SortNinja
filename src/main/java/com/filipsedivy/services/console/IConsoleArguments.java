package com.filipsedivy.services.console;

import java.nio.file.Path;

public interface IConsoleArguments {
  Path getInputPath();

  Path getOutputPath();

  String getInputValue();

  String getOutputValue();

  boolean getSkipValue();
}
