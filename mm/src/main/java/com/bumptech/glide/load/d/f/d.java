package com.bumptech.glide.load.d.f;

import com.bumptech.glide.g.a;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.b.b;
import com.bumptech.glide.load.d.e.c;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d implements e<c, byte[]> {
    @Override // com.bumptech.glide.load.d.f.e
    public final v<byte[]> a(v<c> vVar, i iVar) {
        AppMethodBeat.i(77533);
        b bVar = new b(a.c(vVar.get().getBuffer()));
        AppMethodBeat.o(77533);
        return bVar;
    }
}
