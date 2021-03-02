package com.tencent.recovery.wx.util;

/* access modifiers changed from: package-private */
public class MyByteArray {
    public byte[] array;
    public int begin;

    public MyByteArray() {
        this.begin = 0;
        this.array = new byte[256];
    }

    public MyByteArray(byte b2) {
        this.begin = 0;
        this.array = new byte[]{b2};
    }

    public MyByteArray(byte[] bArr) {
        this.begin = 0;
        this.array = bArr;
    }

    public MyByteArray(MyByteArray myByteArray) {
        this.begin = myByteArray.begin;
        this.array = myByteArray.array;
    }

    public MyByteArray(int i2, byte[] bArr) {
        this.begin = i2;
        this.array = bArr;
    }

    public MyByteArray copy() {
        return new MyByteArray(this.begin, this.array);
    }
}
