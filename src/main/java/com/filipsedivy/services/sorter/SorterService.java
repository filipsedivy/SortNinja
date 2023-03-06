package com.filipsedivy.services.sorter;

import com.filipsedivy.services.console.Arguments;
import com.filipsedivy.services.console.ConsoleLoader;
import com.filipsedivy.services.loader.ILoaderEvent;
import com.filipsedivy.services.loader.ILoaderService;
import com.filipsedivy.services.loader.ILoaderServiceFactory;
import com.google.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import me.tongfei.progressbar.ProgressBar;

public class SorterService implements ISorterService {

  private ILoaderServiceFactory loaderServiceFactory;

  private Arguments arguments;

  @Inject
  public SorterService(ILoaderServiceFactory loaderServiceFactory, Arguments arguments) {
    this.loaderServiceFactory = loaderServiceFactory;
    this.arguments = arguments;
  }

  @Override
  public void run() {
    this.checkArguments();
    this.startSort();
  }

  private void startSort() {
    Path inputPath = new File(this.arguments.getInput()).toPath();
    ConsoleLoader consoleLoader = new ConsoleLoader();

    ILoaderService loaderService = this.loaderServiceFactory.create(inputPath);
    loaderService.loadListFiles();
    loaderService.getListFiles();

    try (ProgressBar progressBar = new ProgressBar("Test", 100_000_000)) {
      for (int i = 0; i < 100_000_000; i++) {
        progressBar.step();
        progressBar.setExtraMessage("Test 123 -> " + i);


      }
    }
  }

  private void checkArguments() {
    Path outputPath = Paths.get(this.arguments.getOutput());

    try {
      Files.createDirectories(outputPath);
    } catch (IOException e) {
      System.err.println("Output folder could not be created");
      throw new RuntimeException(e);
    }
  }
}
