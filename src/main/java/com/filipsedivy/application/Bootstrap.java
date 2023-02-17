package com.filipsedivy.application;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.filipsedivy.services.application.ApplicationModule;
import com.filipsedivy.services.console.ConsoleModule;

final public class Bootstrap {

  public static Bootstrap getInstance() throws InstantiationException, IllegalAccessException {
    return Bootstrap.class.newInstance();
  }

  public Injector create() {
    return this.createInjector();
  }

  private Injector createInjector() {
    return Guice.createInjector(
        new ApplicationModule(),
        new ConsoleModule()
    );
  }
}
