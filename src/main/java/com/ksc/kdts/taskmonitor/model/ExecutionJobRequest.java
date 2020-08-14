package com.ksc.kdts.taskmonitor.model;

import com.ksc.kdts.taskmonitor.util.DateUtils;
import com.ksc.kdts.taskmonitor.util.StringUtils;

import java.util.Objects;

/**
 * @ClassName ExecutionJob
 * @Author wenfeng.zhao
 * @Date 2018/11/12 15:23
 **/
public class ExecutionJobRequest {

  private String taskId;
  private String jobId;
  private String bussinessDate;
  private String triggerTime;
  private String dependencyTime;
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

  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public String getBussinessDate() {
    return bussinessDate;
  }

  public void setBussinessDate(String bussinessDate) {
    this.bussinessDate = bussinessDate;
  }

  public String getTriggerTime() {
    return triggerTime;
  }

  public void setTriggerTime(String triggerTime) {
    this.triggerTime = triggerTime;
  }

  public String getDependencyTime() {
    return dependencyTime;
  }

  public void setDependencyTime(String dependencyTime) {
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

  public ExecutionJob getExecutorJob(){
    ExecutionJob executionJob = new ExecutionJob();
    if(Objects.nonNull(this.getBussinessDate())&&StringUtils.isNotBlank(this.getBussinessDate())){
      executionJob.setBussinessDate(DateUtils.convertToDate(this.getBussinessDate()).getTime());
    }
    if(Objects.nonNull(this.getDependencyTime())&&StringUtils.isNotBlank(this.getDependencyTime())) {
      executionJob.setDependencyTime(DateUtils.convertToDate(this.getDependencyTime()).getTime());
    }
    if(Objects.nonNull(this.getJobId())&&StringUtils.isNotBlank(this.getJobId())) {
      executionJob.setJobId(this.getJobId());
    }
    if(Objects.nonNull(this.getStatus())) {
      executionJob.setStatus(this.getStatus());
    }
    if(Objects.nonNull(this.getTaskId())&&StringUtils.isNotBlank(this.getTaskId())) {
      executionJob.setTaskId(this.getTaskId());
    }
    if(Objects.nonNull(this.getTriggerTime())&&StringUtils.isNotBlank(this.getTriggerTime())) {
      executionJob.setTriggerTime(DateUtils.convertToDate(this.getTriggerTime()).getTime());
    }

    if(Objects.nonNull(this.getBeginTime())&&StringUtils.isNotBlank(this.getBeginTime())) {
      executionJob.setBeginTime(this.getBeginTime());
    }
    if(Objects.nonNull(this.getEndTime())&&StringUtils.isNotBlank(this.getEndTime())) {
      executionJob.setEndTime(this.getEndTime());
    }
    if(Objects.nonNull(this.getEffectDescr())&&StringUtils.isNotBlank(this.getEffectDescr())) {
      executionJob.setEffectDescr(this.getEffectDescr());
    }
    return executionJob;
  }
}
