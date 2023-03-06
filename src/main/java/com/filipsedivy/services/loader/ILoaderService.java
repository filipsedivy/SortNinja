package com.filipsedivy.services.loader;

import com.filipsedivy.services.sorter.Files;

public interface ILoaderService {

  void loadListFiles();

  void addListener(ILoaderEvent event);

  Files getListFiles();
}
