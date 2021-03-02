package com.bumptech.glide.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.e.l;
import android.util.Log;
import com.bumptech.glide.e;
import com.bumptech.glide.e.a.d;
import com.bumptech.glide.e.b.c;
import com.bumptech.glide.g;
import com.bumptech.glide.g.a.a;
import com.bumptech.glide.g.a.b;
import com.bumptech.glide.g.f;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.b.q;
import com.bumptech.glide.load.b.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.Executor;

public final class h<R> implements d, c, g, a.c {
    private static final l.a<h<?>> aHW = com.bumptech.glide.g.a.a.a(150, new a.AbstractC0066a<h<?>>() {
        /* class com.bumptech.glide.e.h.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.bumptech.glide.g.a.a.AbstractC0066a
        public final /* synthetic */ h<?> oR() {
            AppMethodBeat.i(77656);
            h hVar = new h();
            AppMethodBeat.o(77656);
            return hVar;
        }
    });
    private static final boolean aNm = Log.isLoggable("Request", 2);
    private k aCi;
    private e aCm;
    private Class<R> aDd;
    private Object aDf;
    private List<e<R>> aDg;
    private v<R> aFJ;
    private g aGc;
    private final b aGi;
    private Drawable aMY;
    private int aNa;
    private int aNb;
    private Drawable aNd;
    private boolean aNl;
    private e<R> aNn;
    private d aNo;
    private a<?> aNp;
    private com.bumptech.glide.e.a.e<R> aNq;
    private c<? super R> aNr;
    private Executor aNs;
    private k.d aNt;
    private a aNu;
    private Drawable aNv;
    private RuntimeException aNw;
    private Context context;
    private int height;
    private long startTime;
    private final String tag;
    private int width;

    static {
        AppMethodBeat.i(77686);
        AppMethodBeat.o(77686);
    }

    /* access modifiers changed from: package-private */
    public enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED;

        public static a valueOf(String str) {
            AppMethodBeat.i(77658);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(77658);
            return aVar;
        }

        static {
            AppMethodBeat.i(77659);
            AppMethodBeat.o(77659);
        }
    }

    public static <R> h<R> a(Context context2, e eVar, Object obj, Class<R> cls, a<?> aVar, int i2, int i3, g gVar, com.bumptech.glide.e.a.e<R> eVar2, e<R> eVar3, List<e<R>> list, d dVar, k kVar, c<? super R> cVar, Executor executor) {
        AppMethodBeat.i(204489);
        h<R> hVar = (h<R>) aHW.acquire();
        if (hVar == null) {
            hVar = new h<>();
        }
        hVar.b(context2, eVar, obj, cls, aVar, i2, i3, gVar, eVar2, eVar3, list, dVar, kVar, cVar, executor);
        AppMethodBeat.o(204489);
        return hVar;
    }

    h() {
        String str;
        AppMethodBeat.i(77661);
        if (aNm) {
            str = String.valueOf(super.hashCode());
        } else {
            str = null;
        }
        this.tag = str;
        this.aGi = new b.a();
        AppMethodBeat.o(77661);
    }

    private synchronized void b(Context context2, e eVar, Object obj, Class<R> cls, a<?> aVar, int i2, int i3, g gVar, com.bumptech.glide.e.a.e<R> eVar2, e<R> eVar3, List<e<R>> list, d dVar, k kVar, c<? super R> cVar, Executor executor) {
        AppMethodBeat.i(204490);
        this.context = context2;
        this.aCm = eVar;
        this.aDf = obj;
        this.aDd = cls;
        this.aNp = aVar;
        this.aNb = i2;
        this.aNa = i3;
        this.aGc = gVar;
        this.aNq = eVar2;
        this.aNn = eVar3;
        this.aDg = list;
        this.aNo = dVar;
        this.aCi = kVar;
        this.aNr = cVar;
        this.aNs = executor;
        this.aNu = a.PENDING;
        if (this.aNw == null && eVar.aCE) {
            this.aNw = new RuntimeException("Glide request origin trace");
        }
        AppMethodBeat.o(204490);
    }

    @Override // com.bumptech.glide.g.a.a.c
    public final b oK() {
        return this.aGi;
    }

    @Override // com.bumptech.glide.e.c
    public final synchronized void recycle() {
        AppMethodBeat.i(77662);
        qg();
        this.context = null;
        this.aCm = null;
        this.aDf = null;
        this.aDd = null;
        this.aNp = null;
        this.aNb = -1;
        this.aNa = -1;
        this.aNq = null;
        this.aDg = null;
        this.aNn = null;
        this.aNo = null;
        this.aNr = null;
        this.aNt = null;
        this.aNv = null;
        this.aMY = null;
        this.aNd = null;
        this.width = -1;
        this.height = -1;
        this.aNw = null;
        aHW.release(this);
        AppMethodBeat.o(77662);
    }

    @Override // com.bumptech.glide.e.c
    public final synchronized void begin() {
        AppMethodBeat.i(77663);
        qg();
        this.aGi.qz();
        this.startTime = f.qt();
        if (this.aDf == null) {
            if (com.bumptech.glide.g.k.aT(this.aNb, this.aNa)) {
                this.width = this.aNb;
                this.height = this.aNa;
            }
            a(new q("Received null model"), qi() == null ? 5 : 3);
            AppMethodBeat.o(77663);
        } else if (this.aNu == a.RUNNING) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot restart a running request");
            AppMethodBeat.o(77663);
            throw illegalArgumentException;
        } else if (this.aNu == a.COMPLETE) {
            c(this.aFJ, com.bumptech.glide.load.a.MEMORY_CACHE);
            AppMethodBeat.o(77663);
        } else {
            this.aNu = a.WAITING_FOR_SIZE;
            if (com.bumptech.glide.g.k.aT(this.aNb, this.aNa)) {
                aS(this.aNb, this.aNa);
            } else {
                this.aNq.a(this);
            }
            if ((this.aNu == a.RUNNING || this.aNu == a.WAITING_FOR_SIZE) && qk()) {
                getPlaceholderDrawable();
            }
            if (aNm) {
                V("finished run method in " + f.p(this.startTime));
            }
            AppMethodBeat.o(77663);
        }
    }

    private void qg() {
        AppMethodBeat.i(77664);
        if (this.aNl) {
            IllegalStateException illegalStateException = new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
            AppMethodBeat.o(77664);
            throw illegalStateException;
        }
        AppMethodBeat.o(77664);
    }

    @Override // com.bumptech.glide.e.c
    public final synchronized void clear() {
        boolean z;
        AppMethodBeat.i(77665);
        qg();
        this.aGi.qz();
        if (this.aNu == a.CLEARED) {
            AppMethodBeat.o(77665);
        } else {
            qg();
            this.aGi.qz();
            if (this.aNt != null) {
                k.d dVar = this.aNt;
                synchronized (k.this) {
                    try {
                        dVar.aHu.c(dVar.aHv);
                    } catch (Throwable th) {
                        AppMethodBeat.o(77665);
                        throw th;
                    }
                }
                this.aNt = null;
            }
            if (this.aFJ != null) {
                f(this.aFJ);
            }
            if (this.aNo == null || this.aNo.d(this)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                getPlaceholderDrawable();
            }
            this.aNu = a.CLEARED;
            AppMethodBeat.o(77665);
        }
    }

    private void f(v<?> vVar) {
        AppMethodBeat.i(77667);
        k.b(vVar);
        this.aFJ = null;
        AppMethodBeat.o(77667);
    }

    @Override // com.bumptech.glide.e.c
    public final synchronized boolean isRunning() {
        return this.aNu == a.RUNNING || this.aNu == a.WAITING_FOR_SIZE;
    }

    @Override // com.bumptech.glide.e.c
    public final synchronized boolean isComplete() {
        return this.aNu == a.COMPLETE;
    }

    @Override // com.bumptech.glide.e.c
    public final synchronized boolean qb() {
        boolean isComplete;
        AppMethodBeat.i(77668);
        isComplete = isComplete();
        AppMethodBeat.o(77668);
        return isComplete;
    }

    @Override // com.bumptech.glide.e.c
    public final synchronized boolean qc() {
        return this.aNu == a.CLEARED;
    }

    @Override // com.bumptech.glide.e.c
    public final synchronized boolean isFailed() {
        return this.aNu == a.FAILED;
    }

    private Drawable getPlaceholderDrawable() {
        AppMethodBeat.i(77669);
        if (this.aMY == null) {
            this.aMY = this.aNp.aMY;
            if (this.aMY == null && this.aNp.aMZ > 0) {
                this.aMY = dp(this.aNp.aMZ);
            }
        }
        Drawable drawable = this.aMY;
        AppMethodBeat.o(77669);
        return drawable;
    }

    private Drawable qi() {
        AppMethodBeat.i(77670);
        if (this.aNd == null) {
            this.aNd = this.aNp.aNd;
            if (this.aNd == null && this.aNp.aNe > 0) {
                this.aNd = dp(this.aNp.aNe);
            }
        }
        Drawable drawable = this.aNd;
        AppMethodBeat.o(77670);
        return drawable;
    }

    private Drawable dp(int i2) {
        Resources.Theme theme;
        AppMethodBeat.i(77671);
        if (this.aNp.aNf != null) {
            theme = this.aNp.aNf;
        } else {
            theme = this.context.getTheme();
        }
        Drawable a2 = com.bumptech.glide.load.d.c.a.a(this.aCm, i2, theme);
        AppMethodBeat.o(77671);
        return a2;
    }

    private synchronized void qj() {
        AppMethodBeat.i(77672);
        if (!qk()) {
            AppMethodBeat.o(77672);
        } else {
            Drawable drawable = null;
            if (this.aDf == null) {
                drawable = qi();
            }
            if (drawable == null) {
                if (this.aNv == null) {
                    this.aNv = this.aNp.aMW;
                    if (this.aNv == null && this.aNp.aMX > 0) {
                        this.aNv = dp(this.aNp.aMX);
                    }
                }
                drawable = this.aNv;
            }
            if (drawable == null) {
                getPlaceholderDrawable();
            }
            AppMethodBeat.o(77672);
        }
    }

    @Override // com.bumptech.glide.e.a.d
    public final synchronized void aS(int i2, int i3) {
        AppMethodBeat.i(77673);
        this.aGi.qz();
        if (aNm) {
            V("Got onSizeReady in " + f.p(this.startTime));
        }
        if (this.aNu != a.WAITING_FOR_SIZE) {
            AppMethodBeat.o(77673);
        } else {
            this.aNu = a.RUNNING;
            float f2 = this.aNp.aMV;
            this.width = g(i2, f2);
            this.height = g(i3, f2);
            if (aNm) {
                V("finished setup for calling load in " + f.p(this.startTime));
            }
            this.aNt = this.aCi.a(this.aCm, this.aDf, this.aNp.aFT, this.width, this.height, this.aNp.aFX, this.aDd, this.aGc, this.aNp.aGd, this.aNp.aFZ, this.aNp.aGe, this.aNp.aGf, this.aNp.aFV, this.aNp.aFI, this.aNp.aNh, this.aNp.aHC, this.aNp.aGr, this, this.aNs);
            if (this.aNu != a.RUNNING) {
                this.aNt = null;
            }
            if (aNm) {
                V("finished onSizeReady in " + f.p(this.startTime));
            }
            AppMethodBeat.o(77673);
        }
    }

    private static int g(int i2, float f2) {
        AppMethodBeat.i(77674);
        if (i2 == Integer.MIN_VALUE) {
            AppMethodBeat.o(77674);
            return i2;
        }
        int round = Math.round(((float) i2) * f2);
        AppMethodBeat.o(77674);
        return round;
    }

    private boolean qk() {
        AppMethodBeat.i(77676);
        if (this.aNo == null || this.aNo.c(this)) {
            AppMethodBeat.o(77676);
            return true;
        }
        AppMethodBeat.o(77676);
        return false;
    }

    private boolean ql() {
        AppMethodBeat.i(77677);
        if (this.aNo == null || !this.aNo.qd()) {
            AppMethodBeat.o(77677);
            return true;
        }
        AppMethodBeat.o(77677);
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.bumptech.glide.e.h<R> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e.g
    public final synchronized void c(v<?> vVar, com.bumptech.glide.load.a aVar) {
        boolean z;
        AppMethodBeat.i(77680);
        this.aGi.qz();
        this.aNt = null;
        if (vVar == null) {
            a(new q("Expected to receive a Resource<R> with an object of " + this.aDd + " inside, but instead got null."));
            AppMethodBeat.o(77680);
        } else {
            Object obj = vVar.get();
            if (obj == null || !this.aDd.isAssignableFrom(obj.getClass())) {
                f(vVar);
                a(new q("Expected to receive an object of " + this.aDd + " but instead got " + (obj != null ? obj.getClass() : "") + "{" + obj + "} inside Resource{" + vVar + "}." + (obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.")));
                AppMethodBeat.o(77680);
            } else {
                if (this.aNo == null || this.aNo.b(this)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    f(vVar);
                    this.aNu = a.COMPLETE;
                    AppMethodBeat.o(77680);
                } else {
                    a(vVar, obj, aVar);
                    AppMethodBeat.o(77680);
                }
            }
        }
    }

    private synchronized void a(v<R> vVar, R r, com.bumptech.glide.load.a aVar) {
        boolean z;
        AppMethodBeat.i(77681);
        ql();
        this.aNu = a.COMPLETE;
        this.aFJ = vVar;
        if (this.aCm.aCy <= 3) {
            new StringBuilder("Finished loading ").append(r.getClass().getSimpleName()).append(" from ").append(aVar).append(" for ").append(this.aDf).append(" with size [").append(this.width).append("x").append(this.height).append("] in ").append(f.p(this.startTime)).append(" ms");
        }
        this.aNl = true;
        try {
            if (this.aDg != null) {
                z = false;
                for (e<R> eVar : this.aDg) {
                    z |= eVar.qf();
                }
            } else {
                z = false;
            }
            if (!(this.aNn != null && this.aNn.qf()) && !z) {
                this.aNr.qp();
                this.aNq.aa(r);
            }
            this.aNl = false;
            if (this.aNo != null) {
                this.aNo.f(this);
            }
            AppMethodBeat.o(77681);
        } catch (Throwable th) {
            this.aNl = false;
            AppMethodBeat.o(77681);
            throw th;
        }
    }

    @Override // com.bumptech.glide.e.g
    public final synchronized void a(q qVar) {
        AppMethodBeat.i(185718);
        a(qVar, 5);
        AppMethodBeat.o(185718);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008a A[Catch:{ all -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(com.bumptech.glide.load.b.q r6, int r7) {
        /*
        // Method dump skipped, instructions count: 177
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.e.h.a(com.bumptech.glide.load.b.q, int):void");
    }

    @Override // com.bumptech.glide.e.c
    public final synchronized boolean a(c cVar) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(77684);
            if (cVar instanceof h) {
                h<?> hVar = (h) cVar;
                synchronized (hVar) {
                    try {
                        if (this.aNb == hVar.aNb && this.aNa == hVar.aNa && com.bumptech.glide.g.k.i(this.aDf, hVar.aDf) && this.aDd.equals(hVar.aDd) && this.aNp.equals(hVar.aNp) && this.aGc == hVar.aGc && a(hVar)) {
                            z = true;
                        }
                    } finally {
                        AppMethodBeat.o(77684);
                    }
                }
            } else {
                AppMethodBeat.o(77684);
            }
        }
        return z;
    }

    private synchronized boolean a(h<?> hVar) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(204491);
            synchronized (hVar) {
                try {
                    if ((this.aDg == null ? 0 : this.aDg.size()) == (hVar.aDg == null ? 0 : hVar.aDg.size())) {
                        z = true;
                    }
                } finally {
                    AppMethodBeat.o(204491);
                }
            }
        }
        return z;
    }

    private void V(String str) {
        AppMethodBeat.i(77685);
        new StringBuilder().append(str).append(" this: ").append(this.tag);
        AppMethodBeat.o(77685);
    }
}
