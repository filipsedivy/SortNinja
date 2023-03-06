package com.filipsedivy.services.sorter;

import com.filipsedivy.services.console.Arguments;
import com.filipsedivy.services.loader.ILoaderServiceFactory;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class SorterServiceFactory implements ISorterServiceFactory {

  private final Provider<ILoaderServiceFactory> loaderServiceFactoryProvider;

  @Inject
  public SorterServiceFactory(Provider<ILoaderServiceFactory> loaderServiceFactoryProvider) {
    this.loaderServiceFactoryProvider = loaderServiceFactoryProvider;
  }

  @Override
  public ISorterService create(Arguments arguments) {
    return new SorterService(
        this.loaderServiceFactoryProvider.get(),
        arguments
    );
  }
}
