package com.filipsedivy.services.console;

import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

public class ConsoleService implements ConsoleInterface {

  @Override
  public void run(String[] args) {
    ArgumentParser parser = ConsoleArgument.create();
    Namespace ns = null;

    try {
      ns = parser.parseArgs(args);
    } catch (ArgumentParserException e) {
      parser.handleError(e);
      System.exit(1);
    }
  }
}
