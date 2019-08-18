package com.mzx.springbootweb.entity;

public class UserLog {
    private int id;
    private String userA;
    private String userB;
    private String startTime;
    private String endTime;
    private String addressCodeA;
    private String addressCodeB;
    private String dataA;
    private String dataB;

    public UserLog() {
    }

    public UserLog(int id) {
        this.id = id;
    }

    public void setUserLog(int id, String userA, String userB, String startTime, String endTime, String addressCodeA, String addressCodeB, String dataA, String dataB) {
        this.id = id;
        this.userA = userA;
        this.userB = userB;
        this.startTime = startTime;
        this.endTime = endTime;
        this.addressCodeA = addressCodeA;
        this.addressCodeB = addressCodeB;
        this.dataA = dataA;
        this.dataB = dataB;
    }

    public String getDataA() {
        return dataA;
    }

    public void setDataA(String dataA) {
        this.dataA = dataA;
    }

    public String getDataB() {
        return dataB;
    }

    public void setDataB(String dataB) {
        this.dataB = dataB;
    }

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
