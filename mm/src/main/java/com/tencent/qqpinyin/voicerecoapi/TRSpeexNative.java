package com.tencent.qqpinyin.voicerecoapi;

public class TRSpeexNative {
    public native int nativeTRSpeexDecode(long j2, byte[] bArr, int i2, int i3, byte[] bArr2);

    public native long nativeTRSpeexDecodeInit();

    public native int nativeTRSpeexDecodeRelease(long j2);

    /* access modifiers changed from: package-private */
    public native int nativeTRSpeexEncode(long j2, byte[] bArr, int i2, int i3, byte[] bArr2);

    /* access modifiers changed from: package-private */
    public native long nativeTRSpeexInit();

    /* access modifiers changed from: package-private */
    public native int nativeTRSpeexRelease(long j2);

    TRSpeexNative() {
    }
}
