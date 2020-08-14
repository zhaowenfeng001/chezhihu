package com.ksc.kdts.taskmonitor.model;

import java.util.Date;

/**
 * @ClassName ExecutionJob
 * @Author wenfeng.zhao
 * @Date 2018/11/12 15:23
 **/
public class ExecutionJob {

    private String taskId;
    private String jobId;
    private Date bussinessDate;
    private Date triggerTime;
    private Date dependencyTime;
    private Integer status;
    private String effectDescr;
    private String beginTime;
    private String endTime;


    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Date getBussinessDate() {
        return bussinessDate;
    }

    public void setBussinessDate(Date bussinessDate) {
        this.bussinessDate = bussinessDate;
    }

    public Date getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
    }

    public Date getDependencyTime() {
        return dependencyTime;
    }

    public void setDependencyTime(Date dependencyTime) {
        this.dependencyTime = dependencyTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEffectDescr() {
        return effectDescr;
    }

    public void setEffectDescr(String effectDescr) {
        this.effectDescr = effectDescr;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}
