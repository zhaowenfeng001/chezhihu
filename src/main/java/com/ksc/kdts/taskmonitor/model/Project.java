package com.ksc.kdts.taskmonitor.model;

/**
 * @ClassName Project
 * @Author wenfeng.zhao
 * @Date 2018/11/12 15:23
 **/
public class Project {
    private Integer id;

    private String name;

    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
