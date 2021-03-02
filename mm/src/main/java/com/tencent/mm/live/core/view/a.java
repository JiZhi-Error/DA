package com.tencent.mm.live.core.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.view.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16})
public final class a implements b.a {
    private final /* synthetic */ m hEX;

    a(m mVar) {
        this.hEX = mVar;
    }

    @Override // com.tencent.mm.live.core.view.b.a
    public final /* synthetic */ void C(float f2, float f3) {
        AppMethodBeat.i(196752);
        p.g(this.hEX.invoke(Float.valueOf(f2), Float.valueOf(f3)), "invoke(...)");
        AppMethodBeat.o(196752);
    }
}
