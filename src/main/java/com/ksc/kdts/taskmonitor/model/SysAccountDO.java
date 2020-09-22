package com.ksc.kdts.taskmonitor.model;

import com.ksc.kdts.taskmonitor.util.StringUtils;

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

	private String companyName;
	private String departmentName;

	private String managerName;

	public String getManagerName() {
		if(StringUtils.isBlank(managerName)){
			if(this.getManager()==0l){
				return "员工";
			}else if (this.getManager()==1l){
				return "管理者";
			}
		}
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

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
