package com.filipsedivy.services.console;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class ConsoleArgument {

  public static Options getOptions() {
    Options options = new Options();

    Option input = new Option("i", "input", true, "Input file");
    input.setRequired(true);
    options.addOption(input);

    Option output = new Option("o", "output", true, "Output directory");
    output.setRequired(true);
    options.addOption(output);

    return options;
  }

  public static CommandLineParser createParser() {
    return new DefaultParser();
  }

  public static HelpFormatter createHelpFormatter() {
    return new HelpFormatter();
  }
}
