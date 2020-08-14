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

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 10031001 男 10031002 女
     */
    private Integer gender;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 学历 1本科 2硕士 3博士 4本科以下 5博士以上
     */
    private Integer education;

    /**
     * 入职时间
     */
    private Date entryTime;

    /**
     * 对应门店id
     */
    private Long storeId;

    /**
     * 1休息中 2挪车中 3空闲中 4交车 5接待中 6回访中
     */
    private Integer workStatus;

    /**
     * 头像
     */
    private String headImg;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Integer getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(Integer workStatus) {
        this.workStatus = workStatus;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }


}