package com.filipsedivy.services.console;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

final public class ConsoleArgumentsService implements IConsoleArgumentsService {

  @Override
  public IConsoleArguments tryParseArguments(String[] args) throws ParseException {
    CommandLine cmdLine;
    CommandLineParser cmdLineParser = this.createCommandLineParser();
    Options options = this.getOptions();

    cmdLine = cmdLineParser.parse(options, args);

    return new ConsoleArguments(
        cmdLine.getOptionValue("input"),
        cmdLine.getOptionValue("output"),
        cmdLine.hasOption("skip")
    );
  }

  @Override
  public CommandLineParser createCommandLineParser() {
    return DefaultParser.builder().build();
  }

  @Override
  public Options getOptions() {
    Options options = new Options();

    Option inputOption = new Option("i", "input", true, "Input path");
    inputOption.setRequired(true);
    options.addOption(inputOption);

    Option outputOption = new Option("o", "output", true, "Output path");
    outputOption.setRequired(true);
    options.addOption(outputOption);

    Option skipOption = new Option("s", "skip", false, "Skip warnings");
    options.addOption(skipOption);

    return options;
  }
}
