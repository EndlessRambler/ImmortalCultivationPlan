package org.woofteam.immortalcultivationplan.dao;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 *  角色属性值记录
 */
@Data
public class ImmortalAttribute {

    public String immortalID;

    public String immortalAttributeID;
    public String immortalAttributeValue;

    public String immortalAttributeContent;

    public String immortalAttributeUpdateTime;

    // 该属性值加点说明隐藏
    public int immortalAttributeContentHidde;
}
