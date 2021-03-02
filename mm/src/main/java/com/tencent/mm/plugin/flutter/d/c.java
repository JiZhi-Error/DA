package com.tencent.mm.plugin.flutter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.a;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;

public final class c implements a, k.c {
    @Override // io.flutter.plugin.a.k.c
    public final void a(j jVar, k.d dVar) {
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void b(a.b bVar) {
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void a(a.b bVar) {
        AppMethodBeat.i(240951);
        bVar.SPA.a("com.tencent.mm/emoji_preview", new b(bVar.SOH));
        AppMethodBeat.o(240951);
    }
}
