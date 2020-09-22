package com.ksc.kdts.taskmonitor.cons;

public enum  UserCarStateEnum {

    //审核状态，0:未审核；1：已审核；2：审核未通过
    未审核(0),
    已审核(1),
    审核未通过(2);

    private Integer code;

    private UserCarStateEnum(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }


    public static UserCarStateEnum getStateName(Integer code){
        if(code == 0){
            return UserCarStateEnum.未审核;
        }else if(code == 1){
            return UserCarStateEnum.已审核;
        }else if(code == 2){
            return UserCarStateEnum.审核未通过;
        }
        return null;
    }

}
