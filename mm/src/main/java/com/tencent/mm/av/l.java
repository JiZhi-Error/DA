package com.tencent.mm.av;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.cache.g;
import com.tencent.mm.memory.a.b;

final class l implements g {
    private f<String, Bitmap> iYN = new b(5, getClass());

    l() {
        AppMethodBeat.i(150666);
        AppMethodBeat.o(150666);
    }

    @Override // com.tencent.mm.cache.g
    public final void f(Object obj, Object obj2) {
        AppMethodBeat.i(150667);
        this.iYN.x((String) obj, (Bitmap) obj2);
        AppMethodBeat.o(150667);
    }

    @Override // com.tencent.mm.cache.g
    public final Object get(Object obj) {
        AppMethodBeat.i(150668);
        Bitmap bitmap = this.iYN.get((String) obj);
        AppMethodBeat.o(150668);
        return bitmap;
    }

    @Override // com.tencent.mm.cache.g
    public final Object remove(Object obj) {
        AppMethodBeat.i(150669);
        this.iYN.remove((String) obj);
        AppMethodBeat.o(150669);
        return null;
    }
}
