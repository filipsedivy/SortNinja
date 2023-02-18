package com.filipsedivy.services.console;

import com.google.inject.Inject;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class ConsoleService implements ConsoleInterface {

  private final ConsoleValidator consoleValidator;

  @Inject
  public ConsoleService(ConsoleValidator consoleValidator) {
      this.consoleValidator = consoleValidator;
  }

  @Override
  public void run(String[] args) {
    Arguments arguments = this.parseArguments(args);
    this.consoleValidator.validate(arguments);
  }

  private Arguments parseArguments(String[] args) {
    Options options = ConsoleArgument.getOptions();
    CommandLineParser parser = ConsoleArgument.createParser();
    CommandLine cmdLine = null;

    try {
      cmdLine = parser.parse(options, args);
    } catch (ParseException e) {
      System.out.println(e.getMessage());
      System.exit(1);
    }

    return new Arguments(
        cmdLine.getOptionValue("input"),
        cmdLine.getOptionValue("output")
    );
  }
}
