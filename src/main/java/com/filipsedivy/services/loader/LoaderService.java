package com.filipsedivy.services.loader;

import com.filipsedivy.services.sorter.Files;
import com.google.inject.Inject;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LoaderService implements ILoaderService {

  private final Files files;

  private final Path inputPath;

  private final List<ILoaderEvent> listeners = new ArrayList<>();

  private int iterator = 0;

  @Inject
  public LoaderService(Path inputPath) {
    File file = inputPath.toFile();

    if (!file.exists()) {
      throw new RuntimeException("Input path is not exists");
    }

    if (!file.isDirectory()) {
      throw new RuntimeException("Input path is not directory");
    }

    this.files = new Files();
    this.inputPath = inputPath;
  }

  @Override
  public void loadListFiles() {
    this.iterator = 0;
    this.files.clear();

    listeners.forEach(ILoaderEvent::start);
    this.loadFiles(this.inputPath);

    listeners.forEach(e -> e.end(this.iterator));
  }

  @Override
  public Files getListFiles() {
    return this.files;
  }

  @Override
  public void addListener(ILoaderEvent event) {
    this.listeners.add(event);
  }

  private void loadFiles(Path path) {
    File directory = path.toFile();
    File[] files = directory.listFiles();

    if (files != null) {
      for (File file : files) {
        if (file.isDirectory()) {
          this.loadFiles(file.toPath());
        } else {
          this.getListFiles().add(file);
          listeners.forEach(e -> e.load(this.iterator, file.toPath()));
          this.iterator++;
        }
      }
    }
  }
}