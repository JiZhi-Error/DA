package com.bumptech.glide.load.d.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class f {
    private final List<a<?, ?>> aMi = new ArrayList();

    public f() {
        AppMethodBeat.i(77535);
        AppMethodBeat.o(77535);
    }

    public final synchronized <Z, R> void b(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
        AppMethodBeat.i(77536);
        this.aMi.add(new a<>(cls, cls2, eVar));
        AppMethodBeat.o(77536);
    }

    public final synchronized <Z, R> e<Z, R> c(Class<Z> cls, Class<R> cls2) {
        e<Z, R> eVar;
        AppMethodBeat.i(77537);
        if (cls2.isAssignableFrom(cls)) {
            eVar = g.pS();
            AppMethodBeat.o(77537);
        } else {
            for (a<?, ?> aVar : this.aMi) {
                if (aVar.e(cls, cls2)) {
                    eVar = aVar.aGW;
                    AppMethodBeat.o(77537);
                }
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
            AppMethodBeat.o(77537);
            throw illegalArgumentException;
        }
        return eVar;
    }

    public final synchronized <Z, R> List<Class<R>> d(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList;
        AppMethodBeat.i(77538);
        ArrayList arrayList2 = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList2.add(cls2);
            AppMethodBeat.o(77538);
            arrayList = arrayList2;
        } else {
            for (a<?, ?> aVar : this.aMi) {
                if (aVar.e(cls, cls2)) {
                    arrayList2.add(cls2);
                }
            }
            AppMethodBeat.o(77538);
            arrayList = arrayList2;
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public static final class a<Z, R> {
        final e<Z, R> aGW;
        private final Class<Z> aMj;
        private final Class<R> aMk;

        a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
            this.aMj = cls;
            this.aMk = cls2;
            this.aGW = eVar;
        }

        public final boolean e(Class<?> cls, Class<?> cls2) {
            AppMethodBeat.i(77534);
            if (!this.aMj.isAssignableFrom(cls) || !cls2.isAssignableFrom(this.aMk)) {
                AppMethodBeat.o(77534);
                return false;
            }
            AppMethodBeat.o(77534);
            return true;
        }
    }
}
