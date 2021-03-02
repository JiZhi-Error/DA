package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

public final class q extends BufferedOutputStream {
    private boolean closed;

    public q(OutputStream outputStream) {
        super(outputStream);
    }

    public q(OutputStream outputStream, int i2) {
        super(outputStream, i2);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(93194);
        this.closed = true;
        Throwable th = null;
        try {
            flush();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.out.close();
            th = th;
        } catch (Throwable th3) {
            th = th3;
            if (th != null) {
                th = th;
            }
        }
        if (th != null) {
            x.d(th);
        }
        AppMethodBeat.o(93194);
    }

    public final void a(OutputStream outputStream) {
        AppMethodBeat.i(93195);
        a.checkState(this.closed);
        this.out = outputStream;
        this.count = 0;
        this.closed = false;
        AppMethodBeat.o(93195);
    }
}
