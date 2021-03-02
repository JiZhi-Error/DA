package com.tencent.mm.plugin.collect.model.voice;

public class SynthesizerNative {
    public native int init(byte[] bArr);

    public native int readmoney(byte[] bArr, byte[] bArr2, int i2, float f2, float f3);

    public native void release();
}
