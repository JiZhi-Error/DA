package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.cd;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.ui.base.m;

public final class k extends a {
    public k() {
        super(31);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, g gVar, m mVar) {
        AppMethodBeat.i(78703);
        mVar.b(31, context.getString(R.string.j51), R.raw.bottomsheet_icon_search);
        AppMethodBeat.o(78703);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, g gVar) {
        AppMethodBeat.i(78704);
        gVar.zc(true);
        h.INSTANCE.dN(cd.CTRL_INDEX, 8);
        AppMethodBeat.o(78704);
    }
}
