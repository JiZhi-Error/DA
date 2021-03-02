package com.tencent.liteav.audio;

public interface e {
    void onRecordEncData(byte[] bArr, long j2, int i2, int i3, int i4);

    void onRecordError(int i2, String str);

    void onRecordPcmData(byte[] bArr, long j2, int i2, int i3, int i4);

    void onRecordRawPcmData(byte[] bArr, long j2, int i2, int i3, int i4, boolean z);
}
