package com.ksc.kdts.taskmonitor.cons;


public enum ExecutionJobStatusEnum {

    RUNNING(0, "running"),
    SUCC(1, "sucess"),
    FAIL(2, "fail"),
    NONE(-1, "not existence");

    private Integer value;
    private String msg;

    ExecutionJobStatusEnum(Integer value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getValue() {
        return value;
    }


    public static ExecutionJobStatusEnum getEnumByValue(Integer value) {
        ExecutionJobStatusEnum[] values = ExecutionJobStatusEnum.values();
        for (ExecutionJobStatusEnum ejEnum : values) {
            if (ejEnum.getValue().equals(value)) {
                return ejEnum;
            }
        }
        return null;
    }


}
