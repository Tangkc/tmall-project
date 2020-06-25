package com.tmall.auth.admin.exception;

public class BadServerException extends RuntimeException {
    public BadServerException(String msg, Throwable t) {
        super(msg, t);
    }

    public BadServerException(String msg) {
        super(msg);
    }
}
