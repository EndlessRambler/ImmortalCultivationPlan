package org.woofteam.immortalcultivationplan.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.woofteam.immortalcultivationplan.annonation.ResponseResultBody;
import org.woofteam.immortalcultivationplan.common.message.response.ResultResponse;
import org.woofteam.immortalcultivationplan.message.request.ImmortalRequest;

@RestController
@RequestMapping("/immortal")
public class RedisController {
    @Resource
    private RedisTemplate<String, ImmortalRequest> redisTemplate;
    @PostMapping("/redis/add/string")
    @ResponseResultBody
    public ResultResponse addString(@Validated @RequestBody ImmortalRequest immortalRequest){
        redisTemplate.opsForValue().set(immortalRequest.getImmortalName(),immortalRequest);
        return ResultResponse.success( redisTemplate.opsForValue().get(immortalRequest.getImmortalName()));
    }
}
