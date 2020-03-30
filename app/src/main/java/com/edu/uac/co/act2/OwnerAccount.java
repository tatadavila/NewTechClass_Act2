package com.edu.uac.co.act2;

public class OwnerAccount {
    private String owner;
    private String tower;
    private String apartment;
    private String area;

    public OwnerAccount(String owner, String tower, String apartment, String area) {
        this.owner = owner;
        this.tower = tower;
        this.apartment = apartment;
        this.area = area;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTower() {
        return tower;
    }

    public void setTower(String tower) {
        this.tower = tower;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
