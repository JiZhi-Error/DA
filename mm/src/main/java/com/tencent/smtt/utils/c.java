package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class c implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final RandomAccessFile f2166a;

    /* renamed from: b  reason: collision with root package name */
    private final File f2167b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f2168c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2169d;

    public c(String str) {
        this(new File(str));
        AppMethodBeat.i(53949);
        AppMethodBeat.o(53949);
    }

    public c(File file) {
        AppMethodBeat.i(53950);
        this.f2168c = new byte[8];
        this.f2167b = file;
        this.f2166a = new RandomAccessFile(this.f2167b, "r");
        AppMethodBeat.o(53950);
    }

    public void a(boolean z) {
        this.f2169d = z;
    }

    public void a(long j2) {
        AppMethodBeat.i(53951);
        this.f2166a.seek(j2);
        AppMethodBeat.o(53951);
    }

    public final int a(byte[] bArr) {
        AppMethodBeat.i(53952);
        int read = this.f2166a.read(bArr);
        AppMethodBeat.o(53952);
        return read;
    }

    public final int a(char[] cArr) {
        AppMethodBeat.i(53953);
        byte[] bArr = new byte[cArr.length];
        int read = this.f2166a.read(bArr);
        for (int i2 = 0; i2 < cArr.length; i2++) {
            cArr[i2] = (char) bArr[i2];
        }
        AppMethodBeat.o(53953);
        return read;
    }

    public final short a() {
        AppMethodBeat.i(53954);
        short readShort = this.f2166a.readShort();
        if (this.f2169d) {
            short s = (short) (((readShort & 65280) >>> 8) | ((readShort & 255) << 8));
            AppMethodBeat.o(53954);
            return s;
        }
        AppMethodBeat.o(53954);
        return readShort;
    }

    public final int b() {
        AppMethodBeat.i(53955);
        int readInt = this.f2166a.readInt();
        if (this.f2169d) {
            int i2 = ((readInt & WebView.NIGHT_MODE_COLOR) >>> 24) | ((readInt & 255) << 24) | ((65280 & readInt) << 8) | ((16711680 & readInt) >>> 8);
            AppMethodBeat.o(53955);
            return i2;
        }
        AppMethodBeat.o(53955);
        return readInt;
    }

    public final long c() {
        AppMethodBeat.i(53956);
        if (this.f2169d) {
            this.f2166a.readFully(this.f2168c, 0, 8);
            long j2 = (((long) this.f2168c[7]) << 56) | (((long) (this.f2168c[6] & 255)) << 48) | (((long) (this.f2168c[5] & 255)) << 40) | (((long) (this.f2168c[4] & 255)) << 32) | (((long) (this.f2168c[3] & 255)) << 24) | (((long) (this.f2168c[2] & 255)) << 16) | (((long) (this.f2168c[1] & 255)) << 8) | ((long) (this.f2168c[0] & 255));
            AppMethodBeat.o(53956);
            return j2;
        }
        long readLong = this.f2166a.readLong();
        AppMethodBeat.o(53956);
        return readLong;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(53957);
        try {
            this.f2166a.close();
            AppMethodBeat.o(53957);
        } catch (IOException e2) {
            AppMethodBeat.o(53957);
        }
    }
}
