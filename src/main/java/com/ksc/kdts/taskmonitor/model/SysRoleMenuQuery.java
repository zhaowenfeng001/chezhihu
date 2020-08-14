package com.ksc.kdts.taskmonitor.model;

import java.io.Serializable;

public class SysRoleMenuQuery implements Serializable {
    private Long roleId;//角色id
    private Long menuId;//菜单id

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
