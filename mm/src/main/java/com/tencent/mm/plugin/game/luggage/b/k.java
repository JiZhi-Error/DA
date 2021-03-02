package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.it;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class k extends br<i> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "getGameCommInfo";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final b<i>.a aVar) {
        AppMethodBeat.i(180134);
        Log.i("MicroMsg.JsApiGetGameCommInfo", "invoke");
        JSONObject jSONObject = aVar.ctb.csi;
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiGetGameCommInfo", "data is null");
            aVar.c("null_data", null);
            AppMethodBeat.o(180134);
            return;
        }
        int optInt = jSONObject.optInt("cmd", 0);
        String optString = jSONObject.optString("param");
        Bundle bundle = new Bundle();
        bundle.putInt("cmd", optInt);
        bundle.putString("param", optString);
        JSONObject jSONObject2 = new JSONObject();
        if (optInt == 10008) {
            try {
                jSONObject2.put("page_start_time", aVar.cta.xyM.JqU);
                aVar.c("", jSONObject2);
                AppMethodBeat.o(180134);
            } catch (JSONException e2) {
                aVar.c("", null);
                AppMethodBeat.o(180134);
            }
        } else if (optInt == 10009) {
            aVar.cta.xyN = Util.getLong(optString, System.currentTimeMillis());
            aVar.c("", null);
            AppMethodBeat.o(180134);
        } else {
            h.a(MainProcessIPCService.dkO, bundle, a.class, new d<Bundle>() {
                /* class com.tencent.mm.plugin.game.luggage.b.k.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Bundle bundle) {
                    AppMethodBeat.i(180132);
                    try {
                        aVar.c("", new JSONObject(bundle.getString("backResult")));
                        AppMethodBeat.o(180132);
                    } catch (JSONException e2) {
                        aVar.c("", null);
                        AppMethodBeat.o(180132);
                    }
                }
            });
            AppMethodBeat.o(180134);
        }
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
        AppMethodBeat.i(83066);
        AppMethodBeat.o(83066);
    }

    static class a implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
            AppMethodBeat.i(180133);
            Bundle bundle2 = bundle;
            int i2 = bundle2.getInt("cmd");
            String string = bundle2.getString("param");
            Bundle bundle3 = new Bundle();
            if (i2 == 10002) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("webpageCount", 1);
                } catch (JSONException e2) {
                }
                bundle3.putString("backResult", jSONObject.toString());
            } else {
                it itVar = new it();
                itVar.dNs.EX = i2;
                itVar.dNs.param = string;
                itVar.dNs.context = MMApplicationContext.getContext();
                EventCenter.instance.publish(itVar);
                try {
                    if (!Util.isNullOrNil(itVar.dNt.result)) {
                        bundle3.putString("backResult", new JSONObject(itVar.dNt.result).toString());
                    } else {
                        bundle3.putString("backResult", "");
                    }
                } catch (JSONException e3) {
                }
            }
            dVar.bn(bundle3);
            AppMethodBeat.o(180133);
        }
    }
}
