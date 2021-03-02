package com.tencent.midas.data;

public class APMultiProcessData {
    private String guid = "";
    private int intervalTime = 0;
    private long payInterfaceTime = 0;

    public String getGuid() {
        return this.guid;
    }

    public void setGuid(String str) {
        this.guid = str;
    }

    public long getPayInterfaceTime() {
        return this.payInterfaceTime;
    }

    public void setPayInterfaceTime(long j2) {
        this.payInterfaceTime = j2;
    }

    public int getIntervalTime() {
        return this.intervalTime;
    }

    public void setIntervalTime(int i2) {
        this.intervalTime = i2;
    }
}
