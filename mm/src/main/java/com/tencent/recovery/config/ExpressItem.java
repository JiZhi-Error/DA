package com.tencent.recovery.config;

public class ExpressItem {
    private int count;
    private int processStage;
    private int processStartFlag;
    private int processStatus;

    public ExpressItem(int i2, int i3, int i4, int i5) {
        this.processStartFlag = i2;
        this.processStage = i3;
        this.processStatus = i4;
        this.count = i5;
    }

    public int getProcessStartFlag() {
        return this.processStartFlag;
    }

    public void setProcessStartFlag(int i2) {
        this.processStartFlag = i2;
    }

    public int getProcessStage() {
        return this.processStage;
    }

    public void setProcessStage(int i2) {
        this.processStage = i2;
    }

    public int getProcessStatus() {
        return this.processStatus;
    }

    public void setProcessStatus(int i2) {
        this.processStatus = i2;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i2) {
        this.count = i2;
    }
}
