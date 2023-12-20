package org.woofteam.immortalcultivationplan.message.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.woofteam.immortalcultivationplan.common.constant.Constant;


@Data
public class ImmortalRequest {
    @NotBlank(message = "immortalName 不能为空")
    public String immortalName;
    @Range(min=1,max=2,message = "immortalGender 错误")
    public Integer immortalGender;

    public String immortalBirthday;
    @NotBlank(message = "immortalName 不能为空")
    @Pattern(regexp = Constant.IMMORTAL_PASSWORD_REGEX)
    public String immortalPassword;
}
