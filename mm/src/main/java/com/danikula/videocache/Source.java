package com.danikula.videocache;

public interface Source {
    void close();

    long length();

    void open(long j2);

    int read(byte[] bArr);
}
