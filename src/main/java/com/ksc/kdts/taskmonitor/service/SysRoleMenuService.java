package com.ksc.kdts.taskmonitor.service;


import com.ksc.kdts.taskmonitor.model.SysMenuDO;
import com.ksc.kdts.taskmonitor.model.SysMenuQuery;
import com.ksc.kdts.taskmonitor.model.SysRoleDO;
import com.ksc.kdts.taskmonitor.model.SysRoleMenuQuery;

import java.util.List;

/**
 * @ClassName ExecutionJobService
 * @Description ExecutionJobService
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:06
 **/
public interface SysRoleMenuService {

    Integer count(SysRoleMenuQuery query);

    void settingMenu(SysRoleDO sysRoleDO);

    List<Long> listMenuId(SysRoleMenuQuery query);
}
