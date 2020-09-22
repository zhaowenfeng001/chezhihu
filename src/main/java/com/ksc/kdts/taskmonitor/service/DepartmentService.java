package com.ksc.kdts.taskmonitor.service;


import com.ksc.kdts.taskmonitor.model.*;

import java.util.List;

/**
 * @ClassName ExecutionJobService
 * @Description ExecutionJobService
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:06
 **/
public interface DepartmentService {

    DepartmentDO selectById(Long id);

    Integer count(DepartmentQuery departmentQuery);

    void deleteById(Long id);

    void insert(Department department);

    List<DepartmentDO> searchByQuery(DepartmentQuery query);

    void update(Department department);

    Page<DepartmentDO> page(QueryPage queryPage, DepartmentQuery query);
}
