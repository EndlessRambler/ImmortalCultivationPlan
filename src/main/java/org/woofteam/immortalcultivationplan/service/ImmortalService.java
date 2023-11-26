package org.woofteam.immortalcultivationplan.service;

import org.woofteam.immortalcultivationplan.exception.ResultException;
import org.woofteam.immortalcultivationplan.message.request.BasicImmortalRequest;
import org.woofteam.immortalcultivationplan.message.request.ImmortalRequest;
import org.woofteam.immortalcultivationplan.message.response.ImmortalInfoVo;

public interface ImmortalService {

    ImmortalInfoVo getImmortalInfo(String id);

    ImmortalInfoVo getImmortalInfo(BasicImmortalRequest basicImmortalRequest);

    void ImmortalRegister(ImmortalRequest immortalRequest) throws ResultException;
}
