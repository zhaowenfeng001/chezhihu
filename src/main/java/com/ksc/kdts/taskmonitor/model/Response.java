package com.ksc.kdts.taskmonitor.model;

import com.ksc.kdts.taskmonitor.util.StringUtils;

/**
 * @ClassName Response
 * @Description 返回结果
 * @Author wenfeng.zhao
 * @Date 2018/11/15 11:51
 **/
public class Response {
    public static final int SUCCESS = 200;

    //状态码
    private int code;
    //返回信息
    private String msg;
    //返回结果
    private Object data;


    

    public static Response build() {
        return new Response();
    }

    public static Response build(Object result) {
        Response response = new Response();
        response.setData(result);
        return response;
    }

    public Response success() {
        return success(SUCCESS, "SUCCESS");
    }

    public Response success(final int code) {
        return success(code, "SUCCESS");
    }

    public Response success(final String msg) {
        return success(SUCCESS, msg);
    }

    public Response success(int code, final String msg) {
        this.msg = msg;
        this.code = code;
        return this;
    }

    public Response fail(final String msg) {
        return fail(300, msg);
    }

    public Response fail(final int code, final String msg) {
        this.msg = msg;
        this.code = code;
        return this;
    }

    public Response fail(final Exception e) {
        return fail(300, e);
    }

    public Response fail(final int code, final Exception e) {
        String msg = e.getMessage();
        if (msg == null || msg.isEmpty()) {
            msg = "some error occurs";
        }
        fail(code, msg);
        return this;
    }


    protected static String htmlEncode(String text) {
        if (text == null) {
            return null;
        }

        String result = text.replace("\"", "&quot;");
        result = result.replace("<", "&lt;");
        result = result.replace(">", "&gt;");

        return result;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

