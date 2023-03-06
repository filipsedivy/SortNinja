package com.filipsedivy.services.console;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public interface IConsoleArgumentsService {
  IConsoleArguments tryParseArguments(String[] args) throws ParseException;

  CommandLineParser createCommandLineParser();

  Options getOptions();
}
