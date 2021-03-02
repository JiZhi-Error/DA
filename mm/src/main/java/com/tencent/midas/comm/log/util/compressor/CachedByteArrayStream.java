package com.tencent.midas.comm.log.util.compressor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public class CachedByteArrayStream extends OutputStream {
    private final int BUFFER_SIZE;
    private final byte[] _bytes;
    protected byte[] buf;
    protected int count;

    public CachedByteArrayStream() {
        AppMethodBeat.i(193464);
        this.BUFFER_SIZE = 512;
        this._bytes = new byte[512];
        this.buf = this._bytes;
        AppMethodBeat.o(193464);
    }

    public CachedByteArrayStream(int i2) {
        AppMethodBeat.i(193465);
        this.BUFFER_SIZE = 512;
        this._bytes = new byte[512];
        if (i2 >= 0) {
            this.buf = new byte[i2];
            AppMethodBeat.o(193465);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("size < 0");
        AppMethodBeat.o(193465);
        throw illegalArgumentException;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(193466);
        super.close();
        AppMethodBeat.o(193466);
    }

    private void expand(int i2) {
        AppMethodBeat.i(193467);
        if (this.count + i2 <= this.buf.length) {
            AppMethodBeat.o(193467);
            return;
        }
        byte[] bArr = new byte[((this.count + i2) * 2)];
        System.arraycopy(this.buf, 0, bArr, 0, this.count);
        this.buf = bArr;
        AppMethodBeat.o(193467);
    }

    public synchronized void reset() {
        this.buf = this._bytes;
        this.count = 0;
    }

    public int size() {
        return this.count;
    }

    public synchronized byte[] toByteArray() {
        byte[] bArr;
        AppMethodBeat.i(193468);
        bArr = new byte[this.count];
        System.arraycopy(this.buf, 0, bArr, 0, this.count);
        AppMethodBeat.o(193468);
        return bArr;
    }

    public String toString() {
        AppMethodBeat.i(193469);
        String str = new String(this.buf, 0, this.count);
        AppMethodBeat.o(193469);
        return str;
    }

    @Deprecated
    public String toString(int i2) {
        AppMethodBeat.i(193470);
        char[] cArr = new char[size()];
        for (int i3 = 0; i3 < cArr.length; i3++) {
            cArr[i3] = (char) (((i2 & 255) << 8) | (this.buf[i3] & 255));
        }
        String str = new String(cArr);
        AppMethodBeat.o(193470);
        return str;
    }

    public String toString(String str) {
        AppMethodBeat.i(193471);
        String str2 = new String(this.buf, 0, this.count, str);
        AppMethodBeat.o(193471);
        return str2;
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(193472);
        checkOffsetAndCount(bArr.length, i2, i3);
        if (i3 == 0) {
            AppMethodBeat.o(193472);
        } else {
            expand(i3);
            System.arraycopy(bArr, i2, this.buf, this.count, i3);
            this.count += i3;
            AppMethodBeat.o(193472);
        }
    }

    private static void checkOffsetAndCount(int i2, int i3, int i4) {
        AppMethodBeat.i(193473);
        if ((i3 | i4) < 0 || i3 > i2 || i2 - i3 < i4) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException("arrayLength: " + i2 + ", offset: " + i3 + ", count: " + i4);
            AppMethodBeat.o(193473);
            throw arrayIndexOutOfBoundsException;
        }
        AppMethodBeat.o(193473);
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i2) {
        AppMethodBeat.i(193474);
        if (this.count == this.buf.length) {
            expand(1);
        }
        byte[] bArr = this.buf;
        int i3 = this.count;
        this.count = i3 + 1;
        bArr[i3] = (byte) i2;
        AppMethodBeat.o(193474);
    }

    public synchronized void writeTo(OutputStream outputStream) {
        AppMethodBeat.i(193475);
        outputStream.write(this.buf, 0, this.count);
        AppMethodBeat.o(193475);
    }
}
