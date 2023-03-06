package com.filipsedivy.services.console;

import com.filipsedivy.services.application.ApplicationManifest;
import com.filipsedivy.services.sorter.ISorterServiceFactory;
import com.github.lalyos.jfiglet.FigletFont;
import com.google.inject.Inject;
import java.io.IOException;
import org.apache.commons.cli.ParseException;

public class ConsoleService implements IConsoleService {

  private final ISorterServiceFactory sorterServiceFactory;

  private final IConsoleArgumentsService consoleArgumentsService;

  private final IConsoleValidatorService consoleValidatorService;

  private final String[] args;

  @Inject
  public ConsoleService(ISorterServiceFactory sorterServiceFactory,
      IConsoleArgumentsService consoleArgumentsService,
      IConsoleValidatorService consoleValidatorService,
      String[] args) {
    this.sorterServiceFactory = sorterServiceFactory;
    this.consoleArgumentsService = consoleArgumentsService;
    this.consoleValidatorService = consoleValidatorService;
    this.args = args;
  }

  @Override
  public void run() {
    this.printLogo();

    IConsoleArguments arguments = null;

    try {
      arguments = this.consoleArgumentsService.tryParseArguments(this.args);
    } catch (ParseException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }
  }

  private void printLogo() {
    try {
      String logo = FigletFont.convertOneLine(ApplicationManifest.NAME);
      System.out.println(logo);
      System.out.println(ApplicationManifest.DESCRIPTION);
    } catch (IOException ignored) {
    }
  }
}
