package org.woofteam.immortalcultivationplan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.woofteam.immortalcultivationplan.dao.Immortal;
import org.woofteam.immortalcultivationplan.dao.ResultResponse;
import org.woofteam.immortalcultivationplan.dto.BasicImmortalRequest;
import org.woofteam.immortalcultivationplan.dto.ImmortalRequest;
import org.woofteam.immortalcultivationplan.mapper.ImmortalMapperPlus;
import org.woofteam.immortalcultivationplan.service.ImmortalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImmortalServiceImpl implements ImmortalService {
    @Autowired
    ImmortalMapperPlus immortalMapper;


    @Override
    public ResultResponse getImmortalInfo(BasicImmortalRequest basicImmortalRequest) {
        //获取用户信息
        Immortal immortal_info = immortalMapper.selectOne(new QueryWrapper<Immortal>().select().eq("immortal_id",
                basicImmortalRequest.immortalId));

        return null;
    }

    @Override
    public void ImmortalRegister(ImmortalRequest immortalRequest) {
        // todo: 注册逻辑
        Immortal immortal = new Immortal();
        BeanUtils.copyProperties(immortalRequest, immortal);
        immortalMapper.insert(immortal);
    }
}
