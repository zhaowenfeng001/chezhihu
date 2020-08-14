package com.ksc.kdts.taskmonitor.model;

import com.ksc.kdts.taskmonitor.util.DateUtils;
import com.ksc.kdts.taskmonitor.util.StringUtils;

import java.util.Objects;

/**
 * @ClassName ExecutionJob
 * @Author wenfeng.zhao
 * @Date 2018/11/12 15:23
 **/
public class FaQuanBaoRequest {

  private String id;
  private String click;
  private String cost;
  private String cpm;
  private String ctr;
  private String impression;
  private String ppc;
  private String r_time;
  private String create_time;
  private String update_by;
  private String update_time;


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

  public String getCreate_time() {
    return create_time;
  }

  public void setCreate_time(String create_time) {
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
