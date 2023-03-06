package com.filipsedivy.services.application;

import com.filipsedivy.services.console.IConsoleService;
import com.filipsedivy.services.console.IConsoleServiceFactory;
import com.google.inject.Inject;

public class ApplicationService implements IApplicationService {

  private final IConsoleServiceFactory consoleServiceFactory;

  @Inject
  public ApplicationService(IConsoleServiceFactory consoleServiceFactory) {
    this.consoleServiceFactory = consoleServiceFactory;
  }

  @Override
  public void run(String[] args) {
    IConsoleService consoleService = this.consoleServiceFactory.create(args);
    consoleService.run();
  }
}
