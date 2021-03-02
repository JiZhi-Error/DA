package com.tencent.mm.kernel.a.b;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.f;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.h.h;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import junit.framework.Assert;

public final class e<T> {
    private static e hsO = null;
    private Queue<c> hsH = new LinkedList();
    private int hsI;
    private volatile a hsJ;
    private volatile boolean hsK = false;
    private final byte[] hsL = new byte[0];
    private volatile com.tencent.mm.vending.c.a<Void, f.a> hsM;
    private volatile c<T> hsN;

    public interface a {
        void aAM();

        void aAP();
    }

    public static class c {
        public HandlerThread dli;
        Handler handler;
        h hsS;
    }

    static /* synthetic */ void a(e eVar, c cVar) {
        AppMethodBeat.i(158377);
        eVar.b(cVar);
        AppMethodBeat.o(158377);
    }

    static /* synthetic */ void a(e eVar, c cVar, f.a aVar) {
        AppMethodBeat.i(158378);
        eVar.a(cVar, aVar);
        AppMethodBeat.o(158378);
    }

    static /* synthetic */ void c(e eVar) {
        AppMethodBeat.i(158379);
        eVar.active();
        AppMethodBeat.o(158379);
    }

    public static class b implements a {
        private final byte[] mLock = {0};

        public b() {
            AppMethodBeat.i(158360);
            AppMethodBeat.o(158360);
        }

        @Override // com.tencent.mm.kernel.a.b.e.a
        public final void aAM() {
            AppMethodBeat.i(158361);
            try {
                synchronized (this.mLock) {
                    try {
                        if (this.mLock[0] == 0) {
                            j.i("MMSkeleton.Parallels", "Waiting for lock(%s)", this.mLock);
                            this.mLock.wait();
                        } else {
                            j.i("MMSkeleton.Parallels", "Not need wait for lock(%s)", this.mLock);
                        }
                    } finally {
                        AppMethodBeat.o(158361);
                    }
                }
            } catch (InterruptedException e2) {
                Log.printErrStackTrace("MMSkeleton.Parallels", e2, "", new Object[0]);
                AppMethodBeat.o(158361);
            }
        }

        @Override // com.tencent.mm.kernel.a.b.e.a
        public final void aAP() {
            AppMethodBeat.i(158362);
            synchronized (this.mLock) {
                try {
                    this.mLock[0] = 1;
                    this.mLock.notify();
                    j.i("MMSkeleton.Parallels", "Lock(%s) notified", this.mLock);
                } finally {
                    AppMethodBeat.o(158362);
                }
            }
        }
    }

    public static e aAK() {
        return hsO;
    }

    public static e aAL() {
        AppMethodBeat.i(158363);
        if (hsO == null) {
            hsO = new e();
        }
        e eVar = hsO;
        AppMethodBeat.o(158363);
        return eVar;
    }

    private e() {
        AppMethodBeat.i(158364);
        AppMethodBeat.o(158364);
    }

    public final synchronized void init(int i2) {
        AppMethodBeat.i(158365);
        for (int i3 = 0; i3 < i2; i3++) {
            Queue<c> queue = this.hsH;
            HandlerThread handlerThread = new HandlerThread("parallels-".concat(String.valueOf(i3)), -8);
            handlerThread.start();
            c cVar = new c();
            cVar.dli = handlerThread;
            queue.add(cVar);
        }
        this.hsI = i2;
        AppMethodBeat.o(158365);
    }

    public final synchronized void prepare() {
        AppMethodBeat.i(158366);
        for (int i2 = 0; i2 < this.hsI; i2++) {
            c cVar = (c) ((LinkedList) this.hsH).get(i2);
            Handler handler = new Handler(cVar.dli.getLooper());
            h hVar = new h(handler, cVar.dli.getName());
            cVar.handler = handler;
            cVar.hsS = hVar;
        }
        AppMethodBeat.o(158366);
    }

    public final boolean a(a aVar, com.tencent.mm.vending.c.a<Void, f.a> aVar2, c<T> cVar) {
        AppMethodBeat.i(158367);
        synchronized (this.hsL) {
            try {
                if (this.hsK) {
                    Log.w("MMSkeleton.Parallels", "Arrange parallels task failed. It's busy on working.");
                    Assert.assertTrue(false);
                    return false;
                }
                this.hsJ = aVar;
                this.hsM = aVar2;
                this.hsN = cVar;
                AppMethodBeat.o(158367);
                return true;
            } finally {
                AppMethodBeat.o(158367);
            }
        }
    }

    public final void a(a aVar, com.tencent.mm.vending.c.a<Void, f.a> aVar2, c<T> cVar, String str) {
        AppMethodBeat.i(158368);
        if (a(aVar, aVar2, cVar)) {
            cVar.prepare();
            start(str);
            aAM();
        }
        AppMethodBeat.o(158368);
    }

    public final void aAM() {
        AppMethodBeat.i(158369);
        this.hsJ.aAM();
        AppMethodBeat.o(158369);
    }

    public final void start(String str) {
        AppMethodBeat.i(158370);
        j.i("MMSkeleton.Parallels", "Start working. For %s", str);
        synchronized (this.hsL) {
            try {
                this.hsK = true;
            } catch (Throwable th) {
                AppMethodBeat.o(158370);
                throw th;
            }
        }
        active();
        AppMethodBeat.o(158370);
    }

    public final synchronized List<c> aAN() {
        LinkedList linkedList;
        AppMethodBeat.i(158371);
        linkedList = new LinkedList(this.hsH);
        AppMethodBeat.o(158371);
        return linkedList;
    }

    private synchronized c aAO() {
        c poll;
        AppMethodBeat.i(158372);
        poll = this.hsH.poll();
        AppMethodBeat.o(158372);
        return poll;
    }

    private synchronized boolean a(c cVar) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(158373);
            this.hsH.add(cVar);
            j.d("MMSkeleton.Parallels", "Parallels check threads idle. %s of %s", Integer.valueOf(this.hsH.size()), Integer.valueOf(this.hsI));
            if (this.hsH.size() == this.hsI) {
                AppMethodBeat.o(158373);
            } else {
                AppMethodBeat.o(158373);
                z = false;
            }
        }
        return z;
    }

    private void b(c cVar) {
        AppMethodBeat.i(158374);
        if (a(cVar)) {
            synchronized (this.hsL) {
                try {
                    if (this.hsK) {
                        j.i("MMSkeleton.Parallels", "Parallels notify done", new Object[0]);
                    }
                    this.hsK = false;
                    this.hsJ.aAP();
                } finally {
                    AppMethodBeat.o(158374);
                }
            }
            return;
        }
        AppMethodBeat.o(158374);
    }

    private void active() {
        AppMethodBeat.i(158375);
        while (true) {
            c aAO = aAO();
            if (aAO != null) {
                f.a<T> aAJ = this.hsN.aAJ();
                if (aAJ != null) {
                    a(aAO, aAJ);
                } else {
                    b(aAO);
                    AppMethodBeat.o(158375);
                    return;
                }
            } else {
                AppMethodBeat.o(158375);
                return;
            }
        }
    }

    private void a(final c cVar, final f.a<T> aVar) {
        AppMethodBeat.i(158376);
        cVar.hsS.arrange(new Runnable() {
            /* class com.tencent.mm.kernel.a.b.e.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(158359);
                f.a aVar = aVar;
                com.tencent.mm.vending.c.a aVar2 = e.this.hsM;
                if (!aVar.hsC) {
                    aVar.htd.hte.hin();
                    if (!aVar.hsC) {
                        aVar2.call(aVar);
                        Log.d("MMSkeleton.ParallelsDependencies", "consume call functional %s, node %s", aVar2, aVar);
                        aVar.hsC = true;
                    }
                    aVar.htd.hte.done();
                }
                e.this.hsN.a(aVar);
                f.a<T> aAJ = e.this.hsN.aAJ();
                if (aAJ == null) {
                    e.a(e.this, cVar);
                    AppMethodBeat.o(158359);
                    return;
                }
                e.a(e.this, cVar, aAJ);
                e.c(e.this);
                AppMethodBeat.o(158359);
            }
        });
        AppMethodBeat.o(158376);
    }
}
