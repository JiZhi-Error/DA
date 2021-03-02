package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import android.os.ConditionVariable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public final class i implements a {
    private final HashMap<String, f> bGF = new HashMap<>();
    private final HashMap<String, ArrayList<a.AbstractC0709a>> bGH = new HashMap<>();
    private long bGI;
    final o mxJ;
    private final d mxK;
    private final HashMap<String, TreeSet<f>> mxL = new HashMap<>();

    public i(o oVar, d dVar) {
        AppMethodBeat.i(234696);
        this.mxJ = oVar;
        this.mxK = dVar;
        final ConditionVariable conditionVariable = new ConditionVariable();
        new Thread() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.b.a.i.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(234695);
                synchronized (i.this) {
                    try {
                        conditionVariable.open();
                        i iVar = i.this;
                        if (!iVar.mxJ.exists()) {
                            iVar.mxJ.mkdirs();
                        }
                        o[] het = iVar.mxJ.het();
                        if (het != null) {
                            for (o oVar : het) {
                                if (oVar.length() == 0) {
                                    oVar.delete();
                                } else {
                                    f B = f.B(oVar);
                                    if (B == null) {
                                        oVar.delete();
                                    } else if (!iVar.f(B)) {
                                        h.log(3, "SimpleCache", "remove duplicated span " + B.file);
                                        iVar.b(B);
                                    }
                                }
                            }
                        }
                    } finally {
                        AppMethodBeat.o(234695);
                    }
                }
            }
        }.start();
        conditionVariable.block();
        AppMethodBeat.o(234696);
    }

    private synchronized NavigableSet<f> bu(String str) {
        TreeSet treeSet;
        AppMethodBeat.i(234697);
        TreeSet<f> treeSet2 = this.mxL.get(str);
        if (treeSet2 == null) {
            treeSet = null;
            AppMethodBeat.o(234697);
        } else {
            TreeSet treeSet3 = new TreeSet((SortedSet) treeSet2);
            AppMethodBeat.o(234697);
            treeSet = treeSet3;
        }
        return treeSet;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a
    public final synchronized long wN() {
        return this.bGI;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a
    public final synchronized f Q(String str, long j2) {
        f e2;
        AppMethodBeat.i(234698);
        f S = f.S(str, j2);
        while (true) {
            e2 = e(S);
            if (e2 != null) {
                AppMethodBeat.o(234698);
            } else {
                wait();
            }
        }
        return e2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a
    public final synchronized f R(String str, long j2) {
        f e2;
        AppMethodBeat.i(234699);
        e2 = e(f.S(str, j2));
        AppMethodBeat.o(234699);
        return e2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a
    public final synchronized o a(String str, long j2, long j3, c cVar, long j4) {
        o a2;
        AppMethodBeat.i(234701);
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(this.bGF.containsKey(str));
        if (!this.mxJ.exists()) {
            bJQ();
            this.mxJ.mkdirs();
        }
        this.mxK.a(this, j4);
        a2 = f.a(this.mxJ, str, j2, j3, cVar, System.currentTimeMillis());
        AppMethodBeat.o(234701);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a
    public final synchronized void A(o oVar) {
        AppMethodBeat.i(234702);
        f B = f.B(oVar);
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(B != null);
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(this.bGF.containsKey(B.key));
        if (!oVar.exists()) {
            AppMethodBeat.o(234702);
        } else if (oVar.length() == 0) {
            oVar.delete();
            AppMethodBeat.o(234702);
        } else {
            f(B);
            notifyAll();
            AppMethodBeat.o(234702);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a
    public final synchronized void a(f fVar) {
        AppMethodBeat.i(234703);
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(fVar == this.bGF.remove(fVar.key));
        notifyAll();
        AppMethodBeat.o(234703);
    }

    /* access modifiers changed from: package-private */
    public final boolean f(f fVar) {
        AppMethodBeat.i(234704);
        TreeSet<f> treeSet = this.mxL.get(fVar.key);
        if (treeSet == null) {
            treeSet = new TreeSet<>();
            this.mxL.put(fVar.key, treeSet);
        }
        boolean add = treeSet.add(fVar);
        this.bGI += fVar.length;
        h(fVar);
        AppMethodBeat.o(234704);
        return add;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a
    public final synchronized void b(f fVar) {
        AppMethodBeat.i(234705);
        TreeSet<f> treeSet = this.mxL.get(fVar.key);
        this.bGI -= fVar.length;
        fVar.file.delete();
        if (treeSet == null || treeSet.isEmpty()) {
            this.mxL.remove(fVar.key);
        }
        g(fVar);
        AppMethodBeat.o(234705);
    }

    private void bJQ() {
        AppMethodBeat.i(234706);
        Iterator<Map.Entry<String, TreeSet<f>>> it = this.mxL.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<f> it2 = it.next().getValue().iterator();
            boolean z = true;
            while (it2.hasNext()) {
                f next = it2.next();
                if (!next.file.exists()) {
                    it2.remove();
                    if (next.bGq) {
                        this.bGI -= next.length;
                    }
                    g(next);
                } else {
                    z = false;
                }
            }
            if (z) {
                it.remove();
            }
        }
        AppMethodBeat.o(234706);
    }

    private void g(f fVar) {
        AppMethodBeat.i(234707);
        ArrayList<a.AbstractC0709a> arrayList = this.bGH.get(fVar.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).c(fVar);
            }
        }
        this.mxK.c(fVar);
        AppMethodBeat.o(234707);
    }

    private void h(f fVar) {
        AppMethodBeat.i(234708);
        ArrayList<a.AbstractC0709a> arrayList = this.bGH.get(fVar.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).a(this, fVar);
            }
        }
        this.mxK.a(this, fVar);
        AppMethodBeat.o(234708);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a
    public final synchronized long aaY(String str) {
        long j2;
        f first;
        AppMethodBeat.i(234709);
        NavigableSet<f> bu = bu(str);
        if (bu == null || (first = bu.first()) == null || first.kNt < 0) {
            j2 = -1;
            AppMethodBeat.o(234709);
        } else {
            j2 = first.kNt;
            AppMethodBeat.o(234709);
        }
        return j2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a
    public final synchronized c aaZ(String str) {
        c cVar;
        f first;
        AppMethodBeat.i(234710);
        NavigableSet<f> bu = bu(str);
        if (bu == null || (first = bu.first()) == null || first.kNt < 0) {
            cVar = c.myu;
            AppMethodBeat.o(234710);
        } else {
            cVar = first.mxv;
            AppMethodBeat.o(234710);
        }
        return cVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a
    public final synchronized boolean isCached(String str) {
        boolean z;
        f first;
        long j2 = 0;
        synchronized (this) {
            AppMethodBeat.i(234711);
            NavigableSet<f> bu = bu(str);
            if (!(bu == null || (first = bu.first()) == null || first.kNt < 0)) {
                long j3 = first.kNt;
                Iterator<f> it = bu.iterator();
                while (true) {
                    if (it.hasNext()) {
                        f next = it.next();
                        if (!next.bGq) {
                            AppMethodBeat.o(234711);
                            z = false;
                            break;
                        }
                        j2 += next.length;
                    } else if (j2 >= j3) {
                        z = true;
                        AppMethodBeat.o(234711);
                    }
                }
            }
            AppMethodBeat.o(234711);
            z = false;
        }
        return z;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a
    public final synchronized long aba(String str) {
        long j2;
        long j3 = 0;
        synchronized (this) {
            AppMethodBeat.i(234712);
            NavigableSet<f> bu = bu(str);
            if (bu != null) {
                f first = bu.first();
                if (first != null && first.bGq && first.kNt >= 0 && first.position != 0) {
                    AppMethodBeat.o(234712);
                    j2 = 0;
                } else if (first != null && first.kNt >= 0) {
                    Iterator<f> it = bu.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        f next = it.next();
                        if (!next.bGq) {
                            AppMethodBeat.o(234712);
                            j2 = j3;
                            break;
                        }
                        j3 += next.length;
                    }
                }
            }
            j2 = j3;
            AppMethodBeat.o(234712);
        }
        return j2;
    }

    private synchronized f e(f fVar) {
        String str;
        TreeSet<f> treeSet;
        f T;
        AppMethodBeat.i(234700);
        while (true) {
            str = fVar.key;
            long j2 = fVar.position;
            treeSet = this.mxL.get(str);
            if (treeSet == null) {
                T = f.T(str, fVar.position);
                break;
            }
            f floor = treeSet.floor(fVar);
            if (floor == null || floor.position > j2 || j2 >= floor.position + floor.length) {
                f ceiling = treeSet.ceiling(fVar);
            } else if (floor.file.exists()) {
                T = floor;
                break;
            } else {
                bJQ();
            }
        }
        f ceiling2 = treeSet.ceiling(fVar);
        if (ceiling2 == null) {
            T = f.T(str, fVar.position);
        } else {
            T = f.p(str, fVar.position, ceiling2.position - fVar.position);
        }
        if (T.bGq) {
            AppMethodBeat.o(234700);
        } else if (!this.bGF.containsKey(fVar.key)) {
            this.bGF.put(fVar.key, T);
            AppMethodBeat.o(234700);
        } else {
            T = null;
            AppMethodBeat.o(234700);
        }
        return T;
    }
}
