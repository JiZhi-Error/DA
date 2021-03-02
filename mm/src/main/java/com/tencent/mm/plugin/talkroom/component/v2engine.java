package com.tencent.mm.plugin.talkroom.component;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;

public class v2engine {
    public native int Close();

    public native int GetAudioData(PByteArray pByteArray, int i2, PInt pInt, PInt pInt2);

    public native int GetStatis(PByteArray pByteArray, String str);

    public native int IsSilenceFrame();

    public native int Open(b bVar, int i2, int i3, int i4, long j2, int i5, byte[] bArr, int i6);

    public native int Send(byte[] bArr, short s);

    public native int SetCurrentMicId(int i2);

    public native int initLive(int i2, String str);

    public native int uninitLive();
}
