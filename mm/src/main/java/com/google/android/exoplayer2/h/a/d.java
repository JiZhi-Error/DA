package com.google.android.exoplayer2.h.a;

import android.net.Uri;
import com.google.android.exoplayer2.h.a.a;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.h;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InterruptedIOException;

public final class d implements g {
    private long bEJ;
    private final a bFT;
    private final g bFZ;
    private final g bGa;
    private final g bGb;
    private final a bGc;
    private final boolean bGd;
    private final boolean bGe;
    private final boolean bGf;
    private g bGg;
    private boolean bGh;
    private long bGi;
    private g bGj;
    private boolean bGk;
    private boolean bGl;
    private long bGm;
    private int flags;
    private String key;
    private Uri uri;

    public interface a {
        void k(long j2, long j3);
    }

    public d(a aVar, g gVar, g gVar2, f fVar, int i2, a aVar2) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(92966);
        this.bFT = aVar;
        this.bFZ = gVar2;
        this.bGd = (i2 & 1) != 0;
        if ((i2 & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.bGe = z;
        this.bGf = (i2 & 4) == 0 ? false : z2;
        this.bGb = gVar;
        if (fVar != null) {
            this.bGa = new v(gVar, fVar);
        } else {
            this.bGa = null;
        }
        this.bGc = aVar2;
        AppMethodBeat.o(92966);
    }

    @Override // com.google.android.exoplayer2.h.g
    public final long a(j jVar) {
        boolean z = true;
        AppMethodBeat.i(92967);
        try {
            this.uri = jVar.uri;
            this.flags = jVar.flags;
            this.key = h.c(jVar);
            this.bGi = jVar.position;
            if ((!this.bGe || !this.bGk) && (jVar.length != -1 || !this.bGf)) {
                z = false;
            }
            this.bGl = z;
            if (jVar.length != -1 || this.bGl) {
                this.bEJ = jVar.length;
            } else {
                this.bEJ = this.bFT.bp(this.key);
                if (this.bEJ != -1) {
                    this.bEJ -= jVar.position;
                    if (this.bEJ <= 0) {
                        h hVar = new h();
                        AppMethodBeat.o(92967);
                        throw hVar;
                    }
                }
            }
            aW(true);
            long j2 = this.bEJ;
            AppMethodBeat.o(92967);
            return j2;
        } catch (IOException e2) {
            b(e2);
            AppMethodBeat.o(92967);
            throw e2;
        }
    }

    @Override // com.google.android.exoplayer2.h.g
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(92968);
        if (i3 == 0) {
            AppMethodBeat.o(92968);
            return 0;
        } else if (this.bEJ == 0) {
            AppMethodBeat.o(92968);
            return -1;
        } else {
            try {
                int read = this.bGg.read(bArr, i2, i3);
                if (read >= 0) {
                    if (this.bGg == this.bFZ) {
                        this.bGm += (long) read;
                    }
                    this.bGi += (long) read;
                    if (this.bEJ != -1) {
                        this.bEJ -= (long) read;
                    }
                } else {
                    if (this.bGh) {
                        setContentLength(this.bGi);
                        this.bEJ = 0;
                    }
                    wQ();
                    if ((this.bEJ > 0 || this.bEJ == -1) && aW(false)) {
                        int read2 = read(bArr, i2, i3);
                        AppMethodBeat.o(92968);
                        return read2;
                    }
                }
                AppMethodBeat.o(92968);
                return read;
            } catch (IOException e2) {
                b(e2);
                AppMethodBeat.o(92968);
                throw e2;
            }
        }
    }

    @Override // com.google.android.exoplayer2.h.g
    public final Uri getUri() {
        AppMethodBeat.i(92969);
        if (this.bGg == this.bGb) {
            Uri uri2 = this.bGg.getUri();
            AppMethodBeat.o(92969);
            return uri2;
        }
        Uri uri3 = this.uri;
        AppMethodBeat.o(92969);
        return uri3;
    }

    @Override // com.google.android.exoplayer2.h.g
    public final void close() {
        AppMethodBeat.i(92970);
        this.uri = null;
        if (this.bGc != null && this.bGm > 0) {
            this.bGc.k(this.bFT.wN(), this.bGm);
            this.bGm = 0;
        }
        try {
            wQ();
            AppMethodBeat.o(92970);
        } catch (IOException e2) {
            b(e2);
            AppMethodBeat.o(92970);
            throw e2;
        }
    }

    private boolean aW(boolean z) {
        g f2;
        long j2;
        j jVar;
        long j3;
        AppMethodBeat.i(92971);
        if (this.bGl) {
            f2 = null;
        } else if (this.bGd) {
            try {
                f2 = this.bFT.e(this.key, this.bGi);
            } catch (InterruptedException e2) {
                InterruptedIOException interruptedIOException = new InterruptedIOException();
                AppMethodBeat.o(92971);
                throw interruptedIOException;
            }
        } else {
            f2 = this.bFT.f(this.key, this.bGi);
        }
        if (f2 == null) {
            this.bGg = this.bGb;
            jVar = new j(this.uri, this.bGi, this.bEJ, this.key, this.flags);
        } else if (f2.bGq) {
            Uri fromFile = Uri.fromFile(f2.file);
            long j4 = this.bGi - f2.position;
            long j5 = f2.length - j4;
            if (this.bEJ != -1) {
                j5 = Math.min(j5, this.bEJ);
            }
            j jVar2 = new j(fromFile, this.bGi, j4, j5, this.key, this.flags);
            this.bGg = this.bFZ;
            jVar = jVar2;
        } else {
            if (f2.wS()) {
                j2 = this.bEJ;
            } else {
                j2 = f2.length;
                if (this.bEJ != -1) {
                    j2 = Math.min(j2, this.bEJ);
                }
            }
            j jVar3 = new j(this.uri, this.bGi, j2, this.key, this.flags);
            if (this.bGa != null) {
                this.bGg = this.bGa;
                this.bGj = f2;
                jVar = jVar3;
            } else {
                this.bGg = this.bGb;
                this.bFT.a(f2);
                jVar = jVar3;
            }
        }
        this.bGh = jVar.length == -1;
        boolean z2 = false;
        try {
            j3 = this.bGg.a(jVar);
            z2 = true;
        } catch (IOException e3) {
            IOException iOException = e3;
            if (!z && this.bGh) {
                Throwable th = iOException;
                while (true) {
                    if (th != null) {
                        if ((th instanceof h) && ((h) th).bDZ == 0) {
                            iOException = null;
                            break;
                        }
                        th = th.getCause();
                    } else {
                        break;
                    }
                }
            }
            if (iOException != null) {
                AppMethodBeat.o(92971);
                throw iOException;
            }
            j3 = 0;
        }
        if (this.bGh && j3 != -1) {
            this.bEJ = j3;
            setContentLength(jVar.position + this.bEJ);
        }
        AppMethodBeat.o(92971);
        return z2;
    }

    private void setContentLength(long j2) {
        AppMethodBeat.i(92972);
        if (this.bGg == this.bGa) {
            this.bFT.g(this.key, j2);
        }
        AppMethodBeat.o(92972);
    }

    private void wQ() {
        AppMethodBeat.i(92973);
        if (this.bGg == null) {
            AppMethodBeat.o(92973);
            return;
        }
        try {
            this.bGg.close();
            this.bGg = null;
            this.bGh = false;
            if (this.bGj != null) {
                this.bFT.a(this.bGj);
                this.bGj = null;
                AppMethodBeat.o(92973);
                return;
            }
            AppMethodBeat.o(92973);
        } catch (Throwable th) {
            if (this.bGj != null) {
                this.bFT.a(this.bGj);
                this.bGj = null;
            }
            AppMethodBeat.o(92973);
            throw th;
        }
    }

    private void b(IOException iOException) {
        if (this.bGg == this.bFZ || (iOException instanceof a.C0112a)) {
            this.bGk = true;
        }
    }
}
