package com.isaiasgabriel.rest_demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "hello world";
    }
}
