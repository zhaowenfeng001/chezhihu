package com.ksc.kdts.taskmonitor.mapper.monitor;

import com.ksc.kdts.taskmonitor.model.Department;
import com.ksc.kdts.taskmonitor.model.DepartmentDO;
import com.ksc.kdts.taskmonitor.model.DepartmentQuery;
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
public interface DepartmentMapper {


    DepartmentDO selectById(DepartmentQuery departmentQuery);

    Integer count(DepartmentQuery departmentQuery);

    void deleteById(Long id);

    void insert(Department department);

    List<DepartmentDO> searchByQuery(DepartmentQuery departmentQuery);

    void update(Department department);

}
