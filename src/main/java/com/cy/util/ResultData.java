package com.cy.util;

public class ResultData {

    private int code; // 0是成功,其他都是不成功
    private String msg;
    private int count;
    private Object data;

    public ResultData() {
    }

    public static ResultData ok() {
        ResultData resultData = new ResultData( );
        resultData.setCode(0);
        resultData.setMsg("成功");
        return resultData;
    }

    public static ResultData ok(Object data) {
        ResultData resultData = new ResultData( );
        resultData.setCode(0);
        resultData.setMsg("成功");
        resultData.setData(data);
        resultData.setCount(100);
        return resultData;
    }

    public static ResultData ok(Object data,int count) {
        ResultData resultData = new ResultData( );
        resultData.setCode(0);
        resultData.setMsg("成功");
        resultData.setData(data);
        resultData.setCount(count);
        return resultData;
    }

    public static ResultData fail() {
        ResultData resultData = new ResultData( );
        resultData.setCode(-1);
        resultData.setMsg("失败");
        return resultData;
    }
    public static ResultData fail(String str) {
        ResultData resultData = new ResultData( );
        resultData.setCode(-2);
        resultData.setMsg(str);
        return resultData;
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

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
