package org.dimhat.hearthstone.database.exception;

import org.dimhat.hearthstone.exception.GameException;

/**
 * 业务层异常
 */
public class BizException extends GameException {

    public BizException() {
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
}
