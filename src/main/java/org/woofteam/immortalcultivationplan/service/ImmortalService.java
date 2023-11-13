package org.woofteam.immortalcultivationplan.service;

import org.woofteam.immortalcultivationplan.dao.Immortal;
import org.woofteam.immortalcultivationplan.dao.ResultResponse;
import org.woofteam.immortalcultivationplan.dto.BasicImmortalRequest;
import org.woofteam.immortalcultivationplan.dto.ImmortalRequest;

public interface ImmortalService {


    ResultResponse getImmortalInfo(BasicImmortalRequest basicImmortalRequest);

    ResultResponse ImmortalRegister(ImmortalRequest immortalRequest);
}
