package com.ksc.kdts.taskmonitor.service.project;

import com.ksc.kdts.taskmonitor.mapper.monitor.SysMenuMapper;
import com.ksc.kdts.taskmonitor.mapper.monitor.SysRoleMapper;
import com.ksc.kdts.taskmonitor.model.*;
import com.ksc.kdts.taskmonitor.service.SysMenuService;
import com.ksc.kdts.taskmonitor.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ExecutionJobServiceImpl
 * @Description ExecutionJobServiceImpl
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:07
 **/
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public SysRoleDO selectById(Long id) {
        return sysRoleMapper.selectById(id);
    }

    @Override
    public void deleteById(Long id) {
        sysRoleMapper.deleteById(id);
    }

    @Override
    public void insert(SysRole sysRole) {
        sysRoleMapper.insert(sysRole);
    }

    @Override
    public void update(SysRole sysRole) {
        sysRoleMapper.update(sysRole);
    }

    @Override
    public Page<SysRoleDO> page(QueryPage queryPage, SysRoleQuery query) {
        Page result = new Page();
        query.setSize(queryPage.getSize());
        query.setBegin(queryPage.getBegin());
        List sysRoleList = sysRoleMapper.searchByQuery(query);
        result.setRecords(sysRoleList);

        Integer total = sysRoleMapper.count(query);
        result.setTotal(Long.parseLong(total.toString()));
        return result;
    }

    @Override
    public List<SysMenuDO> searchByQuery(SysRoleQuery query) {
        return sysRoleMapper.searchByQuery(query);
    }
}
