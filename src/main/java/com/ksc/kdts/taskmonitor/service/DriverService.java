package com.ksc.kdts.taskmonitor.service;


import com.ksc.kdts.taskmonitor.model.*;

import com.ksc.kdts.taskmonitor.model.Driver;
import java.util.List;

/**
 * @ClassName ExecutionJobService
 * @Description ExecutionJobService
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:06
 **/
public interface DriverService {

    DriverDO selectById(Long id);

    Integer count(DriverQuery driverQuery);

    void deleteById(Long id);

    void insert(Driver driver);

    List<DriverDO> searchByQuery(DriverQuery query);

    void update(Driver driver);

    Page<DriverDO> page(QueryPage queryPage, DriverQuery query);
}
