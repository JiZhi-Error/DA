package com.bumptech.glide.e;

import com.bumptech.glide.load.b.j;
import com.bumptech.glide.load.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f extends a<f> {
    public f() {
        AppMethodBeat.i(77636);
        AppMethodBeat.o(77636);
    }

    public static f b(j jVar) {
        AppMethodBeat.i(77637);
        f fVar = (f) new f().a(jVar);
        AppMethodBeat.o(77637);
        return fVar;
    }

    public static f g(g gVar) {
        AppMethodBeat.i(77638);
        a fVar = new f();
        while (fVar.aNg) {
            fVar = fVar.clone();
        }
        fVar.aFT = (g) com.bumptech.glide.g.j.checkNotNull(gVar, "Argument must not be null");
        fVar.aMU |= 1024;
        f fVar2 = (f) super.pY();
        AppMethodBeat.o(77638);
        return fVar2;
    }

    public static f x(Class<?> cls) {
        AppMethodBeat.i(77639);
        a fVar = new f();
        while (fVar.aNg) {
            fVar = fVar.clone();
        }
        fVar.aFX = (Class) com.bumptech.glide.g.j.checkNotNull(cls, "Argument must not be null");
        fVar.aMU |= 4096;
        f fVar2 = (f) super.pY();
        AppMethodBeat.o(77639);
        return fVar2;
    }
}
