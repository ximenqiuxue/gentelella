package com.shoulder.model;

import java.io.Serializable;

public class PageResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String msg;

    private String count;

    private Object data;

    public PageResult() {
    }

    public PageResult(String code, String msg, String count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public static PageResult PageReturn(String code, String count, Object data) {
        PageResult pageResult = new PageResult();
        pageResult.setCode(code);
        pageResult.setCount(count);
        pageResult.setData(data);
        return pageResult;
    }

    public static PageResult PageError(String code, String msg){
        PageResult pageResult = new PageResult();
        pageResult.setCode(code);
        pageResult.setMsg(msg);
        return pageResult;
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
