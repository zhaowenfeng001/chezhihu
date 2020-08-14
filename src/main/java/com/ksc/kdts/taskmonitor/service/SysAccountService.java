package com.ksc.kdts.taskmonitor.service;


import com.ksc.kdts.taskmonitor.model.ExecutionJob;
import com.ksc.kdts.taskmonitor.model.ExecutionJobRequest;
import com.ksc.kdts.taskmonitor.model.Response;
import com.ksc.kdts.taskmonitor.model.SysAccountQuery;

/**
 * @ClassName ExecutionJobService
 * @Description ExecutionJobService
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:06
 **/
public interface SysAccountService {


    String login(SysAccountQuery req);
}
