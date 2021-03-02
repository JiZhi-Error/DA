package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16})
public final class d implements h.a {
    private final /* synthetic */ b hXF;

    d(b bVar) {
        this.hXF = bVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.h.a
    public final /* synthetic */ boolean onNewIntent(Intent intent) {
        AppMethodBeat.i(183688);
        p.h(intent, "p0");
        Object invoke = this.hXF.invoke(intent);
        p.g(invoke, "invoke(...)");
        boolean booleanValue = ((Boolean) invoke).booleanValue();
        AppMethodBeat.o(183688);
        return booleanValue;
    }
}
