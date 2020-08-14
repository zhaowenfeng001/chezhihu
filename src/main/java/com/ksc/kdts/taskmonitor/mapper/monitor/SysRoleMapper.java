package com.ksc.kdts.taskmonitor.mapper.monitor;

import com.ksc.kdts.taskmonitor.model.SysRole;
import com.ksc.kdts.taskmonitor.model.SysRoleDO;
import com.ksc.kdts.taskmonitor.model.SysRoleQuery;
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
public interface SysRoleMapper {


    SysRoleDO selectById(Long id);

    void deleteById(Long id);

    void insert(SysRole sysRole);

    void update(SysRole sysRole);

    List searchByQuery(SysRoleQuery query);

    Integer count(SysRoleQuery query);
}
