package com.ksc.kdts.taskmonitor.model;

import com.ksc.kdts.taskmonitor.util.DateUtils;
import com.ksc.kdts.taskmonitor.util.StringUtils;

import java.util.Date;
import java.util.Objects;

public class Message extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String title;
    private Long applicationId;
    private Long companyId;
    private Long departmentId;


    private Date applicationTime;

    private String applicationTimeStr;


    public String getApplicationTimeStr() {
        if(StringUtils.isBlank(applicationTimeStr)){
            if(Objects.nonNull(applicationTime)){
                return DateUtils.convertToString(applicationTime);
            }
        }

        return applicationTimeStr;
    }

    public void setApplicationTimeStr(String applicationTimeStr) {
        this.applicationTimeStr = applicationTimeStr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public Message getUpdateMessage(Message searchMessage){
        if(this.getTitle()!=null){
            searchMessage.setTitle(this.getTitle());
        }
        searchMessage.setUpdateTime(new Date());
        return searchMessage;
    }


}
