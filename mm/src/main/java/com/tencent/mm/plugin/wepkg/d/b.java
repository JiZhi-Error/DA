package com.tencent.mm.plugin.wepkg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.InputStream;

public final class b extends InputStream {
    private a JOd;
    private long size;

    public b(o oVar, long j2, long j3) {
        AppMethodBeat.i(177092);
        this.size = j3;
        this.JOd = new a(s.ao(oVar));
        Mk(j2);
        this.JOd.gkW();
        AppMethodBeat.o(177092);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        AppMethodBeat.i(110774);
        int read = read(bArr, 0, bArr.length);
        AppMethodBeat.o(110774);
        return read;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(110775);
        long Mj = Mj((long) i3);
        if (Mj != 0 || i3 <= 0) {
            int read = this.JOd.read(bArr, i2, (int) Mj);
            AppMethodBeat.o(110775);
            return read;
        }
        AppMethodBeat.o(110775);
        return -1;
    }

    @Override // java.io.InputStream
    public final long skip(long j2) {
        AppMethodBeat.i(110776);
        long skip = this.JOd.skip(Mj(j2));
        AppMethodBeat.o(110776);
        return skip;
    }

    @Override // java.io.InputStream
    public final int available() {
        AppMethodBeat.i(110777);
        int Mj = (int) Mj((long) this.JOd.available());
        AppMethodBeat.o(110777);
        return Mj;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public final void close() {
        AppMethodBeat.i(110778);
        this.JOd.close();
        super.close();
        AppMethodBeat.o(110778);
    }

    private long Mj(long j2) {
        AppMethodBeat.i(110779);
        long min = Math.min(gkX(), j2);
        AppMethodBeat.o(110779);
        return min;
    }

    private long gkX() {
        return this.size - ((long) this.JOd.count);
    }

    private void Mk(long j2) {
        AppMethodBeat.i(110780);
        long j3 = 0;
        while (j3 < j2) {
            long skip = this.JOd.skip(j2 - j3);
            if (skip <= 0) {
                break;
            }
            j3 += skip;
        }
        if (j3 < j2) {
            IOException iOException = new IOException("could not seek pos ".concat(String.valueOf(j2)));
            AppMethodBeat.o(110780);
            throw iOException;
        }
        AppMethodBeat.o(110780);
    }

    @Override // java.io.InputStream
    public final int read() {
        boolean z;
        AppMethodBeat.i(110773);
        if (gkX() <= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(110773);
            return -1;
        }
        int read = this.JOd.read();
        AppMethodBeat.o(110773);
        return read;
    }
}
