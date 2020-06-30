package com.example.core.result;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class CommonResult<T> {
    private int code;
    private String message;
    private T data;

    public static CommonResult commonSuccess(Object data) {
        return new CommonResult<>(0, "success", data);
    }

    public static CommonResult commonfail(String message) {
        return new CommonResult<>(-1, message, null);
    }
}
