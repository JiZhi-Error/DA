package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.bumptech.glide.e.e;
import com.bumptech.glide.e.f;
import com.bumptech.glide.g.k;
import com.bumptech.glide.manager.c;
import com.bumptech.glide.manager.d;
import com.bumptech.glide.manager.h;
import com.bumptech.glide.manager.i;
import com.bumptech.glide.manager.m;
import com.bumptech.glide.manager.n;
import com.bumptech.glide.manager.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class j implements i {
    private static final f aDb = ((f) ((f) f.b(com.bumptech.glide.load.b.j.aHb).b(g.LOW)).pX());
    private static final f aDo;
    private static final f aDp;
    protected final c aCg;
    final h aDq;
    private final n aDr;
    private final m aDs;
    private final o aDt;
    private final Runnable aDu;
    private final Handler aDv;
    private final c aDw;
    final CopyOnWriteArrayList<e<Object>> aDx;
    private f aDy;
    protected final Context context;

    static {
        AppMethodBeat.i(76832);
        f x = f.x(Bitmap.class);
        x.aHY = true;
        aDo = x;
        f x2 = f.x(com.bumptech.glide.load.d.e.c.class);
        x2.aHY = true;
        aDp = x2;
        AppMethodBeat.o(76832);
    }

    public j(c cVar, h hVar, m mVar, Context context2) {
        this(cVar, hVar, mVar, new n(), cVar.aCq, context2);
        AppMethodBeat.i(76821);
        AppMethodBeat.o(76821);
    }

    private j(c cVar, h hVar, m mVar, n nVar, d dVar, Context context2) {
        AppMethodBeat.i(76822);
        this.aDt = new o();
        this.aDu = new Runnable() {
            /* class com.bumptech.glide.j.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(76818);
                j.this.aDq.a(j.this);
                AppMethodBeat.o(76818);
            }
        };
        this.aDv = new Handler(Looper.getMainLooper());
        this.aCg = cVar;
        this.aDq = hVar;
        this.aDs = mVar;
        this.aDr = nVar;
        this.context = context2;
        this.aDw = dVar.a(context2.getApplicationContext(), new a(nVar));
        if (k.qx()) {
            this.aDv.post(this.aDu);
        } else {
            hVar.a(this);
        }
        hVar.a(this.aDw);
        this.aDx = new CopyOnWriteArrayList<>(cVar.aCm.aCD);
        a(cVar.aCm.aCz);
        synchronized (cVar.aCr) {
            try {
                if (cVar.aCr.contains(this)) {
                    IllegalStateException illegalStateException = new IllegalStateException("Cannot register already registered manager");
                    AppMethodBeat.o(76822);
                    throw illegalStateException;
                }
                cVar.aCr.add(this);
            } finally {
                AppMethodBeat.o(76822);
            }
        }
    }

    private synchronized void a(f fVar) {
        AppMethodBeat.i(204450);
        f fVar2 = (f) fVar.clone();
        if (!fVar2.aHY || fVar2.aNg) {
            fVar2.aNg = true;
            fVar2.aHY = true;
            this.aDy = fVar2;
            AppMethodBeat.o(204450);
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
            AppMethodBeat.o(204450);
            throw illegalStateException;
        }
    }

    private synchronized void nR() {
        AppMethodBeat.i(204451);
        n nVar = this.aDr;
        nVar.isPaused = true;
        for (com.bumptech.glide.e.c cVar : k.c(nVar.aMG)) {
            if (cVar.isRunning()) {
                cVar.clear();
                nVar.aMH.add(cVar);
            }
        }
        AppMethodBeat.o(204451);
    }

    private synchronized void nS() {
        AppMethodBeat.i(204452);
        n nVar = this.aDr;
        nVar.isPaused = false;
        for (com.bumptech.glide.e.c cVar : k.c(nVar.aMG)) {
            if (!cVar.isComplete() && !cVar.isRunning()) {
                cVar.begin();
            }
        }
        nVar.aMH.clear();
        AppMethodBeat.o(204452);
    }

    @Override // com.bumptech.glide.manager.i
    public final synchronized void onStart() {
        AppMethodBeat.i(76823);
        nS();
        this.aDt.onStart();
        AppMethodBeat.o(76823);
    }

    @Override // com.bumptech.glide.manager.i
    public final synchronized void onStop() {
        AppMethodBeat.i(76824);
        nR();
        this.aDt.onStop();
        AppMethodBeat.o(76824);
    }

    @Override // com.bumptech.glide.manager.i
    public final synchronized void onDestroy() {
        AppMethodBeat.i(76825);
        this.aDt.onDestroy();
        for (com.bumptech.glide.e.a.e<?> eVar : k.c(this.aDt.aML)) {
            c(eVar);
        }
        this.aDt.aML.clear();
        n nVar = this.aDr;
        for (com.bumptech.glide.e.c cVar : k.c(nVar.aMG)) {
            nVar.a(cVar, false);
        }
        nVar.aMH.clear();
        this.aDq.b(this);
        this.aDq.b(this.aDw);
        this.aDv.removeCallbacks(this.aDu);
        c cVar2 = this.aCg;
        synchronized (cVar2.aCr) {
            try {
                if (!cVar2.aCr.contains(this)) {
                    IllegalStateException illegalStateException = new IllegalStateException("Cannot unregister not yet registered manager");
                    AppMethodBeat.o(76825);
                    throw illegalStateException;
                }
                cVar2.aCr.remove(this);
            } finally {
                AppMethodBeat.o(76825);
            }
        }
    }

    public final i<Bitmap> nT() {
        AppMethodBeat.i(76826);
        i<Bitmap> a2 = new i(this.aCg, this, Bitmap.class, this.context).a(aDo);
        AppMethodBeat.o(76826);
        return a2;
    }

    public final synchronized void c(com.bumptech.glide.e.a.e<?> eVar) {
        AppMethodBeat.i(76827);
        if (eVar == null) {
            AppMethodBeat.o(76827);
        } else {
            if (!d(eVar) && !this.aCg.a(eVar) && eVar.qn() != null) {
                com.bumptech.glide.e.c qn = eVar.qn();
                eVar.h(null);
                qn.clear();
            }
            AppMethodBeat.o(76827);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean d(com.bumptech.glide.e.a.e<?> eVar) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(76829);
            com.bumptech.glide.e.c qn = eVar.qn();
            if (qn == null) {
                AppMethodBeat.o(76829);
            } else if (this.aDr.a(qn, true)) {
                this.aDt.aML.remove(eVar);
                eVar.h(null);
                AppMethodBeat.o(76829);
            } else {
                z = false;
                AppMethodBeat.o(76829);
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(com.bumptech.glide.e.a.e<?> eVar, com.bumptech.glide.e.c cVar) {
        AppMethodBeat.i(204453);
        this.aDt.aML.add(eVar);
        n nVar = this.aDr;
        nVar.aMG.add(cVar);
        if (!nVar.isPaused) {
            cVar.begin();
            AppMethodBeat.o(204453);
        } else {
            cVar.clear();
            Log.isLoggable("RequestTracker", 2);
            nVar.aMH.add(cVar);
            AppMethodBeat.o(204453);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized f nU() {
        return this.aDy;
    }

    /* access modifiers changed from: package-private */
    public final <T> k<?, T> k(Class<T> cls) {
        AppMethodBeat.i(76830);
        e eVar = this.aCg.aCm;
        Cloneable cloneable = (k) eVar.aCt.get(cls);
        if (cloneable == null) {
            for (Map.Entry<Class<?>, k<?, ?>> entry : eVar.aCt.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    cloneable = (k) entry.getValue();
                } else {
                    cloneable = cloneable;
                }
            }
            cloneable = (k<?, T>) cloneable;
        }
        if (cloneable == null) {
            cloneable = (k<?, T>) e.aCF;
        }
        AppMethodBeat.o(76830);
        return (k<?, T>) cloneable;
    }

    public final synchronized String toString() {
        String str;
        AppMethodBeat.i(76831);
        str = super.toString() + "{tracker=" + this.aDr + ", treeNode=" + this.aDs + "}";
        AppMethodBeat.o(76831);
        return str;
    }

    class a implements c.a {
        private final n aDr;

        a(n nVar) {
            this.aDr = nVar;
        }

        @Override // com.bumptech.glide.manager.c.a
        public final void aE(boolean z) {
            AppMethodBeat.i(76820);
            if (z) {
                synchronized (j.this) {
                    try {
                        n nVar = this.aDr;
                        for (com.bumptech.glide.e.c cVar : k.c(nVar.aMG)) {
                            if (!cVar.isComplete() && !cVar.qc()) {
                                cVar.clear();
                                if (!nVar.isPaused) {
                                    cVar.begin();
                                } else {
                                    nVar.aMH.add(cVar);
                                }
                            }
                        }
                    } finally {
                        AppMethodBeat.o(76820);
                    }
                }
                return;
            }
            AppMethodBeat.o(76820);
        }
    }
}
