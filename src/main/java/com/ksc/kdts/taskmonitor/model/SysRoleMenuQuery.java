package com.ksc.kdts.taskmonitor.model;

import java.io.Serializable;

public class SysRoleMenuQuery implements Serializable {
    private Long roleId;//角色id
    private Long menuId;//菜单id
    private Long begin;
    private Long size;

    public Long getBegin() {
        return begin;
    }

    public void setBegin(Long begin) {
        this.begin = begin;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}
