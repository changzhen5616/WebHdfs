package com.yuanjing.web.util;

/**
 * @author Poseidon
 * @date 2019/6/14 10:48
 * @descrition 返回结果集
 */
public class Result {

    //状态码
    private int code;
    //返回内容消息
    private String msg;

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
