package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.cd;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.bb;
import com.tencent.mm.ui.base.m;
import org.json.JSONObject;

public final class l extends a {
    public l() {
        super(1);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, g gVar, m mVar) {
        AppMethodBeat.i(78705);
        if (gVar.Oc(21)) {
            mVar.b(this.id, context.getString(R.string.ftk), R.raw.bottomsheet_icon_transmit);
        }
        AppMethodBeat.o(78705);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, g gVar) {
        AppMethodBeat.i(78706);
        bb.afY(0);
        gVar.gbG().aYu("sendAppMessage");
        gVar.ctS.a(new d() {
            /* class com.tencent.mm.plugin.webview.luggage.b.l.AnonymousClass1 */

            @Override // com.tencent.luggage.d.d
            public final String name() {
                return "menu:share:appmessage";
            }

            @Override // com.tencent.luggage.d.d
            public final JSONObject Ld() {
                return null;
            }
        });
        h.INSTANCE.dN(cd.CTRL_INDEX, 9);
        AppMethodBeat.o(78706);
    }
}
