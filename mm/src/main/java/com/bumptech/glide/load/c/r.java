package com.bumptech.glide.load.c;

import android.support.v4.e.l;
import com.bumptech.glide.g.j;
import com.bumptech.glide.h;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class r {
    private static final c aKq = new c();
    private static final n<Object, Object> aKr = new a();
    private final l.a<List<Throwable>> aDa;
    private final List<b<?, ?>> aKs;
    private final c aKt;
    private final Set<b<?, ?>> aKu;

    static {
        AppMethodBeat.i(77294);
        AppMethodBeat.o(77294);
    }

    public r(l.a<List<Throwable>> aVar) {
        this(aVar, aKq);
    }

    private r(l.a<List<Throwable>> aVar, c cVar) {
        AppMethodBeat.i(77288);
        this.aKs = new ArrayList();
        this.aKu = new HashSet();
        this.aDa = aVar;
        this.aKt = cVar;
        AppMethodBeat.o(77288);
    }

    /* access modifiers changed from: package-private */
    public final synchronized <Model> List<n<Model, ?>> t(Class<Model> cls) {
        ArrayList arrayList;
        AppMethodBeat.i(77290);
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.aKs) {
                if (!this.aKu.contains(bVar) && bVar.u(cls)) {
                    this.aKu.add(bVar);
                    arrayList.add(a(bVar));
                    this.aKu.remove(bVar);
                }
            }
            AppMethodBeat.o(77290);
        } catch (Throwable th) {
            this.aKu.clear();
            AppMethodBeat.o(77290);
            throw th;
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final synchronized List<Class<?>> r(Class<?> cls) {
        ArrayList arrayList;
        AppMethodBeat.i(77291);
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.aKs) {
            if (!arrayList.contains(bVar.aGU) && bVar.u(cls)) {
                arrayList.add(bVar.aGU);
            }
        }
        AppMethodBeat.o(77291);
        return arrayList;
    }

    public final synchronized <Model, Data> n<Model, Data> b(Class<Model> cls, Class<Data> cls2) {
        n<Model, Data> nVar;
        AppMethodBeat.i(77292);
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b<?, ?> bVar : this.aKs) {
                if (this.aKu.contains(bVar)) {
                    z = true;
                } else {
                    if (bVar.u(cls) && bVar.aGU.isAssignableFrom(cls2)) {
                        this.aKu.add(bVar);
                        arrayList.add(a(bVar));
                        this.aKu.remove(bVar);
                    }
                }
            }
            if (arrayList.size() > 1) {
                nVar = new q(arrayList, this.aDa);
                AppMethodBeat.o(77292);
            } else if (arrayList.size() == 1) {
                nVar = (n) arrayList.get(0);
                AppMethodBeat.o(77292);
            } else if (z) {
                nVar = (n<Model, Data>) aKr;
                AppMethodBeat.o(77292);
            } else {
                h.c cVar = new h.c(cls, cls2);
                AppMethodBeat.o(77292);
                throw cVar;
            }
        } catch (Throwable th) {
            this.aKu.clear();
            AppMethodBeat.o(77292);
            throw th;
        }
        return nVar;
    }

    private <Model, Data> n<Model, Data> a(b<?, ?> bVar) {
        AppMethodBeat.i(77293);
        n<Model, Data> nVar = (n) j.checkNotNull(bVar.aKw.a(this), "Argument must not be null");
        AppMethodBeat.o(77293);
        return nVar;
    }

    /* access modifiers changed from: package-private */
    public static class b<Model, Data> {
        final Class<Data> aGU;
        private final Class<Model> aKv;
        final o<? extends Model, ? extends Data> aKw;

        public b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
            this.aKv = cls;
            this.aGU = cls2;
            this.aKw = oVar;
        }

        public final boolean u(Class<?> cls) {
            AppMethodBeat.i(77287);
            boolean isAssignableFrom = this.aKv.isAssignableFrom(cls);
            AppMethodBeat.o(77287);
            return isAssignableFrom;
        }
    }

    static class c {
        c() {
        }
    }

    static class a implements n<Object, Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.c.n
        public final n.a<Object> b(Object obj, int i2, int i3, i iVar) {
            return null;
        }

        @Override // com.bumptech.glide.load.c.n
        public final boolean X(Object obj) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized <Model, Data> void b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        AppMethodBeat.i(77289);
        this.aKs.add(this.aKs.size(), new b<>(cls, cls2, oVar));
        AppMethodBeat.o(77289);
    }
}
