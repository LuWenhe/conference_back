package edu.conf.exception;

import lombok.Data;

@Data
public class HintException extends RuntimeException {

    private Integer code;

    public HintException() {}

    public HintException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public HintException(String message) {
        super(message);
    }

}
