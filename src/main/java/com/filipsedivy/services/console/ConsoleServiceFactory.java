package com.filipsedivy.services.console;

import com.filipsedivy.services.sorter.ISorterServiceFactory;
import javax.inject.Inject;
import javax.inject.Provider;

public class ConsoleServiceFactory implements IConsoleServiceFactory {

  final private Provider<ISorterServiceFactory> sorterServiceFactoryProvider;

  final private Provider<IConsoleArgumentsService> consoleArgumentsServiceProvider;

  final private Provider<IConsoleValidatorService> consoleValidatorServiceProvider;

  @Inject
  public ConsoleServiceFactory(Provider<ISorterServiceFactory> sorterServiceFactoryProvider,
      Provider<IConsoleArgumentsService> consoleArgumentsServiceProvider,
      Provider<IConsoleValidatorService> consoleValidatorServiceProvider) {
    this.sorterServiceFactoryProvider = sorterServiceFactoryProvider;
    this.consoleArgumentsServiceProvider = consoleArgumentsServiceProvider;
    this.consoleValidatorServiceProvider = consoleValidatorServiceProvider;
  }

  @Override
  public IConsoleService create(String[] args) {
    return new ConsoleService(
        this.sorterServiceFactoryProvider.get(),
        this.consoleArgumentsServiceProvider.get(),
        this.consoleValidatorServiceProvider.get(),
        args
    );
  }
}
