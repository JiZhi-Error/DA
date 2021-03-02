package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.finder.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;

public class ae extends br {
    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return d.NAME;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b.a aVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(78570);
        int optInt = aVar.ctb.csi.optInt("id");
        if (optInt <= 0) {
            aVar.c("fail", null);
        }
        String optString = aVar.ctb.csi.optString("value");
        if (aVar.ctb.csi.optInt("is_important") > 0) {
            z = true;
        } else {
            z = false;
        }
        if (aVar.ctb.csi.optInt("is_report_now") <= 0) {
            z2 = false;
        }
        h.INSTANCE.a(optInt, optString, z2, z);
        aVar.c("", null);
        AppMethodBeat.o(78570);
    }
}
