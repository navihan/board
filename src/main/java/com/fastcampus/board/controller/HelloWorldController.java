package com.fastcampus.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

    @GetMapping("/hello1")
    public String helloWorld(){
        return "Hello, world";
    }

}