package com.example.warehouse.entity;

public class Supplier {

    private Integer sid;
    private String sName;
    private String sTel;
    private String sEin;
    private Integer sCard;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsTel() {
        return sTel;
    }

    public void setsTel(String sTel) {
        this.sTel = sTel;
    }

    public String getsEin() {
        return sEin;
    }

    public void setsEin(String sEin) {
        this.sEin = sEin;
    }

    public Integer getsCard() {
        return sCard;
    }

    public void setsCard(Integer sCard) {
        this.sCard = sCard;
    }

    @Override
    public String toString() {
        return "supplier{" +
                "sid=" + sid +
                ", sName='" + sName + '\'' +
                ", sTel='" + sTel + '\'' +
                ", sEin='" + sEin + '\'' +
                ", sCard=" + sCard +
                '}';
    }
}
