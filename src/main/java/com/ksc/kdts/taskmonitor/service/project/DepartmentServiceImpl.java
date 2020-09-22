package com.ksc.kdts.taskmonitor.service.project;

import com.ksc.kdts.taskmonitor.mapper.monitor.DepartmentMapper;
import com.ksc.kdts.taskmonitor.model.*;
import com.ksc.kdts.taskmonitor.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ExecutionJobServiceImpl
 * @Description ExecutionJobServiceImpl
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:07
 **/
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public DepartmentDO selectById(Long id) {
        DepartmentQuery departmentQuery = new DepartmentQuery();
        departmentQuery.setId(id);
        return departmentMapper.selectById(departmentQuery);
    }

    @Override
    public Integer count(DepartmentQuery departmentQuery) {
        return departmentMapper.count(departmentQuery);
    }

    @Override
    public void deleteById(Long id) {
        departmentMapper.deleteById(id);
    }

    @Override
    public void insert(Department department) {
        departmentMapper.insert(department);
    }

    @Override
    public List<DepartmentDO> searchByQuery(DepartmentQuery departmentQuery) {
        return departmentMapper.searchByQuery(departmentQuery);
    }

    @Override
    public void update(Department department) {
        departmentMapper.update(department);
    }

    @Override
    public Page<DepartmentDO> page(QueryPage queryPage, DepartmentQuery departmentQuery) {
        Page result = new Page();
        departmentQuery.setSize(queryPage.getSize());
        departmentQuery.setBegin(queryPage.getBegin());
        List departmentList = departmentMapper.searchByQuery(departmentQuery);
        result.setRecords(departmentList);

        Integer total = departmentMapper.count(departmentQuery);
        result.setTotal(Long.parseLong(total.toString()));
        return result;
    }
}
