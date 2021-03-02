package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.handoff.a.a;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import org.json.JSONObject;

public class n extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "currentMpInfo";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        AppMethodBeat.i(78546);
        JSONObject jSONObject = aVar.ctb.csi;
        String optString = jSONObject.optString("brandIcon");
        String optString2 = jSONObject.optString("brandName");
        String optString3 = jSONObject.optString("title");
        Log.i("MicroMsg.JsApiCurrentMpInfo", "doCurrentMpInfo brandIcon:%s", optString);
        if (!Util.isNullOrNil(optString)) {
            aVar.cta.gbI().agS(optString);
            t gbJ = aVar.cta.gbJ();
            p.h(optString, "icon");
            gbJ.IVc = optString;
            gbJ.agS(optString);
        }
        if (!Util.isNullOrNil(optString2)) {
            aVar.cta.gbJ().aGL(optString2);
        }
        if (!Util.isNullOrNil(optString3)) {
            aVar.cta.gbI().agT(optString3);
            aVar.cta.gbJ().aCM(optString3);
        }
        if (aVar.cta.gbK() != null) {
            aVar.cta.gbK().setIcon(Util.nullAsNil(optString));
            if (!Util.isNullOrNil(optString2)) {
                aVar.cta.gbK().setTitle(optString2);
            }
            ((a) com.tencent.mm.kernel.g.af(a.class)).e(aVar.cta.gbK());
        }
        aVar.c("", null);
        AppMethodBeat.o(78546);
    }
}
