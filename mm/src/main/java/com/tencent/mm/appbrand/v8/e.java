package com.tencent.mm.appbrand.v8;

import java.nio.ByteBuffer;

public interface e {
    void bufferStoreBindTo(long j2, long j3);

    int generateId();

    ByteBuffer getBuffer(int i2, boolean z);

    void releaseDirectByteBuffer(ByteBuffer byteBuffer);

    void setBuffer(int i2, ByteBuffer byteBuffer);

    boolean supportBufferStoreBindTo();
}
