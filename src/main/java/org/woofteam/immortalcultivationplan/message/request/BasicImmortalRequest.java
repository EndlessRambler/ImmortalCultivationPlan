package org.woofteam.immortalcultivationplan.message.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.woofteam.immortalcultivationplan.common.message.request.GenericRequest;
import org.woofteam.immortalcultivationplan.exception.VerifyException;

@Data
public class BasicImmortalRequest extends GenericRequest {

    @NotBlank(message = "immortalId 不能为空")
    public String immortalId;

    @Override
    public void checkParams() throws VerifyException {
    }
}
