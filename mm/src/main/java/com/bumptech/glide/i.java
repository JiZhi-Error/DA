package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.e.a;
import com.bumptech.glide.e.b;
import com.bumptech.glide.e.c;
import com.bumptech.glide.e.d;
import com.bumptech.glide.e.e;
import com.bumptech.glide.e.f;
import com.bumptech.glide.e.h;
import com.bumptech.glide.g.k;
import com.bumptech.glide.load.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class i<TranscodeType> extends a<i<TranscodeType>> implements Cloneable {
    protected static final f aDb = ((f) ((f) ((f) new f().a(j.aHb)).b(g.LOW)).pX());
    private final c aCg;
    private final e aCm;
    private final j aDc;
    private final Class<TranscodeType> aDd;
    private k<?, ? super TranscodeType> aDe;
    private Object aDf;
    private List<e<TranscodeType>> aDg;
    private i<TranscodeType> aDh;
    private i<TranscodeType> aDi;
    private Float aDj;
    private boolean aDk = true;
    private boolean aDl;
    private boolean aDm;
    private final Context context;

    @Override // com.bumptech.glide.e.a
    public final /* synthetic */ a b(a aVar) {
        AppMethodBeat.i(204448);
        i<TranscodeType> a2 = a(aVar);
        AppMethodBeat.o(204448);
        return a2;
    }

    @Override // com.bumptech.glide.e.a, java.lang.Object
    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(76816);
        i<TranscodeType> nP = nP();
        AppMethodBeat.o(76816);
        return nP;
    }

    @Override // com.bumptech.glide.e.a
    public final /* synthetic */ a nQ() {
        AppMethodBeat.i(204449);
        i<TranscodeType> nP = nP();
        AppMethodBeat.o(204449);
        return nP;
    }

    static {
        AppMethodBeat.i(76817);
        AppMethodBeat.o(76817);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.util.List<com.bumptech.glide.e.e<TranscodeType>> */
    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"CheckResult"})
    protected i(c cVar, j jVar, Class<TranscodeType> cls, Context context2) {
        AppMethodBeat.i(76807);
        this.aCg = cVar;
        this.aDc = jVar;
        this.aDd = cls;
        this.context = context2;
        this.aDe = jVar.k(cls);
        this.aCm = cVar.aCm;
        for (e<Object> eVar : jVar.aDx) {
            if (eVar != null) {
                if (this.aDg == null) {
                    this.aDg = new ArrayList();
                }
                this.aDg.add(eVar);
            }
        }
        a(jVar.nU());
        AppMethodBeat.o(76807);
    }

    private i<TranscodeType> nP() {
        AppMethodBeat.i(76810);
        i<TranscodeType> iVar = (i) super.clone();
        iVar.aDe = iVar.aDe.clone();
        AppMethodBeat.o(76810);
        return iVar;
    }

    public final <Y extends com.bumptech.glide.e.a.e<TranscodeType>> Y b(Y y) {
        boolean z;
        AppMethodBeat.i(76811);
        Executor qr = com.bumptech.glide.g.e.qr();
        com.bumptech.glide.g.j.checkNotNull(y, "Argument must not be null");
        if (!this.aDl) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You must call #load() before calling #into()");
            AppMethodBeat.o(76811);
            throw illegalArgumentException;
        }
        c a2 = a(y, (e) null, (d) null, this.aDe, this.aGc, this.aNb, this.aNa, this, qr);
        c qn = y.qn();
        if (a2.a(qn)) {
            if (this.aFI || !qn.isComplete()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                a2.recycle();
                if (!((c) com.bumptech.glide.g.j.checkNotNull(qn, "Argument must not be null")).isRunning()) {
                    qn.begin();
                }
                AppMethodBeat.o(76811);
                return y;
            }
        }
        this.aDc.c(y);
        y.h(a2);
        this.aDc.a(y, a2);
        AppMethodBeat.o(76811);
        return y;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.bumptech.glide.i$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Av = new int[ImageView.ScaleType.values().length];

        static {
            AppMethodBeat.i(204443);
            aDn = new int[g.values().length];
            try {
                aDn[g.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                aDn[g.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                aDn[g.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                aDn[g.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                Av[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                Av[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                Av[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                Av[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
            try {
                Av[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError e10) {
            }
            try {
                Av[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError e11) {
            }
            try {
                Av[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError e12) {
            }
            try {
                Av[ImageView.ScaleType.MATRIX.ordinal()] = 8;
                AppMethodBeat.o(204443);
            } catch (NoSuchFieldError e13) {
                AppMethodBeat.o(204443);
            }
        }
    }

    private g a(g gVar) {
        AppMethodBeat.i(76812);
        switch (gVar) {
            case LOW:
                g gVar2 = g.NORMAL;
                AppMethodBeat.o(76812);
                return gVar2;
            case NORMAL:
                g gVar3 = g.HIGH;
                AppMethodBeat.o(76812);
                return gVar3;
            case HIGH:
            case IMMEDIATE:
                g gVar4 = g.IMMEDIATE;
                AppMethodBeat.o(76812);
                return gVar4;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unknown priority: " + this.aGc);
                AppMethodBeat.o(76812);
                throw illegalArgumentException;
        }
    }

    private c a(com.bumptech.glide.e.a.e<TranscodeType> eVar, e<TranscodeType> eVar2, d dVar, k<?, ? super TranscodeType> kVar, g gVar, int i2, int i3, a<?> aVar, Executor executor) {
        b bVar;
        b bVar2;
        AppMethodBeat.i(204445);
        if (this.aDi != null) {
            b bVar3 = new b(dVar);
            bVar = bVar3;
            bVar2 = bVar3;
        } else {
            bVar = null;
            bVar2 = dVar;
        }
        c b2 = b(eVar, eVar2, bVar2, kVar, gVar, i2, i3, aVar, executor);
        if (bVar == null) {
            AppMethodBeat.o(204445);
            return b2;
        }
        int i4 = this.aDi.aNb;
        int i5 = this.aDi.aNa;
        if (k.aT(i2, i3) && !this.aDi.pZ()) {
            i4 = aVar.aNb;
            i5 = aVar.aNa;
        }
        bVar.a(b2, this.aDi.a(eVar, eVar2, bVar, this.aDi.aDe, this.aDi.aGc, i4, i5, this.aDi, executor));
        AppMethodBeat.o(204445);
        return bVar;
    }

    private c b(com.bumptech.glide.e.a.e<TranscodeType> eVar, e<TranscodeType> eVar2, d dVar, k<?, ? super TranscodeType> kVar, g gVar, int i2, int i3, a<?> aVar, Executor executor) {
        k<?, ? super TranscodeType> kVar2;
        g a2;
        int i4;
        int i5;
        AppMethodBeat.i(204446);
        if (this.aDh != null) {
            if (this.aDm) {
                IllegalStateException illegalStateException = new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
                AppMethodBeat.o(204446);
                throw illegalStateException;
            }
            k<?, ? super TranscodeType> kVar3 = this.aDh.aDe;
            if (this.aDh.aDk) {
                kVar2 = kVar;
            } else {
                kVar2 = kVar3;
            }
            if (super.qa()) {
                a2 = this.aDh.aGc;
            } else {
                a2 = a(gVar);
            }
            int i6 = this.aDh.aNb;
            int i7 = this.aDh.aNa;
            if (!k.aT(i2, i3) || this.aDh.pZ()) {
                i4 = i7;
                i5 = i6;
            } else {
                int i8 = aVar.aNb;
                i4 = aVar.aNa;
                i5 = i8;
            }
            com.bumptech.glide.e.i iVar = new com.bumptech.glide.e.i(dVar);
            c a3 = a(eVar, eVar2, aVar, iVar, kVar, gVar, i2, i3, executor);
            this.aDm = true;
            c a4 = this.aDh.a(eVar, eVar2, iVar, kVar2, a2, i5, i4, this.aDh, executor);
            this.aDm = false;
            iVar.a(a3, a4);
            AppMethodBeat.o(204446);
            return iVar;
        } else if (this.aDj != null) {
            com.bumptech.glide.e.i iVar2 = new com.bumptech.glide.e.i(dVar);
            iVar2.a(a(eVar, eVar2, aVar, iVar2, kVar, gVar, i2, i3, executor), a(eVar, eVar2, aVar.clone().Q(this.aDj.floatValue()), iVar2, kVar, a(gVar), i2, i3, executor));
            AppMethodBeat.o(204446);
            return iVar2;
        } else {
            c a5 = a(eVar, eVar2, aVar, dVar, kVar, gVar, i2, i3, executor);
            AppMethodBeat.o(204446);
            return a5;
        }
    }

    private c a(com.bumptech.glide.e.a.e<TranscodeType> eVar, e<TranscodeType> eVar2, a<?> aVar, d dVar, k<?, ? super TranscodeType> kVar, g gVar, int i2, int i3, Executor executor) {
        AppMethodBeat.i(204447);
        h a2 = h.a(this.context, this.aCm, this.aDf, this.aDd, aVar, i2, i3, gVar, eVar, eVar2, this.aDg, dVar, this.aCm.aCi, kVar.aDA, executor);
        AppMethodBeat.o(204447);
        return a2;
    }

    public final i<TranscodeType> a(a<?> aVar) {
        AppMethodBeat.i(204444);
        com.bumptech.glide.g.j.checkNotNull(aVar, "Argument must not be null");
        i<TranscodeType> iVar = (i) super.b(aVar);
        AppMethodBeat.o(204444);
        return iVar;
    }

    public final i<TranscodeType> Q(Object obj) {
        this.aDf = obj;
        this.aDl = true;
        return this;
    }
}
