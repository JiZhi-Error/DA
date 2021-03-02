package com.bumptech.glide.load.b;

import android.support.v4.e.l;
import com.bumptech.glide.g.a.a;
import com.bumptech.glide.g.a.b;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.h;
import com.bumptech.glide.load.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public final class l<R> implements a.c, h.a<R> {
    private static final c aHx = new c();
    private final com.bumptech.glide.load.b.c.a aCB;
    private final com.bumptech.glide.load.b.c.a aCu;
    private final com.bumptech.glide.load.b.c.a aCv;
    private g aFH;
    private boolean aFI;
    private v<?> aFJ;
    com.bumptech.glide.load.a aGD;
    private final com.bumptech.glide.g.a.b aGi;
    private final l.a<l<?>> aGj;
    boolean aGr;
    private final AtomicInteger aHA;
    private boolean aHB;
    private boolean aHC;
    private boolean aHD;
    q aHE;
    private boolean aHF;
    p<?> aHG;
    private h<R> aHH;
    private final com.bumptech.glide.load.b.c.a aHp;
    private final m aHq;
    final e aHy;
    private final c aHz;
    private volatile boolean isCancelled;

    static {
        AppMethodBeat.i(77000);
        AppMethodBeat.o(77000);
    }

    l(com.bumptech.glide.load.b.c.a aVar, com.bumptech.glide.load.b.c.a aVar2, com.bumptech.glide.load.b.c.a aVar3, com.bumptech.glide.load.b.c.a aVar4, m mVar, l.a<l<?>> aVar5) {
        this(aVar, aVar2, aVar3, aVar4, mVar, aVar5, aHx);
    }

    private l(com.bumptech.glide.load.b.c.a aVar, com.bumptech.glide.load.b.c.a aVar2, com.bumptech.glide.load.b.c.a aVar3, com.bumptech.glide.load.b.c.a aVar4, m mVar, l.a<l<?>> aVar5, c cVar) {
        AppMethodBeat.i(76992);
        this.aHy = new e();
        this.aGi = new b.a();
        this.aHA = new AtomicInteger();
        this.aCv = aVar;
        this.aCu = aVar2;
        this.aHp = aVar3;
        this.aCB = aVar4;
        this.aHq = mVar;
        this.aGj = aVar5;
        this.aHz = cVar;
        AppMethodBeat.o(76992);
    }

    /* access modifiers changed from: package-private */
    public final synchronized l<R> a(g gVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.aFH = gVar;
        this.aFI = z;
        this.aHB = z2;
        this.aHC = z3;
        this.aGr = z4;
        return this;
    }

    public final synchronized void b(h<R> hVar) {
        boolean z;
        com.bumptech.glide.load.b.c.a oS;
        AppMethodBeat.i(204471);
        this.aHH = hVar;
        h.g a2 = hVar.a(h.g.INITIALIZE);
        if (a2 == h.g.RESOURCE_CACHE || a2 == h.g.DATA_CACHE) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            oS = this.aCv;
        } else {
            oS = oS();
        }
        oS.execute(hVar);
        AppMethodBeat.o(204471);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(com.bumptech.glide.e.g gVar, Executor executor) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(204472);
            this.aGi.qz();
            this.aHy.aHJ.add(new d(gVar, executor));
            if (this.aHD) {
                dh(1);
                executor.execute(new b(gVar));
                AppMethodBeat.o(204472);
            } else if (this.aHF) {
                dh(1);
                executor.execute(new a(gVar));
                AppMethodBeat.o(204472);
            } else {
                if (this.isCancelled) {
                    z = false;
                }
                j.checkArgument(z, "Cannot add callbacks to a cancelled EngineJob");
                AppMethodBeat.o(204472);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(com.bumptech.glide.e.g gVar) {
        AppMethodBeat.i(204473);
        try {
            gVar.c(this.aHG, this.aGD);
            AppMethodBeat.o(204473);
        } catch (Throwable th) {
            b bVar = new b(th);
            AppMethodBeat.o(204473);
            throw bVar;
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b(com.bumptech.glide.e.g gVar) {
        AppMethodBeat.i(204474);
        try {
            gVar.a(this.aHE);
            AppMethodBeat.o(204474);
        } catch (Throwable th) {
            b bVar = new b(th);
            AppMethodBeat.o(204474);
            throw bVar;
        }
    }

    public final synchronized void c(com.bumptech.glide.e.g gVar) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(204475);
            this.aGi.qz();
            this.aHy.aHJ.remove(e.e(gVar));
            if (this.aHy.isEmpty()) {
                if (!isDone()) {
                    this.isCancelled = true;
                    h<R> hVar = this.aHH;
                    hVar.isCancelled = true;
                    f fVar = hVar.aGy;
                    if (fVar != null) {
                        fVar.cancel();
                    }
                    this.aHq.a(this, this.aFH);
                }
                if (!this.aHD && !this.aHF) {
                    z = false;
                }
                if (z && this.aHA.get() == 0) {
                    release();
                }
            }
            AppMethodBeat.o(204475);
        }
    }

    private com.bumptech.glide.load.b.c.a oS() {
        if (this.aHB) {
            return this.aHp;
        }
        return this.aHC ? this.aCB : this.aCu;
    }

    private boolean isDone() {
        return this.aHF || this.aHD || this.isCancelled;
    }

    private synchronized void dh(int i2) {
        AppMethodBeat.i(204476);
        j.checkArgument(isDone(), "Not yet complete!");
        if (this.aHA.getAndAdd(i2) == 0 && this.aHG != null) {
            this.aHG.acquire();
        }
        AppMethodBeat.o(204476);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void oT() {
        AppMethodBeat.i(204477);
        this.aGi.qz();
        j.checkArgument(isDone(), "Not yet complete!");
        int decrementAndGet = this.aHA.decrementAndGet();
        j.checkArgument(decrementAndGet >= 0, "Can't decrement below 0");
        if (decrementAndGet == 0) {
            if (this.aHG != null) {
                this.aHG.release();
            }
            release();
        }
        AppMethodBeat.o(204477);
    }

    private synchronized void release() {
        AppMethodBeat.i(204478);
        if (this.aFH == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(204478);
            throw illegalArgumentException;
        }
        this.aHy.aHJ.clear();
        this.aFH = null;
        this.aHG = null;
        this.aFJ = null;
        this.aHF = false;
        this.isCancelled = false;
        this.aHD = false;
        h<R> hVar = this.aHH;
        if (hVar.aGl.oM()) {
            hVar.oE();
        }
        this.aHH = null;
        this.aHE = null;
        this.aGD = null;
        this.aGj.release(this);
        AppMethodBeat.o(204478);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.bumptech.glide.load.b.v<R> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007c, code lost:
        r5.aHq.a(r5, r1, r2);
        r1 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0089, code lost:
        if (r1.hasNext() == false) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008b, code lost:
        r0 = r1.next();
        r0.executor.execute(new com.bumptech.glide.load.b.l.b(r5, r0.aHv));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009e, code lost:
        oT();
        com.tencent.matrix.trace.core.AppMethodBeat.o(76996);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    @Override // com.bumptech.glide.load.b.h.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(com.bumptech.glide.load.b.v<R> r6, com.bumptech.glide.load.a r7) {
        /*
        // Method dump skipped, instructions count: 166
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.l.c(com.bumptech.glide.load.b.v, com.bumptech.glide.load.a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0067, code lost:
        r5.aHq.a(r5, r0, null);
        r1 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0075, code lost:
        if (r1.hasNext() == false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0077, code lost:
        r0 = r1.next();
        r0.executor.execute(new com.bumptech.glide.load.b.l.a(r5, r0.aHv));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        oT();
        com.tencent.matrix.trace.core.AppMethodBeat.o(76997);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    @Override // com.bumptech.glide.load.b.h.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.bumptech.glide.load.b.q r6) {
        /*
        // Method dump skipped, instructions count: 145
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.l.a(com.bumptech.glide.load.b.q):void");
    }

    @Override // com.bumptech.glide.load.b.h.a
    public final void a(h<?> hVar) {
        AppMethodBeat.i(76998);
        oS().execute(hVar);
        AppMethodBeat.o(76998);
    }

    @Override // com.bumptech.glide.g.a.a.c
    public final com.bumptech.glide.g.a.b oK() {
        return this.aGi;
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        private final com.bumptech.glide.e.g aHv;

        a(com.bumptech.glide.e.g gVar) {
            this.aHv = gVar;
        }

        public final void run() {
            AppMethodBeat.i(204460);
            synchronized (l.this) {
                try {
                    if (l.this.aHy.d(this.aHv)) {
                        l.this.b(this.aHv);
                    }
                    l.this.oT();
                } finally {
                    AppMethodBeat.o(204460);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements Runnable {
        private final com.bumptech.glide.e.g aHv;

        b(com.bumptech.glide.e.g gVar) {
            this.aHv = gVar;
        }

        public final void run() {
            AppMethodBeat.i(204461);
            synchronized (l.this) {
                try {
                    if (l.this.aHy.d(this.aHv)) {
                        l.this.aHG.acquire();
                        l.this.a(this.aHv);
                        l.this.c(this.aHv);
                    }
                    l.this.oT();
                } finally {
                    AppMethodBeat.o(204461);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class e implements Iterable<d> {
        final List<d> aHJ;

        e() {
            this(new ArrayList(2));
            AppMethodBeat.i(204464);
            AppMethodBeat.o(204464);
        }

        private e(List<d> list) {
            this.aHJ = list;
        }

        /* access modifiers changed from: package-private */
        public final boolean d(com.bumptech.glide.e.g gVar) {
            AppMethodBeat.i(204465);
            boolean contains = this.aHJ.contains(e(gVar));
            AppMethodBeat.o(204465);
            return contains;
        }

        /* access modifiers changed from: package-private */
        public final boolean isEmpty() {
            AppMethodBeat.i(204466);
            boolean isEmpty = this.aHJ.isEmpty();
            AppMethodBeat.o(204466);
            return isEmpty;
        }

        /* access modifiers changed from: package-private */
        public final int size() {
            AppMethodBeat.i(204467);
            int size = this.aHJ.size();
            AppMethodBeat.o(204467);
            return size;
        }

        /* access modifiers changed from: package-private */
        public final e oU() {
            AppMethodBeat.i(204468);
            e eVar = new e(new ArrayList(this.aHJ));
            AppMethodBeat.o(204468);
            return eVar;
        }

        static d e(com.bumptech.glide.e.g gVar) {
            AppMethodBeat.i(204469);
            d dVar = new d(gVar, com.bumptech.glide.g.e.qs());
            AppMethodBeat.o(204469);
            return dVar;
        }

        @Override // java.lang.Iterable
        public final Iterator<d> iterator() {
            AppMethodBeat.i(204470);
            Iterator<d> it = this.aHJ.iterator();
            AppMethodBeat.o(204470);
            return it;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class d {
        final com.bumptech.glide.e.g aHv;
        final Executor executor;

        d(com.bumptech.glide.e.g gVar, Executor executor2) {
            this.aHv = gVar;
            this.executor = executor2;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(204462);
            if (obj instanceof d) {
                boolean equals = this.aHv.equals(((d) obj).aHv);
                AppMethodBeat.o(204462);
                return equals;
            }
            AppMethodBeat.o(204462);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(204463);
            int hashCode = this.aHv.hashCode();
            AppMethodBeat.o(204463);
            return hashCode;
        }
    }

    static class c {
        c() {
        }
    }
}
