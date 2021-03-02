package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;

/* access modifiers changed from: package-private */
public final class e {
    private static final int bpn = x.bJ("OggS");
    private final m bin = new m(255);
    public int bkI;
    public int bpo;
    public long bpp;
    public long bpq;
    public long bpr;
    public long bps;
    public int bpt;
    public int bpu;
    public final int[] bpv = new int[255];
    public int type;

    e() {
        AppMethodBeat.i(92157);
        AppMethodBeat.o(92157);
    }

    static {
        AppMethodBeat.i(92159);
        AppMethodBeat.o(92159);
    }

    public final void reset() {
        this.bpo = 0;
        this.type = 0;
        this.bpp = 0;
        this.bpq = 0;
        this.bpr = 0;
        this.bps = 0;
        this.bpt = 0;
        this.bkI = 0;
        this.bpu = 0;
    }

    public final boolean c(f fVar, boolean z) {
        AppMethodBeat.i(92158);
        this.bin.reset();
        reset();
        if (!(fVar.getLength() == -1 || fVar.getLength() - fVar.uw() >= 27) || !fVar.b(this.bin.data, 0, 27, true)) {
            if (z) {
                AppMethodBeat.o(92158);
                return false;
            }
            EOFException eOFException = new EOFException();
            AppMethodBeat.o(92158);
            throw eOFException;
        } else if (this.bin.dE() == ((long) bpn)) {
            this.bpo = this.bin.readUnsignedByte();
            if (this.bpo == 0) {
                this.type = this.bin.readUnsignedByte();
                this.bpp = this.bin.xi();
                this.bpq = this.bin.xg();
                this.bpr = this.bin.xg();
                this.bps = this.bin.xg();
                this.bpt = this.bin.readUnsignedByte();
                this.bkI = this.bpt + 27;
                this.bin.reset();
                fVar.b(this.bin.data, 0, this.bpt);
                for (int i2 = 0; i2 < this.bpt; i2++) {
                    this.bpv[i2] = this.bin.readUnsignedByte();
                    this.bpu += this.bpv[i2];
                }
                AppMethodBeat.o(92158);
                return true;
            } else if (z) {
                AppMethodBeat.o(92158);
                return false;
            } else {
                o oVar = new o("unsupported bit stream revision");
                AppMethodBeat.o(92158);
                throw oVar;
            }
        } else if (z) {
            AppMethodBeat.o(92158);
            return false;
        } else {
            o oVar2 = new o("expected OggS capture pattern at begin of page");
            AppMethodBeat.o(92158);
            throw oVar2;
        }
    }
}
