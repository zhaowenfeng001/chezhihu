package com.ksc.kdts.taskmonitor.service;


import com.ksc.kdts.taskmonitor.model.*;

import java.util.List;

/**
 * @ClassName ExecutionJobService
 * @Description ExecutionJobService
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:06
 **/
public interface UserCarService {

    UserCarDO selectById(Long id);

    Integer count(UserCarQuery userCarQuery);

    void deleteById(Long id);

    void insert(UserCar userCar);

    List<UserCarDO> searchByQuery(UserCarQuery query);

    void update(UserCar userCar);

    Page<UserCarDO> page(QueryPage queryPage, UserCarQuery query);
}
