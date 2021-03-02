package com.google.android.exoplayer2.c.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.c.f.v;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class j implements h {
    private m biA;
    private boolean bik;
    private String bqA;
    private final boolean[] bqO = new boolean[3];
    private long bqQ;
    private long bqS;
    private final s bqZ;
    private final boolean bra;
    private final boolean brb;
    private final n brc = new n(7);
    private final n brd = new n(8);
    private final n bre = new n(6);
    private a brf;
    private final com.google.android.exoplayer2.i.m brg = new com.google.android.exoplayer2.i.m();

    public j(s sVar, boolean z, boolean z2) {
        AppMethodBeat.i(92244);
        this.bqZ = sVar;
        this.bra = z;
        this.brb = z2;
        AppMethodBeat.o(92244);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void uK() {
        AppMethodBeat.i(92245);
        k.a(this.bqO);
        this.brc.reset();
        this.brd.reset();
        this.bre.reset();
        this.brf.reset();
        this.bqQ = 0;
        AppMethodBeat.o(92245);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void a(g gVar, v.d dVar) {
        AppMethodBeat.i(92246);
        dVar.uW();
        this.bqA = dVar.uX();
        this.biA = gVar.dV(dVar.getTrackId());
        this.brf = new a(this.biA, this.bra, this.brb);
        this.bqZ.a(gVar, dVar);
        AppMethodBeat.o(92246);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void c(long j2, boolean z) {
        this.bqS = j2;
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void uL() {
    }

    private void e(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(92248);
        if (!this.bik || this.brf.brb) {
            this.brc.f(bArr, i2, i3);
            this.brd.f(bArr, i2, i3);
        }
        this.bre.f(bArr, i2, i3);
        this.brf.f(bArr, i2, i3);
        AppMethodBeat.o(92248);
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        final m biA;
        long bqM;
        long bqT;
        boolean bqU;
        boolean bqX;
        final boolean bra;
        final boolean brb;
        private final SparseArray<k.b> brh = new SparseArray<>();
        private final SparseArray<k.a> bri = new SparseArray<>();
        private final n brj = new n(this.buffer, 0, 0);
        int brk;
        int brl;
        long brm;
        long brn;
        C0104a bro = new C0104a((byte) 0);
        C0104a brp = new C0104a((byte) 0);
        boolean brq;
        private byte[] buffer = new byte[128];

        public a(m mVar, boolean z, boolean z2) {
            AppMethodBeat.i(92239);
            this.biA = mVar;
            this.bra = z;
            this.brb = z2;
            reset();
            AppMethodBeat.o(92239);
        }

        public final void a(k.b bVar) {
            AppMethodBeat.i(92240);
            this.brh.append(bVar.bHj, bVar);
            AppMethodBeat.o(92240);
        }

        public final void a(k.a aVar) {
            AppMethodBeat.i(92241);
            this.bri.append(aVar.brw, aVar);
            AppMethodBeat.o(92241);
        }

        public final void reset() {
            AppMethodBeat.i(92242);
            this.bqX = false;
            this.brq = false;
            this.brp.clear();
            AppMethodBeat.o(92242);
        }

        public final void f(byte[] bArr, int i2, int i3) {
            AppMethodBeat.i(92243);
            if (!this.bqX) {
                AppMethodBeat.o(92243);
                return;
            }
            int i4 = i3 - i2;
            if (this.buffer.length < this.brk + i4) {
                this.buffer = Arrays.copyOf(this.buffer, (this.brk + i4) * 2);
            }
            System.arraycopy(bArr, i2, this.buffer, this.brk, i4);
            this.brk = i4 + this.brk;
            this.brj.l(this.buffer, 0, this.brk);
            if (!this.brj.fb(8)) {
                AppMethodBeat.o(92243);
                return;
            }
            this.brj.xb();
            int em = this.brj.em(2);
            this.brj.en(5);
            if (!this.brj.xo()) {
                AppMethodBeat.o(92243);
                return;
            }
            this.brj.xq();
            if (!this.brj.xo()) {
                AppMethodBeat.o(92243);
                return;
            }
            int xq = this.brj.xq();
            if (!this.brb) {
                this.bqX = false;
                this.brp.ep(xq);
                AppMethodBeat.o(92243);
            } else if (!this.brj.xo()) {
                AppMethodBeat.o(92243);
            } else {
                int xq2 = this.brj.xq();
                if (this.bri.indexOfKey(xq2) < 0) {
                    this.bqX = false;
                    AppMethodBeat.o(92243);
                    return;
                }
                k.a aVar = this.bri.get(xq2);
                k.b bVar = this.brh.get(aVar.bHj);
                if (bVar.bHm) {
                    if (!this.brj.fb(2)) {
                        AppMethodBeat.o(92243);
                        return;
                    }
                    this.brj.en(2);
                }
                if (!this.brj.fb(bVar.bHo)) {
                    AppMethodBeat.o(92243);
                    return;
                }
                boolean z = false;
                boolean z2 = false;
                boolean z3 = false;
                int em2 = this.brj.em(bVar.bHo);
                if (!bVar.bHn) {
                    if (!this.brj.fb(1)) {
                        AppMethodBeat.o(92243);
                        return;
                    }
                    z = this.brj.uI();
                    if (z) {
                        if (!this.brj.fb(1)) {
                            AppMethodBeat.o(92243);
                            return;
                        } else {
                            z3 = this.brj.uI();
                            z2 = true;
                        }
                    }
                }
                boolean z4 = this.brl == 5;
                int i5 = 0;
                if (z4) {
                    if (!this.brj.xo()) {
                        AppMethodBeat.o(92243);
                        return;
                    }
                    i5 = this.brj.xq();
                }
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                if (bVar.bHp == 0) {
                    if (!this.brj.fb(bVar.bHq)) {
                        AppMethodBeat.o(92243);
                        return;
                    }
                    i6 = this.brj.em(bVar.bHq);
                    if (aVar.bHk && !z) {
                        if (!this.brj.xo()) {
                            AppMethodBeat.o(92243);
                            return;
                        }
                        i7 = this.brj.xp();
                    }
                } else if (bVar.bHp == 1 && !bVar.bHr) {
                    if (!this.brj.xo()) {
                        AppMethodBeat.o(92243);
                        return;
                    }
                    i8 = this.brj.xp();
                    if (aVar.bHk && !z) {
                        if (!this.brj.xo()) {
                            AppMethodBeat.o(92243);
                            return;
                        }
                        i9 = this.brj.xp();
                    }
                }
                this.brp.a(bVar, em, xq, em2, xq2, z, z2, z3, z4, i5, i6, i7, i8, i9);
                this.bqX = false;
                AppMethodBeat.o(92243);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.google.android.exoplayer2.c.f.j$a$a  reason: collision with other inner class name */
        public static final class C0104a {
            boolean brA;
            int brB;
            int brC;
            int brD;
            int brE;
            int brF;
            boolean brr;
            boolean brs;
            k.b brt;
            int bru;
            int brv;
            int brw;
            boolean brx;
            boolean bry;
            boolean brz;
            int frameNum;

            private C0104a() {
            }

            /* synthetic */ C0104a(byte b2) {
                this();
            }

            public final void clear() {
                this.brs = false;
                this.brr = false;
            }

            public final void ep(int i2) {
                this.brv = i2;
                this.brs = true;
            }

            public final void a(k.b bVar, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, int i6, int i7, int i8, int i9, int i10) {
                this.brt = bVar;
                this.bru = i2;
                this.brv = i3;
                this.frameNum = i4;
                this.brw = i5;
                this.brx = z;
                this.bry = z2;
                this.brz = z3;
                this.brA = z4;
                this.brB = i6;
                this.brC = i7;
                this.brD = i8;
                this.brE = i9;
                this.brF = i10;
                this.brr = true;
                this.brs = true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01fd, code lost:
        if (r2 != false) goto L_0x01ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0270, code lost:
        if (r2 != false) goto L_0x0272;
     */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0250  */
    @Override // com.google.android.exoplayer2.c.f.h
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t(com.google.android.exoplayer2.i.m r22) {
        /*
        // Method dump skipped, instructions count: 829
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.f.j.t(com.google.android.exoplayer2.i.m):void");
    }
}
