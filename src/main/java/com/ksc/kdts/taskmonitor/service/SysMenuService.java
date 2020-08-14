package com.ksc.kdts.taskmonitor.service;


import com.ksc.kdts.taskmonitor.model.*;

import java.util.List;

/**
 * @ClassName ExecutionJobService
 * @Description ExecutionJobService
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:06
 **/
public interface SysMenuService {

    SysMenuDO selectById(Long id);

    Integer count(SysMenuQuery smquery);

    void deleteById(Long id);

    void insertMenu(SysMenu sysMenu);

    List<SysMenuDO> searchByQuery(SysMenuQuery query);

    void update(SysMenu sysMenu);

    Page<SysMenuDO> page(QueryPage queryPage, SysMenuQuery query);
}
