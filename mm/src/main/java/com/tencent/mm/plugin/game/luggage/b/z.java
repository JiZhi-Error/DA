package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.lite.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class z extends bs<i> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "openLiteApp";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<i>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, final br.a aVar) {
        String str2;
        String str3;
        boolean z;
        AppMethodBeat.i(186881);
        JSONObject Zc = com.tencent.mm.plugin.webview.luggage.c.b.Zc(str);
        if (Zc == null) {
            aVar.i("invalid_data", null);
            AppMethodBeat.o(186881);
            return;
        }
        Bundle bundle = new Bundle();
        boolean z2 = false;
        String str4 = "";
        String str5 = "";
        try {
            if (!Zc.has("appId")) {
                aVar.i("invalid_appid", null);
                AppMethodBeat.o(186881);
                return;
            }
            bundle.putString("appId", Zc.getString("appId"));
            String string = Zc.getString("appId");
            if (Zc.has("page")) {
                str4 = Zc.getString("page");
                bundle.putString("path", Zc.getString("page"));
            }
            if (Zc.has("checkUpdate")) {
                z2 = Zc.getBoolean("checkUpdate");
            }
            if (Zc.has(SearchIntents.EXTRA_QUERY)) {
                str5 = Zc.getJSONObject(SearchIntents.EXTRA_QUERY).toString();
                bundle.putString(SearchIntents.EXTRA_QUERY, Zc.getJSONObject(SearchIntents.EXTRA_QUERY).toString());
            }
            if (Zc.has("transparent") && Zc.getBoolean("transparent")) {
                bundle.putBoolean("transparent", true);
            }
            str2 = str4;
            str3 = string;
            z = z2;
            bundle.putInt("nextAnimIn", R.anim.eq);
            bundle.putInt("currentAnimOut", R.anim.er);
            StringBuilder sb = new StringBuilder();
            sb.append(str3).append(",").append(str2).append(",").append(str5).append(",").append(z ? 1 : 0);
            h.INSTANCE.kvStat(20980, sb.toString());
            h.INSTANCE.n(1293, 89, 1);
            Log.i("JsApiOpenLiteApp", "open liteapp:" + str3 + ",page:" + str2);
            ((a) g.af(a.class)).a(context, bundle, z, new a.AbstractC1459a() {
                /* class com.tencent.mm.plugin.game.luggage.b.z.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.lite.a.a.AbstractC1459a
                public final void dTt() {
                    AppMethodBeat.i(186879);
                    Log.i("JsApiOpenLiteApp", "JsApiOpenLiteApp success");
                    aVar.i(null, null);
                    AppMethodBeat.o(186879);
                }

                @Override // com.tencent.mm.plugin.lite.a.a.AbstractC1459a
                public final void dTu() {
                    AppMethodBeat.i(186880);
                    Log.i("JsApiOpenLiteApp", "JsApiOpenLiteApp fail");
                    aVar.i("fail", null);
                    AppMethodBeat.o(186880);
                }
            });
            AppMethodBeat.o(186881);
        } catch (JSONException e2) {
            Log.printErrStackTrace("JsApiOpenLiteApp", e2, "", new Object[0]);
            aVar.i("fail", null);
            str2 = str4;
            str3 = "";
            z = false;
        }
    }
}
