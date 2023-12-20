package org.woofteam.immortalcultivationplan.exception;

import java.io.Serial;
import lombok.Getter;
import org.woofteam.immortalcultivationplan.common.message.result.BaseErrorInfoInterface;

public class VerifyException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    @Getter
    private final String code;


    public VerifyException(String code, String message) {
        super(message, null, false, false);
        this.code = code;
    }

    public VerifyException(BaseErrorInfoInterface baseErrorInfoInterface) {
        super(baseErrorInfoInterface.getResultMsg(), null, false, false);
        this.code = baseErrorInfoInterface.getResultCode();
    }

    public VerifyException(BaseErrorInfoInterface baseErrorInfoInterface, String message) {
        super(message, null, false, false);
        this.code = baseErrorInfoInterface.getResultCode();
    }

}
