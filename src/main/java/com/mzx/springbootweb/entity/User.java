package com.mzx.springbootweb.entity;

public class User {
    private int id;
    private String userA;
    private String userB;
    private String startTime;
    private String endTime;
    private String addressCodeA;
    private String addressCodeB;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserA() {
        return userA;
    }

    public void setUserA(String userA) {
        this.userA = userA;
    }

    public String getUserB() {
        return userB;
    }

    public void setUserB(String userB) {
        this.userB = userB;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAddressCodeA() {
        return addressCodeA;
    }

    public void setAddressCodeA(String addressCodeA) {
        this.addressCodeA = addressCodeA;
    }

    public String getAddressCodeB() {
        return addressCodeB;
    }

    public void setAddressCodeB(String addressCodeB) {
        this.addressCodeB = addressCodeB;
    }
}
