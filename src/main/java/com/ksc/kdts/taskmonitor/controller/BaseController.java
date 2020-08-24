package com.ksc.kdts.taskmonitor.controller;

import com.ksc.kdts.taskmonitor.cons.CacheConstant;
import com.ksc.kdts.taskmonitor.mapper.monitor.SysAccountMapper;
import com.ksc.kdts.taskmonitor.model.Session;
import com.ksc.kdts.taskmonitor.model.SysAccount;
import com.ksc.kdts.taskmonitor.model.SysAccountQuery;
import com.ksc.kdts.taskmonitor.util.CacheHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.Optional;

/**
 * @ClassName BaseController
 * @Description TODO
 * @Author wenfeng.zhao
 * @Date 2018/11/21 10:02
 **/
public abstract class BaseController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;


    @Autowired
    private CacheHelper cacheHelper;

    @Autowired
    private SysAccountMapper sysAccountMapper;

    /**
     * 获取pc当前用户Id
     *
     * @return
     */
    public Long currentAdminId() {
        Object token = this.request.getHeader("token");
        String value = cacheHelper.getValue(CacheConstant.TOKEN_ACCOUNT + token);
        if(StringUtils.isEmpty(value)){
            return null;
        }
        return Long.parseLong(value);
    }

    /**
     * 获取h5当前用户Id
     *
     * @return
     */
    public Long currentH5Id() {
        Object token = this.request.getHeader("token");
        String value = cacheHelper.getValue(CacheConstant.H5_TOKEN_ACCOUNT + token);
        if(StringUtils.isEmpty(value)){
            return null;
        }
        return Long.parseLong(value);
    }


    /**
     * 当前登录人信息
     * @return
     */
    public SysAccount getLoginAccount(){
        Long currentH5Id = this.currentH5Id();
        SysAccount account = null;
        if(!ObjectUtils.isEmpty(currentH5Id)){
            SysAccountQuery sysAccountQuery = new SysAccountQuery();
            sysAccountQuery.setId(currentH5Id);
            account = Optional.ofNullable(sysAccountMapper.searchSysAccount(sysAccountQuery)).orElse(new SysAccount());
        }
        return Optional.ofNullable(account).orElse(new SysAccount());
    }



    protected Session getSession(HttpServletRequest request) {
        Object session = request.getSession().getAttribute("session");
        if (session == null) {
            return null;
        }
        return (Session) session;
    }

}
