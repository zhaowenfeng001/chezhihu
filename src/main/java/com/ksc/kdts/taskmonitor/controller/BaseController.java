package com.ksc.kdts.taskmonitor.controller;

import com.ksc.kdts.taskmonitor.model.Session;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName BaseController
 * @Description TODO
 * @Author wenfeng.zhao
 * @Date 2018/11/21 10:02
 **/
public abstract class BaseController {


    protected Session getSession(HttpServletRequest request) {
        Object session = request.getSession().getAttribute("session");
        if (session == null) {
            return null;
        }
        return (Session) session;
    }

}
