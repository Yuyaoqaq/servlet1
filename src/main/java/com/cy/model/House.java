package com.cy.model;

import java.util.Date;

public class House {
    private int id;
    private String address;
    private int floor;
    private int roomNum;

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", floor=" + floor +
                ", roomNum=" + roomNum +
                ", area='" + area + '\'' +
                ", dir='" + dir + '\'' +
                ", deco=" + deco +
                ", air=" + air +
                ", price=" + price +
                ", rentStatus=" + rentStatus +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public int getDeco() {
        return deco;
    }

    public void setDeco(int deco) {
        this.deco = deco;
    }

    public int getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(int rentStatus) {
        this.rentStatus = rentStatus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAir() {
        return air;
    }

    public void setAir(int air) {
        this.air = air;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private String area;
    private String dir;
    private int deco;
    private int air;
    private double price;
    private int rentStatus;
    private Date addTime;
    private Date updateTime;
    private int status;
}
