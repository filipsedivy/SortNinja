package com.filipsedivy.application;

import com.google.inject.Injector;

final public class Bootstrap {

  public static Bootstrap getInstance() throws InstantiationException, IllegalAccessException {
    return Bootstrap.class.newInstance();
  }

  public Injector create() {
    return Container.createInjector();
  }
}
