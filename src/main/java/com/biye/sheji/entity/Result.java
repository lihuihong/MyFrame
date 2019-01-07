package com.biye.sheji.entity;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 那个谁 on 2018/12/30.
 */
public class Result {

    // 状态标志，0表示成功，1表示失败
    private int code;
    // code说明，建议code为1时，返回 对应说明
    private String msg;

    private int count;// 数据条数，
    private Object data;// 数据列表

    public Result() {
        super();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setSuccessMsg(String msg) {
        this.code = 0;
        this.msg = msg;
    }

    public void setErrorMsg(String msg) {
        this.code = 1;
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
