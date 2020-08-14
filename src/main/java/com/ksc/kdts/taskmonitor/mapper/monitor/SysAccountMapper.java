package com.ksc.kdts.taskmonitor.mapper.monitor;

import com.ksc.kdts.taskmonitor.model.ExecutionJob;
import com.ksc.kdts.taskmonitor.model.ExecutionJobRequest;
import com.ksc.kdts.taskmonitor.model.SysAccount;
import com.ksc.kdts.taskmonitor.model.SysAccountQuery;
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
public interface SysAccountMapper {


    SysAccount searchSysAccount(SysAccountQuery query);
}
