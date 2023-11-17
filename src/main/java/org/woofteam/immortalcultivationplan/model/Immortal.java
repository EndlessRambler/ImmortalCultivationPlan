package org.woofteam.immortalcultivationplan.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

/**
 * 角色信息详情
 */
@Data
public class Immortal {
    @TableId
    public String immortalId;
    public String immortalName;
    public String immortalPassword;
    public int immortalGender;
    public String immortalBirthday;
    // 角色属性隐藏 0 不隐藏 1隐藏
    public int immortalAttributeHide;

    // 角色属性值加点说明隐藏 0 不隐藏 1隐藏
    public int immortalAttributeContentHide;
    @TableField(exist = false)
    public List<ImmortalAttributeInfo> immortalAttributeInfos;
}
