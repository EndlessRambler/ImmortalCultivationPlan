package org.woofteam.immortalcultivationplan.message.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.woofteam.immortalcultivationplan.common.message.request.GenericRequest;
import org.woofteam.immortalcultivationplan.common.message.result.ExceptionEnum;
import org.woofteam.immortalcultivationplan.exception.VerifyException;
import org.woofteam.immortalcultivationplan.message.validation.custom.TelephoneNumber;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HelloRequest extends GenericRequest {
    @TelephoneNumber(message = "name can not be blank")
    private String name;
}
