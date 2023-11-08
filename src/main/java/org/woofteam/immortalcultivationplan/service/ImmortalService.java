package org.woofteam.immortalcultivationplan.service;

import org.woofteam.immortalcultivationplan.dao.Immortal;
import org.woofteam.immortalcultivationplan.dto.BasicImmortalRequest;
import org.woofteam.immortalcultivationplan.dto.ImmortalRequest;

public interface ImmortalService {


    Immortal getImmortalInfo(BasicImmortalRequest basicImmortalRequest);

    void ImmortalRegister(ImmortalRequest immortalRequest);
}
