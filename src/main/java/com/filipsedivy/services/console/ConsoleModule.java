package com.filipsedivy.services.console;

import com.google.inject.AbstractModule;

public class ConsoleModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(ConsoleInterface.class).to(ConsoleService.class);
  }
}
