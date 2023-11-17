package org.woofteam.immortalcultivationplan.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.woofteam.immortalcultivationplan.model.Immortal;

@Mapper
public interface ImmortalDao extends BaseMapper<Immortal> {

    Immortal selectImmortalInfoById(@Param("immortal") Immortal immortal);
    Immortal getImmortalAndAttributeInfo(@Param("immortal") Immortal immortal);
}
