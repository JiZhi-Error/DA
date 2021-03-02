package com.bumptech.glide.load.c;

import android.support.v4.e.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class p {
    private final r aKi;
    private final a aKj;

    public p(l.a<List<Throwable>> aVar) {
        this(new r(aVar));
        AppMethodBeat.i(77270);
        AppMethodBeat.o(77270);
    }

    private p(r rVar) {
        AppMethodBeat.i(77271);
        this.aKj = new a();
        this.aKi = rVar;
        AppMethodBeat.o(77271);
    }

    public final synchronized <Model, Data> void b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        AppMethodBeat.i(77272);
        this.aKi.b(cls, cls2, oVar);
        this.aKj.aKk.clear();
        AppMethodBeat.o(77272);
    }

    public final synchronized List<Class<?>> r(Class<?> cls) {
        List<Class<?>> r;
        AppMethodBeat.i(77274);
        r = this.aKi.r(cls);
        AppMethodBeat.o(77274);
        return r;
    }

    public final synchronized <A> List<n<A, ?>> s(Class<A> cls) {
        List list;
        AppMethodBeat.i(204479);
        a.C0073a<?> aVar = this.aKj.aKk.get(cls);
        if (aVar == null) {
            list = null;
        } else {
            list = aVar.aKl;
        }
        if (list == null) {
            List unmodifiableList = Collections.unmodifiableList(this.aKi.t(cls));
            if (this.aKj.aKk.put(cls, new a.C0073a<>(unmodifiableList)) != null) {
                IllegalStateException illegalStateException = new IllegalStateException("Already cached loaders for model: ".concat(String.valueOf(cls)));
                AppMethodBeat.o(204479);
                throw illegalStateException;
            }
            list = unmodifiableList;
        }
        AppMethodBeat.o(204479);
        return list;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        final Map<Class<?>, C0073a<?>> aKk = new HashMap();

        a() {
            AppMethodBeat.i(77269);
            AppMethodBeat.o(77269);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.bumptech.glide.load.c.p$a$a  reason: collision with other inner class name */
        public static class C0073a<Model> {
            final List<n<Model, ?>> aKl;

            public C0073a(List<n<Model, ?>> list) {
                this.aKl = list;
            }
        }
    }
}
