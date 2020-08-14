package com.ksc.kdts.taskmonitor.model;

import java.util.List;

public class SysRoleDO extends SysRole{
    private List<Long> menuIdList;

    public List<Long> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<Long> menuIdList) {
        this.menuIdList = menuIdList;
    }
}