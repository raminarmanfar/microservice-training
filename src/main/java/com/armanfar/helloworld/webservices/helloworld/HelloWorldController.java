package com.armanfar.helloworld.webservices.helloworld;

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/hello-world")
public class HelloWorldController {
    @GetMapping()
    public HelloWorldBean helloWorld() {
        return new HelloWorldBean("Hello World!");
    }

    @GetMapping(path = "/{name}")
    public HelloWorldBean helloWorldWithName(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello world, %s", name));
    }
}
