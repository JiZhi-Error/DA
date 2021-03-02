package com.google.android.exoplayer2.h.a;

import android.os.ConditionVariable;
import com.google.android.exoplayer2.h.a.a;
import com.google.android.exoplayer2.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NavigableSet;
import java.util.TreeSet;

public final class l implements a {
    private final f bGE;
    private final HashMap<String, g> bGF;
    final j bGG;
    private final HashMap<String, ArrayList<a.b>> bGH;
    private long bGI;
    a.C0112a bGJ;
    final File cacheDir;

    @Override // com.google.android.exoplayer2.h.a.a
    public final /* synthetic */ g e(String str, long j2) {
        AppMethodBeat.i(93026);
        m i2 = i(str, j2);
        AppMethodBeat.o(93026);
        return i2;
    }

    @Override // com.google.android.exoplayer2.h.a.a
    public final /* synthetic */ g f(String str, long j2) {
        AppMethodBeat.i(93025);
        m j3 = j(str, j2);
        AppMethodBeat.o(93025);
        return j3;
    }

    public l(File file, f fVar) {
        this(file, fVar, (byte) 0);
    }

    private l(File file, f fVar, byte b2) {
        this(file, fVar, new j(file));
        AppMethodBeat.i(93006);
        AppMethodBeat.o(93006);
    }

    private l(File file, f fVar, j jVar) {
        AppMethodBeat.i(93007);
        this.bGI = 0;
        this.cacheDir = file;
        this.bGE = fVar;
        this.bGF = new HashMap<>();
        this.bGG = jVar;
        this.bGH = new HashMap<>();
        final ConditionVariable conditionVariable = new ConditionVariable();
        new Thread("SimpleCache.initialize()") {
            /* class com.google.android.exoplayer2.h.a.l.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(93005);
                synchronized (l.this) {
                    try {
                        conditionVariable.open();
                        try {
                            l lVar = l.this;
                            if (!lVar.cacheDir.exists()) {
                                lVar.cacheDir.mkdirs();
                            } else {
                                j jVar = lVar.bGG;
                                com.google.android.exoplayer2.i.a.checkState(!jVar.bGB);
                                if (!jVar.wW()) {
                                    b bVar = jVar.bGx;
                                    bVar.bGP.delete();
                                    bVar.bGQ.delete();
                                    jVar.bGv.clear();
                                    jVar.bGw.clear();
                                }
                                File[] listFiles = lVar.cacheDir.listFiles();
                                if (listFiles != null) {
                                    for (File file : listFiles) {
                                        if (!file.getName().equals("cached_content_index.exi")) {
                                            m a2 = file.length() > 0 ? m.a(file, lVar.bGG) : null;
                                            if (a2 != null) {
                                                lVar.a(a2);
                                            } else {
                                                file.delete();
                                            }
                                        }
                                    }
                                    lVar.bGG.wV();
                                    lVar.bGG.wU();
                                }
                            }
                        } catch (a.C0112a e2) {
                            l.this.bGJ = e2;
                        }
                    } finally {
                        AppMethodBeat.o(93005);
                    }
                }
            }
        }.start();
        conditionVariable.block();
        AppMethodBeat.o(93007);
    }

    @Override // com.google.android.exoplayer2.h.a.a
    public final synchronized NavigableSet<g> a(String str, a.b bVar) {
        NavigableSet<g> bu;
        AppMethodBeat.i(93008);
        ArrayList<a.b> arrayList = this.bGH.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.bGH.put(str, arrayList);
        }
        arrayList.add(bVar);
        bu = bu(str);
        AppMethodBeat.o(93008);
        return bu;
    }

    private synchronized NavigableSet<g> bu(String str) {
        TreeSet treeSet;
        AppMethodBeat.i(93009);
        i br = this.bGG.br(str);
        if (br == null || br.bGu.isEmpty()) {
            treeSet = null;
            AppMethodBeat.o(93009);
        } else {
            treeSet = new TreeSet((Collection) br.bGu);
            AppMethodBeat.o(93009);
        }
        return treeSet;
    }

    @Override // com.google.android.exoplayer2.h.a.a
    public final synchronized long wN() {
        return this.bGI;
    }

    private synchronized m i(String str, long j2) {
        m j3;
        AppMethodBeat.i(93010);
        while (true) {
            j3 = j(str, j2);
            if (j3 != null) {
                AppMethodBeat.o(93010);
            } else {
                wait();
            }
        }
        return j3;
    }

    private synchronized m j(String str, long j2) {
        m am;
        m mVar;
        AppMethodBeat.i(93011);
        if (this.bGJ != null) {
            a.C0112a aVar = this.bGJ;
            AppMethodBeat.o(93011);
            throw aVar;
        }
        i br = this.bGG.br(str);
        if (br != null) {
            while (true) {
                am = br.am(j2);
                if (!am.bGq || am.file.exists()) {
                    break;
                }
                wX();
            }
        } else {
            am = m.l(str, j2);
        }
        if (am.bGq) {
            i br2 = this.bGG.br(str);
            com.google.android.exoplayer2.i.a.checkState(br2.bGu.remove(am));
            int i2 = br2.id;
            com.google.android.exoplayer2.i.a.checkState(am.bGq);
            long currentTimeMillis = System.currentTimeMillis();
            mVar = new m(am.key, am.position, am.length, currentTimeMillis, m.a(am.file.getParentFile(), i2, am.position, currentTimeMillis));
            if (!am.file.renameTo(mVar.file)) {
                a.C0112a aVar2 = new a.C0112a("Renaming of " + am.file + " to " + mVar.file + " failed.");
                AppMethodBeat.o(93011);
                throw aVar2;
            }
            br2.bGu.add(mVar);
            a(am, mVar);
            AppMethodBeat.o(93011);
        } else if (!this.bGF.containsKey(str)) {
            this.bGF.put(str, am);
            AppMethodBeat.o(93011);
            mVar = am;
        } else {
            mVar = null;
            AppMethodBeat.o(93011);
        }
        return mVar;
    }

    @Override // com.google.android.exoplayer2.h.a.a
    public final synchronized File e(String str, long j2, long j3) {
        File a2;
        AppMethodBeat.i(93012);
        com.google.android.exoplayer2.i.a.checkState(this.bGF.containsKey(str));
        if (!this.cacheDir.exists()) {
            wX();
            this.cacheDir.mkdirs();
        }
        this.bGE.a(this, j3);
        a2 = m.a(this.cacheDir, this.bGG.bs(str), j2, System.currentTimeMillis());
        AppMethodBeat.o(93012);
        return a2;
    }

    @Override // com.google.android.exoplayer2.h.a.a
    public final synchronized void w(File file) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(93013);
            m a2 = m.a(file, this.bGG);
            com.google.android.exoplayer2.i.a.checkState(a2 != null);
            com.google.android.exoplayer2.i.a.checkState(this.bGF.containsKey(a2.key));
            if (!file.exists()) {
                AppMethodBeat.o(93013);
            } else if (file.length() == 0) {
                file.delete();
                AppMethodBeat.o(93013);
            } else {
                Long valueOf = Long.valueOf(bp(a2.key));
                if (valueOf.longValue() != -1) {
                    if (a2.position + a2.length > valueOf.longValue()) {
                        z = false;
                    }
                    com.google.android.exoplayer2.i.a.checkState(z);
                }
                a(a2);
                this.bGG.wU();
                notifyAll();
                AppMethodBeat.o(93013);
            }
        }
    }

    @Override // com.google.android.exoplayer2.h.a.a
    public final synchronized void a(g gVar) {
        AppMethodBeat.i(93014);
        com.google.android.exoplayer2.i.a.checkState(gVar == this.bGF.remove(gVar.key));
        notifyAll();
        AppMethodBeat.o(93014);
    }

    /* access modifiers changed from: package-private */
    public final void a(m mVar) {
        AppMethodBeat.i(93015);
        this.bGG.bq(mVar.key).a(mVar);
        this.bGI += mVar.length;
        b(mVar);
        AppMethodBeat.o(93015);
    }

    private void a(g gVar, boolean z) {
        boolean z2;
        AppMethodBeat.i(93016);
        i br = this.bGG.br(gVar.key);
        if (br != null) {
            if (br.bGu.remove(gVar)) {
                gVar.file.delete();
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.bGI -= gVar.length;
                if (z) {
                    try {
                        if (br.bGu.isEmpty()) {
                            this.bGG.bt(br.key);
                            this.bGG.wU();
                        }
                    } catch (Throwable th) {
                        e(gVar);
                        AppMethodBeat.o(93016);
                        throw th;
                    }
                }
                e(gVar);
                AppMethodBeat.o(93016);
                return;
            }
        }
        AppMethodBeat.o(93016);
    }

    @Override // com.google.android.exoplayer2.h.a.a
    public final synchronized void b(g gVar) {
        AppMethodBeat.i(93017);
        a(gVar, true);
        AppMethodBeat.o(93017);
    }

    private void wX() {
        AppMethodBeat.i(93018);
        LinkedList linkedList = new LinkedList();
        for (i iVar : this.bGG.bGv.values()) {
            Iterator<m> it = iVar.bGu.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (!next.file.exists()) {
                    linkedList.add(next);
                }
            }
        }
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            a((g) it2.next(), false);
        }
        this.bGG.wV();
        this.bGG.wU();
        AppMethodBeat.o(93018);
    }

    private void e(g gVar) {
        AppMethodBeat.i(93019);
        ArrayList<a.b> arrayList = this.bGH.get(gVar.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).c(gVar);
            }
        }
        this.bGE.c(gVar);
        AppMethodBeat.o(93019);
    }

    private void b(m mVar) {
        AppMethodBeat.i(93020);
        ArrayList<a.b> arrayList = this.bGH.get(mVar.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).a(this, mVar);
            }
        }
        this.bGE.a(this, mVar);
        AppMethodBeat.o(93020);
    }

    private void a(m mVar, g gVar) {
        AppMethodBeat.i(93021);
        ArrayList<a.b> arrayList = this.bGH.get(mVar.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).a(this, mVar, gVar);
            }
        }
        this.bGE.a(this, mVar, gVar);
        AppMethodBeat.o(93021);
    }

    @Override // com.google.android.exoplayer2.h.a.a
    public final synchronized long f(String str, long j2, long j3) {
        long j4;
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(93022);
            i br = this.bGG.br(str);
            if (br != null) {
                m am = br.am(j2);
                if (!am.bGq) {
                    z = true;
                }
                if (z) {
                    j4 = -Math.min(am.wS() ? MAlarmHandler.NEXT_FIRE_INTERVAL : am.length, j3);
                    AppMethodBeat.o(93022);
                } else {
                    long j5 = j2 + j3;
                    long j6 = am.position + am.length;
                    if (j6 < j5) {
                        Iterator<m> it = br.bGu.tailSet(am, false).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            m next = it.next();
                            if (next.position > j6) {
                                break;
                            }
                            j6 = Math.max(j6, next.length + next.position);
                            if (j6 >= j5) {
                                break;
                            }
                        }
                        j6 = j6;
                    }
                    j4 = Math.min(j6 - j2, j3);
                    AppMethodBeat.o(93022);
                }
            } else {
                j4 = -j3;
                AppMethodBeat.o(93022);
            }
        }
        return j4;
    }

    @Override // com.google.android.exoplayer2.h.a.a
    public final synchronized void g(String str, long j2) {
        AppMethodBeat.i(93023);
        j jVar = this.bGG;
        i br = jVar.br(str);
        if (br == null) {
            jVar.h(str, j2);
        } else if (br.length != j2) {
            br.length = j2;
            jVar.bGB = true;
        }
        this.bGG.wU();
        AppMethodBeat.o(93023);
    }

    @Override // com.google.android.exoplayer2.h.a.a
    public final synchronized long bp(String str) {
        long j2;
        AppMethodBeat.i(93024);
        i br = this.bGG.br(str);
        if (br == null) {
            j2 = -1;
            AppMethodBeat.o(93024);
        } else {
            j2 = br.length;
            AppMethodBeat.o(93024);
        }
        return j2;
    }
}
