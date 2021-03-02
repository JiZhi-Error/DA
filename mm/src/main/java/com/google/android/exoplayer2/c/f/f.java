package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a.h;
import com.google.android.exoplayer2.c.f.v;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TimeUtil;

public final class f implements h {
    private Format bdF;
    private m biA;
    private String bqA;
    private int bqH;
    private final com.google.android.exoplayer2.i.m bqp = new com.google.android.exoplayer2.i.m(new byte[15]);
    private int bqr;
    private long bqt;
    private final String language;
    private int sampleSize;
    private int state;
    private long timeUs;

    public f(String str) {
        AppMethodBeat.i(92225);
        this.bqp.data[0] = Byte.MAX_VALUE;
        this.bqp.data[1] = -2;
        this.bqp.data[2] = Byte.MIN_VALUE;
        this.bqp.data[3] = 1;
        this.state = 0;
        this.language = str;
        AppMethodBeat.o(92225);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void uK() {
        this.state = 0;
        this.bqr = 0;
        this.bqH = 0;
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void a(g gVar, v.d dVar) {
        AppMethodBeat.i(92226);
        dVar.uW();
        this.bqA = dVar.uX();
        this.biA = gVar.dV(dVar.getTrackId());
        AppMethodBeat.o(92226);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void c(long j2, boolean z) {
        this.timeUs = j2;
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void t(com.google.android.exoplayer2.i.m mVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(92227);
        while (mVar.xd() > 0) {
            switch (this.state) {
                case 1:
                    byte[] bArr = this.bqp.data;
                    int min = Math.min(mVar.xd(), 15 - this.bqr);
                    mVar.readBytes(bArr, this.bqr, min);
                    this.bqr += min;
                    if (this.bqr == 15) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        byte[] bArr2 = this.bqp.data;
                        if (this.bdF == null) {
                            this.bdF = h.a(bArr2, this.bqA, this.language);
                            this.biA.f(this.bdF);
                        }
                        this.sampleSize = h.p(bArr2);
                        this.bqt = (long) ((int) ((((long) h.o(bArr2)) * TimeUtil.SECOND_TO_US) / ((long) this.bdF.sampleRate)));
                        this.bqp.setPosition(0);
                        this.biA.a(this.bqp, 15);
                        this.state = 2;
                    } else {
                        continue;
                    }
                case 2:
                    int min2 = Math.min(mVar.xd(), this.sampleSize - this.bqr);
                    this.biA.a(mVar, min2);
                    this.bqr = min2 + this.bqr;
                    if (this.bqr == this.sampleSize) {
                        this.biA.a(this.timeUs, 1, this.sampleSize, 0, null);
                        this.timeUs += this.bqt;
                        this.state = 0;
                    } else {
                        continue;
                    }
            }
            while (true) {
                if (mVar.xd() > 0) {
                    this.bqH <<= 8;
                    this.bqH |= mVar.readUnsignedByte();
                    if (this.bqH == 2147385345) {
                        this.bqH = 0;
                        z2 = true;
                    }
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                this.bqr = 4;
                this.state = 1;
            }
        }
        AppMethodBeat.o(92227);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void uL() {
    }
}
