package com.tencent.mm.audio.mix.h;

import com.tencent.mm.ai.b;

public interface c {
    b ZU();

    String ZV();

    void connect();

    void disconnect();

    long getSize();

    int readAt(long j2, byte[] bArr, int i2, int i3);
}
