package com.example.Sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("name")
    public String name() {
      return "Hello Chinna";
    }
}
