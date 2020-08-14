package com.ksc.kdts.taskmonitor.model;

/**
 * @ClassName Project
 * @Author wenfeng.zhao
 * @Date 2018/11/12 15:23
 **/
public class Flows {
    private Integer id;

    private String uuid;

    private String flowName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }
}
