package com.tencent.mm.plugin.appbrand.jsapi.ag.e;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.w.a;
import com.tencent.mm.plugin.appbrand.w.b;

public final class f implements e {
    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e
    public final void aW(long j2) {
        AppMethodBeat.i(139597);
        c(928, j2, 1);
        AppMethodBeat.o(139597);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e
    public final void c(long j2, long j3, long j4) {
        AppMethodBeat.i(139598);
        ((a) com.tencent.luggage.a.e.N(a.class)).idkeyStat(j2, j3, j4, false);
        AppMethodBeat.o(139598);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e
    public final void e(Object... objArr) {
        AppMethodBeat.i(139599);
        ((b) com.tencent.luggage.a.e.N(b.class)).a(18651, objArr);
        AppMethodBeat.o(139599);
    }
}
