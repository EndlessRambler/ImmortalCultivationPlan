package org.woofteam.immortalcultivationplan.message.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.woofteam.immortalcultivationplan.common.message.request.GenericRequest;
import org.woofteam.immortalcultivationplan.common.message.result.ExceptionEnum;
import org.woofteam.immortalcultivationplan.exception.VerifyException;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HelloRequest extends GenericRequest {

    private String name;

    @Override
    public void checkParams() throws VerifyException {
        // TODO: implement a verify util to validate the parameters
        if (name == null || name.length() == 0) {
            throw new VerifyException(ExceptionEnum.SIGNATURE_NOT_MATCH, "name can not be blank");
        }
    }
}
