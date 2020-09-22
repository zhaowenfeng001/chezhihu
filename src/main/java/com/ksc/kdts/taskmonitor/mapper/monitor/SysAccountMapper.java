package com.ksc.kdts.taskmonitor.mapper.monitor;

import com.ksc.kdts.taskmonitor.model.*;
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
public interface SysAccountMapper {


    SysAccount searchSysAccount(SysAccountQuery query);

    SysAccountDO selectById(SysAccountQuery sysAccountQuery);

    Integer count(SysAccountQuery sysAccountQuery);

    void deleteById(Long id);

    void insert(SysAccount sysAccount);

    List<SysAccountDO> searchByQuery(SysAccountQuery sysAccountQuery);

    void update(SysAccount sysAccount);
}
