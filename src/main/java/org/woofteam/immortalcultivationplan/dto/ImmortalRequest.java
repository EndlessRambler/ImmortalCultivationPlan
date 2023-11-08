package org.woofteam.immortalcultivationplan.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ImmortalRequest extends  BasicImmortalRequest{
    @NotBlank(message = "immortalName 不能为空")
    public String immortalName;
    @Pattern(regexp = "[男,女]")
    public String immortalGender;

    public String immortalBirthday;
    @NotBlank(message = "immortalName 不能为空")
    @Pattern(regexp = RegexPattern.IMMORTAL_PASSWORD_REGEX)
    public String immortalPassword;
}
