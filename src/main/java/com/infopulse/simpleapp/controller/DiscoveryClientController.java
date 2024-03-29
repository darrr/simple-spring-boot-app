package com.infopulse.simpleapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscoveryClientController {

  @GetMapping("/my-health-check")
  public ResponseEntity<String> myCustomCheck() {
    String message = "Testing my health check function";
    return new ResponseEntity<>(message, HttpStatus.OK);
  }

}
