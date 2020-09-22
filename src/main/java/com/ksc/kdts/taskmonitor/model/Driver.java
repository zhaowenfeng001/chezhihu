package com.ksc.kdts.taskmonitor.model;

import com.ksc.kdts.taskmonitor.util.DateUtils;
import com.ksc.kdts.taskmonitor.util.StringUtils;

import java.util.Date;
import java.util.Objects;

public class Driver extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private String roleName;

    private String name;
    private String certifiedMobile;
    private long departmentId;
    private long companyId;
    private String wechatNumber;
    private Date entryTime;
    private String entryTimeStr;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEntryTimeStr() {
        if(StringUtils.isBlank(entryTimeStr)){
            if(Objects.nonNull(entryTime)){
                return DateUtils.convertToString(entryTime);
            }
        }

        return entryTimeStr;
    }

    public void setEntryTimeStr(String entryTimeStr) {
        this.entryTimeStr = entryTimeStr;
    }
}
