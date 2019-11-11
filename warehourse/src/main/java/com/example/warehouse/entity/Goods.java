package com.example.warehouse.entity;

public class Goods {
    private Integer gid;
    private String gLocation;
    private String gName;
    private Double gPrice;
    private Integer gNumber;
    private String gUnit;
    private Warehouse warehouse;


    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getgLocation() {
        return gLocation;
    }

    public void setgLocation(String gLocation) {
        this.gLocation = gLocation;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public Double getgPrice() {
        return gPrice;
    }

    public void setgPrice(Double gPrice) {
        this.gPrice = gPrice;
    }

    public Integer getgNumber() {
        return gNumber;
    }

    public void setgNumber(Integer gNumber) {
        this.gNumber = gNumber;
    }

    public String getgUnit() {
        return gUnit;
    }

    public void setgUnit(String gUnit) {
        this.gUnit = gUnit;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", gLocation='" + gLocation + '\'' +
                ", gName='" + gName + '\'' +
                ", gPrice=" + gPrice +
                ", gNumber=" + gNumber +
                ", gUnit='" + gUnit + '\'' +
                ", Warehouse='" + warehouse + '\'' +
                '}';
    }
}
