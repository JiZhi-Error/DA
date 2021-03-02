package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.cd;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;

public final class c extends a {
    public c() {
        super(6);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, g gVar, m mVar) {
        AppMethodBeat.i(78683);
        if (gVar.Oc(44)) {
            mVar.b(6, context.getString(R.string.j45), R.raw.bottomsheet_icon_copy);
        }
        AppMethodBeat.o(78683);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, g gVar) {
        AppMethodBeat.i(78684);
        String aZj = gVar.gbF().aZj(gVar.getUrl());
        if (Util.isNullOrNil(aZj)) {
            aZj = gVar.getUrl();
        }
        ClipboardHelper.setText(aZj);
        Toast.makeText(context, context.getString(R.string.j46), 0).show();
        h.INSTANCE.dN(cd.CTRL_INDEX, 0);
        AppMethodBeat.o(78684);
    }
}
