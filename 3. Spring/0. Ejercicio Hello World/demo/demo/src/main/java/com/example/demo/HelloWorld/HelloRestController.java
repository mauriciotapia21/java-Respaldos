package com.example.demo.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @GetMapping("/{name}/{edad}")
    public String HelloWorld(@PathVariable String name, @PathVariable int edad)
    {
        name = name+" Tapia, tu edad es: " + edad;
        return "Hello world, tu nombre es: " + name;
    }
}
