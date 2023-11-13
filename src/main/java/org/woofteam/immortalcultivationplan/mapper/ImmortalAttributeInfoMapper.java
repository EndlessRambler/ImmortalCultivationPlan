package org.woofteam.immortalcultivationplan.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.woofteam.immortalcultivationplan.dao.ImmortalAttributeInfo;

import java.util.List;

@Mapper
public interface ImmortalAttributeInfoMapper {
    /**
     *  todo: ImmortalAttributeInfo通用sql
     * @param ImmortalID
     * @return
     */
    List<ImmortalAttributeInfo> selectImmortalAttributeInfoById(@Param("immortal_id")String ImmortalID);
}
