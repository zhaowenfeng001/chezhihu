package com.ksc.kdts.taskmonitor.model;

import java.util.List;

/**
 * <p>
 * 账号表 领域模型
 * </p>
 *
 * @author Richard
 * @since 2019-11-18
 */
public class SysAccountDO extends SysAccount{
	private List<SysMenuDO> menuList;//账号关联的菜单列表(树形结构)
	private String token;
	private String genderName;

	public List<SysMenuDO> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<SysMenuDO> menuList) {
		this.menuList = menuList;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

}
