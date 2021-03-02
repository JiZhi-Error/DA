package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f.v;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TimeUtil;

public final class m implements h {
    private int beI;
    private com.google.android.exoplayer2.c.m biA;
    private boolean bik;
    private String bqA;
    private final com.google.android.exoplayer2.i.m brR;
    private final j brS;
    private int brT;
    private boolean brU;
    private long frameDurationUs;
    private final String language;
    private int state;
    private long timeUs;

    public m() {
        this(null);
    }

    public m(String str) {
        AppMethodBeat.i(92259);
        this.state = 0;
        this.brR = new com.google.android.exoplayer2.i.m(4);
        this.brR.data[0] = -1;
        this.brS = new j();
        this.language = str;
        AppMethodBeat.o(92259);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void uK() {
        this.state = 0;
        this.brT = 0;
        this.brU = false;
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void a(g gVar, v.d dVar) {
        AppMethodBeat.i(92260);
        dVar.uW();
        this.bqA = dVar.uX();
        this.biA = gVar.dV(dVar.getTrackId());
        AppMethodBeat.o(92260);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void c(long j2, boolean z) {
        this.timeUs = j2;
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void t(com.google.android.exoplayer2.i.m mVar) {
        boolean z;
        AppMethodBeat.i(92261);
        while (mVar.xd() > 0) {
            switch (this.state) {
                case 0:
                    byte[] bArr = mVar.data;
                    int i2 = mVar.position;
                    int i3 = mVar.limit;
                    int i4 = i2;
                    while (true) {
                        if (i4 >= i3) {
                            mVar.setPosition(i3);
                            break;
                        } else {
                            boolean z2 = (bArr[i4] & 255) == 255;
                            if (!this.brU || (bArr[i4] & 224) != 224) {
                                z = false;
                            } else {
                                z = true;
                            }
                            this.brU = z2;
                            if (z) {
                                mVar.setPosition(i4 + 1);
                                this.brU = false;
                                this.brR.data[1] = bArr[i4];
                                this.brT = 2;
                                this.state = 1;
                                break;
                            } else {
                                i4++;
                            }
                        }
                    }
                    break;
                case 1:
                    int min = Math.min(mVar.xd(), 4 - this.brT);
                    mVar.readBytes(this.brR.data, this.brT, min);
                    this.brT = min + this.brT;
                    if (this.brT < 4) {
                        break;
                    } else {
                        this.brR.setPosition(0);
                        if (j.a(this.brR.readInt(), this.brS)) {
                            this.beI = this.brS.beI;
                            if (!this.bik) {
                                this.frameDurationUs = (TimeUtil.SECOND_TO_US * ((long) this.brS.bif)) / ((long) this.brS.sampleRate);
                                this.biA.f(Format.a(this.bqA, this.brS.mimeType, -1, 4096, this.brS.channels, this.brS.sampleRate, null, null, this.language));
                                this.bik = true;
                            }
                            this.brR.setPosition(0);
                            this.biA.a(this.brR, 4);
                            this.state = 2;
                            break;
                        } else {
                            this.brT = 0;
                            this.state = 1;
                            break;
                        }
                    }
                case 2:
                    int min2 = Math.min(mVar.xd(), this.beI - this.brT);
                    this.biA.a(mVar, min2);
                    this.brT = min2 + this.brT;
                    if (this.brT < this.beI) {
                        break;
                    } else {
                        this.biA.a(this.timeUs, 1, this.beI, 0, null);
                        this.timeUs += this.frameDurationUs;
                        this.brT = 0;
                        this.state = 0;
                        break;
                    }
            }
        }
        AppMethodBeat.o(92261);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void uL() {
    }
}
