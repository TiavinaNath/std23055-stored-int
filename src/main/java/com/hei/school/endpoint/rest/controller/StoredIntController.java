package com.hei.school.endpoint.rest.controller;

import com.hei.school.model.StoredInt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoredIntController {
  private final StoredInt storedInt = new StoredInt();

  @GetMapping("/stored-int")
  public int getStoredInt() {
    return storedInt.getValue();
  }
}
