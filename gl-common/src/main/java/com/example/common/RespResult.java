package com.example.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lkle
 * @date 2023/3/17 17:17
 */
@Data
public class RespResult implements Serializable {
    private static final long serialVersionUID = 5635833589180135122L;

    /** 调用成功状态码 **/
    public static final int SUCCESS = 0;
    /** 调用失败状态码 **/
    public static final int FAIL = -1;
    /** 调用成功返回字符串 **/
    public static final String SUCC_MESSAGE = "调用成功";
    /** 调用失败返回字符串 **/
    public static final String FAIL_MESSAGE = "调用失败";


    /** 状态码 **/
    private int code;
    /** 数据 **/
    private Object data;
    /** 返回信息 **/
    private String message;

    public RespResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public RespResult(int code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static RespResult SUCC() {
        return new RespResult(SUCCESS, SUCC_MESSAGE);
    }

    public static RespResult FAIL() {
        return new RespResult(FAIL, FAIL_MESSAGE);
    }

    public static RespResult FAIL(String message) {
        return new RespResult(FAIL, message);
    }

    public static RespResult SUCC_DATA(Object data) {
        return new RespResult(SUCCESS, data, SUCC_MESSAGE);
    }

    public static RespResult SUCC_DATA(Object data, String message) {
        return new RespResult(SUCCESS, data, message);
    }


}
