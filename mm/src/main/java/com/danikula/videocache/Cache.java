package com.danikula.videocache;

public interface Cache {
    void append(byte[] bArr, int i2);

    long available();

    void close();

    void complete();

    boolean isCompleted();

    int read(byte[] bArr, long j2, int i2);
}
