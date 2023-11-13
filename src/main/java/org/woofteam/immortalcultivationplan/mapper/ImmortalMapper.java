package org.woofteam.immortalcultivationplan.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.woofteam.immortalcultivationplan.dao.Immortal;
import org.woofteam.immortalcultivationplan.dto.ImmortalInfoVo;

@Mapper
public interface ImmortalMapper {

    Immortal selectImmortalInfoById(@Param("immortal") Immortal immortal);
    Immortal getImmortalAndAttributeInfo(@Param("immortal") Immortal immortal);
}
