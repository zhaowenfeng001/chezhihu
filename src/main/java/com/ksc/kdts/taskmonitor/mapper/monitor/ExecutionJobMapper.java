package com.ksc.kdts.taskmonitor.mapper.monitor;

import com.ksc.kdts.taskmonitor.model.ExecutionJob;
import com.ksc.kdts.taskmonitor.model.ExecutionJobRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @InterfaceName ProjectFlowsMapper
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:09
 **/
@Repository
@Mapper
public interface ExecutionJobMapper {

    /**
     * 查询ExecutionJob
     * @param executionJobRequest
     * @return
     */
    List<ExecutionJob> searchExecutionJob(ExecutionJobRequest executionJobRequest);

    /**
     * 添加ExecutionJob
     * @param executionJob
     */
    void add(ExecutionJob executionJob);

    /**
     * 更新ExecutionJob
     * @param ExecutionJobRequest
     * @return
     */
    ExecutionJob update(ExecutionJobRequest ExecutionJobRequest);

}
