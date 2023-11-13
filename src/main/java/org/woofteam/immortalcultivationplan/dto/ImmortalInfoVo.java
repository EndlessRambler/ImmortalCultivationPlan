package org.woofteam.immortalcultivationplan.dto;

import lombok.Data;
import org.woofteam.immortalcultivationplan.dao.ImmortalAttributeInfo;

import java.util.List;
@Data
public class ImmortalInfoVo {
    public String immortalId;
    public String immortalName;

    // 用户对应的属性列表
    List<ImmortalAttributeInfo> ImmortalAttributeInfos;

}
