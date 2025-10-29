package com.cy.model;

import java.util.Date;

public class Contract {
    private int id;
    private String num;
    private int hid;
    private int lid;
    private Date time;
    private Date startTime;
    private Date endTime;
    private double totalMoney;
    private int payType;

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", hid=" + hid +
                ", lid=" + lid +
                ", time=" + time +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", totalMoney=" + totalMoney +
                ", payType=" + payType +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }
}
