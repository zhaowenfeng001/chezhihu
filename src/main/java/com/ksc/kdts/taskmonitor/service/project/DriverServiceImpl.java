package com.ksc.kdts.taskmonitor.service.project;

import com.ksc.kdts.taskmonitor.mapper.monitor.DriverMapper;
import com.ksc.kdts.taskmonitor.model.DriverDO;
import com.ksc.kdts.taskmonitor.model.DriverQuery;
import com.ksc.kdts.taskmonitor.model.Page;
import com.ksc.kdts.taskmonitor.model.QueryPage;
import com.ksc.kdts.taskmonitor.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksc.kdts.taskmonitor.model.Driver;
import java.util.List;

/**
 * @ClassName ExecutionJobServiceImpl
 * @Description ExecutionJobServiceImpl
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:07
 **/
@Service("driverService")
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverMapper driverMapper;


    @Override
    public DriverDO selectById(Long id) {
        DriverQuery driverQuery = new DriverQuery();
        driverQuery.setId(id);
        return driverMapper.selectById(driverQuery);
    }

    @Override
    public Integer count(DriverQuery driverQuery) {
        return driverMapper.count(driverQuery);
    }

    @Override
    public void deleteById(Long id) {
        driverMapper.deleteById(id);
    }

    @Override
    public void insert(Driver driver) {
        driverMapper.insert(driver);
    }

    @Override
    public List<DriverDO> searchByQuery(DriverQuery driverQuery) {
        return driverMapper.searchByQuery(driverQuery);
    }

    @Override
    public void update(Driver driver) {
        driverMapper.update(driver);
    }

    @Override
    public Page<DriverDO> page(QueryPage queryPage, DriverQuery driverQuery) {
        Page result = new Page();
        driverQuery.setSize(queryPage.getSize());
        driverQuery.setBegin(queryPage.getBegin());
        List driverList = driverMapper.searchByQuery(driverQuery);
        result.setRecords(driverList);

        Integer total = driverMapper.count(driverQuery);
        result.setTotal(Long.parseLong(total.toString()));
        return result;
    }
}
