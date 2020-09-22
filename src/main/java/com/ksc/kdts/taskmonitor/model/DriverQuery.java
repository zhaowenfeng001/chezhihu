package com.ksc.kdts.taskmonitor.model;

import java.io.Serializable;
import java.util.Date;

public class DriverQuery implements Serializable {

    private Long id;
    private String roleName;
    private String name;
    private String certifiedMobile;
    private String mobileLike;
    private String startEntryTime;
    private String endEntryTime;
    private String nameLike; //姓名匹配
    private Long begin;
    private Long size;


    public String getCertifiedMobile() {
        return certifiedMobile;
    }

    public void setCertifiedMobile(String certifiedMobile) {
        this.certifiedMobile = certifiedMobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getMobileLike() {
        return mobileLike;
    }

    public void setMobileLike(String mobileLike) {
        this.mobileLike = mobileLike;
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

    public String getNameLike() {
        return nameLike;
    }

    public void setNameLike(String nameLike) {
        this.nameLike = nameLike;
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
}

