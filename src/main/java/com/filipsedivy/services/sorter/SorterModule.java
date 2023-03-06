package com.filipsedivy.services.sorter;

import com.google.inject.AbstractModule;

public class SorterModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(ISorterServiceFactory.class).to(SorterServiceFactory.class);
  }
}
