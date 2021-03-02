package com.bumptech.glide.d;

import com.bumptech.glide.load.d;
import com.bumptech.glide.load.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class f {
    private final List<a<?>> aMM = new ArrayList();

    public f() {
        AppMethodBeat.i(77616);
        AppMethodBeat.o(77616);
    }

    public final synchronized <Z> void b(Class<Z> cls, k<Z> kVar) {
        AppMethodBeat.i(77617);
        this.aMM.add(new a<>(cls, kVar));
        AppMethodBeat.o(77617);
    }

    public final synchronized <Z> k<Z> w(Class<Z> cls) {
        d dVar;
        AppMethodBeat.i(77618);
        int size = this.aMM.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                dVar = (k<Z>) null;
                AppMethodBeat.o(77618);
                break;
            }
            a<?> aVar = this.aMM.get(i2);
            if (aVar.aFX.isAssignableFrom(cls)) {
                dVar = (k<T>) aVar.aGF;
                AppMethodBeat.o(77618);
                break;
            }
            i2++;
        }
        return (k<Z>) dVar;
    }

    /* access modifiers changed from: package-private */
    public static final class a<T> {
        final Class<T> aFX;
        final k<T> aGF;

        a(Class<T> cls, k<T> kVar) {
            this.aFX = cls;
            this.aGF = kVar;
        }
    }
}
