package org.woofteam.immortalcultivationplan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.woofteam.immortalcultivationplan.dao.Immortal;
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
    public Immortal getImmortalInfo(BasicImmortalRequest basicImmortalRequest) {
        return immortalMapper.selectOne(new QueryWrapper<Immortal>().select().eq("immortal_id",
                basicImmortalRequest.immortalId));
    }

    @Override
    public void ImmortalRegister(ImmortalRequest immortalRequest) {
        Immortal immortal = new Immortal();
        BeanUtils.copyProperties(immortalRequest, immortal);
        immortalMapper.insert(immortal);
    }
}
