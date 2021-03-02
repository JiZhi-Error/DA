package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.cd;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.m;

public final class g extends a {
    public g() {
        super(27);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, com.tencent.mm.plugin.webview.luggage.g gVar, m mVar) {
        AppMethodBeat.i(78694);
        if (gVar.isFullScreen()) {
            mVar.b(27, context.getString(R.string.ftr), R.raw.bottomsheet_icon_exit);
        }
        AppMethodBeat.o(78694);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, com.tencent.mm.plugin.webview.luggage.g gVar) {
        AppMethodBeat.i(78695);
        if (!gVar.gbB() && !gVar.ctg.Ly().Lo()) {
            ((Activity) gVar.mContext).finish();
        }
        h.INSTANCE.dN(cd.CTRL_INDEX, 11);
        AppMethodBeat.o(78695);
    }
}
