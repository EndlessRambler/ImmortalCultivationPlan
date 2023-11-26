package org.woofteam.immortalcultivationplan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.woofteam.immortalcultivationplan.annonation.ImmortalPrivileges;
import org.woofteam.immortalcultivationplan.annonation.ResponseResultBody;
import org.woofteam.immortalcultivationplan.common.message.response.ResultResponse;
import org.woofteam.immortalcultivationplan.message.request.HelloRequest;
import org.woofteam.immortalcultivationplan.utils.JWTUtils;

@Slf4j
@RequestMapping("/hello")
@RestController
public class HelloController {

    @ResponseStatus(HttpStatus.OK)
    @ImmortalPrivileges
    @GetMapping("")
    public ResultResponse hello() {
        return ResultResponse.success();
    }

    @ResponseStatus(HttpStatus.OK)
    @ImmortalPrivileges
    @PostMapping("")
    public String hello(@RequestBody HelloRequest request) throws Exception {
        request.checkParams();
        return "hello " + request.getName();
    }
    @ResponseResultBody
    @GetMapping("/get")
    public String getImmortalToken(){
        return JWTUtils.generateToken("111");
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public String create() {
        return "created";
    }

}
