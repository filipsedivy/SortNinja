package com.filipsedivy.services.loader;

import java.nio.file.Path;

public interface ILoaderEvent {
  void start();
  void load(int i, Path file);
  void end(int total);
}
