package com.bumptech.glide.d;

import com.bumptech.glide.load.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a {
    private final List<C0063a<?>> aMM = new ArrayList();

    public a() {
        AppMethodBeat.i(77598);
        AppMethodBeat.o(77598);
    }

    public final synchronized <T> d<T> v(Class<T> cls) {
        d<T> dVar;
        AppMethodBeat.i(77599);
        Iterator<C0063a<?>> it = this.aMM.iterator();
        while (true) {
            if (!it.hasNext()) {
                dVar = null;
                AppMethodBeat.o(77599);
                break;
            }
            C0063a<?> next = it.next();
            if (next.aGU.isAssignableFrom(cls)) {
                dVar = next.aFU;
                AppMethodBeat.o(77599);
                break;
            }
        }
        return dVar;
    }

    public final synchronized <T> void b(Class<T> cls, d<T> dVar) {
        AppMethodBeat.i(77600);
        this.aMM.add(new C0063a<>(cls, dVar));
        AppMethodBeat.o(77600);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.bumptech.glide.d.a$a  reason: collision with other inner class name */
    public static final class C0063a<T> {
        final d<T> aFU;
        final Class<T> aGU;

        C0063a(Class<T> cls, d<T> dVar) {
            this.aGU = cls;
            this.aFU = dVar;
        }
    }
}
