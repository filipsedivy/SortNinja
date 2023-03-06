package com.filipsedivy.services.loader;

import java.nio.file.Path;

public class LoaderServiceFactory implements ILoaderServiceFactory {

  @Override
  public LoaderService create(Path inputPath) {
    return new LoaderService(inputPath);
  }
}
