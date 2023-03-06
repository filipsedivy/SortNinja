package com.filipsedivy.services.loader;

import com.google.inject.AbstractModule;

public class LoaderModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(ILoaderServiceFactory.class).to(LoaderServiceFactory.class);
  }
}
