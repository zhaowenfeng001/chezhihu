package com.ksc.kdts.taskmonitor.model;

import java.util.List;

/**
 * @ClassName ReportRequest
 * @Description 请求参数
 * @Author wenfeng.zhao
 * @Date 2018/11/15 14:21
 **/
public class ReportRequest {

    private String project;

    private String flow;

    private String startDate;

    private String endDate;

    private String userId;

    private Boolean isAdmin;

    private List<Integer> projectList;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public List<Integer> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Integer> projectList) {
        this.projectList = projectList;
    }
}
