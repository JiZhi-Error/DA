package com.tencent.mm.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.lang.Comparable;
import java.util.NavigableMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentSkipListMap;

public abstract class e<T, S extends Comparable> {
    protected NavigableMap<S, d<T, S>> itu = new ConcurrentSkipListMap();
    private Vector<e<T, S>.a> itv = new Vector<>();
    protected long itw = 0;

    /* access modifiers changed from: protected */
    public abstract long aRP();

    /* access modifiers changed from: protected */
    public abstract long aRQ();

    /* access modifiers changed from: protected */
    public abstract long bV(T t);

    /* access modifiers changed from: protected */
    public abstract S bW(T t);

    /* access modifiers changed from: protected */
    public abstract S c(S s);

    /* access modifiers changed from: protected */
    public abstract d<T, S> d(S s);

    /* access modifiers changed from: protected */
    public abstract T e(S s);

    public final void a(e<T, S>.a aVar) {
        this.itv.add(aVar);
        Log.i("MicroMsg.BucketPool", "%s addPreload: %s", this, aVar);
        YU();
    }

    public final void YU() {
        if (this.itv.size() > 0) {
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.memory.e.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(156416);
                    e.a(e.this);
                    AppMethodBeat.o(156416);
                }
            }, "BucketPool_preload");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.tencent.mm.memory.e<T, S extends java.lang.Comparable> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public synchronized T b(S s) {
        T t;
        d dVar = (d) this.itu.get(s);
        if (dVar == null || dVar.size() <= 0) {
            Log.d("MicroMsg.BucketPool", "BucketPool get cannot get %s size", s);
            t = null;
        } else {
            Object pop = dVar.pop();
            this.itu.put(dVar.aRS(), dVar);
            zZ(bV(pop));
            t = pop;
        }
        return t;
    }

    public synchronized void bU(T t) {
        if (t != null) {
            S bW = bW(t);
            long bV = bV(t);
            if (bV > aRQ()) {
                Log.e("MicroMsg.BucketPool", "release, reach maximum element size: %s, ignore this", Long.valueOf(bV));
            } else if (this.itw + bV > aRP()) {
                Log.e("MicroMsg.BucketPool", "release, reach maximum size, just ignore %s %s", Long.valueOf(bV), Long.valueOf(this.itw));
            } else {
                d<T, S> dVar = (d) this.itu.get(bW);
                if (dVar == null) {
                    dVar = d(bW);
                }
                dVar.put(t);
                this.itu.put(bW, dVar);
                zY(bV);
            }
        }
    }

    private synchronized void zY(long j2) {
        this.itw += j2;
    }

    /* access modifiers changed from: protected */
    public final synchronized void zZ(long j2) {
        this.itw -= j2;
    }

    public void aRR() {
        Log.i("MicroMsg.BucketPool", "freeAll: %s", getClass().getName());
        this.itu.clear();
        this.itw = 0;
    }

    public abstract class a {
        public abstract S aRT();

        public abstract long aRU();

        public abstract int aRV();

        public a() {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r15v0, resolved type: com.tencent.mm.memory.e */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.tencent.mm.memory.d */
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void a(e eVar) {
        while (eVar.itv.size() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            e<T, S>.a remove = eVar.itv.remove(0);
            d d2 = eVar.d(eVar.c(remove.aRT()));
            long j2 = 0;
            int i2 = 0;
            long aRU = remove.aRU();
            int aRV = remove.aRV();
            Log.i("MicroMsg.BucketPool", "%s preload start preloadSize: %s sizeInBytes: %s  preLoadBytes: %s and nums: %s", eVar, remove.aRT(), eVar.c(remove.aRT()), Long.valueOf(aRU), Integer.valueOf(aRV));
            while (eVar.itw < eVar.aRP() && ((aRU <= 0 || j2 < aRU) && (aRV <= 0 || i2 < aRV))) {
                Object e2 = eVar.e(remove.aRT());
                d2.put(e2);
                j2 += eVar.bV(e2);
                i2++;
                eVar.zY(eVar.bV(e2));
            }
            Log.d("MicroMsg.BucketPool", "%s preload finished, put %d elements, used %dms", eVar, Integer.valueOf(d2.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            eVar.itu.put(eVar.c(remove.aRT()), d2);
        }
    }
}
