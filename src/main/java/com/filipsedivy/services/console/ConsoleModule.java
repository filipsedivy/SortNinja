package com.filipsedivy.services.console;

import com.google.inject.AbstractModule;

public class ConsoleModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(IConsoleValidatorService.class).to(ConsoleValidatorService.class);
    bind(IConsoleArgumentsService.class).to(ConsoleArgumentsService.class);
  }
}
