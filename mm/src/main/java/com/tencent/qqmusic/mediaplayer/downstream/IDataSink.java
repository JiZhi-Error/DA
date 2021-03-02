package com.tencent.qqmusic.mediaplayer.downstream;

import java.io.Closeable;

public interface IDataSink extends Closeable {
    void open();

    int write(long j2, byte[] bArr, int i2, int i3);
}
