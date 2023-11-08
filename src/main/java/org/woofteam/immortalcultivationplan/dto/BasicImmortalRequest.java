package org.woofteam.immortalcultivationplan.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BasicImmortalRequest {
    @NotBlank(message = "immortalId 不能为空")
    public String immortalId;
}
