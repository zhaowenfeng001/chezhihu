package com.ksc.kdts.taskmonitor.service.project;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.ksc.kdts.taskmonitor.mapper.monitor.SysMenuMapper;
import com.ksc.kdts.taskmonitor.mapper.monitor.SysRoleMenuMapper;
import com.ksc.kdts.taskmonitor.model.*;
import com.ksc.kdts.taskmonitor.service.SysMenuService;
import com.ksc.kdts.taskmonitor.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName ExecutionJobServiceImpl
 * @Description ExecutionJobServiceImpl
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:07
 **/
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;


    @Override
    public Integer count(SysRoleMenuQuery query) {
        return sysRoleMenuMapper.count(query);
    }

    @Override
    public void settingMenu(SysRoleDO sysRoleDO) {
        SysRoleMenuQuery sysRoleMenuQuery = new SysRoleMenuQuery();
        sysRoleMenuQuery.setRoleId(sysRoleDO.getId());
        //移除该角色下所有的菜单
        sysRoleMenuMapper.remove(sysRoleMenuQuery);
        //将新的菜单id和角色关联
        if(!CollectionUtils.isEmpty(sysRoleDO.getMenuIdList())){
            for(Long menuId : sysRoleDO.getMenuIdList()){
                SysRoleMenu srm  = new SysRoleMenu();
                srm.setMenuId(menuId);
                srm.setRoleId(sysRoleDO.getId());
                sysRoleMenuMapper.insert(srm);
            }
        }
    }

    @Override
    public List<Long> listMenuId(SysRoleMenuQuery query) {
        List<SysRoleMenuDO> list = sysRoleMenuMapper.searchByQuery(query);
        if(!CollectionUtils.isEmpty(list)){
            List<Long> menuIdList = list.stream().map(SysRoleMenuDO :: getMenuId).distinct().collect(Collectors.toList());
            return menuIdList;
        }
        return new ArrayList<>();
    }
}
