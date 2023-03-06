package com.filipsedivy.services.loader;

import java.nio.file.Path;

public interface ILoaderServiceFactory {

  LoaderService create(Path inputPath);
}
