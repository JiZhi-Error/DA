package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigDecimal;
import org.json.JSONObject;

public final class t extends ab<d> {
    private static final int CTRL_INDEX = 413;
    public static final String NAME = "scrollWebviewTo";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* bridge */ /* synthetic */ String a(d dVar, JSONObject jSONObject) {
        AppMethodBeat.i(138225);
        String a2 = a(dVar, jSONObject);
        AppMethodBeat.o(138225);
        return a2;
    }

    private String a(d dVar, JSONObject jSONObject) {
        final ac currentPageView;
        AppMethodBeat.i(138224);
        if (dVar instanceof ac) {
            currentPageView = (ac) dVar;
        } else {
            currentPageView = dVar instanceof s ? ((s) dVar).getCurrentPageView() : null;
        }
        if (currentPageView == null) {
            String h2 = h("fail:page don't exist", null);
            AppMethodBeat.o(138224);
            return h2;
        }
        final long optLong = jSONObject.optLong(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 300);
        if (!jSONObject.has("scrollTop")) {
            String h3 = h("fail:invalid data", null);
            AppMethodBeat.o(138224);
            return h3;
        }
        try {
            final int round = Math.round(g.aT(new BigDecimal(jSONObject.getString("scrollTop")).floatValue()));
            currentPageView.P(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.p.t.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(138223);
                    if (currentPageView.nmX == null) {
                        AppMethodBeat.o(138223);
                        return;
                    }
                    currentPageView.nmX.s(round, optLong);
                    AppMethodBeat.o(138223);
                }
            });
            String h4 = h("ok", null);
            AppMethodBeat.o(138224);
            return h4;
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrand.Jsapi_scrollWebviewTo", "opt scrollTop, e = %s", e2);
            String h5 = h("fail:invalid data " + Util.nullAsNil(e2.getMessage()), null);
            AppMethodBeat.o(138224);
            return h5;
        }
    }
}
