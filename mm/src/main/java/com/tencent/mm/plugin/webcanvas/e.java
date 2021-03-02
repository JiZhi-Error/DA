package com.tencent.mm.plugin.webcanvas;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16})
final class e implements ValueCallback {
    private final /* synthetic */ b hXF;

    e(b bVar) {
        this.hXF = bVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(Object obj) {
        AppMethodBeat.i(224639);
        p.g(this.hXF.invoke(obj), "invoke(...)");
        AppMethodBeat.o(224639);
    }
}
