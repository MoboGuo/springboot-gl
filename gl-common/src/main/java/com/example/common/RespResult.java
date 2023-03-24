package com.example.common;

import com.google.protobuf.Message;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lkle
 * @date 2023/3/17 17:17
 */
@Data
public class RespResult<T> implements Serializable {
    private static final long serialVersionUID = 5635833589180135122L;

    /** 调用成功状态码 **/
    public static final int SUCCESS = 200;
    /** 调用失败状态码 **/
    public static final int FAIL = -1;
    /** 调用成功返回字符串 **/
    public static final String SUCC_MSG = "调用成功";
    /** 调用失败返回字符串 **/
    public static final String FAIL_MSG = "调用失败";


    /** 状态码 **/
    private int code;
    /** 数据 **/
    private T data;
    /** 返回信息 **/
    private String msg;

    public RespResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RespResult(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static RespResult SUCC() {
        return new RespResult(SUCCESS, SUCC_MSG);
    }

    public static RespResult SUCC(String msg) {
        return new RespResult(SUCCESS, msg);
    }

    public static RespResult FAIL() {
        return new RespResult(FAIL, FAIL_MSG);
    }

    public static RespResult FAIL(String msg) {
        return new RespResult(FAIL, msg);
    }

    public static RespResult SUCC_DATA(Object data) {
        return new RespResult(SUCCESS, data, SUCC_MSG);
    }

    public static RespResult SUCC_DATA(Object data, String msg) {
        return new RespResult(SUCCESS, data, msg);
    }

    public static RespResult ERROR(int code, String msg) {
        return new RespResult(code, msg);
    }

    public RespResult info(T data, String message, int code) {
        return new RespResult(code, data, message);
    }
}
