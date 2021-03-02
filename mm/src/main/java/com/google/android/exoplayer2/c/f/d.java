package com.google.android.exoplayer2.c.f;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f.v;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tav.decoder.EncoderWriter;
import java.util.Arrays;
import java.util.Collections;

public final class d implements h {
    private static final byte[] bqw = {73, 68, 51};
    private m biA;
    private boolean bik;
    private String bqA;
    private m bqB;
    private int bqC;
    private boolean bqD;
    private m bqE;
    private long bqF;
    private int bqr;
    private long bqt;
    private final boolean bqx;
    private final l bqy;
    private final com.google.android.exoplayer2.i.m bqz;
    private final String language;
    private int sampleSize;
    private int state;
    long timeUs;

    public d() {
        this(true, null);
    }

    public d(boolean z, String str) {
        AppMethodBeat.i(92210);
        this.bqy = new l(new byte[7]);
        this.bqz = new com.google.android.exoplayer2.i.m(Arrays.copyOf(bqw, 10));
        uN();
        this.bqx = z;
        this.language = str;
        AppMethodBeat.o(92210);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void uK() {
        AppMethodBeat.i(259079);
        uN();
        AppMethodBeat.o(259079);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void a(g gVar, v.d dVar) {
        AppMethodBeat.i(92212);
        dVar.uW();
        this.bqA = dVar.uX();
        this.biA = gVar.dV(dVar.getTrackId());
        if (this.bqx) {
            dVar.uW();
            this.bqB = gVar.dV(dVar.getTrackId());
            this.bqB.f(Format.k(dVar.uX(), "application/id3"));
            AppMethodBeat.o(92212);
            return;
        }
        this.bqB = new com.google.android.exoplayer2.c.d();
        AppMethodBeat.o(92212);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void c(long j2, boolean z) {
        this.timeUs = j2;
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void t(com.google.android.exoplayer2.i.m mVar) {
        AppMethodBeat.i(92213);
        while (mVar.xd() > 0) {
            switch (this.state) {
                case 0:
                    v(mVar);
                    break;
                case 1:
                    if (!a(mVar, this.bqz.data, 10)) {
                        break;
                    } else {
                        uQ();
                        break;
                    }
                case 2:
                    if (!a(mVar, this.bqy.data, this.bqD ? 7 : 5)) {
                        break;
                    } else {
                        uR();
                        break;
                    }
                case 3:
                    w(mVar);
                    break;
            }
        }
        AppMethodBeat.o(92213);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void uL() {
    }

    private boolean a(com.google.android.exoplayer2.i.m mVar, byte[] bArr, int i2) {
        AppMethodBeat.i(92214);
        int min = Math.min(mVar.xd(), i2 - this.bqr);
        mVar.readBytes(bArr, this.bqr, min);
        this.bqr = min + this.bqr;
        if (this.bqr == i2) {
            AppMethodBeat.o(92214);
            return true;
        }
        AppMethodBeat.o(92214);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void uN() {
        this.state = 0;
        this.bqr = 0;
        this.bqC = 256;
    }

    private void uO() {
        AppMethodBeat.i(92215);
        this.state = 1;
        this.bqr = bqw.length;
        this.sampleSize = 0;
        this.bqz.setPosition(0);
        AppMethodBeat.o(92215);
    }

    private void a(m mVar, long j2, int i2, int i3) {
        this.state = 3;
        this.bqr = i2;
        this.bqE = mVar;
        this.bqF = j2;
        this.sampleSize = i3;
    }

    private void uP() {
        this.state = 2;
        this.bqr = 0;
    }

    private void v(com.google.android.exoplayer2.i.m mVar) {
        AppMethodBeat.i(92216);
        byte[] bArr = mVar.data;
        int i2 = mVar.position;
        int i3 = mVar.limit;
        int i4 = i2;
        while (i4 < i3) {
            int i5 = i4 + 1;
            int i6 = bArr[i4] & 255;
            if (this.bqC != 512 || i6 < 240 || i6 == 255) {
                switch (i6 | this.bqC) {
                    case TbsListener.ErrorCode.ERROR_GETSTRINGARRAY_JARFILE /*{ENCODED_INT: 329}*/:
                        this.bqC = 768;
                        i4 = i5;
                        break;
                    case TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBFAILED /*{ENCODED_INT: 511}*/:
                        this.bqC = 512;
                        i4 = i5;
                        break;
                    case 836:
                        this.bqC = 1024;
                        i4 = i5;
                        break;
                    case 1075:
                        uO();
                        mVar.setPosition(i5);
                        AppMethodBeat.o(92216);
                        return;
                    default:
                        if (this.bqC == 256) {
                            i4 = i5;
                            break;
                        } else {
                            this.bqC = 256;
                            i4 = i5 - 1;
                            break;
                        }
                }
            } else {
                this.bqD = (i6 & 1) == 0;
                uP();
                mVar.setPosition(i5);
                AppMethodBeat.o(92216);
                return;
            }
        }
        mVar.setPosition(i4);
        AppMethodBeat.o(92216);
    }

    private void uQ() {
        AppMethodBeat.i(92217);
        this.bqB.a(this.bqz, 10);
        this.bqz.setPosition(6);
        a(this.bqB, 0, 10, this.bqz.xj() + 10);
        AppMethodBeat.o(92217);
    }

    private void uR() {
        int i2 = 2;
        AppMethodBeat.i(92218);
        this.bqy.setPosition(0);
        if (!this.bik) {
            int em = this.bqy.em(2) + 1;
            if (em != 2) {
                new StringBuilder("Detected audio object type: ").append(em).append(", but assuming AAC LC.");
            } else {
                i2 = em;
            }
            int em2 = this.bqy.em(4);
            this.bqy.en(1);
            byte[] r = com.google.android.exoplayer2.i.d.r(i2, em2, this.bqy.em(3));
            Pair<Integer, Integer> u = com.google.android.exoplayer2.i.d.u(r);
            Format a2 = Format.a(this.bqA, EncoderWriter.OUTPUT_AUDIO_MIME_TYPE, -1, -1, ((Integer) u.second).intValue(), ((Integer) u.first).intValue(), Collections.singletonList(r), null, this.language);
            this.bqt = 1024000000 / ((long) a2.sampleRate);
            this.biA.f(a2);
            this.bik = true;
        } else {
            this.bqy.en(10);
        }
        this.bqy.en(4);
        int em3 = (this.bqy.em(13) - 2) - 5;
        if (this.bqD) {
            em3 -= 2;
        }
        a(this.biA, this.bqt, 0, em3);
        AppMethodBeat.o(92218);
    }

    private void w(com.google.android.exoplayer2.i.m mVar) {
        AppMethodBeat.i(92219);
        int min = Math.min(mVar.xd(), this.sampleSize - this.bqr);
        this.bqE.a(mVar, min);
        this.bqr = min + this.bqr;
        if (this.bqr == this.sampleSize) {
            this.bqE.a(this.timeUs, 1, this.sampleSize, 0, null);
            this.timeUs += this.bqF;
            uN();
        }
        AppMethodBeat.o(92219);
    }
}
