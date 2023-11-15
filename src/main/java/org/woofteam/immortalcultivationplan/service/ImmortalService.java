package org.woofteam.immortalcultivationplan.service;

import org.woofteam.immortalcultivationplan.vo.ResultResponse;
import org.woofteam.immortalcultivationplan.dto.BasicImmortalRequest;
import org.woofteam.immortalcultivationplan.dto.ImmortalRequest;

public interface ImmortalService {


    ResultResponse getImmortalInfo(BasicImmortalRequest basicImmortalRequest);

    ResultResponse ImmortalRegister(ImmortalRequest immortalRequest);
}
