package com.ksc.kdts.taskmonitor.model;

public class SysRoleMenu extends BaseEntity{

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 权限id
     */
    private Long menuId;


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
