package org.woofteam.immortalcultivationplan.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
        return  immortalService.getImmortalInfo(basicImmortalRequest);
    }

    /**
     *  注册逻辑
     * @param immortalRequest
     * @return
     */
    @PostMapping("/register")
    public ResultResponse ImmortalRegister(@Valid @RequestBody ImmortalRequest immortalRequest) {
        try {
            immortalService.ImmortalRegister(immortalRequest);
        } catch (Exception e) {
            return new ResultResponse("System error","5001" );
        }
        return new ResultResponse();
    }
    //  todo: page immortal info 暂时不需要
    @PostMapping("/getList")
    public ResultResponse getImmortals() {
        return new ResultResponse("System");
    }


    @GetMapping("/getImmortalInfo")
    public ResultResponse getImmortalInfo(@RequestParam("id") @NotBlank String id){
        return new ResultResponse<>();
    }

    // todo: 用户模板设置
    @PostMapping("/set/AttributeInfo")
    public ResultResponse setAttributeInfoTemplate(@RequestParam("id") @NotBlank String id){
        return new ResultResponse<>();
    }
}
