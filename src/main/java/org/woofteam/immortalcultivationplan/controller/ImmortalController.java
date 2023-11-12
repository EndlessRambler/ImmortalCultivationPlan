package org.woofteam.immortalcultivationplan.controller;

import jakarta.validation.Valid;
import org.woofteam.immortalcultivationplan.dao.ResultResponse;
import org.woofteam.immortalcultivationplan.dto.BasicImmortalRequest;
import org.woofteam.immortalcultivationplan.dto.ImmortalRequest;
import org.woofteam.immortalcultivationplan.service.ImmortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/immortal")
public class ImmortalController {
    @Autowired
    ImmortalService immortalService;

    /**
     * 获取用户基本信息-属性值以及属性说明
     * @param basicImmortalRequest
     * @return
     */
    @PostMapping("/getInfo")
    public ResultResponse getImmortalInfo(@Validated @RequestBody BasicImmortalRequest basicImmortalRequest){
        return   immortalService.getImmortalInfo(basicImmortalRequest);
    }
    @PostMapping("/register")
    public ResultResponse ImmortalRegister(@Valid @RequestBody ImmortalRequest immortalRequest) {
        try {
            immortalService.ImmortalRegister(immortalRequest);
        } catch (Exception e) {
            return new ResultResponse("System error","5001" );
        }
        return new ResultResponse();
    }
    // todo: page immortal info
    @PostMapping("/getList")
    public ResultResponse getImmortals() {
        return new ResultResponse("System");
    }




}
