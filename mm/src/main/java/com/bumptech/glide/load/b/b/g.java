package com.bumptech.glide.load.b.b;

import android.annotation.SuppressLint;
import com.bumptech.glide.load.b.b.h;
import com.bumptech.glide.load.b.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g extends com.bumptech.glide.g.g<com.bumptech.glide.load.g, v<?>> implements h {
    private h.a aJa;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.bumptech.glide.g.g
    public final /* synthetic */ int W(v<?> vVar) {
        AppMethodBeat.i(77158);
        v<?> vVar2 = vVar;
        if (vVar2 == null) {
            int W = super.W(null);
            AppMethodBeat.o(77158);
            return W;
        }
        int size = vVar2.getSize();
        AppMethodBeat.o(77158);
        return size;
    }

    @Override // com.bumptech.glide.load.b.b.h
    public final /* synthetic */ v a(com.bumptech.glide.load.g gVar, v vVar) {
        AppMethodBeat.i(77159);
        v vVar2 = (v) super.put(gVar, vVar);
        AppMethodBeat.o(77159);
        return vVar2;
    }

    @Override // com.bumptech.glide.load.b.b.h
    public final /* synthetic */ v d(com.bumptech.glide.load.g gVar) {
        AppMethodBeat.i(77160);
        v vVar = (v) super.remove(gVar);
        AppMethodBeat.o(77160);
        return vVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.bumptech.glide.g.g
    public final /* synthetic */ void g(com.bumptech.glide.load.g gVar, v<?> vVar) {
        AppMethodBeat.i(77157);
        v<?> vVar2 = vVar;
        if (!(this.aJa == null || vVar2 == null)) {
            this.aJa.c(vVar2);
        }
        AppMethodBeat.o(77157);
    }

    public g(long j2) {
        super(j2);
    }

    @Override // com.bumptech.glide.load.b.b.h
    public final void a(h.a aVar) {
        this.aJa = aVar;
    }

    @Override // com.bumptech.glide.load.b.b.h
    @SuppressLint({"InlinedApi"})
    public final void trimMemory(int i2) {
        AppMethodBeat.i(77156);
        if (i2 >= 40) {
            oZ();
            AppMethodBeat.o(77156);
            return;
        }
        if (i2 >= 20 || i2 == 15) {
            o(qu() / 2);
        }
        AppMethodBeat.o(77156);
    }
}
