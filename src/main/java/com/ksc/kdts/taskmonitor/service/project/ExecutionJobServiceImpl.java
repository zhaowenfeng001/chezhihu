package com.ksc.kdts.taskmonitor.service.project;

import com.ksc.kdts.taskmonitor.mapper.monitor.ExecutionJobMapper;
import com.ksc.kdts.taskmonitor.model.ExecutionJob;
import com.ksc.kdts.taskmonitor.model.ExecutionJobRequest;
import com.ksc.kdts.taskmonitor.service.ExecutionJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @ClassName ExecutionJobServiceImpl
 * @Description ExecutionJobServiceImpl
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:07
 **/
@Service("executionJobService")
public class ExecutionJobServiceImpl implements ExecutionJobService {

    @Autowired
    private ExecutionJobMapper executionJobMapper;


    @Override
    public ExecutionJob searchSingleExecutionJob(ExecutionJobRequest executionJobRequest) {
        ExecutionJob result = new ExecutionJob();
        List<ExecutionJob> executionJobList = executionJobMapper.searchExecutionJob(executionJobRequest);
        if (executionJobList.size() > 1) {
            throw new RuntimeException("对应多个ExecutionJob!");
        }
        if (Objects.nonNull(executionJobList) && executionJobList.size() == 1) {
            result = executionJobList.get(0);
        }
        return result;
    }

    @Override
    public ExecutionJob addExecutionJob(ExecutionJob executionJob) {
        executionJobMapper.add(executionJob);
        return executionJob;
    }
}
