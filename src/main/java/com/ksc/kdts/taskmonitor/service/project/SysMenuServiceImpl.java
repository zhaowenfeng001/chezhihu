package com.ksc.kdts.taskmonitor.service.project;

import com.ksc.kdts.taskmonitor.mapper.monitor.SysMenuMapper;
import com.ksc.kdts.taskmonitor.model.*;
import com.ksc.kdts.taskmonitor.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ExecutionJobServiceImpl
 * @Description ExecutionJobServiceImpl
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:07
 **/
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;


    @Override
    public SysMenuDO selectById(Long id) {
        SysMenuQuery sysMenuQuery = new SysMenuQuery();
        sysMenuQuery.setId(id);
        return sysMenuMapper.selectById(sysMenuQuery);
    }

    @Override
    public Integer count(SysMenuQuery smquery) {
        return sysMenuMapper.count(smquery);
    }

    @Override
    public void deleteById(Long id) {
        sysMenuMapper.deleteById(id);
    }

    @Override
    public void insertMenu(SysMenu sysMenu) {
        sysMenuMapper.insertMenu(sysMenu);
    }

    @Override
    public List<SysMenuDO> searchByQuery(SysMenuQuery query) {
        return sysMenuMapper.searchByQuery(query);
    }

    @Override
    public void update(SysMenu sysMenu) {
        sysMenuMapper.update(sysMenu);
    }

    @Override
    public Page<SysMenuDO> page(QueryPage queryPage, SysMenuQuery query) {
        Page result = new Page();
        SysMenuQuery sysMenuQuery = query;
        sysMenuQuery.setSize(queryPage.getSize());
        sysMenuQuery.setBegin(queryPage.getBegin());
        List sysMenuList = sysMenuMapper.searchByQuery(sysMenuQuery);
        result.setRecords(sysMenuList);

        Integer total = sysMenuMapper.count(sysMenuQuery);
        result.setTotal(Long.parseLong(total.toString()));
        return result;
    }
}
