package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class i extends InputStream {
    private final byte[] bEM;
    long bEN;
    private final g bhK;
    private final j bxj;
    private boolean closed = false;
    private boolean opened = false;

    public i(g gVar, j jVar) {
        AppMethodBeat.i(93037);
        this.bhK = gVar;
        this.bxj = jVar;
        this.bEM = new byte[1];
        AppMethodBeat.o(93037);
    }

    @Override // java.io.InputStream
    public final int read() {
        AppMethodBeat.i(93038);
        if (read(this.bEM) == -1) {
            AppMethodBeat.o(93038);
            return -1;
        }
        int i2 = this.bEM[0] & 255;
        AppMethodBeat.o(93038);
        return i2;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        AppMethodBeat.i(93039);
        int read = read(bArr, 0, bArr.length);
        AppMethodBeat.o(93039);
        return read;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(93040);
        a.checkState(!this.closed);
        wH();
        int read = this.bhK.read(bArr, i2, i3);
        if (read == -1) {
            AppMethodBeat.o(93040);
            return -1;
        }
        this.bEN += (long) read;
        AppMethodBeat.o(93040);
        return read;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public final void close() {
        AppMethodBeat.i(93041);
        if (!this.closed) {
            this.bhK.close();
            this.closed = true;
        }
        AppMethodBeat.o(93041);
    }

    /* access modifiers changed from: package-private */
    public final void wH() {
        AppMethodBeat.i(93042);
        if (!this.opened) {
            this.bhK.a(this.bxj);
            this.opened = true;
        }
        AppMethodBeat.o(93042);
    }
}
