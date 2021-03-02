package com.tencent.mm.ai;

import java.io.Closeable;

public interface e extends Closeable {
    int aYm();

    long getSize();

    boolean isOpen();

    void open();

    int readAt(long j2, byte[] bArr, int i2, int i3);
}
