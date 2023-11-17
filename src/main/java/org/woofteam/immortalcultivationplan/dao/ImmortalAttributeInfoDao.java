package org.woofteam.immortalcultivationplan.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.woofteam.immortalcultivationplan.model.ImmortalAttributeInfo;

import java.util.List;

@Mapper
public interface ImmortalAttributeInfoDao {
    /**
     *  todo: ImmortalAttributeInfo通用sql
     * @param ImmortalID
     * @return
     */
    List<ImmortalAttributeInfo> selectImmortalAttributeInfoById(@Param("immortal_id")String ImmortalID);
}
