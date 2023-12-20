package org.woofteam.immortalcultivationplan.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woofteam.immortalcultivationplan.common.message.result.ExceptionEnum;
import org.woofteam.immortalcultivationplan.exception.ResultException;
import org.woofteam.immortalcultivationplan.dao.ImmortalAttributeInfoDao;
import org.woofteam.immortalcultivationplan.dao.ImmortalDao;
import org.woofteam.immortalcultivationplan.message.request.BasicImmortalRequest;
import org.woofteam.immortalcultivationplan.message.request.ImmortalRequest;
import org.woofteam.immortalcultivationplan.message.response.ImmortalInfoVo;
import org.woofteam.immortalcultivationplan.model.Immortal;
import org.woofteam.immortalcultivationplan.service.ImmortalService;

import java.util.UUID;

@Service
public class ImmortalServiceImpl implements ImmortalService {

    @Autowired
    ImmortalDao immortalDao;
    @Autowired
    ImmortalAttributeInfoDao immortalAttributeInfoDao;

    @Override
    public ImmortalInfoVo getImmortalInfo(String id) {
        Immortal immortal = new Immortal();
        immortal.setImmortalId(id);

        Immortal immortalAndAttributeInfo = immortalDao.getImmortalAndAttributeInfo(immortal);
        ImmortalInfoVo immortalInfoVo = new ImmortalInfoVo();
        BeanUtils.copyProperties(immortalAndAttributeInfo, immortalInfoVo);
        return immortalInfoVo;
    }

    @Override
    public ImmortalInfoVo getImmortalInfo(BasicImmortalRequest basicImmortalRequest) {

        Immortal immortal = new Immortal();
        BeanUtils.copyProperties(basicImmortalRequest, immortal);
        // 获取用户基本信息以及属性
        Immortal immortalAndAttributeInfo = immortalDao.getImmortalAndAttributeInfo(immortal);
        ImmortalInfoVo immortalInfoVo = new ImmortalInfoVo();
        BeanUtils.copyProperties(immortalAndAttributeInfo, immortalInfoVo);
        return immortalInfoVo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void ImmortalRegister(ImmortalRequest immortalRequest) throws ResultException {
        // todo: 注册逻辑 添加一个唯一身份信息
        Immortal immortal = new Immortal();
        BeanUtils.copyProperties(immortalRequest, immortal);
        immortal.setImmortalId(UUID.randomUUID().toString());
        try {
            immortalDao.insert(immortal);
        } catch (Exception e) {
            throw new ResultException(ExceptionEnum.USER_DEFINE);
        }
    }
}
