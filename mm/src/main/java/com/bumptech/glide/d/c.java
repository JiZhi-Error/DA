package com.bumptech.glide.d;

import android.support.v4.e.a;
import com.bumptech.glide.load.b.i;
import com.bumptech.glide.load.b.t;
import com.bumptech.glide.load.d.f.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

public final class c {
    public static final t<?, ?, ?> aMN = new t<>(Object.class, Object.class, Object.class, Collections.singletonList(new i(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null)), null);
    public final a<com.bumptech.glide.g.i, t<?, ?, ?>> aMO = new a<>();
    private final AtomicReference<com.bumptech.glide.g.i> aMP = new AtomicReference<>();

    public c() {
        AppMethodBeat.i(77603);
        AppMethodBeat.o(77603);
    }

    static {
        AppMethodBeat.i(77606);
        AppMethodBeat.o(77606);
    }

    public static boolean a(t<?, ?, ?> tVar) {
        AppMethodBeat.i(77604);
        boolean equals = aMN.equals(tVar);
        AppMethodBeat.o(77604);
        return equals;
    }

    public final <Data, TResource, Transcode> t<Data, TResource, Transcode> c(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        com.bumptech.glide.g.i iVar;
        t<Data, TResource, Transcode> tVar;
        AppMethodBeat.i(77605);
        com.bumptech.glide.g.i andSet = this.aMP.getAndSet(null);
        if (andSet == null) {
            iVar = new com.bumptech.glide.g.i();
        } else {
            iVar = andSet;
        }
        iVar.e(cls, cls2, cls3);
        synchronized (this.aMO) {
            try {
                tVar = (t<Data, TResource, Transcode>) this.aMO.get(iVar);
            } catch (Throwable th) {
                AppMethodBeat.o(77605);
                throw th;
            }
        }
        this.aMP.set(iVar);
        AppMethodBeat.o(77605);
        return tVar;
    }
}
