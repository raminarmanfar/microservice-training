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

    @GetMapping(path = "/person", params = "version=1")
    @ResponseBody
    public PersonV1 getFirstVersionOfPersonParameter() {
        return new PersonV1("Ramin Armanfar");
    }

    @GetMapping(path = "/person", params = "version=2")
    @ResponseBody
    public PersonV2 getSecondVersionOfPersonParameter() {
        return new PersonV2(new Name("Ramin", "Armanfar"));
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=1")
    @ResponseBody
    public PersonV1 getFirstVersionOfPersonRequestHeader() {
        return new PersonV1("Ramin Armanfar");
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=2")
    @ResponseBody
    public PersonV2 getSecondVersionOfPersonRequestHeader() {
        return new PersonV2(new Name("Ramin", "Armanfar"));
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    @ResponseBody
    public PersonV1 getFirstVersionOfPersonAcceptHeader() {
        return new PersonV1("Ramin Armanfar");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    @ResponseBody
    public PersonV2 getSecondVersionOfPersonAcceptHeader() {
        return new PersonV2(new Name("Ramin", "Armanfar"));
    }
}
