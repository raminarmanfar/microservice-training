package com.armanfar.microservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/versioning")
public class VersioningPersonController {
    @GetMapping("/v1/person")
    @ResponseBody
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Ramin Armanfar");
    }

    @GetMapping("/v2/person")
    @ResponseBody
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Ramin", "Armanfar"));
    }
}
