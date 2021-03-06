package com.example.demo.model;

/**
 * http请求返回的最外层对象
 * Created by jing on 2017/9/22.
 */
public class Result<T> {
    //错误码
    private Integer code;
    //提示信息
    private String msg;
    //具体信息(对象)
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
