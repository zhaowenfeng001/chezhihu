package com.ksc.kdts.taskmonitor.model;

import java.util.List;

public class SysMenuDO extends SysMenu{
    /**
     * 子节点列表
     */
    private List<SysMenuDO> childList;

    public List<SysMenuDO> getChildList() {
        return childList;
    }

    public void setChildList(List<SysMenuDO> childList) {
        this.childList = childList;
    }
}
