package com.ksc.kdts.taskmonitor.mapper.monitor;

import com.ksc.kdts.taskmonitor.model.Car;
import com.ksc.kdts.taskmonitor.model.CarDO;
import com.ksc.kdts.taskmonitor.model.CarQuery;
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
public interface CarMapper {

    CarDO selectById(CarQuery carQuery);

    Integer count(CarQuery carQuery);

    void deleteById(Long id);

    void insert(Car car);

    List<CarDO> searchByQuery(CarQuery carQuery);

    void update(Car car);

}
