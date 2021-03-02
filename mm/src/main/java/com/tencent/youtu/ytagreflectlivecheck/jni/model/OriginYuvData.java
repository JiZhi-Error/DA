package com.tencent.youtu.ytagreflectlivecheck.jni.model;

public class OriginYuvData {
    int height;
    int width;
    public byte[] yuvData;

    public void setYuvData(byte[] bArr) {
        this.yuvData = bArr;
    }

    public byte[] getYuvData() {
        return this.yuvData;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i2) {
        this.width = i2;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i2) {
        this.height = i2;
    }
}
