package com.ksc.kdts.taskmonitor.model;

import com.ksc.kdts.taskmonitor.cons.UserCarStateEnum;
import com.ksc.kdts.taskmonitor.util.DateUtils;
import com.ksc.kdts.taskmonitor.util.StringUtils;

import java.util.Date;
import java.util.Objects;

public class UserCarDO extends UserCar{

    private String carNumber;
    private String carModel;
    private String vin;
    private Date entryTime;
    private String entryTimeStr;

    private String stateStr;

    private String userCarName;
    private String driverName;
    private String companyName;
    private String departmentName;


    public String getUserCarName() {
        return userCarName;
    }

    public void setUserCarName(String userCarName) {
        this.userCarName = userCarName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getStateStr() {
        if(StringUtils.isBlank(stateStr)){
            if(Objects.nonNull(super.getState())){
                return UserCarStateEnum.getStateName(super.getState()).toString();
            }
        }
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getEntryTimeStr() {
        if(StringUtils.isBlank(entryTimeStr)){
            if(Objects.nonNull(entryTime)){
                return DateUtils.convertToString(entryTime);
            }
        }

        return entryTimeStr;
    }

    public void setEntryTimeStr(String entryTimeStr) {
        this.entryTimeStr = entryTimeStr;
    }
}
