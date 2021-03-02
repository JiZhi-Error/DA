package com.tencent.mm.plugin.imgenc;

public class MMIMAGEENCJNI {
    public static final String TAG = "MMIMAGEENCJNI";

    public static native long free(long j2);

    public static native long open(long j2);

    public static native long open(String str);

    public static native byte[] readByte(long j2, byte[] bArr);

    public static native long seek(long j2, long j3, int i2);

    public static native long transFor(long j2, byte[] bArr, long j3, long j4);
}
