package com.ksc.kdts.taskmonitor.service;


import com.ksc.kdts.taskmonitor.model.*;

import java.util.List;

/**
 * @ClassName ExecutionJobService
 * @Description ExecutionJobService
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:06
 **/
public interface SysRoleService {


    SysRoleDO selectById(Long id);

    void deleteById(Long id);

    void insert(SysRole sysRole);

    void update(SysRole sysRole);

    Page<SysRoleDO> page(QueryPage queryPage, SysRoleQuery query);

    List<SysMenuDO> searchByQuery(SysRoleQuery query);
}
