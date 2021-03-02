package com.bumptech.glide.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public final class d extends InputStream {
    private static final Queue<d> aNN = k.ds(0);
    private InputStream aNO;
    public IOException aNP;

    static {
        AppMethodBeat.i(77745);
        AppMethodBeat.o(77745);
    }

    public static d e(InputStream inputStream) {
        d poll;
        AppMethodBeat.i(77734);
        synchronized (aNN) {
            try {
                poll = aNN.poll();
            } catch (Throwable th) {
                AppMethodBeat.o(77734);
                throw th;
            }
        }
        if (poll == null) {
            poll = new d();
        }
        poll.aNO = inputStream;
        AppMethodBeat.o(77734);
        return poll;
    }

    d() {
    }

    @Override // java.io.InputStream
    public final int available() {
        AppMethodBeat.i(77735);
        int available = this.aNO.available();
        AppMethodBeat.o(77735);
        return available;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public final void close() {
        AppMethodBeat.i(77736);
        this.aNO.close();
        AppMethodBeat.o(77736);
    }

    public final void mark(int i2) {
        AppMethodBeat.i(77737);
        this.aNO.mark(i2);
        AppMethodBeat.o(77737);
    }

    public final boolean markSupported() {
        AppMethodBeat.i(77738);
        boolean markSupported = this.aNO.markSupported();
        AppMethodBeat.o(77738);
        return markSupported;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        int i2;
        AppMethodBeat.i(77739);
        try {
            i2 = this.aNO.read(bArr);
        } catch (IOException e2) {
            this.aNP = e2;
            i2 = -1;
        }
        AppMethodBeat.o(77739);
        return i2;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        int i4;
        AppMethodBeat.i(77740);
        try {
            i4 = this.aNO.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.aNP = e2;
            i4 = -1;
        }
        AppMethodBeat.o(77740);
        return i4;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        AppMethodBeat.i(77741);
        this.aNO.reset();
        AppMethodBeat.o(77741);
    }

    @Override // java.io.InputStream
    public final long skip(long j2) {
        long j3;
        AppMethodBeat.i(77742);
        try {
            j3 = this.aNO.skip(j2);
        } catch (IOException e2) {
            this.aNP = e2;
            j3 = 0;
        }
        AppMethodBeat.o(77742);
        return j3;
    }

    @Override // java.io.InputStream
    public final int read() {
        int i2;
        AppMethodBeat.i(77743);
        try {
            i2 = this.aNO.read();
        } catch (IOException e2) {
            this.aNP = e2;
            i2 = -1;
        }
        AppMethodBeat.o(77743);
        return i2;
    }

    public final void release() {
        AppMethodBeat.i(77744);
        this.aNP = null;
        this.aNO = null;
        synchronized (aNN) {
            try {
                aNN.offer(this);
            } finally {
                AppMethodBeat.o(77744);
            }
        }
    }
}
