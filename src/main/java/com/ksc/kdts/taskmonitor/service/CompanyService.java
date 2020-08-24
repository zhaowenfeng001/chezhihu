package com.ksc.kdts.taskmonitor.service;


import com.ksc.kdts.taskmonitor.model.*;

import java.util.List;

/**
 * @ClassName ExecutionJobService
 * @Description ExecutionJobService
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:06
 **/
public interface CompanyService {

    CompanyDO selectById(Long id);

    Integer count(CompanyQuery companyQuery);

    void deleteById(Long id);

    void insert(Company company);

    List<CompanyDO> searchByQuery(CompanyQuery query);

    void update(Company company);

    Page<CompanyDO> page(QueryPage queryPage, CompanyQuery query);
}
