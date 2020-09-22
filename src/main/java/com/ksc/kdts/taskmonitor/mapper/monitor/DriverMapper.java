package com.ksc.kdts.taskmonitor.mapper.monitor;

import com.ksc.kdts.taskmonitor.model.Driver;
import com.ksc.kdts.taskmonitor.model.DriverDO;
import com.ksc.kdts.taskmonitor.model.DriverQuery;
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
public interface DriverMapper {


    DriverDO selectById(DriverQuery driverQuery);

    Integer count(DriverQuery driverQuery);

    void deleteById(Long id);

    void insert(Driver driver);

    List<DriverDO> searchByQuery(DriverQuery driverQuery);

    void update(Driver driver);

}
