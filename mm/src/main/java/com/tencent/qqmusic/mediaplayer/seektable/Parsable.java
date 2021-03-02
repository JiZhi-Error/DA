package com.tencent.qqmusic.mediaplayer.seektable;

public interface Parsable {
    long available();

    void readBytes(byte[] bArr, int i2, int i3);

    int readInt();

    int[] readIntArray(int i2);

    void readIntArrayInterleaved(int i2, int[]... iArr);

    long readLong();

    long[] readLongArray(int i2);

    void readLongArrayInterleaved(int i2, long[]... jArr);

    String readString(int i2);

    long skip(long j2);

    long tell();
}
