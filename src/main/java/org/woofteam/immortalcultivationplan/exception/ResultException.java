package org.woofteam.immortalcultivationplan.exception;

import java.io.Serial;
import lombok.Getter;
import org.woofteam.immortalcultivationplan.common.message.result.BaseErrorInfoInterface;

public class ResultException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    @Getter
    private final String code;

    public ResultException(String code) {
        this(code, null);
    }

    public ResultException(String code, String message) {
        super(message, null, false, false);
        this.code = code;
    }

    public ResultException(BaseErrorInfoInterface baseErrorInfoInterface) {
        super(baseErrorInfoInterface.getResultMsg(), null, false, false);
        this.code = baseErrorInfoInterface.getResultCode();
    }

    public ResultException(BaseErrorInfoInterface baseErrorInfoInterface, String message) {
        super(message, null, false, false);
        this.code = baseErrorInfoInterface.getResultCode();
    }

}
