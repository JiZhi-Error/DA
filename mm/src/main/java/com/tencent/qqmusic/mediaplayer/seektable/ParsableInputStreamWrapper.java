package com.tencent.qqmusic.mediaplayer.seektable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.Closeable;
import java.nio.charset.Charset;

public class ParsableInputStreamWrapper implements Parsable, Closeable {
    private final IDataSource dataSource;
    private final byte[] intBuffer = new byte[4];
    private final byte[] longBuffer = new byte[8];
    private long position = 0;

    public ParsableInputStreamWrapper(IDataSource iDataSource) {
        AppMethodBeat.i(114219);
        this.dataSource = iDataSource;
        AppMethodBeat.o(114219);
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public int readInt() {
        AppMethodBeat.i(114220);
        int readAt = this.dataSource.readAt(this.position, this.intBuffer, 0, this.intBuffer.length);
        this.position += (long) readAt;
        if (readAt != this.intBuffer.length) {
            AppMethodBeat.o(114220);
            return -1;
        }
        int i2 = ((this.intBuffer[0] & 255) << 24) | ((this.intBuffer[1] & 255) << 16) | ((this.intBuffer[2] & 255) << 8) | (this.intBuffer[3] & 255);
        AppMethodBeat.o(114220);
        return i2;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public long readLong() {
        AppMethodBeat.i(114221);
        int readAt = this.dataSource.readAt(this.position, this.longBuffer, 0, this.longBuffer.length);
        this.position += (long) readAt;
        if (readAt != this.longBuffer.length) {
            AppMethodBeat.o(114221);
            return -1;
        }
        long j2 = ((((long) this.longBuffer[0]) & 255) << 56) | ((((long) this.longBuffer[1]) & 255) << 48) | ((((long) this.longBuffer[2]) & 255) << 40) | ((((long) this.longBuffer[3]) & 255) << 32) | ((((long) this.longBuffer[4]) & 255) << 24) | ((((long) this.longBuffer[5]) & 255) << 16) | ((((long) this.longBuffer[6]) & 255) << 8) | (((long) this.longBuffer[7]) & 255);
        AppMethodBeat.o(114221);
        return j2;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public int[] readIntArray(int i2) {
        AppMethodBeat.i(114222);
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = readInt();
        }
        AppMethodBeat.o(114222);
        return iArr;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public long[] readLongArray(int i2) {
        AppMethodBeat.i(114223);
        long[] jArr = new long[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            jArr[i3] = readLong();
        }
        AppMethodBeat.o(114223);
        return jArr;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public void readIntArrayInterleaved(int i2, int[]... iArr) {
        AppMethodBeat.i(114224);
        for (int i3 = 0; i3 < i2; i3++) {
            for (int[] iArr2 : iArr) {
                iArr2[i3] = readInt();
            }
        }
        AppMethodBeat.o(114224);
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public void readLongArrayInterleaved(int i2, long[]... jArr) {
        AppMethodBeat.i(114225);
        for (int i3 = 0; i3 < i2; i3++) {
            for (long[] jArr2 : jArr) {
                jArr2[i3] = readLong();
            }
        }
        AppMethodBeat.o(114225);
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public void readBytes(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(114226);
        this.position = ((long) this.dataSource.readAt(this.position, bArr, i2, i3)) + this.position;
        AppMethodBeat.o(114226);
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public String readString(int i2) {
        AppMethodBeat.i(114227);
        byte[] bArr = new byte[i2];
        readBytes(bArr, 0, i2);
        String str = new String(bArr, Charset.defaultCharset());
        AppMethodBeat.o(114227);
        return str;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public long available() {
        AppMethodBeat.i(114228);
        long size = this.dataSource.getSize() - this.position;
        AppMethodBeat.o(114228);
        return size;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public long skip(long j2) {
        AppMethodBeat.i(114229);
        long available = available();
        if (available > j2) {
            this.position += j2;
        } else {
            this.position += available;
            j2 = available;
        }
        AppMethodBeat.o(114229);
        return j2;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public long tell() {
        return this.position;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(114230);
        this.dataSource.close();
        AppMethodBeat.o(114230);
    }
}
