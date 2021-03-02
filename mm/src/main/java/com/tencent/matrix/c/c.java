package com.tencent.matrix.c;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.f.i.k;
import com.tencent.matrix.a.b.a.c;
import com.tencent.matrix.a.b.a.d;
import com.tencent.matrix.a.b.a.g;
import com.tencent.matrix.a.c.e;
import com.tencent.matrix.report.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c extends com.tencent.matrix.a.b.a.a {
    private Runnable cSK = new Runnable() {
        /* class com.tencent.matrix.c.c.AnonymousClass1 */

        public final void run() {
            if (c.this.cVh.size() >= c.this.cVg) {
                Log.w("Matrix.battery.ThreadPoolJiffies", "cooling thread pools jiffies, before = " + c.this.cVh.size());
                List<g.a.AbstractC0209a<b>> SJ = c.this.SJ();
                c.this.SK();
                Log.w("Matrix.battery.ThreadPoolJiffies", "cooling thread pools jiffies, after = " + c.this.cVh.size());
                Log.w("Matrix.battery.ThreadPoolJiffies", "report thread pools jiffies");
                if (c.this.cVj != null) {
                    for (g.a.AbstractC0209a<b> aVar : SJ) {
                        com.tencent.matrix.b.b unused = c.this.cVj;
                        com.tencent.matrix.b.b.e(aVar);
                    }
                }
            }
        }
    };
    private com.tencent.matrix.a.b.a.c cUL;
    private d cUM;
    private int cVg = 1024;
    private final List<g.a.AbstractC0209a<b>> cVh = new ArrayList();
    final Map<Integer, b> cVi = new ConcurrentHashMap();
    private com.tencent.matrix.b.b cVj;
    private a cVk;

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void d(com.tencent.matrix.a.b.c cVar) {
        super.d(cVar);
        this.cVk = new a(this, com.tencent.f.c.b.RTE, (byte) 0);
        this.cUL = (com.tencent.matrix.a.b.a.c) cVar.aa(com.tencent.matrix.a.b.a.c.class);
        this.cUM = (d) cVar.aa(d.class);
        com.tencent.matrix.a.b.a aVar = cVar.cSe.cRJ;
        if (aVar instanceof com.tencent.matrix.b.b) {
            this.cVj = (com.tencent.matrix.b.b) aVar;
        }
        this.cVg = Math.max(cVar.cSe.cRQ, this.cVg);
    }

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void Se() {
        super.Se();
        com.tencent.f.c.b.RTE = new com.tencent.f.b.c() {
            /* class com.tencent.matrix.c.c.a.AnonymousClass1 */

            @Override // com.tencent.f.f.a
            public final void a(k kVar) {
                b t;
                a.this.cVm.a(kVar);
                c cVar = c.this;
                String key = kVar.getKey();
                if (Looper.myLooper() != Looper.getMainLooper() && (t = b.t(key, Process.myTid())) != null) {
                    cVar.cVi.put(Integer.valueOf(kVar.hashCode()), t);
                }
            }

            @Override // com.tencent.f.f.a
            public final void a(k kVar, long j2, long j3) {
                a.this.cVm.a(kVar, j2, j3);
                c.this.b(kVar.getKey(), kVar);
            }

            @Override // com.tencent.f.f.a
            public final void b(k kVar) {
                a.this.cVm.b(kVar);
                c cVar = c.this;
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    cVar.cVi.remove(Integer.valueOf(kVar.hashCode()));
                }
            }

            @Override // com.tencent.f.f.a
            public final void c(k kVar) {
                a.this.cVm.c(kVar);
                c.this.b(kVar.getKey(), kVar);
            }

            @Override // com.tencent.f.i.a
            public final boolean ez(String str) {
                return a.this.cVm.ez(str);
            }

            @Override // com.tencent.f.f.a
            public final void d(k kVar) {
                a.this.cVm.d(kVar);
            }

            @Override // com.tencent.f.f.a
            public final void e(k kVar) {
                a.this.cVm.e(kVar);
            }

            @Override // com.tencent.f.b.c
            public final void onShutdown() {
                a.this.cVm.onShutdown();
            }
        };
    }

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void Sf() {
        super.Sf();
        this.cVi.clear();
        this.cVh.clear();
        com.tencent.f.c.b.RTE = this.cVk.cVm;
    }

    @Override // com.tencent.matrix.a.b.a.g
    public final int Sg() {
        return 0;
    }

    public final List<g.a.AbstractC0209a<b>> SJ() {
        ArrayList arrayList;
        for (b bVar : this.cVi.values()) {
            b t = b.t(bVar.name, bVar.tid);
            if (t != null) {
                a(bVar, t);
            }
        }
        synchronized (this.cVh) {
            arrayList = new ArrayList(this.cVh);
        }
        Collections.sort(arrayList, new Comparator<g.a.AbstractC0209a<b>>() {
            /* class com.tencent.matrix.c.c.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(g.a.AbstractC0209a<b> aVar, g.a.AbstractC0209a<b> aVar2) {
                g.a.AbstractC0209a<b> aVar3 = aVar;
                g.a.AbstractC0209a<b> aVar4 = aVar2;
                if (aVar3.cTt == null || aVar4.cTt == null) {
                    Log.w("Matrix.battery.ThreadPoolJiffies", "delta should not be null: " + aVar3 + " vs " + aVar4);
                    return 0;
                }
                b bVar = (b) aVar3.cTt;
                b bVar2 = (b) aVar4.cTt;
                if (!(bVar.cVp == 1 && bVar2.cVp == 1)) {
                    if (bVar.cVp != 1) {
                        if (bVar2.cVp == 1) {
                            return -1;
                        }
                    }
                    return 1;
                }
                long longValue = ((Long) bVar.cVo.cTz).longValue() - ((Long) bVar2.cVo.cTz).longValue();
                if (longValue == 0) {
                    return 0;
                }
                if (longValue > 0) {
                    return -1;
                }
                return 1;
            }
        });
        return arrayList;
    }

    public final void SK() {
        synchronized (this.cVh) {
            Iterator<g.a.AbstractC0209a<b>> it = this.cVh.iterator();
            while (it.hasNext()) {
                if (((b) it.next().cTt).isFinished) {
                    it.remove();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str, Runnable runnable) {
        b bVar;
        if (Looper.myLooper() != Looper.getMainLooper() && (bVar = this.cVi.get(Integer.valueOf(runnable.hashCode()))) != null) {
            this.cVi.remove(Integer.valueOf(runnable.hashCode()));
            b t = b.t(str, Process.myTid());
            if (t != null) {
                t.isFinished = true;
                a(bVar, t);
            }
        }
    }

    private void a(b bVar, b bVar2) {
        F f2;
        if (bVar2.tid != bVar.tid) {
            Log.w("Matrix.battery.ThreadPoolJiffies", "task tid mismatch: " + bVar + " vs " + bVar2);
        } else if (!bVar2.name.equals(bVar.name)) {
            Log.w("Matrix.battery.ThreadPoolJiffies", "task name mismatch: " + bVar + " vs " + bVar2);
        } else {
            synchronized (this.cVh) {
                g.a.AbstractC0209a<b> a2 = bVar2.a(bVar);
                Iterator<g.a.AbstractC0209a<b>> it = this.cVh.iterator();
                while (it.hasNext()) {
                    g.a.AbstractC0209a<b> next = it.next();
                    if (((b) next.cTt).name.equals(((b) a2.cTt).name) && ((b) next.cTt).tid == ((b) a2.cTt).tid && !((b) next.cTt).isFinished) {
                        it.remove();
                    }
                }
                if (this.cUL != null) {
                    c.b bb = this.cUL.bb(a2.cTu);
                    if (!bb.cTq) {
                        ((b) a2.cTs).cTq = false;
                        ((b) a2.cTt).cTq = false;
                    }
                    String str = ((b) a2.cTt).scene;
                    long j2 = 100;
                    android.support.v4.e.k<String, Integer> Ss = this.cUL.bc(a2.cTu).Ss();
                    if (Ss != null) {
                        F f3 = Ss.first;
                        j2 = Ss.second == null ? 0 : (long) Ss.second.intValue();
                        f2 = f3;
                    } else {
                        f2 = str;
                    }
                    ((b) a2.cTt).cVr = ((Long) bb.cSO.cTz).longValue();
                    ((b) a2.cTt).scene = f2;
                    ((b) a2.cTt).cVt = j2;
                }
                if (this.cUM != null) {
                    d.C0208d bd = this.cUM.bd(a2.cTu);
                    if (!bd.cTq) {
                        ((b) a2.cTs).cTq = false;
                        ((b) a2.cTt).cTq = false;
                    }
                    ((b) a2.cTt).cVs = ((Long) bd.cTb.cTz).longValue();
                }
                this.cVh.add(a2);
            }
            if (this.cVh.size() >= this.cVg) {
                Log.w("Matrix.battery.ThreadPoolJiffies", "thread pools jiffies overheat, size = " + this.cVh.size());
                this.cSq.mHandler.post(this.cSK);
            }
        }
    }

    public static final class b extends g.a<b> {
        public g.a.c.b<Long> cVo;
        public int cVp;
        public int cVq;
        public long cVr = 100;
        public long cVs = 100;
        public long cVt = 100;
        public boolean isFinished = false;
        public String name;
        public String scene;
        public int tid;

        static b t(String str, int i2) {
            b bVar = new b();
            bVar.tid = i2;
            bVar.name = str;
            bVar.cVp = com.tencent.matrix.report.a.SP();
            bVar.cVq = com.tencent.matrix.report.a.SQ();
            bVar.scene = com.tencent.matrix.report.a.SO();
            if (a.SF()) {
                bVar.cVo = g.a.c.b.b(Long.valueOf(SystemClock.currentThreadTimeMillis() / 10));
                return bVar;
            }
            int myPid = Process.myPid();
            e.a cf = e.cf(myPid, i2);
            if (cf == null) {
                Log.w("Matrix.battery.ThreadPoolJiffies", "parse task procStat fail, name = " + str + ", tid = " + i2);
                a.C0226a.SR();
                a.b.C0228b.c(myPid, i2, str);
                return null;
            }
            bVar.cVo = g.a.c.b.b(Long.valueOf(cf.Sr()));
            return bVar;
        }

        b() {
        }

        public final g.a.AbstractC0209a<b> a(b bVar) {
            return new g.a.AbstractC0209a<b>(bVar, this) {
                /* class com.tencent.matrix.c.c.b.AnonymousClass1 */

                /* Return type fixed from 'com.tencent.matrix.a.b.a.g$a' to match base method */
                @Override // com.tencent.matrix.a.b.a.g.a.AbstractC0209a
                public final /* synthetic */ b Si() {
                    b bVar = new b();
                    bVar.tid = ((b) this.cTs).tid;
                    bVar.name = ((b) this.cTs).name;
                    bVar.cVo = g.a.b.C0211b.a(((b) this.cTr).cVo, ((b) this.cTs).cVo);
                    bVar.isFinished = ((b) this.cTs).isFinished;
                    if (((b) this.cTr).cVp == 1 || ((b) this.cTs).cVp == 1) {
                        bVar.cVp = 1;
                    } else if (((b) this.cTr).cVp == 3 && ((b) this.cTs).cVp == 3) {
                        bVar.cVp = 3;
                    } else {
                        bVar.cVp = 2;
                    }
                    if (((b) this.cTr).cVq == 1 || ((b) this.cTs).cVq == 1) {
                        bVar.cVq = 1;
                    } else if (((b) this.cTr).cVq == 3 && ((b) this.cTs).cVq == 3) {
                        bVar.cVq = 3;
                    } else if (((b) this.cTr).cVq == 4 && ((b) this.cTs).cVq == 4) {
                        bVar.cVq = 3;
                    } else {
                        bVar.cVq = 2;
                    }
                    bVar.scene = ((b) this.cTs).scene;
                    return bVar;
                }
            };
        }

        public final String toString() {
            return "TaskJiffiesSnapshot{appStat=" + this.cVp + ", devStat=" + this.cVq + ", tid=" + this.tid + ", name='" + this.name + '\'' + ", jiffies=" + this.cVo + '}';
        }
    }

    final class a {
        final com.tencent.f.b.c cVm;

        /* synthetic */ a(c cVar, com.tencent.f.b.c cVar2, byte b2) {
            this(cVar2);
        }

        private a(com.tencent.f.b.c cVar) {
            this.cVm = cVar;
        }
    }
}
