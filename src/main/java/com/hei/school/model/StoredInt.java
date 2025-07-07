package com.hei.school.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class StoredInt {
  private static final Path FILE_PATH = Path.of("/tmp/stored-int.txt");

  public int getValue() {
    try {
      if (Files.exists(FILE_PATH)) {
        String content = Files.readString(FILE_PATH).trim();
        return Integer.parseInt(content);
      } else {
        int randomInt = new Random().nextInt(1000);
        Files.writeString(FILE_PATH, String.valueOf(randomInt));
        return randomInt;
      }
    } catch (IOException | NumberFormatException e) {
      throw new RuntimeException("Failed to process stored integer file", e);
    }
  }
}
