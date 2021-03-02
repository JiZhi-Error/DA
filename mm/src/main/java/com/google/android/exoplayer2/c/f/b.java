package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a.a;
import com.google.android.exoplayer2.c.f.v;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.l;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TimeUtil;

public final class b implements h {
    private Format bdF;
    private m biA;
    private final l bqo;
    private final com.google.android.exoplayer2.i.m bqp;
    private String bqq;
    private int bqr;
    private boolean bqs;
    private long bqt;
    private final String language;
    private int sampleSize;
    private int state;
    long timeUs;

    public b() {
        this(null);
    }

    public b(String str) {
        AppMethodBeat.i(92197);
        this.bqo = new l(new byte[8]);
        this.bqp = new com.google.android.exoplayer2.i.m(this.bqo.data);
        this.state = 0;
        this.language = str;
        AppMethodBeat.o(92197);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void uK() {
        this.state = 0;
        this.bqr = 0;
        this.bqs = false;
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void a(g gVar, v.d dVar) {
        AppMethodBeat.i(92198);
        dVar.uW();
        this.bqq = dVar.uX();
        this.biA = gVar.dV(dVar.getTrackId());
        AppMethodBeat.o(92198);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void c(long j2, boolean z) {
        this.timeUs = j2;
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void t(com.google.android.exoplayer2.i.m mVar) {
        AppMethodBeat.i(92199);
        while (mVar.xd() > 0) {
            switch (this.state) {
                case 0:
                    if (!u(mVar)) {
                        break;
                    } else {
                        this.state = 1;
                        this.bqp.data[0] = JceStruct.STRUCT_END;
                        this.bqp.data[1] = 119;
                        this.bqr = 2;
                        break;
                    }
                case 1:
                    if (!a(mVar, this.bqp.data)) {
                        break;
                    } else {
                        uM();
                        this.bqp.setPosition(0);
                        this.biA.a(this.bqp, 8);
                        this.state = 2;
                        break;
                    }
                case 2:
                    int min = Math.min(mVar.xd(), this.sampleSize - this.bqr);
                    this.biA.a(mVar, min);
                    this.bqr = min + this.bqr;
                    if (this.bqr != this.sampleSize) {
                        break;
                    } else {
                        this.biA.a(this.timeUs, 1, this.sampleSize, 0, null);
                        this.timeUs += this.bqt;
                        this.state = 0;
                        break;
                    }
            }
        }
        AppMethodBeat.o(92199);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void uL() {
    }

    private boolean a(com.google.android.exoplayer2.i.m mVar, byte[] bArr) {
        AppMethodBeat.i(92200);
        int min = Math.min(mVar.xd(), 8 - this.bqr);
        mVar.readBytes(bArr, this.bqr, min);
        this.bqr = min + this.bqr;
        if (this.bqr == 8) {
            AppMethodBeat.o(92200);
            return true;
        }
        AppMethodBeat.o(92200);
        return false;
    }

    private boolean u(com.google.android.exoplayer2.i.m mVar) {
        AppMethodBeat.i(92201);
        while (mVar.xd() > 0) {
            if (!this.bqs) {
                this.bqs = mVar.readUnsignedByte() == 11;
            } else {
                int readUnsignedByte = mVar.readUnsignedByte();
                if (readUnsignedByte == 119) {
                    this.bqs = false;
                    AppMethodBeat.o(92201);
                    return true;
                }
                this.bqs = readUnsignedByte == 11;
            }
        }
        AppMethodBeat.o(92201);
        return false;
    }

    private void uM() {
        AppMethodBeat.i(92202);
        this.bqo.setPosition(0);
        a.C0098a a2 = a.a(this.bqo);
        if (!(this.bdF != null && a2.channelCount == this.bdF.channelCount && a2.sampleRate == this.bdF.sampleRate && a2.mimeType == this.bdF.bdq)) {
            this.bdF = Format.a(this.bqq, a2.mimeType, -1, -1, a2.channelCount, a2.sampleRate, null, null, this.language);
            this.biA.f(this.bdF);
        }
        this.sampleSize = a2.beI;
        this.bqt = (TimeUtil.SECOND_TO_US * ((long) a2.sampleCount)) / ((long) this.bdF.sampleRate);
        AppMethodBeat.o(92202);
    }
}
