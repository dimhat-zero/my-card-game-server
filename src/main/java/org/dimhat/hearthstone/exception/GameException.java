package org.dimhat.hearthstone.exception;

/**
 * Created by think on 2016/9/19.
 */
public class GameException extends RuntimeException{

    public GameException() {
    }

    public GameException(String message) {
        super(message);
    }

    public GameException(String message, Throwable cause) {
        super(message, cause);
    }
}
