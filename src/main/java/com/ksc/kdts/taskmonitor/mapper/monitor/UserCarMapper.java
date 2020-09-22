package com.ksc.kdts.taskmonitor.mapper.monitor;

import com.ksc.kdts.taskmonitor.model.UserCar;
import com.ksc.kdts.taskmonitor.model.UserCarDO;
import com.ksc.kdts.taskmonitor.model.UserCarQuery;
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
public interface UserCarMapper {


    UserCarDO selectById(UserCarQuery userCarQuery);

    Integer count(UserCarQuery userCarQuery);

    void deleteById(Long id);

    void insert(UserCar userCar);

    List<UserCarDO> searchByQuery(UserCarQuery userCarQuery);

    void update(UserCar userCar);

}
