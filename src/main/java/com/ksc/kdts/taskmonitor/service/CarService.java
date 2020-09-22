package com.ksc.kdts.taskmonitor.service;


import com.ksc.kdts.taskmonitor.model.*;

import java.util.List;

/**
 * @ClassName ExecutionJobService
 * @Description ExecutionJobService
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:06
 **/
public interface CarService {

    CarDO selectById(Long id);

    Integer count(CarQuery carQuery);

    void deleteById(Long id);

    void insert(Car car);

    List<CarDO> searchByQuery(CarQuery query);

    void update(Car car);

    Page<CarDO> page(QueryPage queryPage, CarQuery query);
}
