package com.google.android.exoplayer2.h.a;

import com.google.android.exoplayer2.h.a.a;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.i.q;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class b implements f {
    private final a bFT;
    private final long bFU;
    private FileOutputStream bFV;
    private long bFW;
    private long bFX;
    private q bFY;
    private final int bufferSize;
    private j bxj;
    private File file;
    private OutputStream outputStream;

    public static class a extends a.C0112a {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public b(a aVar, long j2, int i2) {
        AppMethodBeat.i(92959);
        this.bFT = (a) com.google.android.exoplayer2.i.a.checkNotNull(aVar);
        this.bFU = j2;
        this.bufferSize = i2;
        AppMethodBeat.o(92959);
    }

    @Override // com.google.android.exoplayer2.h.f
    public final void b(j jVar) {
        AppMethodBeat.i(92960);
        if (jVar.length != -1 || jVar.eW(2)) {
            this.bxj = jVar;
            this.bFX = 0;
            try {
                wO();
                AppMethodBeat.o(92960);
            } catch (IOException e2) {
                a aVar = new a(e2);
                AppMethodBeat.o(92960);
                throw aVar;
            }
        } else {
            this.bxj = null;
            AppMethodBeat.o(92960);
        }
    }

    @Override // com.google.android.exoplayer2.h.f
    public final void write(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(92961);
        if (this.bxj == null) {
            AppMethodBeat.o(92961);
            return;
        }
        int i4 = 0;
        while (i4 < i3) {
            try {
                if (this.bFW == this.bFU) {
                    wP();
                    wO();
                }
                int min = (int) Math.min((long) (i3 - i4), this.bFU - this.bFW);
                this.outputStream.write(bArr, i2 + i4, min);
                i4 += min;
                this.bFW += (long) min;
                this.bFX += (long) min;
            } catch (IOException e2) {
                a aVar = new a(e2);
                AppMethodBeat.o(92961);
                throw aVar;
            }
        }
        AppMethodBeat.o(92961);
    }

    @Override // com.google.android.exoplayer2.h.f
    public final void close() {
        AppMethodBeat.i(92962);
        if (this.bxj == null) {
            AppMethodBeat.o(92962);
            return;
        }
        try {
            wP();
            AppMethodBeat.o(92962);
        } catch (IOException e2) {
            a aVar = new a(e2);
            AppMethodBeat.o(92962);
            throw aVar;
        }
    }

    private void wO() {
        long min;
        AppMethodBeat.i(92963);
        if (this.bxj.length == -1) {
            min = this.bFU;
        } else {
            min = Math.min(this.bxj.length - this.bFX, this.bFU);
        }
        this.file = this.bFT.e(this.bxj.key, this.bxj.bEP + this.bFX, min);
        this.bFV = new FileOutputStream(this.file);
        if (this.bufferSize > 0) {
            if (this.bFY == null) {
                this.bFY = new q(this.bFV, this.bufferSize);
            } else {
                this.bFY.a(this.bFV);
            }
            this.outputStream = this.bFY;
        } else {
            this.outputStream = this.bFV;
        }
        this.bFW = 0;
        AppMethodBeat.o(92963);
    }

    private void wP() {
        AppMethodBeat.i(92964);
        if (this.outputStream == null) {
            AppMethodBeat.o(92964);
            return;
        }
        try {
            this.outputStream.flush();
            this.bFV.getFD().sync();
            x.closeQuietly(this.outputStream);
            this.outputStream = null;
            File file2 = this.file;
            this.file = null;
            this.bFT.w(file2);
            AppMethodBeat.o(92964);
        } catch (Throwable th) {
            x.closeQuietly(this.outputStream);
            this.outputStream = null;
            File file3 = this.file;
            this.file = null;
            file3.delete();
            AppMethodBeat.o(92964);
            throw th;
        }
    }
}
