package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.d.a;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.i;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.ArrayList;
import java.util.Stack;

public final class g implements e, l {
    public static final h bil = new h() {
        /* class com.google.android.exoplayer2.c.d.g.AnonymousClass1 */

        @Override // com.google.android.exoplayer2.c.h
        public final e[] ux() {
            AppMethodBeat.i(92112);
            e[] eVarArr = {new g()};
            AppMethodBeat.o(92112);
            return eVarArr;
        }
    };
    private static final int boj = x.bJ("qt  ");
    private long bdJ;
    private final m biB;
    private final m biC;
    private com.google.android.exoplayer2.c.g bir;
    private int bis;
    private int bjJ;
    private int bjK;
    private final m bni;
    private final Stack<a.C0101a> bnk;
    private int bnm;
    private long bnn;
    private int bno;
    private m bnp;
    private a[] bok;
    private boolean bol;
    private final int flags;

    static {
        AppMethodBeat.i(92120);
        AppMethodBeat.o(92120);
    }

    public g() {
        this(0);
    }

    public g(int i2) {
        AppMethodBeat.i(92113);
        this.flags = i2;
        this.bni = new m(16);
        this.bnk = new Stack<>();
        this.biB = new m(k.bGT);
        this.biC = new m(4);
        AppMethodBeat.o(92113);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final boolean a(f fVar) {
        AppMethodBeat.i(92114);
        boolean h2 = i.h(fVar);
        AppMethodBeat.o(92114);
        return h2;
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void a(com.google.android.exoplayer2.c.g gVar) {
        this.bir = gVar;
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void f(long j2, long j3) {
        AppMethodBeat.i(92115);
        this.bnk.clear();
        this.bno = 0;
        this.bjK = 0;
        this.bjJ = 0;
        if (j2 == 0) {
            uF();
            AppMethodBeat.o(92115);
            return;
        }
        if (this.bok != null) {
            a[] aVarArr = this.bok;
            for (a aVar : aVarArr) {
                m mVar = aVar.bom;
                int P = mVar.P(j3);
                if (P == -1) {
                    P = mVar.Q(j3);
                }
                aVar.bmT = P;
            }
        }
        AppMethodBeat.o(92115);
    }

    /* JADX WARNING: Removed duplicated region for block: B:164:0x002c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0006 A[SYNTHETIC] */
    @Override // com.google.android.exoplayer2.c.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.google.android.exoplayer2.c.f r13, com.google.android.exoplayer2.c.k r14) {
        /*
        // Method dump skipped, instructions count: 850
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.d.g.a(com.google.android.exoplayer2.c.f, com.google.android.exoplayer2.c.k):int");
    }

    @Override // com.google.android.exoplayer2.c.l
    public final boolean uu() {
        return true;
    }

    @Override // com.google.android.exoplayer2.c.l
    public final long getDurationUs() {
        return this.bdJ;
    }

    @Override // com.google.android.exoplayer2.c.l
    public final long L(long j2) {
        AppMethodBeat.i(92117);
        long j3 = MAlarmHandler.NEXT_FIRE_INTERVAL;
        a[] aVarArr = this.bok;
        int length = aVarArr.length;
        int i2 = 0;
        while (i2 < length) {
            m mVar = aVarArr[i2].bom;
            int P = mVar.P(j2);
            if (P == -1) {
                P = mVar.Q(j2);
            }
            long j4 = mVar.offsets[P];
            if (j4 >= j3) {
                j4 = j3;
            }
            i2++;
            j3 = j4;
        }
        AppMethodBeat.o(92117);
        return j3;
    }

    private void uF() {
        this.bis = 0;
        this.bno = 0;
    }

    private void O(long j2) {
        AppMethodBeat.i(92118);
        while (!this.bnk.isEmpty() && this.bnk.peek().bmy == j2) {
            a.C0101a pop = this.bnk.pop();
            if (pop.type == a.blk) {
                f(pop);
                this.bnk.clear();
                this.bis = 2;
            } else if (!this.bnk.isEmpty()) {
                this.bnk.peek().a(pop);
            }
        }
        if (this.bis != 2) {
            uF();
        }
        AppMethodBeat.o(92118);
    }

    private void f(a.C0101a aVar) {
        Metadata metadata;
        AppMethodBeat.i(92119);
        long j2 = -9223372036854775807L;
        ArrayList arrayList = new ArrayList();
        i iVar = new i();
        a.b ef = aVar.ef(a.bmj);
        if (ef != null) {
            Metadata a2 = b.a(ef, this.bol);
            if (a2 != null) {
                iVar.c(a2);
            }
            metadata = a2;
        } else {
            metadata = null;
        }
        int i2 = 0;
        while (true) {
            long j3 = j2;
            if (i2 < aVar.bmA.size()) {
                a.C0101a aVar2 = aVar.bmA.get(i2);
                if (aVar2.type == a.blm) {
                    j a3 = b.a(aVar2, aVar.ef(a.bll), -9223372036854775807L, (DrmInitData) null, (this.flags & 1) != 0, this.bol);
                    if (a3 != null) {
                        m a4 = b.a(a3, aVar2.eg(a.bln).eg(a.blo).eg(a.blp), iVar);
                        if (a4.sampleCount != 0) {
                            a aVar3 = new a(a3, a4, this.bir.dV(i2));
                            Format dF = a3.bdF.dF(a4.bmW + 30);
                            if (a3.type == 1) {
                                if (iVar.uz()) {
                                    dF = dF.aY(iVar.bdA, iVar.bdB);
                                }
                                if (metadata != null) {
                                    dF = dF.a(metadata);
                                }
                            }
                            aVar3.bky.f(dF);
                            j3 = Math.max(j3, a3.bdJ);
                            arrayList.add(aVar3);
                        }
                    }
                }
                j2 = j3;
                i2++;
            } else {
                this.bdJ = j3;
                this.bok = (a[]) arrayList.toArray(new a[arrayList.size()]);
                this.bir.uy();
                this.bir.a(this);
                AppMethodBeat.o(92119);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        public final com.google.android.exoplayer2.c.m bky;
        public int bmT;
        public final j bnA;
        public final m bom;

        public a(j jVar, m mVar, com.google.android.exoplayer2.c.m mVar2) {
            this.bnA = jVar;
            this.bom = mVar;
            this.bky = mVar2;
        }
    }
}
