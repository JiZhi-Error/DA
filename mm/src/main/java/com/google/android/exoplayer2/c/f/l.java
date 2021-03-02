package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f.v;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l implements h {
    private m biA;
    private int bjC;
    private boolean bqK;
    private long bqM;
    private final com.google.android.exoplayer2.i.m brQ = new com.google.android.exoplayer2.i.m(10);
    private int sampleSize;

    public l() {
        AppMethodBeat.i(92255);
        AppMethodBeat.o(92255);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void uK() {
        this.bqK = false;
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void a(g gVar, v.d dVar) {
        AppMethodBeat.i(92256);
        dVar.uW();
        this.biA = gVar.dV(dVar.getTrackId());
        this.biA.f(Format.k(dVar.uX(), "application/id3"));
        AppMethodBeat.o(92256);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void c(long j2, boolean z) {
        if (z) {
            this.bqK = true;
            this.bqM = j2;
            this.sampleSize = 0;
            this.bjC = 0;
        }
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void t(com.google.android.exoplayer2.i.m mVar) {
        AppMethodBeat.i(92257);
        if (!this.bqK) {
            AppMethodBeat.o(92257);
            return;
        }
        int xd = mVar.xd();
        if (this.bjC < 10) {
            int min = Math.min(xd, 10 - this.bjC);
            System.arraycopy(mVar.data, mVar.position, this.brQ.data, this.bjC, min);
            if (min + this.bjC == 10) {
                this.brQ.setPosition(0);
                if (73 == this.brQ.readUnsignedByte() && 68 == this.brQ.readUnsignedByte() && 51 == this.brQ.readUnsignedByte()) {
                    this.brQ.eZ(3);
                    this.sampleSize = this.brQ.xj() + 10;
                } else {
                    this.bqK = false;
                    AppMethodBeat.o(92257);
                    return;
                }
            }
        }
        int min2 = Math.min(xd, this.sampleSize - this.bjC);
        this.biA.a(mVar, min2);
        this.bjC = min2 + this.bjC;
        AppMethodBeat.o(92257);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void uL() {
        AppMethodBeat.i(92258);
        if (!this.bqK || this.sampleSize == 0 || this.bjC != this.sampleSize) {
            AppMethodBeat.o(92258);
            return;
        }
        this.biA.a(this.bqM, 1, this.sampleSize, 0, null);
        this.bqK = false;
        AppMethodBeat.o(92258);
    }
}
