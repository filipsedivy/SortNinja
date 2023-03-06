package com.filipsedivy.services.console;

final public class ConsoleLoader {

  private byte position = 0;

  private String lastLine = "";

  final private char[] listOfCharacterPositions = new char[]{'\\', '|', '/', '-'};

  public void print(String text) {
    char symbol = listOfCharacterPositions[position];

    if (lastLine.length() > text.length()) {
      String temp = "";

      for (int i = 0; i < lastLine.length(); i++) {
        temp += " ";
      }

      if (temp.length() > 1) {
        System.out.print("\r" + temp);
      }
    }

    System.out.print("\r" + "[ " + symbol + " ] " + text);
    lastLine = text;

    nextCharacter();
  }

  private void nextCharacter() {
    position++;

    if (position > listOfCharacterPositions.length) {
      position = 0;
    }
  }
}
