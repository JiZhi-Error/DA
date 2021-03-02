package com.tencent.tbs.one.impl.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

public final class k extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public long f2369a = 0;

    /* renamed from: b  reason: collision with root package name */
    public a f2370b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f2371c;

    /* renamed from: d  reason: collision with root package name */
    private long f2372d;

    /* renamed from: e  reason: collision with root package name */
    private int f2373e = 0;

    public interface a {
        void a(int i2);

        boolean a();
    }

    public k(InputStream inputStream, long j2) {
        this.f2371c = inputStream;
        this.f2372d = j2;
    }

    private void a() {
        AppMethodBeat.i(173945);
        if (this.f2370b == null || this.f2370b.a()) {
            AppMethodBeat.o(173945);
            return;
        }
        IOException iOException = new IOException("Aborted");
        AppMethodBeat.o(173945);
        throw iOException;
    }

    private void b() {
        AppMethodBeat.i(173955);
        if (this.f2372d > 0 && this.f2370b != null) {
            int i2 = (int) ((((double) this.f2369a) / ((double) this.f2372d)) * 100.0d);
            if (i2 - this.f2373e >= 2) {
                this.f2373e = i2;
                this.f2370b.a(i2);
            }
        }
        AppMethodBeat.o(173955);
    }

    @Override // java.io.InputStream
    public final int available() {
        AppMethodBeat.i(173950);
        int available = this.f2371c.available();
        AppMethodBeat.o(173950);
        return available;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public final void close() {
        AppMethodBeat.i(173951);
        this.f2371c.close();
        AppMethodBeat.o(173951);
    }

    public final synchronized void mark(int i2) {
        AppMethodBeat.i(173952);
        this.f2371c.mark(i2);
        AppMethodBeat.o(173952);
    }

    public final boolean markSupported() {
        AppMethodBeat.i(173954);
        boolean markSupported = this.f2371c.markSupported();
        AppMethodBeat.o(173954);
        return markSupported;
    }

    @Override // java.io.InputStream
    public final int read() {
        AppMethodBeat.i(173946);
        a();
        int read = this.f2371c.read();
        if (read != -1) {
            this.f2369a++;
            b();
        }
        AppMethodBeat.o(173946);
        return read;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        AppMethodBeat.i(173947);
        a();
        int read = this.f2371c.read(bArr);
        if (read != -1) {
            this.f2369a += (long) read;
            b();
        }
        AppMethodBeat.o(173947);
        return read;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(173948);
        a();
        int read = this.f2371c.read(bArr, i2, i3);
        if (read != -1) {
            this.f2369a += (long) read;
            b();
        }
        AppMethodBeat.o(173948);
        return read;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        AppMethodBeat.i(173953);
        this.f2371c.reset();
        AppMethodBeat.o(173953);
    }

    @Override // java.io.InputStream
    public final long skip(long j2) {
        AppMethodBeat.i(173949);
        long skip = this.f2371c.skip(j2);
        AppMethodBeat.o(173949);
        return skip;
    }
}
