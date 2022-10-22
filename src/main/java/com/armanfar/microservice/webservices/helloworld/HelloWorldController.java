package com.armanfar.microservice.webservices.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController()
@RequestMapping("/hello-world")
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping()
    public HelloWorldBean helloWorld() {
        return new HelloWorldBean("Hello World!");
    }

    @GetMapping(path = "/{name}")
    public HelloWorldBean helloWorldWithName(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello world, %s", name));
    }

    @GetMapping("/i18n/{name}")
    public String sayGoodMorningInternationalized(@PathVariable String name) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale) + ", " + name + "!";
    }
}
