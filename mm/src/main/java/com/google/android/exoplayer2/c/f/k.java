package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f.v;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import java.util.Collections;

public final class k implements h {
    private m biA;
    private boolean bik;
    private String bqA;
    private final boolean[] bqO = new boolean[3];
    private long bqQ;
    private long bqS;
    private final s bqZ;
    private a brG;
    private final n brH = new n(32);
    private final n brI = new n(39);
    private final n brJ = new n(40);
    private final n brc = new n(33);
    private final n brd = new n(34);
    private final com.google.android.exoplayer2.i.m brg = new com.google.android.exoplayer2.i.m();

    public k(s sVar) {
        AppMethodBeat.i(92250);
        this.bqZ = sVar;
        AppMethodBeat.o(92250);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void uK() {
        AppMethodBeat.i(92251);
        com.google.android.exoplayer2.i.k.a(this.bqO);
        this.brH.reset();
        this.brc.reset();
        this.brd.reset();
        this.brI.reset();
        this.brJ.reset();
        a aVar = this.brG;
        aVar.brM = false;
        aVar.brN = false;
        aVar.brO = false;
        aVar.brq = false;
        aVar.brP = false;
        this.bqQ = 0;
        AppMethodBeat.o(92251);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void a(g gVar, v.d dVar) {
        AppMethodBeat.i(92252);
        dVar.uW();
        this.bqA = dVar.uX();
        this.biA = gVar.dV(dVar.getTrackId());
        this.brG = new a(this.biA);
        this.bqZ.a(gVar, dVar);
        AppMethodBeat.o(92252);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void c(long j2, boolean z) {
        this.bqS = j2;
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void t(com.google.android.exoplayer2.i.m mVar) {
        int i2;
        float f2;
        boolean z;
        boolean z2;
        AppMethodBeat.i(92253);
        while (mVar.xd() > 0) {
            int i3 = mVar.position;
            int i4 = mVar.limit;
            byte[] bArr = mVar.data;
            this.bqQ += (long) mVar.xd();
            this.biA.a(mVar, mVar.xd());
            while (true) {
                if (i3 < i4) {
                    int a2 = com.google.android.exoplayer2.i.k.a(bArr, i3, i4, this.bqO);
                    if (a2 == i4) {
                        e(bArr, i3, i4);
                        AppMethodBeat.o(92253);
                        return;
                    }
                    int l = com.google.android.exoplayer2.i.k.l(bArr, a2);
                    int i5 = a2 - i3;
                    if (i5 > 0) {
                        e(bArr, i3, a2);
                    }
                    int i6 = i4 - a2;
                    long j2 = this.bqQ - ((long) i6);
                    int i7 = i5 < 0 ? -i5 : 0;
                    long j3 = this.bqS;
                    if (this.bik) {
                        a aVar = this.brG;
                        if (aVar.brP && aVar.brN) {
                            aVar.bqU = aVar.brK;
                            aVar.brP = false;
                        } else if (aVar.brO || aVar.brN) {
                            if (aVar.brq) {
                                aVar.eq(((int) (j2 - aVar.brm)) + i6);
                            }
                            aVar.bqT = aVar.brm;
                            aVar.bqM = aVar.brn;
                            aVar.brq = true;
                            aVar.bqU = aVar.brK;
                        }
                    } else {
                        this.brH.es(i7);
                        this.brc.es(i7);
                        this.brd.es(i7);
                        if (this.brH.brW && this.brc.brW && this.brd.brW) {
                            m mVar2 = this.biA;
                            String str = this.bqA;
                            n nVar = this.brH;
                            n nVar2 = this.brc;
                            n nVar3 = this.brd;
                            byte[] bArr2 = new byte[(nVar.brX + nVar2.brX + nVar3.brX)];
                            System.arraycopy(nVar.nalData, 0, bArr2, 0, nVar.brX);
                            System.arraycopy(nVar2.nalData, 0, bArr2, nVar.brX, nVar2.brX);
                            System.arraycopy(nVar3.nalData, 0, bArr2, nVar.brX + nVar2.brX, nVar3.brX);
                            n nVar4 = new n(nVar2.nalData, 0, nVar2.brX);
                            nVar4.en(44);
                            int em = nVar4.em(3);
                            nVar4.xb();
                            nVar4.en(88);
                            nVar4.en(8);
                            int i8 = 0;
                            for (int i9 = 0; i9 < em; i9++) {
                                if (nVar4.uI()) {
                                    i8 += 89;
                                }
                                if (nVar4.uI()) {
                                    i8 += 8;
                                }
                            }
                            nVar4.en(i8);
                            if (em > 0) {
                                nVar4.en((8 - em) * 2);
                            }
                            nVar4.xq();
                            int xq = nVar4.xq();
                            if (xq == 3) {
                                nVar4.xb();
                            }
                            int xq2 = nVar4.xq();
                            int xq3 = nVar4.xq();
                            if (nVar4.uI()) {
                                int xq4 = nVar4.xq();
                                int xq5 = nVar4.xq();
                                int xq6 = nVar4.xq();
                                int xq7 = nVar4.xq();
                                xq2 -= ((xq == 1 || xq == 2) ? 2 : 1) * (xq4 + xq5);
                                xq3 -= (xq == 1 ? 2 : 1) * (xq6 + xq7);
                            }
                            nVar4.xq();
                            nVar4.xq();
                            int xq8 = nVar4.xq();
                            if (nVar4.uI()) {
                                i2 = 0;
                            } else {
                                i2 = em;
                            }
                            while (i2 <= em) {
                                nVar4.xq();
                                nVar4.xq();
                                nVar4.xq();
                                i2++;
                            }
                            nVar4.xq();
                            nVar4.xq();
                            nVar4.xq();
                            nVar4.xq();
                            nVar4.xq();
                            nVar4.xq();
                            if (nVar4.uI() && nVar4.uI()) {
                                int i10 = 0;
                                while (i10 < 4) {
                                    for (int i11 = 0; i11 < 6; i11 = (i10 == 3 ? 3 : 1) + i11) {
                                        if (!nVar4.uI()) {
                                            nVar4.xq();
                                        } else {
                                            int min = Math.min(64, 1 << ((i10 << 1) + 4));
                                            if (i10 > 1) {
                                                nVar4.xp();
                                            }
                                            for (int i12 = 0; i12 < min; i12++) {
                                                nVar4.xp();
                                            }
                                        }
                                    }
                                    i10++;
                                }
                            }
                            nVar4.en(2);
                            if (nVar4.uI()) {
                                nVar4.en(8);
                                nVar4.xq();
                                nVar4.xq();
                                nVar4.xb();
                            }
                            int xq9 = nVar4.xq();
                            boolean z3 = false;
                            int i13 = 0;
                            int i14 = 0;
                            while (i14 < xq9) {
                                if (i14 != 0) {
                                    z = nVar4.uI();
                                } else {
                                    z = z3;
                                }
                                if (z) {
                                    nVar4.xb();
                                    nVar4.xq();
                                    for (int i15 = 0; i15 <= i13; i15++) {
                                        if (nVar4.uI()) {
                                            nVar4.xb();
                                        }
                                    }
                                } else {
                                    int xq10 = nVar4.xq();
                                    int xq11 = nVar4.xq();
                                    i13 = xq10 + xq11;
                                    for (int i16 = 0; i16 < xq10; i16++) {
                                        nVar4.xq();
                                        nVar4.xb();
                                    }
                                    for (int i17 = 0; i17 < xq11; i17++) {
                                        nVar4.xq();
                                        nVar4.xb();
                                    }
                                }
                                i14++;
                                z3 = z;
                            }
                            if (nVar4.uI()) {
                                for (int i18 = 0; i18 < nVar4.xq(); i18++) {
                                    nVar4.en(xq8 + 4 + 1);
                                }
                            }
                            nVar4.en(2);
                            float f3 = 1.0f;
                            if (nVar4.uI() && nVar4.uI()) {
                                int em2 = nVar4.em(8);
                                if (em2 == 255) {
                                    int em3 = nVar4.em(16);
                                    int em4 = nVar4.em(16);
                                    if (!(em3 == 0 || em4 == 0)) {
                                        f3 = ((float) em3) / ((float) em4);
                                    }
                                    f2 = f3;
                                } else if (em2 < com.google.android.exoplayer2.i.k.bHg.length) {
                                    f2 = com.google.android.exoplayer2.i.k.bHg[em2];
                                }
                                mVar2.f(Format.a(str, TPDecoderType.TP_CODEC_MIMETYPE_HEVC, xq2, xq3, Collections.singletonList(bArr2), f2));
                                this.bik = true;
                            }
                            f2 = 1.0f;
                            mVar2.f(Format.a(str, TPDecoderType.TP_CODEC_MIMETYPE_HEVC, xq2, xq3, Collections.singletonList(bArr2), f2));
                            this.bik = true;
                        }
                    }
                    if (this.brI.es(i7)) {
                        this.brg.n(this.brI.nalData, com.google.android.exoplayer2.i.k.j(this.brI.nalData, this.brI.brX));
                        this.brg.eZ(5);
                        this.bqZ.a(j3, this.brg);
                    }
                    if (this.brJ.es(i7)) {
                        this.brg.n(this.brJ.nalData, com.google.android.exoplayer2.i.k.j(this.brJ.nalData, this.brJ.brX));
                        this.brg.eZ(5);
                        this.bqZ.a(j3, this.brg);
                    }
                    long j4 = this.bqS;
                    if (this.bik) {
                        a aVar2 = this.brG;
                        aVar2.brN = false;
                        aVar2.brO = false;
                        aVar2.brn = j4;
                        aVar2.brL = 0;
                        aVar2.brm = j2;
                        if (l >= 32) {
                            if (!aVar2.brP && aVar2.brq) {
                                aVar2.eq(i6);
                                aVar2.brq = false;
                            }
                            if (l <= 34) {
                                aVar2.brO = !aVar2.brP;
                                aVar2.brP = true;
                            }
                        }
                        aVar2.brK = l >= 16 && l <= 21;
                        if (aVar2.brK || l <= 9) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        aVar2.brM = z2;
                    } else {
                        this.brH.er(l);
                        this.brc.er(l);
                        this.brd.er(l);
                    }
                    this.brI.er(l);
                    this.brJ.er(l);
                    i3 = a2 + 3;
                }
            }
        }
        AppMethodBeat.o(92253);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void uL() {
    }

    private void e(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(92254);
        if (this.bik) {
            this.brG.g(bArr, i2, i3);
        } else {
            this.brH.f(bArr, i2, i3);
            this.brc.f(bArr, i2, i3);
            this.brd.f(bArr, i2, i3);
        }
        this.brI.f(bArr, i2, i3);
        this.brJ.f(bArr, i2, i3);
        AppMethodBeat.o(92254);
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        private final m biA;
        long bqM;
        long bqT;
        boolean bqU;
        boolean brK;
        int brL;
        boolean brM;
        boolean brN;
        boolean brO;
        boolean brP;
        long brm;
        long brn;
        boolean brq;

        public a(m mVar) {
            this.biA = mVar;
        }

        public final void g(byte[] bArr, int i2, int i3) {
            if (this.brM) {
                int i4 = (i2 + 2) - this.brL;
                if (i4 < i3) {
                    this.brN = (bArr[i4] & 128) != 0;
                    this.brM = false;
                    return;
                }
                this.brL += i3 - i2;
            }
        }

        /* access modifiers changed from: package-private */
        public final void eq(int i2) {
            AppMethodBeat.i(92249);
            this.biA.a(this.bqM, this.bqU ? 1 : 0, (int) (this.brm - this.bqT), i2, null);
            AppMethodBeat.o(92249);
        }
    }
}
