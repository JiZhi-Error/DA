package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.cd;
import com.tencent.mm.plugin.appbrand.jsapi.share.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.g;
import org.json.JSONObject;

public final class m extends a {
    public m() {
        super(2);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, g gVar, com.tencent.mm.ui.base.m mVar) {
        AppMethodBeat.i(78707);
        if (gVar.Oc(23)) {
            mVar.b(2, context.getString(R.string.ftl), R.raw.bottomsheet_icon_moment);
        }
        AppMethodBeat.o(78707);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, g gVar) {
        AppMethodBeat.i(78708);
        gVar.gbG().aYu(l.NAME);
        gVar.ctS.a(new d() {
            /* class com.tencent.mm.plugin.webview.luggage.b.m.AnonymousClass1 */

            @Override // com.tencent.luggage.d.d
            public final String name() {
                return "menu:share:timeline";
            }

            @Override // com.tencent.luggage.d.d
            public final JSONObject Ld() {
                return null;
            }
        });
        h.INSTANCE.dN(cd.CTRL_INDEX, 10);
        AppMethodBeat.o(78708);
    }
}
