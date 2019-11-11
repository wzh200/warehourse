package com.example.warehouse.entity;

public class Warehouse {
       private Integer wid;
       private String  wName;
       private String  wLeader;
       private String  wAddress;
       private Integer wLocationNum;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName;
    }

    public String getwLeader() {
        return wLeader;
    }

    public void setwLeader(String wLeader) {
        this.wLeader = wLeader;
    }

    public String getwAddress() {
        return wAddress;
    }

    public void setwAddress(String wAddress) {
        this.wAddress = wAddress;
    }

    public Integer getwLocationNum() {
        return wLocationNum;
    }

    public void setwLocationNum(Integer wLocationNum) {
        this.wLocationNum = wLocationNum;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "wid=" + wid +
                ", wName='" + wName + '\'' +
                ", wLeader='" + wLeader + '\'' +
                ", wAddress='" + wAddress + '\'' +
                ", wLocationNum=" + wLocationNum +
                '}';
    }
}
