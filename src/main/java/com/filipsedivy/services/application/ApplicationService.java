package com.filipsedivy.services.application;

import com.google.inject.Inject;
import com.filipsedivy.services.console.ConsoleService;

public class ApplicationService implements ApplicationInterface {

  private final ConsoleService consoleService;

  @Inject
  public ApplicationService(ConsoleService consoleService) {
    this.consoleService = consoleService;
  }

  @Override
  public void run(String[] args) {
    consoleService.run(args);
  }
}
