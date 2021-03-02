package com.qq.wx.voice.vad;

public class MMVoipVadNative {
    public native int AddData(long j2, short[] sArr, int i2);

    public native long Init(int i2, int i3, float f2, int i4, int i5);

    public native int Release(long j2);

    public native int Reset(long j2);
}
