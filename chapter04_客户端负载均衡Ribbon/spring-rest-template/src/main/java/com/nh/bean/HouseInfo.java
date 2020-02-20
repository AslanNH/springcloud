package com.nh.bean;

public class HouseInfo {

    private long id;
    private String province;
    private String block;
    private String street;


    public HouseInfo() {
    }

    public HouseInfo(long id, String province, String block, String street) {
        this.id = id;
        this.province = province;
        this.block = block;
        this.street = street;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
