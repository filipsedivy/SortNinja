package com.filipsedivy.services.console;

import java.nio.file.Files;
import java.nio.file.Path;

public class ConsoleValidatorService implements IConsoleValidatorService {

  @Override
  public boolean tryValidate(IConsoleArguments arguments) {
    Path input = arguments.getInputPath();

    if (!Files.exists(input)) {
      System.err.println("Input path not exits (--i/-input parameter)");

      if (!arguments.getSkipValue()) {
        return false;
      }
    }

    Path output = arguments.getOutputPath();

    if (Files.exists(output)) {
      System.err.println("Output path is exists (--o/-output parameter)");

      if (!arguments.getSkipValue()) {
        return false;
      }
    }

    return true;
  }
}
