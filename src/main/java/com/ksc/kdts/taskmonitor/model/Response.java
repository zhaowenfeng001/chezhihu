package com.ksc.kdts.taskmonitor.model;

/**
 * @ClassName Response
 * @Description 返回结果
 * @Author wenfeng.zhao
 * @Date 2018/11/15 11:51
 **/
public class Response {
    public static final int SUCCESS = 200;

    //状态码
    private int status;
    //返回信息
    private String message;
    //返回结果
    private Object result;

    public static Response build() {
        return new Response();
    }

    public static Response build(Object result) {
        Response response = new Response();
        response.setResult(result);
        return response;
    }

    public Response success() {
        return success(SUCCESS, "SUCCESS");
    }

    public Response success(final int status) {
        return success(status, "SUCCESS");
    }

    public Response success(final String message) {
        return success(SUCCESS, message);
    }

    public Response success(int status, final String message) {
        this.message = message;
        this.status = status;
        return this;
    }

    public Response fail(final String message) {
        return fail(300, message);
    }

    public Response fail(final int status, final String message) {
        this.message = message;
        this.status = status;
        return this;
    }

    public Response fail(final Exception e) {
        return fail(300, e);
    }

    public Response fail(final int status, final Exception e) {
        String message = e.getMessage();
        if (message == null || message.isEmpty()) {
            message = "some error occurs";
        }
        fail(status, message);
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}

