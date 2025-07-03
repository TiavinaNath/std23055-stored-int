package com.hei.school.endpoint.rest.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoredIntController {

  private static final String FILE_NAME = "/tmp/stored-int.txt";

  @GetMapping("/stored-int")
  public String getStoredInt() {
    File file = new File(FILE_NAME);

    try {
      if (file.exists()) {
        String value = Files.readString(file.toPath());
        return "Stored value: " + value;
      } else {
        int random = new Random().nextInt(1000);
        try (FileWriter writer = new FileWriter(file)) {
          writer.write(String.valueOf(random));
        }
        return "Generated and stored: " + random;
      }
    } catch (IOException e) {
      return "Error: " + e.getMessage();
    }
  }
}
