package org.woofteam.immortalcultivationplan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.woofteam.immortalcultivationplan.annonation.ResponseResultBody;
import org.woofteam.immortalcultivationplan.message.request.HelloRequest;

@Slf4j
@RequestMapping("/hello")
@RestController
public class HelloController {

    @ResponseResultBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public String hello() {
        return "hello";
    }

    @ResponseResultBody
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("")
    public String hello(@RequestBody HelloRequest request) throws Exception {
        request.checkParams();
        return "hello " + request.getName();
    }

    @ResponseResultBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public String create() {
        return "created";
    }

}
