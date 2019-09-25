package com.shoulder.model;

import com.shoulder.constants.ResponseCode;

import java.io.Serializable;

public class Result implements Serializable {

    private static final long serialVersionUID = -3948389268046368059L;

    private String code;

    private String msg;

    private Object data;

    public Result() {

    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result success(){
        Result result = new Result();
        result.setCode(ResponseCode.SUCCESS);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(ResponseCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result success(String code, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setData(data);
        return result;
    }

    public static Result failure(String msg) {
        Result result = new Result();
        result.setMsg(msg);
        return result;
    }

    public static Result failure(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result failure(String code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
