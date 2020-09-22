package com.ksc.kdts.taskmonitor.service;


import com.ksc.kdts.taskmonitor.model.*;

import java.util.List;

/**
 * @ClassName ExecutionJobService
 * @Description ExecutionJobService
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:06
 **/
public interface SysAccountService {


    String login(SysAccountQuery req);

    SysAccount selectById(Long id);

    Integer count(SysAccountQuery sysAccountQuery);

    void deleteById(Long id);

    void insert(SysAccount sysAccount);

    List<SysAccountDO> searchByQuery(SysAccountQuery query);

    void update(SysAccount sysAccount);

    Page<SysAccountDO> page(QueryPage queryPage, SysAccountQuery query);
}
