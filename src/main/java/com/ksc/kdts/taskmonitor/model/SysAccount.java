package com.ksc.kdts.taskmonitor.model;

import java.util.Date;

/**
 * <p>
 * 账号表
 * </p>
 *
 * @author Richard
 * @since 2019-11-18
 */
public class SysAccount extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private Long roleId;
    private String loginName;
    private String password;
    private String name;
    private Integer gender;
    private String certifiedMobile;
    private long departmentId;
    private long companyId;
    private String wechatNumber;
    private Date entryTime;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCertifiedMobile() {
        return certifiedMobile;
    }

    public void setCertifiedMobile(String certifiedMobile) {
        this.certifiedMobile = certifiedMobile;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getWechatNumber() {
        return wechatNumber;
    }

    public void setWechatNumber(String wechatNumber) {
        this.wechatNumber = wechatNumber;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }
}