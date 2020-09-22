package com.ksc.kdts.taskmonitor.model;

import com.ksc.kdts.taskmonitor.util.DateUtils;
import com.ksc.kdts.taskmonitor.util.StringUtils;

import java.util.Date;
import java.util.Objects;

public class UserCar extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long carId;
    private Long userCarId;
    private Long companyId;
    private Long departmentId;
    private Date userTime;
    private Double kilometers;


    //审核状态，0:未审核；1：已审核；2：审核未通过
    private Integer state;

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getUserCarId() {
        return userCarId;
    }

    public void setUserCarId(Long userCarId) {
        this.userCarId = userCarId;
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

    public Date getUserTime() {
        return userTime;
    }

    public void setUserTime(Date userTime) {
        this.userTime = userTime;
    }

    public Double getKilometers() {
        return kilometers;
    }

    public void setKilometers(Double kilometers) {
        this.kilometers = kilometers;
    }

    public UserCar getUpdateCar(UserCar searchUserCar){
        if(this.getState()!=null){
            searchUserCar.setState(this.getState());
        }
        searchUserCar.setUpdateTime(new Date());
        return searchUserCar;
    }


}
