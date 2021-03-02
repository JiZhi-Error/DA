package com.bumptech.glide.d;

import android.support.v4.e.a;
import com.bumptech.glide.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class d {
    private final AtomicReference<i> aMQ = new AtomicReference<>();
    public final a<i, List<Class<?>>> aMR = new a<>();

    public d() {
        AppMethodBeat.i(77607);
        AppMethodBeat.o(77607);
    }

    public final List<Class<?>> d(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        i iVar;
        List<Class<?>> list;
        AppMethodBeat.i(204487);
        i andSet = this.aMQ.getAndSet(null);
        if (andSet == null) {
            iVar = new i(cls, cls2, cls3);
        } else {
            andSet.e(cls, cls2, cls3);
            iVar = andSet;
        }
        synchronized (this.aMR) {
            try {
                list = this.aMR.get(iVar);
            } catch (Throwable th) {
                AppMethodBeat.o(204487);
                throw th;
            }
        }
        this.aMQ.set(iVar);
        AppMethodBeat.o(204487);
        return list;
    }
}
