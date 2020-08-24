package com.ksc.kdts.taskmonitor.service.project;

import com.ksc.kdts.taskmonitor.mapper.monitor.CompanyMapper;
import com.ksc.kdts.taskmonitor.mapper.monitor.CompanyMapper;
import com.ksc.kdts.taskmonitor.model.*;
import com.ksc.kdts.taskmonitor.service.CompanyService;
import com.ksc.kdts.taskmonitor.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName ExecutionJobServiceImpl
 * @Description ExecutionJobServiceImpl
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:07
 **/
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;


    @Override
    public CompanyDO selectById(Long id) {
        CompanyQuery companyQuery = new CompanyQuery();
        companyQuery.setId(id);
        return companyMapper.selectById(companyQuery);
    }

    @Override
    public Integer count(CompanyQuery companyQuery) {
        return companyMapper.count(companyQuery);
    }

    @Override
    public void deleteById(Long id) {
        companyMapper.deleteById(id);
    }

    @Override
    public void insert(Company company) {
        companyMapper.insert(company);
    }

    @Override
    public List<CompanyDO> searchByQuery(CompanyQuery companyQuery) {
        return companyMapper.searchByQuery(companyQuery);
    }

    @Override
    public void update(Company company) {
        companyMapper.update(company);
    }

    @Override
    public Page<CompanyDO> page(QueryPage queryPage, CompanyQuery companyQuery) {
        Page result = new Page();
        companyQuery.setSize(queryPage.getSize());
        companyQuery.setBegin(queryPage.getBegin());
        List companyList = companyMapper.searchByQuery(companyQuery);
        result.setRecords(companyList);

        Integer total = companyMapper.count(companyQuery);
        result.setTotal(Long.parseLong(total.toString()));
        return result;
    }
}
