package com.ksc.kdts.taskmonitor.service;


import com.ksc.kdts.taskmonitor.model.ExecutionJob;
import com.ksc.kdts.taskmonitor.model.ExecutionJobRequest;
import com.ksc.kdts.taskmonitor.model.ReportRequest;

import java.util.Map;

/**
 * @ClassName ExecutionJobService
 * @Description ExecutionJobService
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:06
 **/
public interface ExecutionJobService {
    /**
     * 查询工作流
     * @param executionJobRequest
     * @return
     */
    ExecutionJob searchSingleExecutionJob(ExecutionJobRequest executionJobRequest);

    /**
     * 添加ExecutorJob
     * @param executionJob
     * @return
     */
    ExecutionJob addExecutionJob(ExecutionJob executionJob);


}
