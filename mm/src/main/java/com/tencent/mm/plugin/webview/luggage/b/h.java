package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.cd;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.ui.base.m;

public final class h extends a {
    public h() {
        super(35);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, g gVar, m mVar) {
        AppMethodBeat.i(78696);
        t gbJ = gVar.gbJ();
        if (gVar.gbH() && gbJ != null) {
            mVar.b(35, context.getString(R.string.ftx), R.raw.icons_outlined_multitask);
        }
        AppMethodBeat.o(78696);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, g gVar) {
        AppMethodBeat.i(78697);
        t gbJ = gVar.gbJ();
        if (gbJ != null) {
            gbJ.ic(true);
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(cd.CTRL_INDEX, 4);
        }
        AppMethodBeat.o(78697);
    }
}
