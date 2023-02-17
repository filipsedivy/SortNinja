package com.filipsedivy;

import com.filipsedivy.application.Bootstrap;
import com.filipsedivy.services.application.ApplicationService;

public class Main {

  public static void main(String[] args) {
    try {
      Bootstrap
          .getInstance()
          .create()
          .getInstance(ApplicationService.class)
          .run(args);
    } catch (Throwable exc) {
      System.out.println(exc.getMessage());
    }
  }
}