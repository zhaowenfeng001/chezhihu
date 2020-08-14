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
public interface SysRoleMenuMapper {


    Integer count(SysRoleMenuQuery query);

    void remove(SysRoleMenuQuery query);

    void insert(SysRoleMenu srm);

    List<SysRoleMenuDO> searchByQuery(SysRoleMenuQuery query);
}
