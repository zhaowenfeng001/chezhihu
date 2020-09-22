package com.ksc.kdts.taskmonitor.model;

import com.ksc.kdts.taskmonitor.util.DateUtils;
import com.ksc.kdts.taskmonitor.util.StringUtils;

import java.util.Date;
import java.util.Objects;

public class Department extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private String departmentName;
    private Date entryTime;
    private String entryTimeStr;
    private Long companyId;
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

}
