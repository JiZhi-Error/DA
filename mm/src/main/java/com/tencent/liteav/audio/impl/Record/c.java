package com.tencent.liteav.audio.impl.Record;

public interface c {
    void onAudioRecordError(int i2, String str);

    void onAudioRecordPCM(byte[] bArr, int i2, long j2);

    void onAudioRecordStart();

    void onAudioRecordStop();
}
