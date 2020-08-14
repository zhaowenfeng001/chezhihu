package com.ksc.kdts.taskmonitor.model;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 账号表 查询
 * </p>
 *
 * @author Richard
 * @since 2019-11-18
 */
public class SysAccountQuery implements Serializable{
	private List<Long> idList;

    private Long id;
    
    /**
     * 登录用的验证码
     */
    private String vcCode;
    
    /**
     * 登录用的token
     */
    private String vcToken;

    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 登录账号
     */
    private String loginName;

    private String password;

    private String mobileLike;

    /**
     * 学历多选  学历 1本科 2硕士 3博士 4本科以下 5博士以上'
     */
    private List<Integer> eduList;

    /**
     * 统一格式 yyyy-MM-dd
     */
    private String startCreateTime;
    private String endCreateTime;
    private String startUpdateTime;
    private String endUpdateTime;
    /**
     * 入职时间
     */
    private String startEntryTime;
    /**
     * 入职时间
     */
    private String endEntryTime;

    /**
     * 被分享的销售顾问
     */
    private Long shareAccountId;

    /**
     * 顾客id
     */
    private Long customerId;

    /***
     * 是否推送保险数据
     */
    private Integer sendInsure;

    /**
     * 销售顾问id
     */
    private Long salesId;

    /**
     * 店铺id
     */
    private Long storeId;

    private String nameLike; //姓名匹配


    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVcCode() {
        return vcCode;
    }

    public void setVcCode(String vcCode) {
        this.vcCode = vcCode;
    }

    public String getVcToken() {
        return vcToken;
    }

    public void setVcToken(String vcToken) {
        this.vcToken = vcToken;
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

    public String getMobileLike() {
        return mobileLike;
    }

    public void setMobileLike(String mobileLike) {
        this.mobileLike = mobileLike;
    }

    public List<Integer> getEduList() {
        return eduList;
    }

    public void setEduList(List<Integer> eduList) {
        this.eduList = eduList;
    }

    public String getStartCreateTime() {
        return startCreateTime;
    }

    public void setStartCreateTime(String startCreateTime) {
        this.startCreateTime = startCreateTime;
    }

    public String getEndCreateTime() {
        return endCreateTime;
    }

    public void setEndCreateTime(String endCreateTime) {
        this.endCreateTime = endCreateTime;
    }

    public String getStartUpdateTime() {
        return startUpdateTime;
    }

    public void setStartUpdateTime(String startUpdateTime) {
        this.startUpdateTime = startUpdateTime;
    }

    public String getEndUpdateTime() {
        return endUpdateTime;
    }

    public void setEndUpdateTime(String endUpdateTime) {
        this.endUpdateTime = endUpdateTime;
    }

    public String getStartEntryTime() {
        return startEntryTime;
    }

    public void setStartEntryTime(String startEntryTime) {
        this.startEntryTime = startEntryTime;
    }

    public String getEndEntryTime() {
        return endEntryTime;
    }

    public void setEndEntryTime(String endEntryTime) {
        this.endEntryTime = endEntryTime;
    }

    public Long getShareAccountId() {
        return shareAccountId;
    }

    public void setShareAccountId(Long shareAccountId) {
        this.shareAccountId = shareAccountId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getSendInsure() {
        return sendInsure;
    }

    public void setSendInsure(Integer sendInsure) {
        this.sendInsure = sendInsure;
    }

    public Long getSalesId() {
        return salesId;
    }

    public void setSalesId(Long salesId) {
        this.salesId = salesId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getNameLike() {
        return nameLike;
    }

    public void setNameLike(String nameLike) {
        this.nameLike = nameLike;
    }
}
