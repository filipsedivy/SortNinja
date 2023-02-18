package com.filipsedivy.services.console;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConsoleValidator implements ConsoleValidatorInterface {

  @Override
  public boolean validate(Arguments arguments) {
    Path input = Paths.get(arguments.getInput());

    if (!Files.exists(input)) {
      System.err.println("Input path not exits (--i/-input parameter)");
      return false;
    }

    Path output = Paths.get(arguments.getOutput());

    if (Files.exists(output)) {
      System.err.println("Output path is exists (--o/-output parameter)");
      return false;
    }

    return true;
  }
}
