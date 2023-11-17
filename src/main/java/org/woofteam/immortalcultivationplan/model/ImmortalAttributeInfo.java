package org.woofteam.immortalcultivationplan.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 *  角色属性信息详情
 */
@Data
public class ImmortalAttributeInfo {
    public String immortalID;
    @TableId
    public String immortalAttributeID;
    public String immortalAttributeName;
    //
    public int immortalAttributeHide;

}
