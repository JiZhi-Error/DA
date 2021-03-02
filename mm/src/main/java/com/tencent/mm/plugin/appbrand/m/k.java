package com.tencent.mm.plugin.appbrand.m;

import java.nio.ByteBuffer;

public interface k extends j {
    ByteBuffer N(int i2, boolean z);

    void a(y yVar);

    y bMF();

    void bufferStoreBindTo(long j2, long j3);

    int getNativeBufferId();

    void releaseDirectByteBuffer(ByteBuffer byteBuffer);

    void setNativeBuffer(int i2, ByteBuffer byteBuffer);

    boolean supportBufferStoreBindTo();
}
