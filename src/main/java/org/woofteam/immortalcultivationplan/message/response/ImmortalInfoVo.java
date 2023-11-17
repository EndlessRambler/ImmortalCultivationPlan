package org.woofteam.immortalcultivationplan.message.response;

import lombok.Data;
import org.woofteam.immortalcultivationplan.model.ImmortalAttributeInfo;

import java.util.List;
@Data
public class ImmortalInfoVo {
    public String immortalId;
    public String immortalName;

    // 用户对应的属性列表
    List<ImmortalAttributeInfo> ImmortalAttributeInfos;

}
