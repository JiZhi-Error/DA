package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat;
import java.io.Closeable;

public interface IDataSource extends Closeable {
    AudioFormat.AudioType getAudioType();

    long getSize();

    void open();

    int readAt(long j2, byte[] bArr, int i2, int i3);
}
