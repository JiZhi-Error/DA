package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.cd;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.ui.base.m;

public final class j extends a {
    public j() {
        super(28);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, g gVar, m mVar) {
        AppMethodBeat.i(78701);
        mVar.b(28, context.getString(R.string.iy_), R.raw.bottomsheet_icon_refresh);
        AppMethodBeat.o(78701);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, g gVar) {
        AppMethodBeat.i(78702);
        gVar.reload();
        h.INSTANCE.dN(cd.CTRL_INDEX, 7);
        AppMethodBeat.o(78702);
    }
}
