package org.woofteam.immortalcultivationplan.dao;

import lombok.Data;

@Data
public class ImmortalAttribute {
    public String immortalID;
    public String immortalAttributeID;
    public String immortalAttributeValue;

    public String immortalAttributeContent;

    public String immortalAttributeUpdateTime;

    // 该属性值说明隐藏
    public int immortalAttributeContentHidde;
}
