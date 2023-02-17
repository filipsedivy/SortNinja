package com.filipsedivy.services.console;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;

public class ConsoleArgument {
  public static ArgumentParser create() {
    ArgumentParser parser = ArgumentParsers.newFor("Process").build()
        .defaultHelp(true)
        .description("Set input path");

    parser.addArgument("-i", "--input")
        .nargs("*")
        .help("Set input path");

    parser.addArgument("-o", "--output")
        .nargs("*")
        .help("Set output path");

    return parser;
  }
}
