package com.filipsedivy.services.sorter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Files {

  private final List<File> files;

  public Files() {
    this.files = new ArrayList<>();
  }

  public void add(String filepath) {
    File file = new File(filepath);
    this.add(file);
  }

  public void add(File file) {
    files.add(file);
  }

  public List<File> getAll() {
    return this.files;
  }

  public void clear() {
    this.getAll().clear();
  }
}
