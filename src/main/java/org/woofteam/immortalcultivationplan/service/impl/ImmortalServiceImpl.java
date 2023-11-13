package org.woofteam.immortalcultivationplan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.woofteam.immortalcultivationplan.dao.Immortal;
import org.woofteam.immortalcultivationplan.dao.ImmortalAttributeInfo;
import org.woofteam.immortalcultivationplan.dao.ResultResponse;
import org.woofteam.immortalcultivationplan.dto.BasicImmortalRequest;
import org.woofteam.immortalcultivationplan.dto.ExceptionEnum;
import org.woofteam.immortalcultivationplan.dto.ImmortalInfoVo;
import org.woofteam.immortalcultivationplan.dto.ImmortalRequest;
import org.woofteam.immortalcultivationplan.mapper.ImmortalAttributeInfoMapper;
import org.woofteam.immortalcultivationplan.mapper.ImmortalMapper;
import org.woofteam.immortalcultivationplan.mapper.ImmortalMapperPlus;
import org.woofteam.immortalcultivationplan.service.ImmortalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImmortalServiceImpl implements ImmortalService {
    @Autowired
    ImmortalMapperPlus immortalMapperPlus;
    @Autowired
    ImmortalMapper immortalMapper;
    @Autowired
    ImmortalAttributeInfoMapper immortalAttributeInfoMapper;
    @Override
    public ResultResponse getImmortalInfo(BasicImmortalRequest basicImmortalRequest) {

        Immortal immortal = new Immortal();
        BeanUtils.copyProperties(basicImmortalRequest,immortal);
        // 获取用户基本信息以及属性
        Immortal immortalAndAttributeInfo = immortalMapper.getImmortalAndAttributeInfo(immortal);
        ImmortalInfoVo immortalInfoVo = new ImmortalInfoVo();
        BeanUtils.copyProperties(immortalAndAttributeInfo,immortalInfoVo);
        return new ResultResponse(immortalInfoVo);
    }

    @Override
    public ResultResponse ImmortalRegister(ImmortalRequest immortalRequest) {
        // todo: 注册逻辑
        //
        Immortal immortal = immortalMapperPlus.selectById(Immortal.class);
        if (immortal!=null){
            return ResultResponse.setFailed(ExceptionEnum.USER_DEFINE);
        }
        immortal= new Immortal();
        BeanUtils.copyProperties(immortalRequest, immortal);
        try {
            immortalMapperPlus.insert(immortal);
        }catch (Exception e) {
            // todo 自定义异常类 处理Sql异常
        }
        return ResultResponse.success();
    }
}
