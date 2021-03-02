package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.util.Arrays;

public final class b implements f {
    private static final byte[] bhJ = new byte[4096];
    private final g bhK;
    private final long bhL;
    private byte[] bhM = new byte[65536];
    private int bhN;
    private int bhO;
    private long position;

    public b(g gVar, long j2, long j3) {
        AppMethodBeat.i(91957);
        this.bhK = gVar;
        this.position = j2;
        this.bhL = j3;
        AppMethodBeat.o(91957);
    }

    @Override // com.google.android.exoplayer2.c.f
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(91958);
        int c2 = c(bArr, i2, i3);
        if (c2 == 0) {
            c2 = a(bArr, i2, i3, 0, true);
        }
        dU(c2);
        AppMethodBeat.o(91958);
        return c2;
    }

    @Override // com.google.android.exoplayer2.c.f
    public final boolean a(byte[] bArr, int i2, int i3, boolean z) {
        AppMethodBeat.i(91959);
        int c2 = c(bArr, i2, i3);
        while (c2 < i3 && c2 != -1) {
            c2 = a(bArr, i2, i3, c2, z);
        }
        dU(c2);
        if (c2 != -1) {
            AppMethodBeat.o(91959);
            return true;
        }
        AppMethodBeat.o(91959);
        return false;
    }

    @Override // com.google.android.exoplayer2.c.f
    public final void readFully(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(91960);
        a(bArr, i2, i3, false);
        AppMethodBeat.o(91960);
    }

    @Override // com.google.android.exoplayer2.c.f
    public final int dO(int i2) {
        AppMethodBeat.i(91961);
        int dS = dS(i2);
        if (dS == 0) {
            dS = a(bhJ, 0, Math.min(i2, bhJ.length), 0, true);
        }
        dU(dS);
        AppMethodBeat.o(91961);
        return dS;
    }

    @Override // com.google.android.exoplayer2.c.f
    public final boolean b(byte[] bArr, int i2, int i3, boolean z) {
        AppMethodBeat.i(91963);
        if (!o(i3, z)) {
            AppMethodBeat.o(91963);
            return false;
        }
        System.arraycopy(this.bhM, this.bhN - i3, bArr, i2, i3);
        AppMethodBeat.o(91963);
        return true;
    }

    @Override // com.google.android.exoplayer2.c.f
    public final void b(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(91964);
        b(bArr, i2, i3, false);
        AppMethodBeat.o(91964);
    }

    private boolean o(int i2, boolean z) {
        AppMethodBeat.i(91965);
        dR(i2);
        int min = Math.min(this.bhO - this.bhN, i2);
        while (min < i2) {
            min = a(this.bhM, this.bhN, i2, min, z);
            if (min == -1) {
                AppMethodBeat.o(91965);
                return false;
            }
        }
        this.bhN += i2;
        this.bhO = Math.max(this.bhO, this.bhN);
        AppMethodBeat.o(91965);
        return true;
    }

    @Override // com.google.android.exoplayer2.c.f
    public final void dQ(int i2) {
        AppMethodBeat.i(91966);
        o(i2, false);
        AppMethodBeat.o(91966);
    }

    @Override // com.google.android.exoplayer2.c.f
    public final void uv() {
        this.bhN = 0;
    }

    @Override // com.google.android.exoplayer2.c.f
    public final long uw() {
        return this.position + ((long) this.bhN);
    }

    @Override // com.google.android.exoplayer2.c.f
    public final long getPosition() {
        return this.position;
    }

    @Override // com.google.android.exoplayer2.c.f
    public final long getLength() {
        return this.bhL;
    }

    private void dR(int i2) {
        AppMethodBeat.i(91967);
        int i3 = this.bhN + i2;
        if (i3 > this.bhM.length) {
            this.bhM = Arrays.copyOf(this.bhM, x.s(this.bhM.length * 2, 65536 + i3, i3 + 524288));
        }
        AppMethodBeat.o(91967);
    }

    private int dS(int i2) {
        AppMethodBeat.i(91968);
        int min = Math.min(this.bhO, i2);
        dT(min);
        AppMethodBeat.o(91968);
        return min;
    }

    private int c(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(91969);
        if (this.bhO == 0) {
            AppMethodBeat.o(91969);
            return 0;
        }
        int min = Math.min(this.bhO, i3);
        System.arraycopy(this.bhM, 0, bArr, i2, min);
        dT(min);
        AppMethodBeat.o(91969);
        return min;
    }

    private void dT(int i2) {
        AppMethodBeat.i(91970);
        this.bhO -= i2;
        this.bhN = 0;
        byte[] bArr = this.bhM;
        if (this.bhO < this.bhM.length - 524288) {
            bArr = new byte[(this.bhO + 65536)];
        }
        System.arraycopy(this.bhM, i2, bArr, 0, this.bhO);
        this.bhM = bArr;
        AppMethodBeat.o(91970);
    }

    private int a(byte[] bArr, int i2, int i3, int i4, boolean z) {
        AppMethodBeat.i(91971);
        if (Thread.interrupted()) {
            InterruptedException interruptedException = new InterruptedException();
            AppMethodBeat.o(91971);
            throw interruptedException;
        }
        int read = this.bhK.read(bArr, i2 + i4, i3 - i4);
        if (read != -1) {
            int i5 = i4 + read;
            AppMethodBeat.o(91971);
            return i5;
        } else if (i4 != 0 || !z) {
            EOFException eOFException = new EOFException();
            AppMethodBeat.o(91971);
            throw eOFException;
        } else {
            AppMethodBeat.o(91971);
            return -1;
        }
    }

    private void dU(int i2) {
        if (i2 != -1) {
            this.position += (long) i2;
        }
    }

    @Override // com.google.android.exoplayer2.c.f
    public final void dP(int i2) {
        AppMethodBeat.i(91962);
        int dS = dS(i2);
        while (dS < i2 && dS != -1) {
            dS = a(bhJ, -dS, Math.min(i2, bhJ.length + dS), dS, false);
        }
        dU(dS);
        AppMethodBeat.o(91962);
    }
}
