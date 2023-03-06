package com.filipsedivy.application;

import com.filipsedivy.services.application.ApplicationModule;
import com.filipsedivy.services.console.ConsoleModule;
import com.filipsedivy.services.loader.LoaderModule;
import com.filipsedivy.services.sorter.SorterModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

final public class Container {

  public static Injector createInjector() {
    return Guice.createInjector(
        new ApplicationModule(),
        new ConsoleModule(),
        new SorterModule(),
        new LoaderModule()
    );
  }
}
