package org.woofteam.immortalcultivationplan.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.woofteam.immortalcultivationplan.annonation.ImmortalPrivileges;
import org.woofteam.immortalcultivationplan.annonation.ResponseResultBody;
import org.woofteam.immortalcultivationplan.common.message.response.ResultResponse;
import org.woofteam.immortalcultivationplan.exception.ResultException;
import org.woofteam.immortalcultivationplan.message.request.BasicImmortalRequest;
import org.woofteam.immortalcultivationplan.message.request.ImmortalRequest;
import org.woofteam.immortalcultivationplan.message.response.ImmortalInfoVo;
import org.woofteam.immortalcultivationplan.service.ImmortalService;

@RestController
@RequestMapping("/immortal")
public class ImmortalController {

    final ImmortalService immortalService;

    @Autowired
    public ImmortalController(ImmortalService immortalService) {
        this.immortalService = immortalService;
    }

    /**
     * 获取用户基本信息-属性值以及属性说明
     *
     * @param basicImmortalRequest
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ImmortalPrivileges
    @PostMapping("/getInfo")
    public ImmortalInfoVo getImmortalInfo(
            @Validated @RequestBody BasicImmortalRequest basicImmortalRequest) {
        return immortalService.getImmortalInfo(basicImmortalRequest);
    }

    /**
     * 注册逻辑
     *
     * @param immortalRequest
     * @return
     */
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseResultBody
    @PostMapping("/register")
    public ResultResponse ImmortalRegister(@Valid @RequestBody ImmortalRequest immortalRequest)
            throws ResultException {
        immortalService.ImmortalRegister(immortalRequest);
        return ResultResponse.success();
    }

    //  todo: page immortal info 暂时不需要
    @GetMapping("/getList")
    @ResponseResultBody
    public Object getImmortals() {
        return null;
    }


    @ResponseStatus(HttpStatus.OK)
    @ResponseResultBody
    @GetMapping("/getImmortalInfo/{id}")
    public ImmortalInfoVo getImmortalInfo(@NotBlank @PathVariable("id") String id) {
        return immortalService.getImmortalInfo(id);
    }

    // todo: 用户模板设置
    @ResponseStatus(HttpStatus.OK)
    @ResponseResultBody
    @PostMapping("/set/AttributeInfo/{id}")
    public Object setAttributeInfoTemplate(@NotBlank @PathVariable("id") String id) {
        return null;
    }
}
