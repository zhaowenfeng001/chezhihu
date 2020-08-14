package com.ksc.kdts.taskmonitor.model;

import java.util.Date;

/**
 * @ClassName ExecutionJob
 * @Author wenfeng.zhao
 * @Date 2018/11/12 15:23
 **/
public class FaQuanBao {

//    `id` bigint(12) NOT NULL AUTO_INCREMENT,
//    `click` varchar(64) DEFAULT NULL COMMENT '点击数',
//    `cost` varchar(64) NOT NULL COMMENT '消费',
//    `cpm` varchar(128) NOT NULL COMMENT 'cpm',
//    `ctr` varchar(128) NOT NULL COMMENT '点击率',
//    `impression` varchar(128) NOT NULL COMMENT '累积曝光次数',
//    `ppc` varchar(128) NOT NULL COMMENT 'ppc',
//    `r_time` varchar(128) NOT NULL COMMENT 'time',
//    `r_time` bigint(12) DEFAULT '0',
//    `create_time` datetime NOT NULL,
//    `update_by` bigint(12) DEFAULT '0',
//    `update_time` datetime NOT NULL,

    private String id;
    private String click;
    private String cost;
    private String cpm;
    private String ctr;
    private String impression;
    private String ppc;
    private String r_time;
    private String create_by;
    private Date create_time;
    private String update_by;
    private String update_time;


    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCpm() {
        return cpm;
    }

    public void setCpm(String cpm) {
        this.cpm = cpm;
    }

    public String getCtr() {
        return ctr;
    }

    public void setCtr(String ctr) {
        this.ctr = ctr;
    }

    public String getImpression() {
        return impression;
    }

    public void setImpression(String impression) {
        this.impression = impression;
    }

    public String getPpc() {
        return ppc;
    }

    public void setPpc(String ppc) {
        this.ppc = ppc;
    }

    public String getR_time() {
        return r_time;
    }

    public void setR_time(String r_time) {
        this.r_time = r_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}
