package com.ksc.kdts.taskmonitor.mapper.monitor;

import com.ksc.kdts.taskmonitor.model.Company;
import com.ksc.kdts.taskmonitor.model.CompanyDO;
import com.ksc.kdts.taskmonitor.model.CompanyQuery;
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
public interface CompanyMapper {


    CompanyDO selectById(CompanyQuery companyQuery);

    Integer count(CompanyQuery companyQuery);

    void deleteById(Long id);

    void insert(Company company);

    List<CompanyDO> searchByQuery(CompanyQuery companyQuery);

    void update(Company company);

}
