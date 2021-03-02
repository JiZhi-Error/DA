package com.bumptech.glide.load.b;

import android.os.Build;
import android.support.v4.e.l;
import android.util.Log;
import com.bumptech.glide.g.a.a;
import com.bumptech.glide.g.a.b;
import com.bumptech.glide.h;
import com.bumptech.glide.load.b.f;
import com.bumptech.glide.load.b.i;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public final class h<R> implements a.c, f.a, Comparable<h<?>>, Runnable {
    com.bumptech.glide.e aCm;
    Object aDf;
    com.bumptech.glide.load.g aFT;
    i aFV;
    final d aFY;
    com.bumptech.glide.g aGc;
    j aGd;
    final g<R> aGg = new g<>();
    private final List<Throwable> aGh = new ArrayList();
    private final com.bumptech.glide.g.a.b aGi = new b.a();
    private final l.a<h<?>> aGj;
    final c<?> aGk = new c<>();
    final e aGl = new e();
    n aGm;
    a<R> aGn;
    private g aGo;
    f aGp;
    private long aGq;
    boolean aGr;
    private Thread aGs;
    com.bumptech.glide.load.g aGt;
    private com.bumptech.glide.load.g aGu;
    private Object aGv;
    private com.bumptech.glide.load.a aGw;
    private com.bumptech.glide.load.a.d<?> aGx;
    volatile f aGy;
    private volatile boolean aGz;
    int height;
    volatile boolean isCancelled;
    int order;
    int width;

    /* access modifiers changed from: package-private */
    public interface a<R> {
        void a(h<?> hVar);

        void a(q qVar);

        void c(v<R> vVar, com.bumptech.glide.load.a aVar);
    }

    /* access modifiers changed from: package-private */
    public interface d {
        com.bumptech.glide.load.b.b.a oz();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(h<?> hVar) {
        AppMethodBeat.i(76972);
        h<?> hVar2 = hVar;
        int ordinal = this.aGc.ordinal() - hVar2.aGc.ordinal();
        if (ordinal == 0) {
            ordinal = this.order - hVar2.order;
        }
        AppMethodBeat.o(76972);
        return ordinal;
    }

    h(d dVar, l.a<h<?>> aVar) {
        AppMethodBeat.i(76953);
        this.aFY = dVar;
        this.aGj = aVar;
        AppMethodBeat.o(76953);
    }

    private void oC() {
        AppMethodBeat.i(76954);
        if (this.aGl.oN()) {
            oE();
        }
        AppMethodBeat.o(76954);
    }

    private void oD() {
        AppMethodBeat.i(76955);
        if (this.aGl.oO()) {
            oE();
        }
        AppMethodBeat.o(76955);
    }

    /* access modifiers changed from: package-private */
    public final void oE() {
        AppMethodBeat.i(76956);
        this.aGl.reset();
        this.aGk.clear();
        this.aGg.clear();
        this.aGz = false;
        this.aCm = null;
        this.aFT = null;
        this.aFV = null;
        this.aGc = null;
        this.aGm = null;
        this.aGn = null;
        this.aGo = null;
        this.aGy = null;
        this.aGs = null;
        this.aGt = null;
        this.aGv = null;
        this.aGw = null;
        this.aGx = null;
        this.aGq = 0;
        this.isCancelled = false;
        this.aDf = null;
        this.aGh.clear();
        this.aGj.release(this);
        AppMethodBeat.o(76956);
    }

    public final void run() {
        AppMethodBeat.i(76957);
        com.bumptech.glide.load.a.d<?> dVar = this.aGx;
        try {
            if (this.isCancelled) {
                oH();
                if (dVar != null) {
                    dVar.cleanup();
                }
                AppMethodBeat.o(76957);
                return;
            }
            switch (this.aGp) {
                case INITIALIZE:
                    this.aGo = a(g.INITIALIZE);
                    this.aGy = oF();
                    oG();
                    break;
                case SWITCH_TO_SOURCE_SERVICE:
                    oG();
                    break;
                case DECODE_DATA:
                    oJ();
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Unrecognized run reason: " + this.aGp);
                    AppMethodBeat.o(76957);
                    throw illegalStateException;
            }
            if (dVar != null) {
                dVar.cleanup();
            }
            AppMethodBeat.o(76957);
        } catch (b e2) {
            AppMethodBeat.o(76957);
            throw e2;
        } catch (Throwable th) {
            if (dVar != null) {
                dVar.cleanup();
            }
            AppMethodBeat.o(76957);
            throw th;
        }
    }

    private f oF() {
        AppMethodBeat.i(76958);
        switch (this.aGo) {
            case RESOURCE_CACHE:
                w wVar = new w(this.aGg, this);
                AppMethodBeat.o(76958);
                return wVar;
            case DATA_CACHE:
                c cVar = new c(this.aGg, this);
                AppMethodBeat.o(76958);
                return cVar;
            case SOURCE:
                z zVar = new z(this.aGg, this);
                AppMethodBeat.o(76958);
                return zVar;
            case FINISHED:
                AppMethodBeat.o(76958);
                return null;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Unrecognized stage: " + this.aGo);
                AppMethodBeat.o(76958);
                throw illegalStateException;
        }
    }

    private void oG() {
        AppMethodBeat.i(76959);
        this.aGs = Thread.currentThread();
        this.aGq = com.bumptech.glide.g.f.qt();
        boolean z = false;
        while (!this.isCancelled && this.aGy != null && !(z = this.aGy.ow())) {
            this.aGo = a(this.aGo);
            this.aGy = oF();
            if (this.aGo == g.SOURCE) {
                oy();
                AppMethodBeat.o(76959);
                return;
            }
        }
        if ((this.aGo == g.FINISHED || this.isCancelled) && !z) {
            oH();
        }
        AppMethodBeat.o(76959);
    }

    private void oH() {
        AppMethodBeat.i(76960);
        oI();
        this.aGn.a(new q("Failed to load resource", new ArrayList(this.aGh)));
        oD();
        AppMethodBeat.o(76960);
    }

    private void a(v<R> vVar, com.bumptech.glide.load.a aVar) {
        AppMethodBeat.i(76961);
        oI();
        this.aGn.c(vVar, aVar);
        AppMethodBeat.o(76961);
    }

    private void oI() {
        AppMethodBeat.i(76962);
        this.aGi.qz();
        if (this.aGz) {
            IllegalStateException illegalStateException = new IllegalStateException("Already notified", this.aGh.isEmpty() ? null : this.aGh.get(this.aGh.size() - 1));
            AppMethodBeat.o(76962);
            throw illegalStateException;
        }
        this.aGz = true;
        AppMethodBeat.o(76962);
    }

    /* access modifiers changed from: package-private */
    public final g a(g gVar) {
        AppMethodBeat.i(76963);
        while (true) {
            switch (gVar) {
                case RESOURCE_CACHE:
                    if (!this.aGd.oQ()) {
                        gVar = g.DATA_CACHE;
                        break;
                    } else {
                        g gVar2 = g.DATA_CACHE;
                        AppMethodBeat.o(76963);
                        return gVar2;
                    }
                case DATA_CACHE:
                    if (this.aGr) {
                        g gVar3 = g.FINISHED;
                        AppMethodBeat.o(76963);
                        return gVar3;
                    }
                    g gVar4 = g.SOURCE;
                    AppMethodBeat.o(76963);
                    return gVar4;
                case SOURCE:
                case FINISHED:
                    g gVar5 = g.FINISHED;
                    AppMethodBeat.o(76963);
                    return gVar5;
                case INITIALIZE:
                    if (!this.aGd.oP()) {
                        gVar = g.RESOURCE_CACHE;
                        break;
                    } else {
                        g gVar6 = g.RESOURCE_CACHE;
                        AppMethodBeat.o(76963);
                        return gVar6;
                    }
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unrecognized stage: ".concat(String.valueOf(gVar)));
                    AppMethodBeat.o(76963);
                    throw illegalArgumentException;
            }
        }
    }

    @Override // com.bumptech.glide.load.b.f.a
    public final void oy() {
        AppMethodBeat.i(76964);
        this.aGp = f.SWITCH_TO_SOURCE_SERVICE;
        this.aGn.a((h<?>) this);
        AppMethodBeat.o(76964);
    }

    @Override // com.bumptech.glide.load.b.f.a
    public final void a(com.bumptech.glide.load.g gVar, Object obj, com.bumptech.glide.load.a.d<?> dVar, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.g gVar2) {
        AppMethodBeat.i(76965);
        this.aGt = gVar;
        this.aGv = obj;
        this.aGx = dVar;
        this.aGw = aVar;
        this.aGu = gVar2;
        if (Thread.currentThread() != this.aGs) {
            this.aGp = f.DECODE_DATA;
            this.aGn.a((h<?>) this);
            AppMethodBeat.o(76965);
            return;
        }
        try {
            oJ();
        } finally {
            AppMethodBeat.o(76965);
        }
    }

    @Override // com.bumptech.glide.load.b.f.a
    public final void a(com.bumptech.glide.load.g gVar, Exception exc, com.bumptech.glide.load.a.d<?> dVar, com.bumptech.glide.load.a aVar) {
        AppMethodBeat.i(76966);
        dVar.cleanup();
        q qVar = new q("Fetching data failed", exc);
        qVar.a(gVar, aVar, dVar.os());
        this.aGh.add(qVar);
        if (Thread.currentThread() != this.aGs) {
            this.aGp = f.SWITCH_TO_SOURCE_SERVICE;
            this.aGn.a((h<?>) this);
            AppMethodBeat.o(76966);
            return;
        }
        oG();
        AppMethodBeat.o(76966);
    }

    private void oJ() {
        v<R> vVar;
        AppMethodBeat.i(76967);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Retrieved data", this.aGq, "data: " + this.aGv + ", cache key: " + this.aGt + ", fetcher: " + this.aGx);
        }
        try {
            vVar = a(this.aGx, this.aGv, this.aGw);
        } catch (q e2) {
            e2.a(this.aGu, this.aGw, null);
            this.aGh.add(e2);
            vVar = null;
        }
        if (vVar != null) {
            b(vVar, this.aGw);
            AppMethodBeat.o(76967);
            return;
        }
        oG();
        AppMethodBeat.o(76967);
    }

    private void b(v<R> vVar, com.bumptech.glide.load.a aVar) {
        AppMethodBeat.i(76968);
        if (vVar instanceof r) {
            ((r) vVar).initialize();
        }
        u uVar = null;
        if (this.aGk.oL()) {
            u d2 = u.d(vVar);
            uVar = d2;
            vVar = d2;
        }
        a(vVar, aVar);
        this.aGo = g.ENCODE;
        try {
            if (this.aGk.oL()) {
                this.aGk.a(this.aFY, this.aFV);
            }
            if (uVar != null) {
                uVar.unlock();
            }
            oC();
            AppMethodBeat.o(76968);
        } catch (Throwable th) {
            if (uVar != null) {
                uVar.unlock();
            }
            AppMethodBeat.o(76968);
            throw th;
        }
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: com.bumptech.glide.load.b.t<Data, ?, R>, com.bumptech.glide.load.b.t<Data, ResourceType, R> */
    private <Data> v<R> a(com.bumptech.glide.load.a.d<?> dVar, Data data, com.bumptech.glide.load.a aVar) {
        v<R> vVar = null;
        AppMethodBeat.i(76969);
        if (data == null) {
            dVar.cleanup();
            AppMethodBeat.o(76969);
        } else {
            try {
                long qt = com.bumptech.glide.g.f.qt();
                vVar = a(data, aVar, (t<Data, ?, R>) this.aGg.m(data.getClass()));
                if (Log.isLoggable("DecodeJob", 2)) {
                    a("Decoded result ".concat(String.valueOf(vVar)), qt, (String) null);
                }
            } finally {
                dVar.cleanup();
                AppMethodBeat.o(76969);
            }
        }
        return vVar;
    }

    private void a(String str, long j2, String str2) {
        AppMethodBeat.i(76971);
        new StringBuilder().append(str).append(" in ").append(com.bumptech.glide.g.f.p(j2)).append(", load key: ").append(this.aGm).append(str2 != null ? ", ".concat(String.valueOf(str2)) : "").append(", thread: ").append(Thread.currentThread().getName());
        AppMethodBeat.o(76971);
    }

    @Override // com.bumptech.glide.g.a.a.c
    public final com.bumptech.glide.g.a.b oK() {
        return this.aGi;
    }

    /* access modifiers changed from: package-private */
    public final class b<Z> implements i.a<Z> {
        private final com.bumptech.glide.load.a aGD;

        b(com.bumptech.glide.load.a aVar) {
            this.aGD = aVar;
        }

        @Override // com.bumptech.glide.load.b.i.a
        public final v<Z> a(v<Z> vVar) {
            v<Z> vVar2;
            boolean z;
            com.bumptech.glide.load.c cVar;
            k<Z> kVar;
            boolean z2;
            com.bumptech.glide.load.g xVar;
            AppMethodBeat.i(76942);
            h hVar = h.this;
            com.bumptech.glide.load.a aVar = this.aGD;
            Class<?> cls = vVar.get().getClass();
            com.bumptech.glide.load.l<Z> lVar = null;
            if (aVar != com.bumptech.glide.load.a.RESOURCE_DISK_CACHE) {
                lVar = hVar.aGg.n(cls);
                vVar2 = lVar.a(hVar.aCm, vVar, hVar.width, hVar.height);
            } else {
                vVar2 = vVar;
            }
            if (!vVar.equals(vVar2)) {
                vVar.recycle();
            }
            if (hVar.aGg.aCm.aCn.aCU.w(vVar2.oV()) != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                k<Z> w = hVar.aGg.aCm.aCn.aCU.w(vVar2.oV());
                if (w != null) {
                    cVar = w.b(hVar.aFV);
                    kVar = w;
                } else {
                    h.d dVar = new h.d(vVar2.oV());
                    AppMethodBeat.o(76942);
                    throw dVar;
                }
            } else {
                cVar = com.bumptech.glide.load.c.NONE;
                kVar = null;
            }
            g<R> gVar = hVar.aGg;
            com.bumptech.glide.load.g gVar2 = hVar.aGt;
            List<n.a<?>> oA = gVar.oA();
            int size = oA.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    z2 = false;
                    break;
                } else if (oA.get(i2).aFO.equals(gVar2)) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            u<Z> uVar = vVar2;
            if (hVar.aGd.a(!z2, aVar, cVar)) {
                if (kVar == null) {
                    h.d dVar2 = new h.d(vVar2.get().getClass());
                    AppMethodBeat.o(76942);
                    throw dVar2;
                }
                switch (cVar) {
                    case SOURCE:
                        xVar = new d(hVar.aGt, hVar.aFT);
                        break;
                    case TRANSFORMED:
                        xVar = new x(hVar.aGg.aCm.aCo, hVar.aGt, hVar.aFT, hVar.width, hVar.height, lVar, cls, hVar.aFV);
                        break;
                    default:
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown strategy: ".concat(String.valueOf(cVar)));
                        AppMethodBeat.o(76942);
                        throw illegalArgumentException;
                }
                u<Z> d2 = u.d(vVar2);
                c<?> cVar2 = hVar.aGk;
                cVar2.aFH = xVar;
                cVar2.aGF = kVar;
                cVar2.aGG = d2;
                uVar = d2;
            }
            AppMethodBeat.o(76942);
            return uVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static class e {
        private boolean aGH;
        private boolean aGI;
        private boolean isReleased;

        e() {
        }

        /* access modifiers changed from: package-private */
        public final synchronized boolean oM() {
            boolean aF;
            AppMethodBeat.i(76944);
            this.isReleased = true;
            aF = aF(false);
            AppMethodBeat.o(76944);
            return aF;
        }

        /* access modifiers changed from: package-private */
        public final synchronized boolean oN() {
            boolean aF;
            AppMethodBeat.i(76945);
            this.aGH = true;
            aF = aF(false);
            AppMethodBeat.o(76945);
            return aF;
        }

        /* access modifiers changed from: package-private */
        public final synchronized boolean oO() {
            boolean aF;
            AppMethodBeat.i(76946);
            this.aGI = true;
            aF = aF(false);
            AppMethodBeat.o(76946);
            return aF;
        }

        /* access modifiers changed from: package-private */
        public final synchronized void reset() {
            this.aGH = false;
            this.isReleased = false;
            this.aGI = false;
        }

        private boolean aF(boolean z) {
            return (this.aGI || this.aGH) && this.isReleased;
        }
    }

    /* access modifiers changed from: package-private */
    public static class c<Z> {
        com.bumptech.glide.load.g aFH;
        k<Z> aGF;
        u<Z> aGG;

        c() {
        }

        /* access modifiers changed from: package-private */
        public final void a(d dVar, com.bumptech.glide.load.i iVar) {
            AppMethodBeat.i(76943);
            try {
                dVar.oz().a(this.aFH, new e(this.aGF, this.aGG, iVar));
            } finally {
                this.aGG.unlock();
                AppMethodBeat.o(76943);
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean oL() {
            return this.aGG != null;
        }

        /* access modifiers changed from: package-private */
        public final void clear() {
            this.aFH = null;
            this.aGF = null;
            this.aGG = null;
        }
    }

    /* access modifiers changed from: package-private */
    public enum f {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA;

        public static f valueOf(String str) {
            AppMethodBeat.i(76948);
            f fVar = (f) Enum.valueOf(f.class, str);
            AppMethodBeat.o(76948);
            return fVar;
        }

        static {
            AppMethodBeat.i(76949);
            AppMethodBeat.o(76949);
        }
    }

    /* access modifiers changed from: package-private */
    public enum g {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED;

        public static g valueOf(String str) {
            AppMethodBeat.i(76951);
            g gVar = (g) Enum.valueOf(g.class, str);
            AppMethodBeat.o(76951);
            return gVar;
        }

        static {
            AppMethodBeat.i(76952);
            AppMethodBeat.o(76952);
        }
    }

    private <Data, ResourceType> v<R> a(Data data, com.bumptech.glide.load.a aVar, t<Data, ResourceType, R> tVar) {
        boolean z;
        AppMethodBeat.i(76970);
        com.bumptech.glide.load.i iVar = this.aFV;
        if (Build.VERSION.SDK_INT >= 26) {
            if (aVar == com.bumptech.glide.load.a.RESOURCE_DISK_CACHE || this.aGg.aGf) {
                z = true;
            } else {
                z = false;
            }
            Boolean bool = (Boolean) iVar.a(com.bumptech.glide.load.d.a.h.aLf);
            if (bool == null || (bool.booleanValue() && !z)) {
                iVar = new com.bumptech.glide.load.i();
                iVar.a(this.aFV);
                iVar.aFa.put(com.bumptech.glide.load.d.a.h.aLf, Boolean.valueOf(z));
            }
        }
        com.bumptech.glide.load.a.e<Data> T = this.aCm.aCn.aCV.T(data);
        try {
            return tVar.a(T, iVar, this.width, this.height, new b(aVar));
        } finally {
            T.cleanup();
            AppMethodBeat.o(76970);
        }
    }
}
