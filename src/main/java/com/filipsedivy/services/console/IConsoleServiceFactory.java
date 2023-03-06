package com.filipsedivy.services.console;

public interface IConsoleServiceFactory {
  IConsoleService create(String[] args);
}
