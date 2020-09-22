package com.ksc.kdts.taskmonitor.service.project;

import com.ksc.kdts.taskmonitor.mapper.monitor.UserCarMapper;
import com.ksc.kdts.taskmonitor.model.Page;
import com.ksc.kdts.taskmonitor.model.QueryPage;
import com.ksc.kdts.taskmonitor.model.UserCar;
import com.ksc.kdts.taskmonitor.model.UserCarDO;
import com.ksc.kdts.taskmonitor.model.UserCarQuery;
import com.ksc.kdts.taskmonitor.service.UserCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ExecutionJobServiceImpl
 * @Description ExecutionJobServiceImpl
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:07
 **/
@Service("userCarService")
public class UserCarServiceImpl implements UserCarService {

    @Autowired
    private UserCarMapper userCarMapper;


    @Override
    public UserCarDO selectById(Long id) {
        UserCarQuery userCarQuery = new UserCarQuery();
        userCarQuery.setId(id);
        return userCarMapper.selectById(userCarQuery);
    }

    @Override
    public Integer count(UserCarQuery userCarQuery) {
        return userCarMapper.count(userCarQuery);
    }

    @Override
    public void deleteById(Long id) {
        userCarMapper.deleteById(id);
    }

    @Override
    public void insert(UserCar userCar) {
        userCarMapper.insert(userCar);
    }

    @Override
    public List<UserCarDO> searchByQuery(UserCarQuery userCarQuery) {
        return userCarMapper.searchByQuery(userCarQuery);
    }

    @Override
    public void update(UserCar userCar) {
        userCarMapper.update(userCar);
    }

    @Override
    public Page<UserCarDO> page(QueryPage queryPage, UserCarQuery userCarQuery) {
        Page result = new Page();
        userCarQuery.setSize(queryPage.getSize());
        userCarQuery.setBegin(queryPage.getBegin());
        List carList = userCarMapper.searchByQuery(userCarQuery);
        result.setRecords(carList);

        Integer total = userCarMapper.count(userCarQuery);
        result.setTotal(Long.parseLong(total.toString()));
        return result;
    }
}
