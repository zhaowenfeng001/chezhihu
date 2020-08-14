package com.ksc.kdts.taskmonitor.model;

import java.io.Serializable;
import java.util.List;

public class SysMenuQuery implements Serializable {
    private String name;//菜单名字
    private List<Long> idList;
    private Long pid;//父节点id
    private String lastSql;
    private Long id;
    private Long begin;
    private Long size;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getBegin() {
        return begin;
    }

    public void setBegin(Long begin) {
        this.begin = begin;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getLastSql() {
        return lastSql;
    }

    public void setLastSql(String lastSql) {
        this.lastSql = lastSql;
    }
}

