package com.ksc.kdts.taskmonitor.service.project;

import com.ksc.kdts.taskmonitor.mapper.monitor.CarMapper;
import com.ksc.kdts.taskmonitor.model.*;
import com.ksc.kdts.taskmonitor.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ExecutionJobServiceImpl
 * @Description ExecutionJobServiceImpl
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:07
 **/
@Service("carService")
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;


    @Override
    public CarDO selectById(Long id) {
        CarQuery carQuery = new CarQuery();
        carQuery.setId(id);
        return carMapper.selectById(carQuery);
    }

    @Override
    public Integer count(CarQuery carQuery) {
        return carMapper.count(carQuery);
    }

    @Override
    public void deleteById(Long id) {
        carMapper.deleteById(id);
    }

    @Override
    public void insert(Car car) {
        carMapper.insert(car);
    }

    @Override
    public List<CarDO> searchByQuery(CarQuery carQuery) {
        return carMapper.searchByQuery(carQuery);
    }

    @Override
    public void update(Car car) {
        carMapper.update(car);
    }

    @Override
    public Page<CarDO> page(QueryPage queryPage, CarQuery carQuery) {
        Page result = new Page();
        carQuery.setSize(queryPage.getSize());
        carQuery.setBegin(queryPage.getBegin());
        List carList = carMapper.searchByQuery(carQuery);
        result.setRecords(carList);

        Integer total = carMapper.count(carQuery);
        result.setTotal(Long.parseLong(total.toString()));
        return result;
    }
}
