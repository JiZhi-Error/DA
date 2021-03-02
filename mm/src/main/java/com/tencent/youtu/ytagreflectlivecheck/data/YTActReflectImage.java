package com.tencent.youtu.ytagreflectlivecheck.data;

public class YTActReflectImage {
    public String checksum;
    public byte[] image;
    public float[] xys;

    public YTActReflectImage(byte[] bArr, float[] fArr, String str) {
        this.image = bArr;
        this.xys = fArr;
        this.checksum = str;
    }
}
