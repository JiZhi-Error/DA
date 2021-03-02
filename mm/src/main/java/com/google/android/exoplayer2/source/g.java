package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

final class g implements com.google.android.exoplayer2.c.g, t.a<a>, t.d, j, m.b {
    boolean bcY;
    long bdJ;
    private final com.google.android.exoplayer2.h.g bhK;
    private final int bvE;
    final h.a bvF;
    final c bvG;
    private final com.google.android.exoplayer2.h.b bvH;
    final String bvI;
    final long bvJ;
    final t bvK = new t("Loader:ExtractorMediaPeriod");
    private final b bvL;
    final f bvM;
    private final Runnable bvN;
    final Runnable bvO;
    l bvP;
    m[] bvQ;
    private int[] bvR;
    boolean bvS;
    private boolean bvT;
    boolean bvU;
    private int bvV;
    r bvW;
    boolean[] bvX;
    boolean[] bvY;
    boolean bvZ;
    j.a bvs;
    long bwa;
    private long bwb;
    private int bwc;
    boolean bwd;
    private final Handler eventHandler;
    final Handler handler;
    private long length;
    boolean released;
    private final Uri uri;

    interface c {
        void d(long j2, boolean z);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.h.t$c, long, long, java.io.IOException] */
    @Override // com.google.android.exoplayer2.h.t.a
    public final /* synthetic */ int a(a aVar, long j2, long j3, final IOException iOException) {
        boolean z;
        AppMethodBeat.i(92669);
        a aVar2 = aVar;
        a(aVar2);
        if (!(this.eventHandler == null || this.bvF == null)) {
            this.eventHandler.post(new Runnable() {
                /* class com.google.android.exoplayer2.source.g.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(92645);
                    g.this.bvF.onLoadError(iOException);
                    AppMethodBeat.o(92645);
                }
            });
        }
        if (iOException instanceof s) {
            AppMethodBeat.o(92669);
            return 3;
        }
        if (vx() > this.bwc) {
            z = true;
        } else {
            z = false;
        }
        if (this.length == -1 && (this.bvP == null || this.bvP.getDurationUs() == -9223372036854775807L)) {
            this.bwa = 0;
            this.bvU = this.bcY;
            for (m mVar : this.bvQ) {
                mVar.reset(false);
            }
            aVar2.i(0, 0);
        }
        this.bwc = vx();
        if (z) {
            AppMethodBeat.o(92669);
            return 1;
        }
        AppMethodBeat.o(92669);
        return 0;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.h.t$c, long, long] */
    @Override // com.google.android.exoplayer2.h.t.a
    public final /* synthetic */ void a(a aVar, long j2, long j3) {
        AppMethodBeat.i(92671);
        a(aVar);
        this.bwd = true;
        if (this.bdJ == -9223372036854775807L) {
            long vy = vy();
            this.bdJ = vy == Long.MIN_VALUE ? 0 : vy + 10000;
            this.bvG.d(this.bdJ, this.bvP.uu());
        }
        this.bvs.a((o) this);
        AppMethodBeat.o(92671);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.h.t$c, long, long, boolean] */
    @Override // com.google.android.exoplayer2.h.t.a
    public final /* synthetic */ void a(a aVar, long j2, long j3, boolean z) {
        AppMethodBeat.i(92670);
        a aVar2 = aVar;
        if (!z) {
            a(aVar2);
            for (m mVar : this.bvQ) {
                mVar.reset(false);
            }
            if (this.bvV > 0) {
                this.bvs.a((o) this);
            }
        }
        AppMethodBeat.o(92670);
    }

    public g(Uri uri2, com.google.android.exoplayer2.h.g gVar, e[] eVarArr, int i2, Handler handler2, h.a aVar, c cVar, com.google.android.exoplayer2.h.b bVar, String str, int i3) {
        AppMethodBeat.i(92652);
        this.uri = uri2;
        this.bhK = gVar;
        this.bvE = i2;
        this.eventHandler = handler2;
        this.bvF = aVar;
        this.bvG = cVar;
        this.bvH = bVar;
        this.bvI = str;
        this.bvJ = (long) i3;
        this.bvL = new b(eVarArr, this);
        this.bvM = new f();
        this.bvN = new Runnable() {
            /* class com.google.android.exoplayer2.source.g.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(92643);
                g gVar = g.this;
                if (gVar.released || gVar.bcY || gVar.bvP == null || !gVar.bvS) {
                    AppMethodBeat.o(92643);
                    return;
                }
                m[] mVarArr = gVar.bvQ;
                int length = mVarArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        if (mVarArr[i2].bwO.vG() == null) {
                            break;
                        }
                        i2++;
                    } else {
                        gVar.bvM.close();
                        int length2 = gVar.bvQ.length;
                        q[] qVarArr = new q[length2];
                        gVar.bvY = new boolean[length2];
                        gVar.bvX = new boolean[length2];
                        gVar.bdJ = gVar.bvP.getDurationUs();
                        for (int i3 = 0; i3 < length2; i3++) {
                            Format vG = gVar.bvQ[i3].bwO.vG();
                            qVarArr[i3] = new q(vG);
                            String str = vG.bdq;
                            boolean z = com.google.android.exoplayer2.i.j.by(str) || com.google.android.exoplayer2.i.j.bx(str);
                            gVar.bvY[i3] = z;
                            gVar.bvZ = z | gVar.bvZ;
                        }
                        gVar.bvW = new r(qVarArr);
                        gVar.bcY = true;
                        gVar.bvG.d(gVar.bdJ, gVar.bvP.uu());
                        gVar.bvs.a((j) gVar);
                    }
                }
                AppMethodBeat.o(92643);
            }
        };
        this.bvO = new Runnable() {
            /* class com.google.android.exoplayer2.source.g.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(92644);
                if (!g.this.released) {
                    g.this.bvs.a((o) g.this);
                }
                AppMethodBeat.o(92644);
            }
        };
        this.handler = new Handler();
        this.bvR = new int[0];
        this.bvQ = new m[0];
        this.bwb = -9223372036854775807L;
        this.length = -1;
        AppMethodBeat.o(92652);
    }

    @Override // com.google.android.exoplayer2.h.t.d
    public final void vv() {
        AppMethodBeat.i(92653);
        b bVar = this.bvL;
        if (bVar.bwk != null) {
            bVar.bwk = null;
        }
        for (m mVar : this.bvQ) {
            mVar.reset(false);
        }
        AppMethodBeat.o(92653);
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void a(j.a aVar, long j2) {
        AppMethodBeat.i(92654);
        this.bvs = aVar;
        this.bvM.open();
        startLoading();
        AppMethodBeat.o(92654);
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void vn() {
    }

    @Override // com.google.android.exoplayer2.source.j
    public final r vo() {
        return this.bvW;
    }

    @Override // com.google.android.exoplayer2.source.j
    public final long a(com.google.android.exoplayer2.g.f[] fVarArr, boolean[] zArr, n[] nVarArr, boolean[] zArr2, long j2) {
        int i2 = 0;
        AppMethodBeat.i(92655);
        com.google.android.exoplayer2.i.a.checkState(this.bcY);
        int i3 = this.bvV;
        for (int i4 = 0; i4 < fVarArr.length; i4++) {
            if (nVarArr[i4] != null && (fVarArr[i4] == null || !zArr[i4])) {
                int i5 = ((d) nVarArr[i4]).track;
                com.google.android.exoplayer2.i.a.checkState(this.bvX[i5]);
                this.bvV--;
                this.bvX[i5] = false;
                nVarArr[i4] = null;
            }
        }
        boolean z = this.bvT ? i3 == 0 : j2 != 0;
        for (int i6 = 0; i6 < fVarArr.length; i6++) {
            if (nVarArr[i6] == null && fVarArr[i6] != null) {
                com.google.android.exoplayer2.g.f fVar = fVarArr[i6];
                com.google.android.exoplayer2.i.a.checkState(fVar.length() == 1);
                com.google.android.exoplayer2.i.a.checkState(fVar.eV(0) == 0);
                int a2 = this.bvW.a(fVar.wy());
                com.google.android.exoplayer2.i.a.checkState(!this.bvX[a2]);
                this.bvV++;
                this.bvX[a2] = true;
                nVarArr[i6] = new d(a2);
                zArr2[i6] = true;
                if (!z) {
                    m mVar = this.bvQ[a2];
                    mVar.rewind();
                    if (mVar.f(j2, true) || mVar.bwO.vE() == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                }
            }
            z = z;
        }
        if (this.bvV == 0) {
            this.bvU = false;
            if (this.bvK.isLoading()) {
                m[] mVarArr = this.bvQ;
                int length2 = mVarArr.length;
                while (i2 < length2) {
                    mVarArr[i2].vL();
                    i2++;
                }
                this.bvK.cancelLoading();
            } else {
                for (m mVar2 : this.bvQ) {
                    mVar2.reset(false);
                }
            }
        } else if (z) {
            j2 = W(j2);
            while (i2 < nVarArr.length) {
                if (nVarArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.bvT = true;
        AppMethodBeat.o(92655);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void V(long j2) {
        AppMethodBeat.i(92656);
        int length2 = this.bvQ.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.bvQ[i2].h(j2, this.bvX[i2]);
        }
        AppMethodBeat.o(92656);
    }

    @Override // com.google.android.exoplayer2.source.o, com.google.android.exoplayer2.source.j
    public final boolean X(long j2) {
        AppMethodBeat.i(92657);
        if (this.bwd || (this.bcY && this.bvV == 0)) {
            AppMethodBeat.o(92657);
            return false;
        }
        boolean open = this.bvM.open();
        if (!this.bvK.isLoading()) {
            startLoading();
            open = true;
        }
        AppMethodBeat.o(92657);
        return open;
    }

    @Override // com.google.android.exoplayer2.source.o, com.google.android.exoplayer2.source.j
    public final long vr() {
        AppMethodBeat.i(92658);
        if (this.bvV == 0) {
            AppMethodBeat.o(92658);
            return Long.MIN_VALUE;
        }
        long vq = vq();
        AppMethodBeat.o(92658);
        return vq;
    }

    @Override // com.google.android.exoplayer2.source.j
    public final long vp() {
        if (!this.bvU) {
            return -9223372036854775807L;
        }
        this.bvU = false;
        return this.bwa;
    }

    @Override // com.google.android.exoplayer2.source.o, com.google.android.exoplayer2.source.j
    public final long vq() {
        long j2;
        AppMethodBeat.i(92659);
        if (this.bwd) {
            AppMethodBeat.o(92659);
            return Long.MIN_VALUE;
        } else if (vz()) {
            long j3 = this.bwb;
            AppMethodBeat.o(92659);
            return j3;
        } else {
            if (this.bvZ) {
                j2 = MAlarmHandler.NEXT_FIRE_INTERVAL;
                int length2 = this.bvQ.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    if (this.bvY[i2]) {
                        j2 = Math.min(j2, this.bvQ[i2].bwO.vy());
                    }
                }
            } else {
                j2 = vy();
            }
            if (j2 == Long.MIN_VALUE) {
                long j4 = this.bwa;
                AppMethodBeat.o(92659);
                return j4;
            }
            AppMethodBeat.o(92659);
            return j2;
        }
    }

    @Override // com.google.android.exoplayer2.source.j
    public final long W(long j2) {
        AppMethodBeat.i(92660);
        if (!this.bvP.uu()) {
            j2 = 0;
        }
        this.bwa = j2;
        this.bvU = false;
        if (vz() || !Z(j2)) {
            this.bwb = j2;
            this.bwd = false;
            if (this.bvK.isLoading()) {
                this.bvK.cancelLoading();
            } else {
                for (m mVar : this.bvQ) {
                    mVar.reset(false);
                }
            }
            AppMethodBeat.o(92660);
        } else {
            AppMethodBeat.o(92660);
        }
        return j2;
    }

    @Override // com.google.android.exoplayer2.c.g
    public final com.google.android.exoplayer2.c.m dV(int i2) {
        AppMethodBeat.i(196042);
        int length2 = this.bvQ.length;
        for (int i3 = 0; i3 < length2; i3++) {
            if (this.bvR[i3] == i2) {
                m mVar = this.bvQ[i3];
                AppMethodBeat.o(196042);
                return mVar;
            }
        }
        m mVar2 = new m(this.bvH);
        mVar2.bwY = this;
        this.bvR = Arrays.copyOf(this.bvR, length2 + 1);
        this.bvR[length2] = i2;
        this.bvQ = (m[]) Arrays.copyOf(this.bvQ, length2 + 1);
        this.bvQ[length2] = mVar2;
        AppMethodBeat.o(196042);
        return mVar2;
    }

    @Override // com.google.android.exoplayer2.c.g
    public final void uy() {
        AppMethodBeat.i(92662);
        this.bvS = true;
        this.handler.post(this.bvN);
        AppMethodBeat.o(92662);
    }

    @Override // com.google.android.exoplayer2.c.g
    public final void a(l lVar) {
        AppMethodBeat.i(92663);
        this.bvP = lVar;
        this.handler.post(this.bvN);
        AppMethodBeat.o(92663);
    }

    @Override // com.google.android.exoplayer2.source.m.b
    public final void vw() {
        AppMethodBeat.i(92664);
        this.handler.post(this.bvN);
        AppMethodBeat.o(92664);
    }

    private void a(a aVar) {
        if (this.length == -1) {
            this.length = aVar.length;
        }
    }

    private void startLoading() {
        AppMethodBeat.i(92665);
        a aVar = new a(this.uri, this.bhK, this.bvL, this.bvM);
        if (this.bcY) {
            com.google.android.exoplayer2.i.a.checkState(vz());
            if (this.bdJ == -9223372036854775807L || this.bwb < this.bdJ) {
                aVar.i(this.bvP.L(this.bwb), this.bwb);
                this.bwb = -9223372036854775807L;
            } else {
                this.bwd = true;
                this.bwb = -9223372036854775807L;
                AppMethodBeat.o(92665);
                return;
            }
        }
        this.bwc = vx();
        int i2 = this.bvE;
        if (i2 == -1) {
            i2 = (this.bcY && this.length == -1 && (this.bvP == null || this.bvP.getDurationUs() == -9223372036854775807L)) ? 6 : 3;
        }
        this.bvK.a(aVar, this, i2);
        AppMethodBeat.o(92665);
    }

    private boolean Z(long j2) {
        AppMethodBeat.i(92666);
        int length2 = this.bvQ.length;
        for (int i2 = 0; i2 < length2; i2++) {
            m mVar = this.bvQ[i2];
            mVar.rewind();
            if (mVar.f(j2, false) || (!this.bvY[i2] && this.bvZ)) {
                mVar.vK();
            } else {
                AppMethodBeat.o(92666);
                return false;
            }
        }
        AppMethodBeat.o(92666);
        return true;
    }

    private int vx() {
        AppMethodBeat.i(92667);
        m[] mVarArr = this.bvQ;
        int length2 = mVarArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length2) {
            i2++;
            i3 = mVarArr[i2].bwO.vD() + i3;
        }
        AppMethodBeat.o(92667);
        return i3;
    }

    private long vy() {
        AppMethodBeat.i(92668);
        long j2 = Long.MIN_VALUE;
        for (m mVar : this.bvQ) {
            j2 = Math.max(j2, mVar.bwO.vy());
        }
        AppMethodBeat.o(92668);
        return j2;
    }

    /* access modifiers changed from: package-private */
    public final boolean vz() {
        return this.bwb != -9223372036854775807L;
    }

    final class d implements n {
        final int track;

        public d(int i2) {
            this.track = i2;
        }

        @Override // com.google.android.exoplayer2.source.n
        public final boolean isReady() {
            AppMethodBeat.i(92649);
            g gVar = g.this;
            int i2 = this.track;
            if (gVar.bwd || (!gVar.vz() && gVar.bvQ[i2].bwO.vF())) {
                AppMethodBeat.o(92649);
                return true;
            }
            AppMethodBeat.o(92649);
            return false;
        }

        @Override // com.google.android.exoplayer2.source.n
        public final void vs() {
        }

        @Override // com.google.android.exoplayer2.source.n
        public final int b(k kVar, com.google.android.exoplayer2.b.e eVar, boolean z) {
            AppMethodBeat.i(92650);
            g gVar = g.this;
            int i2 = this.track;
            if (gVar.bvU || gVar.vz()) {
                AppMethodBeat.o(92650);
                return -3;
            }
            int a2 = gVar.bvQ[i2].a(kVar, eVar, z, gVar.bwd, gVar.bwa);
            AppMethodBeat.o(92650);
            return a2;
        }

        @Override // com.google.android.exoplayer2.source.n
        public final void Y(long j2) {
            AppMethodBeat.i(92651);
            g gVar = g.this;
            m mVar = gVar.bvQ[this.track];
            if (!gVar.bwd || j2 <= mVar.bwO.vy()) {
                mVar.f(j2, true);
                AppMethodBeat.o(92651);
                return;
            }
            mVar.bwO.vH();
            AppMethodBeat.o(92651);
        }
    }

    /* access modifiers changed from: package-private */
    public final class a implements t.c {
        private final com.google.android.exoplayer2.h.g bhK;
        private final b bvL;
        private final f bvM;
        private final com.google.android.exoplayer2.c.k bwf = new com.google.android.exoplayer2.c.k();
        private volatile boolean bwg;
        private boolean bwh = true;
        private long bwi;
        long length = -1;
        private final Uri uri;

        public a(Uri uri2, com.google.android.exoplayer2.h.g gVar, b bVar, f fVar) {
            AppMethodBeat.i(92646);
            this.uri = (Uri) com.google.android.exoplayer2.i.a.checkNotNull(uri2);
            this.bhK = (com.google.android.exoplayer2.h.g) com.google.android.exoplayer2.i.a.checkNotNull(gVar);
            this.bvL = (b) com.google.android.exoplayer2.i.a.checkNotNull(bVar);
            this.bvM = fVar;
            AppMethodBeat.o(92646);
        }

        public final void i(long j2, long j3) {
            this.bwf.position = j2;
            this.bwi = j3;
            this.bwh = true;
        }

        @Override // com.google.android.exoplayer2.h.t.c
        public final void vA() {
            this.bwg = true;
        }

        @Override // com.google.android.exoplayer2.h.t.c
        public final boolean vB() {
            return this.bwg;
        }

        @Override // com.google.android.exoplayer2.h.t.c
        public final void vC() {
            int i2;
            com.google.android.exoplayer2.c.b bVar;
            Throwable th;
            int i3;
            AppMethodBeat.i(92647);
            int i4 = 0;
            while (i4 == 0 && !this.bwg) {
                try {
                    long j2 = this.bwf.position;
                    this.length = this.bhK.a(new com.google.android.exoplayer2.h.j(this.uri, j2, -1, g.this.bvI));
                    if (this.length != -1) {
                        this.length += j2;
                    }
                    com.google.android.exoplayer2.c.b bVar2 = new com.google.android.exoplayer2.c.b(this.bhK, j2, this.length);
                    try {
                        e a2 = this.bvL.a(bVar2, this.bhK.getUri());
                        if (this.bwh) {
                            a2.f(j2, this.bwi);
                            this.bwh = false;
                        }
                        int i5 = i4;
                        while (i5 == 0) {
                            try {
                                if (this.bwg) {
                                    break;
                                }
                                this.bvM.block();
                                i2 = a2.a(bVar2, this.bwf);
                                try {
                                    if (bVar2.getPosition() > g.this.bvJ + j2) {
                                        j2 = bVar2.getPosition();
                                        this.bvM.close();
                                        g.this.handler.post(g.this.bvO);
                                        i5 = i2;
                                    } else {
                                        i5 = i2;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    bVar = bVar2;
                                    this.bwf.position = bVar.getPosition();
                                    x.a(this.bhK);
                                    AppMethodBeat.o(92647);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                bVar = bVar2;
                                i2 = i5;
                                this.bwf.position = bVar.getPosition();
                                x.a(this.bhK);
                                AppMethodBeat.o(92647);
                                throw th;
                            }
                        }
                        if (i5 == 1) {
                            i3 = 0;
                        } else {
                            this.bwf.position = bVar2.getPosition();
                            i3 = i5;
                        }
                        x.a(this.bhK);
                        i4 = i3;
                    } catch (Throwable th4) {
                        th = th4;
                        bVar = bVar2;
                        i2 = i4;
                        this.bwf.position = bVar.getPosition();
                        x.a(this.bhK);
                        AppMethodBeat.o(92647);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bVar = null;
                    i2 = i4;
                    if (!(i2 == 1 || bVar == null)) {
                        this.bwf.position = bVar.getPosition();
                    }
                    x.a(this.bhK);
                    AppMethodBeat.o(92647);
                    throw th;
                }
            }
            AppMethodBeat.o(92647);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        private final com.google.android.exoplayer2.c.g bir;
        private final e[] bwj;
        e bwk;

        public b(e[] eVarArr, com.google.android.exoplayer2.c.g gVar) {
            this.bwj = eVarArr;
            this.bir = gVar;
        }

        public final e a(com.google.android.exoplayer2.c.f fVar, Uri uri) {
            AppMethodBeat.i(92648);
            if (this.bwk != null) {
                e eVar = this.bwk;
                AppMethodBeat.o(92648);
                return eVar;
            }
            e[] eVarArr = this.bwj;
            int length = eVarArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                e eVar2 = eVarArr[i2];
                try {
                    if (eVar2.a(fVar)) {
                        this.bwk = eVar2;
                        fVar.uv();
                        break;
                    }
                    fVar.uv();
                    i2++;
                } catch (EOFException e2) {
                    fVar.uv();
                } catch (Throwable th) {
                    fVar.uv();
                    AppMethodBeat.o(92648);
                    throw th;
                }
            }
            if (this.bwk == null) {
                s sVar = new s("None of the available extractors (" + x.d(this.bwj) + ") could read the stream.", uri);
                AppMethodBeat.o(92648);
                throw sVar;
            }
            this.bwk.a(this.bir);
            e eVar3 = this.bwk;
            AppMethodBeat.o(92648);
            return eVar3;
        }
    }
}
