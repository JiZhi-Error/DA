package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.cd;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.modeltools.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;

public final class i extends a {
    private a IVh = new a();

    public i() {
        super(7);
        AppMethodBeat.i(78698);
        AppMethodBeat.o(78698);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, g gVar, m mVar) {
        AppMethodBeat.i(78699);
        mVar.b(7, context.getString(R.string.j4_), R.raw.bottomsheet_icon_brower);
        AppMethodBeat.o(78699);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, g gVar) {
        AppMethodBeat.i(78700);
        String aZj = gVar.gbF().aZj(gVar.getUrl());
        if (Util.isNullOrNil(aZj)) {
            aZj = gVar.getUrl();
        }
        if (context instanceof Activity) {
            this.IVh.c((Activity) context, aZj);
        }
        h.INSTANCE.dN(cd.CTRL_INDEX, 6);
        AppMethodBeat.o(78700);
    }
}
