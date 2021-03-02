package com.tencent.tbs.one.impl.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tbs.one.impl.a.c;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;

public final class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    boolean f2422a;

    /* renamed from: b  reason: collision with root package name */
    private final RandomAccessFile f2423b;

    /* renamed from: c  reason: collision with root package name */
    private final File f2424c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f2425d = new byte[8];

    public a(File file) {
        AppMethodBeat.i(173819);
        this.f2424c = file;
        this.f2423b = new RandomAccessFile(this.f2424c, "r");
        AppMethodBeat.o(173819);
    }

    public final int a(byte[] bArr) {
        AppMethodBeat.i(173821);
        int read = this.f2423b.read(bArr);
        AppMethodBeat.o(173821);
        return read;
    }

    public final int a(char[] cArr) {
        AppMethodBeat.i(173822);
        byte[] bArr = new byte[cArr.length];
        int read = this.f2423b.read(bArr);
        for (int i2 = 0; i2 < cArr.length; i2++) {
            cArr[i2] = (char) bArr[i2];
        }
        AppMethodBeat.o(173822);
        return read;
    }

    public final short a() {
        AppMethodBeat.i(173823);
        short readShort = this.f2423b.readShort();
        if (this.f2422a) {
            short s = (short) (((readShort & 65280) >>> 8) | ((readShort & 255) << 8));
            AppMethodBeat.o(173823);
            return s;
        }
        AppMethodBeat.o(173823);
        return readShort;
    }

    public final void a(long j2) {
        AppMethodBeat.i(173820);
        this.f2423b.seek(j2);
        AppMethodBeat.o(173820);
    }

    public final int b() {
        AppMethodBeat.i(173824);
        int readInt = this.f2423b.readInt();
        if (this.f2422a) {
            int i2 = ((readInt & WebView.NIGHT_MODE_COLOR) >>> 24) | ((readInt & 255) << 24) | ((65280 & readInt) << 8) | ((16711680 & readInt) >>> 8);
            AppMethodBeat.o(173824);
            return i2;
        }
        AppMethodBeat.o(173824);
        return readInt;
    }

    public final long c() {
        AppMethodBeat.i(173825);
        if (this.f2422a) {
            this.f2423b.readFully(this.f2425d, 0, 8);
            long j2 = (((long) this.f2425d[7]) << 56) | (((long) (this.f2425d[6] & 255)) << 48) | (((long) (this.f2425d[5] & 255)) << 40) | (((long) (this.f2425d[4] & 255)) << 32) | (((long) (this.f2425d[3] & 255)) << 24) | (((long) (this.f2425d[2] & 255)) << 16) | (((long) (this.f2425d[1] & 255)) << 8) | ((long) (this.f2425d[0] & 255));
            AppMethodBeat.o(173825);
            return j2;
        }
        long readLong = this.f2423b.readLong();
        AppMethodBeat.o(173825);
        return readLong;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(173826);
        c.a(this.f2423b);
        AppMethodBeat.o(173826);
    }
}
