package com.greglturnquist.payroll.hilo.json;

public class DataSend {
    private Integer operation;
    private Integer deviceIds;
    private Integer index;

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public Integer getDeviceIds() {
        return deviceIds;
    }

    public void setDeviceIds(Integer deviceIds) {
        this.deviceIds = deviceIds;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
