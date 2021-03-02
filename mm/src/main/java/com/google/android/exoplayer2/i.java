package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.i.s;
import com.google.android.exoplayer2.n;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class i implements Handler.Callback, h.a, j.a, k.a {
    private final s bcA;
    private final HandlerThread bcB;
    private final f bcC;
    private final n bcD;
    private r bcE;
    private com.google.android.exoplayer2.i.i bcF;
    private k bcG;
    private r[] bcH;
    private boolean bcI;
    int bcJ;
    private int bcK;
    private long bcL;
    private int bcM;
    private c bcN;
    private long bcO;
    private a bcP;
    private a bcQ;
    private a bcR;
    private final r[] bcc;
    private final h bcd;
    private final w.b bch;
    private final w.a bci;
    private boolean bck;
    private w bco;
    private p bcs;
    private b bct;
    private final s[] bcy;
    private final m bcz;
    private final Handler eventHandler;
    final Handler handler;
    private boolean isLoading;
    boolean released;
    private int repeatMode;
    private int state = 1;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.source.o] */
    @Override // com.google.android.exoplayer2.source.o.a
    public final /* synthetic */ void a(j jVar) {
        AppMethodBeat.i(91951);
        this.handler.obtainMessage(9, jVar).sendToTarget();
        AppMethodBeat.o(91951);
    }

    public static final class b {
        public final k.b bdd;
        public final long bde;
        public final long bdf;
        public volatile long bdg;
        public volatile long bdh;

        public b(long j2) {
            this(new k.b(0), j2);
            AppMethodBeat.i(91917);
            AppMethodBeat.o(91917);
        }

        public b(k.b bVar, long j2) {
            this(bVar, j2, -9223372036854775807L);
        }

        public b(k.b bVar, long j2, long j3) {
            this.bdd = bVar;
            this.bde = j2;
            this.bdf = j3;
            this.bdg = j2;
            this.bdh = j2;
        }
    }

    public static final class d {
        public final w bco;
        public final Object bcp;
        public final b bct;
        public final int bdk;

        public d(w wVar, Object obj, b bVar, int i2) {
            this.bco = wVar;
            this.bcp = obj;
            this.bct = bVar;
            this.bdk = i2;
        }
    }

    public i(r[] rVarArr, h hVar, m mVar, boolean z, int i2, Handler handler2, b bVar, f fVar) {
        AppMethodBeat.i(91918);
        this.bcc = rVarArr;
        this.bcd = hVar;
        this.bcz = mVar;
        this.bck = z;
        this.repeatMode = i2;
        this.eventHandler = handler2;
        this.bct = bVar;
        this.bcC = fVar;
        this.bcy = new s[rVarArr.length];
        for (int i3 = 0; i3 < rVarArr.length; i3++) {
            rVarArr[i3].setIndex(i3);
            this.bcy[i3] = rVarArr[i3].sW();
        }
        this.bcA = new s();
        this.bcH = new r[0];
        this.bch = new w.b();
        this.bci = new w.a();
        this.bcD = new n();
        hVar.bEE = this;
        this.bcs = p.bdM;
        this.bcB = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.bcB.start();
        this.handler = new Handler(this.bcB.getLooper(), this);
        AppMethodBeat.o(91918);
    }

    public final void a(w wVar, int i2, long j2) {
        AppMethodBeat.i(91919);
        this.handler.obtainMessage(3, new c(wVar, i2, j2)).sendToTarget();
        AppMethodBeat.o(91919);
    }

    public final synchronized void b(f.c... cVarArr) {
        AppMethodBeat.i(91920);
        if (this.released) {
            AppMethodBeat.o(91920);
        } else {
            int i2 = this.bcJ;
            this.bcJ = i2 + 1;
            this.handler.obtainMessage(11, cVarArr).sendToTarget();
            boolean z = false;
            while (this.bcK <= i2) {
                try {
                    wait();
                } catch (InterruptedException e2) {
                    z = true;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            AppMethodBeat.o(91920);
        }
    }

    public final synchronized void release() {
        AppMethodBeat.i(91921);
        if (this.released) {
            AppMethodBeat.o(91921);
        } else {
            this.handler.sendEmptyMessage(6);
            boolean z = false;
            while (!this.released) {
                try {
                    wait();
                } catch (InterruptedException e2) {
                    z = true;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            this.bcB.quit();
            AppMethodBeat.o(91921);
        }
    }

    @Override // com.google.android.exoplayer2.source.k.a
    public final void a(w wVar, Object obj) {
        AppMethodBeat.i(91922);
        this.handler.obtainMessage(7, Pair.create(wVar, obj)).sendToTarget();
        AppMethodBeat.o(91922);
    }

    @Override // com.google.android.exoplayer2.source.j.a
    public final void a(j jVar) {
        AppMethodBeat.i(91923);
        this.handler.obtainMessage(8, jVar).sendToTarget();
        AppMethodBeat.o(91923);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:444:0x0bcc, code lost:
        if (r16.bcQ == null) goto L_0x0c08;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:446:0x0bd6, code lost:
        if (r16.bcQ.index >= r5.index) goto L_0x0c08;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:447:0x0bd8, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:448:0x0bd9, code lost:
        if (r2 != false) goto L_0x0c0a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:449:0x0bdb, code lost:
        r16.bct = new com.google.android.exoplayer2.i.b(r16.bcR.bcX.bdH, a(r16.bcR.bcX.bdH, r16.bct.bdg), r16.bct.bdf);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:450:0x0c08, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:451:0x0c0a, code lost:
        r16.bcP = r3;
        r16.bcP.bda = null;
        a(r5);
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0268 A[LOOP:2: B:100:0x0268->B:104:0x0282, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x06e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r17) {
        /*
        // Method dump skipped, instructions count: 3530
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.handleMessage(android.os.Message):boolean");
    }

    private void setState(int i2) {
        AppMethodBeat.i(91925);
        if (this.state != i2) {
            this.state = i2;
            this.eventHandler.obtainMessage(1, i2, 0).sendToTarget();
        }
        AppMethodBeat.o(91925);
    }

    private void aP(boolean z) {
        int i2;
        AppMethodBeat.i(91926);
        if (this.isLoading != z) {
            this.isLoading = z;
            Handler handler2 = this.eventHandler;
            if (z) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            handler2.obtainMessage(2, i2, 0).sendToTarget();
        }
        AppMethodBeat.o(91926);
    }

    private void tl() {
        AppMethodBeat.i(91927);
        this.bcI = false;
        this.bcA.start();
        for (r rVar : this.bcH) {
            rVar.start();
        }
        AppMethodBeat.o(91927);
    }

    private void tm() {
        AppMethodBeat.i(91928);
        this.bcA.stop();
        for (r rVar : this.bcH) {
            a(rVar);
        }
        AppMethodBeat.o(91928);
    }

    private void tn() {
        long vq;
        AppMethodBeat.i(91929);
        if (this.bcR == null) {
            AppMethodBeat.o(91929);
            return;
        }
        long vp = this.bcR.bcS.vp();
        if (vp != -9223372036854775807L) {
            z(vp);
        } else {
            if (this.bcE == null || this.bcE.tB()) {
                this.bcO = this.bcA.tV();
            } else {
                this.bcO = this.bcF.tV();
                this.bcA.ah(this.bcO);
            }
            vp = this.bcO - this.bcR.tr();
        }
        this.bct.bdg = vp;
        this.bcL = SystemClock.elapsedRealtime() * 1000;
        if (this.bcH.length == 0) {
            vq = Long.MIN_VALUE;
        } else {
            vq = this.bcR.bcS.vq();
        }
        b bVar = this.bct;
        if (vq == Long.MIN_VALUE) {
            vq = this.bcR.bcX.bdJ;
        }
        bVar.bdh = vq;
        AppMethodBeat.o(91929);
    }

    private void d(long j2, long j3) {
        AppMethodBeat.i(91930);
        this.handler.removeMessages(2);
        long elapsedRealtime = (j2 + j3) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.handler.sendEmptyMessage(2);
            AppMethodBeat.o(91930);
            return;
        }
        this.handler.sendEmptyMessageDelayed(2, elapsedRealtime);
        AppMethodBeat.o(91930);
    }

    private long a(k.b bVar, long j2) {
        a aVar;
        AppMethodBeat.i(91931);
        tm();
        this.bcI = false;
        setState(2);
        if (this.bcR != null) {
            aVar = null;
            for (a aVar2 = this.bcR; aVar2 != null; aVar2 = aVar2.bda) {
                if (aVar != null || !a(bVar, j2, aVar2)) {
                    aVar2.release();
                } else {
                    aVar = aVar2;
                }
            }
        } else if (this.bcP != null) {
            this.bcP.release();
            aVar = null;
        } else {
            aVar = null;
        }
        if (!(this.bcR == aVar && this.bcR == this.bcQ)) {
            for (r rVar : this.bcH) {
                rVar.disable();
            }
            this.bcH = new r[0];
            this.bcF = null;
            this.bcE = null;
            this.bcR = null;
        }
        if (aVar != null) {
            aVar.bda = null;
            this.bcP = aVar;
            this.bcQ = aVar;
            b(aVar);
            if (this.bcR.bcZ) {
                j2 = this.bcR.bcS.W(j2);
            }
            z(j2);
            tq();
        } else {
            this.bcP = null;
            this.bcQ = null;
            this.bcR = null;
            z(j2);
        }
        this.handler.sendEmptyMessage(2);
        AppMethodBeat.o(91931);
        return j2;
    }

    private boolean a(k.b bVar, long j2, a aVar) {
        AppMethodBeat.i(91932);
        if (bVar.equals(aVar.bcX.bdH) && aVar.bcY) {
            this.bco.a(aVar.bcX.bdH.bwx, this.bci, false);
            int F = this.bci.F(j2);
            if (F == -1 || this.bci.beo[F] == aVar.bcX.bdI) {
                AppMethodBeat.o(91932);
                return true;
            }
        }
        AppMethodBeat.o(91932);
        return false;
    }

    private void z(long j2) {
        long tr;
        AppMethodBeat.i(91933);
        if (this.bcR == null) {
            tr = 60000000 + j2;
        } else {
            tr = this.bcR.tr() + j2;
        }
        this.bcO = tr;
        this.bcA.ah(this.bcO);
        for (r rVar : this.bcH) {
            rVar.u(this.bcO);
        }
        AppMethodBeat.o(91933);
    }

    private void to() {
        AppMethodBeat.i(91934);
        aQ(true);
        this.bcz.onStopped();
        setState(1);
        AppMethodBeat.o(91934);
    }

    private void oE() {
        AppMethodBeat.i(91935);
        aQ(true);
        this.bcz.tg();
        setState(1);
        synchronized (this) {
            try {
                this.released = true;
                notifyAll();
            } finally {
                AppMethodBeat.o(91935);
            }
        }
    }

    private void aQ(boolean z) {
        AppMethodBeat.i(91936);
        this.handler.removeMessages(2);
        this.bcI = false;
        this.bcA.stop();
        this.bcF = null;
        this.bcE = null;
        this.bcO = 60000000;
        r[] rVarArr = this.bcH;
        for (r rVar : rVarArr) {
            try {
                a(rVar);
                rVar.disable();
            } catch (e | RuntimeException e2) {
            }
        }
        this.bcH = new r[0];
        a(this.bcR != null ? this.bcR : this.bcP);
        this.bcP = null;
        this.bcQ = null;
        this.bcR = null;
        aP(false);
        if (z) {
            if (this.bcG != null) {
                this.bcG.vu();
                this.bcG = null;
            }
            this.bcD.bco = null;
            this.bco = null;
        }
        AppMethodBeat.o(91936);
    }

    private void c(f.c[] cVarArr) {
        AppMethodBeat.i(91937);
        try {
            for (f.c cVar : cVarArr) {
                cVar.bbZ.c(cVar.bca, cVar.bcb);
            }
            if (this.state == 3 || this.state == 2) {
                this.handler.sendEmptyMessage(2);
            }
            synchronized (this) {
                try {
                    this.bcK++;
                    notifyAll();
                } finally {
                    AppMethodBeat.o(91937);
                }
            }
        } catch (Throwable th) {
            AppMethodBeat.o(91937);
            throw th;
        }
    }

    private static void a(r rVar) {
        AppMethodBeat.i(91938);
        if (rVar.getState() == 2) {
            rVar.stop();
        }
        AppMethodBeat.o(91938);
    }

    private boolean A(long j2) {
        AppMethodBeat.i(91939);
        if (j2 == -9223372036854775807L || this.bct.bdg < j2 || (this.bcR.bda != null && (this.bcR.bda.bcY || this.bcR.bda.bcX.bdH.isAd()))) {
            AppMethodBeat.o(91939);
            return true;
        }
        AppMethodBeat.o(91939);
        return false;
    }

    private void tp() {
        AppMethodBeat.i(91940);
        if (this.bcP != null && !this.bcP.bcY && (this.bcQ == null || this.bcQ.bda == this.bcP)) {
            for (r rVar : this.bcH) {
                if (!rVar.sZ()) {
                    AppMethodBeat.o(91940);
                    return;
                }
            }
            this.bcP.bcS.vn();
        }
        AppMethodBeat.o(91940);
    }

    private a a(a aVar, int i2) {
        AppMethodBeat.i(91941);
        while (true) {
            aVar.bcX = this.bcD.a(aVar.bcX, i2);
            if (aVar.bcX.bdK || aVar.bda == null) {
                AppMethodBeat.o(91941);
            } else {
                aVar = aVar.bda;
            }
        }
        AppMethodBeat.o(91941);
        return aVar;
    }

    private void b(Object obj, int i2) {
        AppMethodBeat.i(91942);
        this.bct = new b(0);
        c(obj, i2);
        this.bct = new b(-9223372036854775807L);
        setState(4);
        aQ(false);
        AppMethodBeat.o(91942);
    }

    private void c(Object obj, int i2) {
        AppMethodBeat.i(91943);
        this.eventHandler.obtainMessage(6, new d(this.bco, obj, this.bct, i2)).sendToTarget();
        AppMethodBeat.o(91943);
    }

    private int a(int i2, w wVar, w wVar2) {
        AppMethodBeat.i(91944);
        int tE = wVar.tE();
        int i3 = -1;
        for (int i4 = 0; i4 < tE && i3 == -1; i4++) {
            i2 = wVar.a(i2, this.bci, this.bch, this.repeatMode);
            if (i2 == -1) {
                break;
            }
            i3 = wVar2.ae(wVar.a(i2, this.bci, true).bcT);
        }
        AppMethodBeat.o(91944);
        return i3;
    }

    private Pair<Integer, Long> a(c cVar) {
        AppMethodBeat.i(91945);
        w wVar = cVar.bco;
        if (wVar.isEmpty()) {
            wVar = this.bco;
        }
        try {
            Pair<Integer, Long> a2 = wVar.a(this.bch, this.bci, cVar.bdi, cVar.bdj);
            if (this.bco == wVar) {
                AppMethodBeat.o(91945);
                return a2;
            }
            int ae = this.bco.ae(wVar.a(((Integer) a2.first).intValue(), this.bci, true).bcT);
            if (ae != -1) {
                Pair<Integer, Long> create = Pair.create(Integer.valueOf(ae), a2.second);
                AppMethodBeat.o(91945);
                return create;
            }
            int a3 = a(((Integer) a2.first).intValue(), wVar, this.bco);
            if (a3 != -1) {
                Pair<Integer, Long> dE = dE(this.bco.a(a3, this.bci, false).bdi);
                AppMethodBeat.o(91945);
                return dE;
            }
            AppMethodBeat.o(91945);
            return null;
        } catch (IndexOutOfBoundsException e2) {
            l lVar = new l(this.bco, cVar.bdi, cVar.bdj);
            AppMethodBeat.o(91945);
            throw lVar;
        }
    }

    private Pair<Integer, Long> dE(int i2) {
        AppMethodBeat.i(91946);
        Pair<Integer, Long> a2 = this.bco.a(this.bch, this.bci, i2, -9223372036854775807L);
        AppMethodBeat.o(91946);
        return a2;
    }

    private void tq() {
        AppMethodBeat.i(91947);
        boolean x = this.bcP.x(this.bcO);
        aP(x);
        if (x) {
            this.bcP.B(this.bcO);
        }
        AppMethodBeat.o(91947);
    }

    private static void a(a aVar) {
        AppMethodBeat.i(91948);
        while (aVar != null) {
            aVar.release();
            aVar = aVar.bda;
        }
        AppMethodBeat.o(91948);
    }

    private void b(a aVar) {
        AppMethodBeat.i(91949);
        if (this.bcR == aVar) {
            AppMethodBeat.o(91949);
            return;
        }
        boolean[] zArr = new boolean[this.bcc.length];
        int i2 = 0;
        for (int i3 = 0; i3 < this.bcc.length; i3++) {
            r rVar = this.bcc[i3];
            zArr[i3] = rVar.getState() != 0;
            com.google.android.exoplayer2.g.f fVar = aVar.bdb.bEG.bED[i3];
            if (fVar != null) {
                i2++;
            }
            if (zArr[i3] && (fVar == null || (rVar.tb() && rVar.sY() == this.bcR.bcU[i3]))) {
                if (rVar == this.bcE) {
                    this.bcA.a(this.bcF);
                    this.bcF = null;
                    this.bcE = null;
                }
                a(rVar);
                rVar.disable();
            }
        }
        this.bcR = aVar;
        this.eventHandler.obtainMessage(3, aVar.bdb).sendToTarget();
        a(zArr, i2);
        AppMethodBeat.o(91949);
    }

    private void a(boolean[] zArr, int i2) {
        AppMethodBeat.i(91950);
        this.bcH = new r[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < this.bcc.length; i4++) {
            r rVar = this.bcc[i4];
            com.google.android.exoplayer2.g.f fVar = this.bcR.bdb.bEG.bED[i4];
            if (fVar != null) {
                int i5 = i3 + 1;
                this.bcH[i3] = rVar;
                if (rVar.getState() == 0) {
                    t tVar = this.bcR.bdb.bEH[i4];
                    boolean z = this.bck && this.state == 3;
                    boolean z2 = !zArr[i4] && z;
                    Format[] formatArr = new Format[fVar.length()];
                    for (int i6 = 0; i6 < formatArr.length; i6++) {
                        formatArr[i6] = fVar.eU(i6);
                    }
                    rVar.a(tVar, formatArr, this.bcR.bcU[i4], this.bcO, z2, this.bcR.tr());
                    com.google.android.exoplayer2.i.i sX = rVar.sX();
                    if (sX != null) {
                        if (this.bcF != null) {
                            e a2 = e.a(new IllegalStateException("Multiple renderer media clocks enabled."));
                            AppMethodBeat.o(91950);
                            throw a2;
                        }
                        this.bcF = sX;
                        this.bcE = rVar;
                        this.bcF.c(this.bcs);
                    }
                    if (z) {
                        rVar.start();
                    }
                }
                i3 = i5;
            }
        }
        AppMethodBeat.o(91950);
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        private final k bcG;
        public final j bcS;
        public final Object bcT;
        public final n[] bcU;
        public final boolean[] bcV;
        public final long bcW;
        public n.a bcX;
        public boolean bcY;
        public boolean bcZ;
        private final r[] bcc;
        private final h bcd;
        private final s[] bcy;
        final m bcz;
        public a bda;
        public com.google.android.exoplayer2.g.i bdb;
        private com.google.android.exoplayer2.g.i bdc;
        public final int index;

        public a(r[] rVarArr, s[] sVarArr, long j2, h hVar, m mVar, k kVar, Object obj, int i2, n.a aVar) {
            com.google.android.exoplayer2.source.d dVar;
            AppMethodBeat.i(91909);
            this.bcc = rVarArr;
            this.bcy = sVarArr;
            this.bcW = j2;
            this.bcd = hVar;
            this.bcz = mVar;
            this.bcG = kVar;
            this.bcT = com.google.android.exoplayer2.i.a.checkNotNull(obj);
            this.index = i2;
            this.bcX = aVar;
            this.bcU = new com.google.android.exoplayer2.source.n[rVarArr.length];
            this.bcV = new boolean[rVarArr.length];
            j a2 = kVar.a(aVar.bdH, mVar.th());
            if (aVar.bdI != Long.MIN_VALUE) {
                com.google.android.exoplayer2.source.d dVar2 = new com.google.android.exoplayer2.source.d(a2, true);
                dVar2.h(0, aVar.bdI);
                dVar = dVar2;
            } else {
                dVar = a2;
            }
            this.bcS = dVar;
            AppMethodBeat.o(91909);
        }

        public final long tr() {
            return this.index == 0 ? this.bcW : this.bcW - this.bcX.bde;
        }

        public final boolean ts() {
            AppMethodBeat.i(91910);
            if (!this.bcY || (this.bcZ && this.bcS.vq() != Long.MIN_VALUE)) {
                AppMethodBeat.o(91910);
                return false;
            }
            AppMethodBeat.o(91910);
            return true;
        }

        public final boolean x(long j2) {
            long vr;
            AppMethodBeat.i(91911);
            if (!this.bcY) {
                vr = 0;
            } else {
                vr = this.bcS.vr();
            }
            if (vr == Long.MIN_VALUE) {
                AppMethodBeat.o(91911);
                return false;
            }
            boolean x = this.bcz.x(vr - (j2 - tr()));
            AppMethodBeat.o(91911);
            return x;
        }

        public final boolean tt() {
            AppMethodBeat.i(91913);
            com.google.android.exoplayer2.g.i a2 = this.bcd.a(this.bcy, this.bcS.vo());
            if (a2.a(this.bdc)) {
                AppMethodBeat.o(91913);
                return false;
            }
            this.bdb = a2;
            AppMethodBeat.o(91913);
            return true;
        }

        public final long C(long j2) {
            AppMethodBeat.i(91914);
            long a2 = a(j2, false, new boolean[this.bcc.length]);
            AppMethodBeat.o(91914);
            return a2;
        }

        public final long a(long j2, boolean z, boolean[] zArr) {
            AppMethodBeat.i(91915);
            g gVar = this.bdb.bEG;
            for (int i2 = 0; i2 < gVar.length; i2++) {
                this.bcV[i2] = !z && this.bdb.a(this.bdc, i2);
            }
            long a2 = this.bcS.a(gVar.wB(), this.bcV, this.bcU, zArr, j2);
            this.bdc = this.bdb;
            this.bcZ = false;
            for (int i3 = 0; i3 < this.bcU.length; i3++) {
                if (this.bcU[i3] != null) {
                    com.google.android.exoplayer2.i.a.checkState(gVar.bED[i3] != null);
                    this.bcZ = true;
                } else {
                    com.google.android.exoplayer2.i.a.checkState(gVar.bED[i3] == null);
                }
            }
            this.bcz.a(this.bcc, gVar);
            AppMethodBeat.o(91915);
            return a2;
        }

        public final void release() {
            AppMethodBeat.i(91916);
            try {
                if (this.bcX.bdI != Long.MIN_VALUE) {
                    this.bcG.b(((com.google.android.exoplayer2.source.d) this.bcS).bcS);
                    AppMethodBeat.o(91916);
                    return;
                }
                this.bcG.b(this.bcS);
                AppMethodBeat.o(91916);
            } catch (RuntimeException e2) {
                AppMethodBeat.o(91916);
            }
        }

        public final void B(long j2) {
            AppMethodBeat.i(91912);
            this.bcS.X(j2 - tr());
            AppMethodBeat.o(91912);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c {
        public final w bco;
        public final int bdi;
        public final long bdj;

        public c(w wVar, int i2, long j2) {
            this.bco = wVar;
            this.bdi = i2;
            this.bdj = j2;
        }
    }
}
