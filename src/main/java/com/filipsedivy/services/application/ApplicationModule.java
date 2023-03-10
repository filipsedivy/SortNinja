package com.filipsedivy.services.application;

import com.google.inject.AbstractModule;

public class ApplicationModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(ApplicationInterface.class).to(ApplicationService.class);
  }
}
