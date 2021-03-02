package com.tencent.f;

import android.os.SystemClock;
import android.util.Pair;
import com.tencent.f.b;
import com.tencent.f.e.a;
import com.tencent.f.h.e;
import com.tencent.f.i.d;
import com.tencent.f.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class h implements c, i {
    public static i RTc;
    public static c RTd;
    private AtomicBoolean RTe = new AtomicBoolean(false);
    private a RTf;
    final e RTg;

    static synchronized void a(a aVar) {
        synchronized (h.class) {
            AppMethodBeat.i(183163);
            h hVar = new h(aVar);
            RTc = hVar;
            RTd = hVar;
            AppMethodBeat.o(183163);
        }
    }

    private h(a aVar) {
        AppMethodBeat.i(183164);
        this.RTf = aVar;
        this.RTg = new e(aVar);
        AppMethodBeat.o(183164);
    }

    @Override // com.tencent.f.i
    public final d<?> aV(Runnable runnable) {
        AppMethodBeat.i(183165);
        Objects.requireNonNull(runnable);
        d<?> c2 = c(runnable, 0L, false);
        AppMethodBeat.o(183165);
        return c2;
    }

    @Override // com.tencent.f.i
    public final d<?> n(Runnable runnable, long j2) {
        AppMethodBeat.i(183166);
        Objects.requireNonNull(runnable);
        d<?> c2 = c(runnable, j2, false);
        AppMethodBeat.o(183166);
        return c2;
    }

    @Override // com.tencent.f.i
    public final d<?> aW(Runnable runnable) {
        AppMethodBeat.i(183167);
        Objects.requireNonNull(runnable);
        d<?> c2 = c(runnable, 0L, true);
        AppMethodBeat.o(183167);
        return c2;
    }

    @Override // com.tencent.f.i
    public final d<?> aX(Runnable runnable) {
        AppMethodBeat.i(183168);
        Objects.requireNonNull(runnable);
        d<?> o = o(runnable, 0);
        AppMethodBeat.o(183168);
        return o;
    }

    @Override // com.tencent.f.i
    public final d<?> o(Runnable runnable, long j2) {
        AppMethodBeat.i(183170);
        Objects.requireNonNull(runnable);
        d<?> q = q(runnable, j2);
        AppMethodBeat.o(183170);
        return q;
    }

    @Override // com.tencent.f.i
    public final d<?> b(Runnable runnable, String str) {
        AppMethodBeat.i(183171);
        Objects.requireNonNull(runnable);
        d<?> a2 = a(runnable, 0, str);
        AppMethodBeat.o(183171);
        return a2;
    }

    @Override // com.tencent.f.i
    public final <T> d<T> a(Callable<T> callable, final String str) {
        AppMethodBeat.i(183172);
        Objects.requireNonNull(callable);
        Objects.requireNonNull(callable);
        d<T> dVar = (d) com.tencent.f.e.e.eD(callable).a(new a<Callable<T>, k<T>>() {
            /* class com.tencent.f.h.AnonymousClass11 */
            final /* synthetic */ long RTi = 0;

            @Override // com.tencent.f.e.a
            public final /* synthetic */ Object bT(Object obj) {
                AppMethodBeat.i(183155);
                Callable callable = (Callable) obj;
                k a2 = com.tencent.f.a.a.a(callable, this.RTi, str);
                if (callable instanceof com.tencent.f.i.e) {
                    ((com.tencent.f.i.e) callable).a(a2);
                }
                AppMethodBeat.o(183155);
                return a2;
            }
        }).a(new a<k<T>, d<T>>() {
            /* class com.tencent.f.h.AnonymousClass10 */
            final /* synthetic */ boolean RTj = false;

            @Override // com.tencent.f.e.a
            public final /* synthetic */ Object bT(Object obj) {
                AppMethodBeat.i(183154);
                d a2 = h.this.RTg.a((k) obj, this.RTj);
                AppMethodBeat.o(183154);
                return a2;
            }
        }).take();
        AppMethodBeat.o(183172);
        return dVar;
    }

    @Override // com.tencent.f.i
    public final d<?> c(Runnable runnable, String str) {
        AppMethodBeat.i(183173);
        Objects.requireNonNull(runnable);
        d<?> a2 = a(runnable, 0L, str, true);
        AppMethodBeat.o(183173);
        return a2;
    }

    @Override // com.tencent.f.i
    public final d<?> a(Runnable runnable, long j2, String str) {
        AppMethodBeat.i(183174);
        Objects.requireNonNull(runnable);
        d<?> a2 = a(runnable, j2, str, false);
        AppMethodBeat.o(183174);
        return a2;
    }

    @Override // com.tencent.f.i
    public final d<?> aY(Runnable runnable) {
        AppMethodBeat.i(183175);
        Objects.requireNonNull(runnable);
        Objects.requireNonNull(runnable);
        d<?> f2 = f(runnable, null);
        AppMethodBeat.o(183175);
        return f2;
    }

    @Override // com.tencent.f.i
    public final d<?> d(Runnable runnable, String str) {
        AppMethodBeat.i(256659);
        Objects.requireNonNull(runnable);
        Objects.requireNonNull(runnable);
        d<?> f2 = f(runnable, str);
        AppMethodBeat.o(256659);
        return f2;
    }

    @Override // com.tencent.f.i
    public final d<?> aZ(Runnable runnable) {
        AppMethodBeat.i(183176);
        Objects.requireNonNull(runnable);
        Objects.requireNonNull(runnable);
        d<?> c2 = c(runnable, 0, (String) null);
        AppMethodBeat.o(183176);
        return c2;
    }

    @Override // com.tencent.f.i
    public final <T> d<T> d(Callable<T> callable) {
        AppMethodBeat.i(256660);
        Objects.requireNonNull(callable);
        Objects.requireNonNull(callable);
        d<T> dVar = (d) com.tencent.f.e.e.eD(callable).a(new a<Callable<T>, k<T>>() {
            /* class com.tencent.f.h.AnonymousClass9 */
            final /* synthetic */ long RTi = 0;
            final /* synthetic */ String RTk = null;

            @Override // com.tencent.f.e.a
            public final /* synthetic */ Object bT(Object obj) {
                AppMethodBeat.i(256658);
                Callable callable = (Callable) obj;
                k a2 = com.tencent.f.a.a.a(callable, this.RTi, this.RTk);
                if (callable instanceof com.tencent.f.i.e) {
                    ((com.tencent.f.i.e) callable).a(a2);
                }
                AppMethodBeat.o(256658);
                return a2;
            }
        }).a(new a<k<T>, d<T>>() {
            /* class com.tencent.f.h.AnonymousClass8 */

            @Override // com.tencent.f.e.a
            public final /* synthetic */ Object bT(Object obj) {
                AppMethodBeat.i(256657);
                d j2 = h.this.RTg.j((k) obj);
                AppMethodBeat.o(256657);
                return j2;
            }
        }).take();
        AppMethodBeat.o(256660);
        return dVar;
    }

    @Override // com.tencent.f.i
    public final d<?> e(Runnable runnable, String str) {
        AppMethodBeat.i(256661);
        Objects.requireNonNull(runnable);
        d<?> b2 = b(runnable, 0, str);
        AppMethodBeat.o(256661);
        return b2;
    }

    @Override // com.tencent.f.i
    public final d<?> b(Runnable runnable, long j2, String str) {
        AppMethodBeat.i(256662);
        Objects.requireNonNull(runnable);
        d<?> c2 = c(runnable, j2, str);
        AppMethodBeat.o(256662);
        return c2;
    }

    @Override // com.tencent.f.i
    public final d<?> p(Runnable runnable, long j2) {
        AppMethodBeat.i(183177);
        Objects.requireNonNull(runnable);
        d<?> a2 = a(runnable, 0L, j2, true);
        AppMethodBeat.o(183177);
        return a2;
    }

    @Override // com.tencent.f.i
    public final d<?> a(Runnable runnable, long j2, long j3) {
        AppMethodBeat.i(256663);
        Objects.requireNonNull(runnable);
        d<?> a2 = a(runnable, j2, j3, false);
        AppMethodBeat.o(256663);
        return a2;
    }

    @Override // com.tencent.f.i
    public final d<?> ba(Runnable runnable) {
        AppMethodBeat.i(183178);
        d<?> aY = aY(runnable);
        AppMethodBeat.o(183178);
        return aY;
    }

    @Override // com.tencent.f.i
    public final boolean bqo(String str) {
        AppMethodBeat.i(183179);
        Objects.requireNonNull(str);
        com.tencent.f.j.a bqu = com.tencent.f.j.a.bqu(str);
        if (bqu != null) {
            bqu.RUS.clear();
            AppMethodBeat.o(183179);
            return true;
        }
        AppMethodBeat.o(183179);
        return false;
    }

    @Override // com.tencent.f.i
    public final boolean isShutdown() {
        AppMethodBeat.i(183180);
        boolean z = this.RTe.get();
        AppMethodBeat.o(183180);
        return z;
    }

    @Override // com.tencent.f.i
    public final synchronized boolean hmg() {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(183181);
            if (this.RTe.compareAndSet(false, true)) {
                com.tencent.f.j.a.release();
                e eVar = this.RTg;
                eVar.RUz.shutdown();
                eVar.RUA.shutdown();
                eVar.RUB.shutdown();
                d.RSS.i("PoolAdapter", "[shutdown]", new Object[0]);
                com.tencent.f.e.h.release();
                com.tencent.f.e.d.release();
                d.RSQ.shutdown();
                AppMethodBeat.o(183181);
            } else {
                AppMethodBeat.o(183181);
                z = false;
            }
        }
        return z;
    }

    @Override // com.tencent.f.c
    public final Map<String, Integer> hmd() {
        AppMethodBeat.i(183182);
        Map<String, Integer> hmv = com.tencent.f.g.h.RUe.hmv();
        AppMethodBeat.o(183182);
        return hmv;
    }

    @Override // com.tencent.f.c
    public final Map<String, List<Pair<String, Integer>>> hme() {
        AppMethodBeat.i(183183);
        long uptimeMillis = SystemClock.uptimeMillis();
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<String>> entry : this.RTg.hme().entrySet()) {
            HashMap hashMap2 = new HashMap();
            for (String str : entry.getValue()) {
                Pair pair = (Pair) hashMap2.get(str);
                hashMap2.put(str, new Pair<String, Integer>(str, Integer.valueOf(pair == null ? 1 : ((Integer) pair.second).intValue() + 1)) {
                    /* class com.tencent.f.h.AnonymousClass1 */

                    public final String toString() {
                        AppMethodBeat.i(183145);
                        String str = "(" + ((String) this.first) + " -> " + this.second + ")";
                        AppMethodBeat.o(183145);
                        return str;
                    }
                });
            }
            LinkedList linkedList = new LinkedList(hashMap2.values());
            Collections.sort(linkedList, new Comparator<Pair<String, Integer>>() {
                /* class com.tencent.f.h.AnonymousClass7 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(Pair<String, Integer> pair, Pair<String, Integer> pair2) {
                    AppMethodBeat.i(183152);
                    int compare = Integer.compare(((Integer) pair2.second).intValue(), ((Integer) pair.second).intValue());
                    AppMethodBeat.o(183152);
                    return compare;
                }
            });
            hashMap.put(entry.getKey(), linkedList);
        }
        d.RSS.i("ThreadPool", "[dumpWaitingTask] cost=" + (SystemClock.uptimeMillis() - uptimeMillis) + LocaleUtil.MALAY, new Object[0]);
        AppMethodBeat.o(183183);
        return hashMap;
    }

    @Override // com.tencent.f.i
    public final b bqp(String str) {
        AppMethodBeat.i(183184);
        b bVar = new b(str, 1, 1, new LinkedBlockingQueue(), new b.a());
        AppMethodBeat.o(183184);
        return bVar;
    }

    @Override // com.tencent.f.i
    public final b a(String str, int i2, int i3, BlockingQueue<Runnable> blockingQueue) {
        AppMethodBeat.i(183185);
        b bVar = new b(str, i2, i3, blockingQueue, new b.a());
        AppMethodBeat.o(183185);
        return bVar;
    }

    @Override // com.tencent.f.i
    public final a hmh() {
        return this.RTf;
    }

    private d<?> c(Runnable runnable, final long j2, final boolean z) {
        AppMethodBeat.i(183186);
        d<?> dVar = (d) com.tencent.f.e.e.eD(runnable).a(new a<Runnable, k>() {
            /* class com.tencent.f.h.AnonymousClass13 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.f.e.a
            public final /* synthetic */ k bT(Runnable runnable) {
                AppMethodBeat.i(183157);
                Runnable runnable2 = runnable;
                k<?> d2 = com.tencent.f.a.a.d(runnable2, j2, null);
                if (runnable2 instanceof com.tencent.f.i.e) {
                    ((com.tencent.f.i.e) runnable2).a(d2);
                }
                AppMethodBeat.o(183157);
                return d2;
            }
        }).a(new a<k, d<?>>() {
            /* class com.tencent.f.h.AnonymousClass12 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.f.e.a
            public final /* synthetic */ d<?> bT(k kVar) {
                AppMethodBeat.i(183156);
                k kVar2 = kVar;
                e eVar = h.this.RTg;
                boolean z = z;
                kVar2.a(eVar.RUB);
                if (z) {
                    eVar.RUB.RUC.aDv.postAtFrontOfQueue(kVar2);
                    AppMethodBeat.o(183156);
                    return kVar2;
                }
                d f2 = eVar.RUB.f(kVar2);
                AppMethodBeat.o(183156);
                return f2;
            }
        }).take();
        AppMethodBeat.o(183186);
        return dVar;
    }

    private d<?> f(Runnable runnable, String str) {
        AppMethodBeat.i(256664);
        d<?> dVar = (d) com.tencent.f.e.e.eD(runnable).a(new a<Runnable, k>(0, str) {
            /* class com.tencent.f.h.AnonymousClass15 */
            final /* synthetic */ long RTi = 0;
            final /* synthetic */ String RTk;

            {
                this.RTk = r6;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.f.e.a
            public final /* synthetic */ k bT(Runnable runnable) {
                AppMethodBeat.i(183159);
                Runnable runnable2 = runnable;
                k<?> d2 = com.tencent.f.a.a.d(runnable2, this.RTi, this.RTk);
                if (runnable2 instanceof com.tencent.f.i.e) {
                    ((com.tencent.f.i.e) runnable2).a(d2);
                }
                AppMethodBeat.o(183159);
                return d2;
            }
        }).a(new a<k, d<?>>() {
            /* class com.tencent.f.h.AnonymousClass14 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.f.e.a
            public final /* synthetic */ d<?> bT(k kVar) {
                AppMethodBeat.i(183158);
                d a2 = e.a(kVar, false, h.this.RTg.RUz);
                AppMethodBeat.o(183158);
                return a2;
            }
        }).take();
        AppMethodBeat.o(256664);
        return dVar;
    }

    private d<?> c(Runnable runnable, final long j2, final String str) {
        AppMethodBeat.i(256665);
        d<?> dVar = (d) com.tencent.f.e.e.eD(runnable).a(new a<Runnable, k>() {
            /* class com.tencent.f.h.AnonymousClass17 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.f.e.a
            public final /* synthetic */ k bT(Runnable runnable) {
                AppMethodBeat.i(183161);
                Runnable runnable2 = runnable;
                k<?> d2 = com.tencent.f.a.a.d(runnable2, j2, str);
                if (runnable2 instanceof com.tencent.f.i.e) {
                    ((com.tencent.f.i.e) runnable2).a(d2);
                }
                AppMethodBeat.o(183161);
                return d2;
            }
        }).a(new a<k, d<?>>() {
            /* class com.tencent.f.h.AnonymousClass16 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.f.e.a
            public final /* synthetic */ d<?> bT(k kVar) {
                AppMethodBeat.i(183160);
                d j2 = h.this.RTg.j(kVar);
                AppMethodBeat.o(183160);
                return j2;
            }
        }).take();
        AppMethodBeat.o(256665);
        return dVar;
    }

    private d<?> q(Runnable runnable, final long j2) {
        AppMethodBeat.i(183187);
        d<?> dVar = (d) com.tencent.f.e.e.eD(runnable).a(new a<Runnable, k>() {
            /* class com.tencent.f.h.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.f.e.a
            public final /* synthetic */ k bT(Runnable runnable) {
                AppMethodBeat.i(183146);
                Runnable runnable2 = runnable;
                k<?> d2 = com.tencent.f.a.a.d(runnable2, j2, null);
                if (runnable2 instanceof com.tencent.f.i.e) {
                    ((com.tencent.f.i.e) runnable2).a(d2);
                }
                AppMethodBeat.o(183146);
                return d2;
            }
        }).a(new a<k, d<?>>() {
            /* class com.tencent.f.h.AnonymousClass18 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.f.e.a
            public final /* synthetic */ d<?> bT(k kVar) {
                AppMethodBeat.i(183162);
                d a2 = h.this.RTg.a(kVar, false);
                AppMethodBeat.o(183162);
                return a2;
            }
        }).take();
        AppMethodBeat.o(183187);
        return dVar;
    }

    private d<?> a(Runnable runnable, final long j2, final String str, final boolean z) {
        AppMethodBeat.i(183188);
        d<?> dVar = (d) com.tencent.f.e.e.eD(runnable).a(new a<Runnable, k>() {
            /* class com.tencent.f.h.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.f.e.a
            public final /* synthetic */ k bT(Runnable runnable) {
                AppMethodBeat.i(183148);
                Runnable runnable2 = runnable;
                k<?> d2 = com.tencent.f.a.a.d(runnable2, j2, str);
                if (runnable2 instanceof com.tencent.f.i.e) {
                    ((com.tencent.f.i.e) runnable2).a(d2);
                }
                AppMethodBeat.o(183148);
                return d2;
            }
        }).a(new a<k, d<?>>() {
            /* class com.tencent.f.h.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.f.e.a
            public final /* synthetic */ d<?> bT(k kVar) {
                AppMethodBeat.i(183147);
                d a2 = h.this.RTg.a(kVar, z);
                AppMethodBeat.o(183147);
                return a2;
            }
        }).take();
        AppMethodBeat.o(183188);
        return dVar;
    }

    private d<?> a(Runnable runnable, final long j2, final long j3, final boolean z) {
        AppMethodBeat.i(256666);
        d<?> dVar = (d) com.tencent.f.e.e.eD(runnable).a(new a<Runnable, k>() {
            /* class com.tencent.f.h.AnonymousClass6 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.f.e.a
            public final /* synthetic */ k bT(Runnable runnable) {
                AppMethodBeat.i(183150);
                Runnable runnable2 = runnable;
                long j2 = j2;
                long j3 = j3;
                boolean z = z;
                long convert = TimeUnit.NANOSECONDS.convert(j3, TimeUnit.MILLISECONDS);
                long a2 = com.tencent.f.a.a.a(j2, TimeUnit.MILLISECONDS);
                if (z) {
                    convert = -convert;
                }
                k kVar = new k(runnable2, a2, convert, com.tencent.f.a.a.eC(runnable2));
                if (runnable2 instanceof com.tencent.f.i.e) {
                    ((com.tencent.f.i.e) runnable2).a(kVar);
                }
                AppMethodBeat.o(183150);
                return kVar;
            }
        }).a(new a<k, d<?>>() {
            /* class com.tencent.f.h.AnonymousClass5 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.f.e.a
            public final /* synthetic */ d<?> bT(k kVar) {
                AppMethodBeat.i(183149);
                d a2 = h.this.RTg.a(kVar, false);
                AppMethodBeat.o(183149);
                return a2;
            }
        }).take();
        AppMethodBeat.o(256666);
        return dVar;
    }
}
