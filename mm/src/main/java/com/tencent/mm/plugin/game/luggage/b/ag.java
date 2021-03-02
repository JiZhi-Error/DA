package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class ag extends bs<i> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "setBlackList";
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
        AppMethodBeat.i(186886);
        Log.i("MicroMsg.GameLife.JsApiSetBlackList", "invokeInMM");
        JSONObject Zc = com.tencent.mm.plugin.webview.luggage.c.b.Zc(str);
        if (Zc == null) {
            aVar.i("invalid_params", null);
            AppMethodBeat.o(186886);
            return;
        }
        String optString = Zc.optString("userName");
        Log.i("MicroMsg.GameLife.JsApiSetBlackList", "userName:[%s]", optString);
        if (Util.isNullOrNil(optString)) {
            aVar.i("null_data", null);
            AppMethodBeat.o(186886);
        } else if (!Zc.has("switch")) {
            aVar.i("switch_null", null);
            AppMethodBeat.o(186886);
        } else {
            try {
                boolean z = Zc.getBoolean("switch");
                boolean optBoolean = Zc.optBoolean("associateWxGameAccount", false);
                Log.i("MicroMsg.GameLife.JsApiSetBlackList", "JsApiSetBlackList setBlack:%b,associateWxGameAccount:%b", Boolean.valueOf(z), Boolean.valueOf(optBoolean));
                ((com.tencent.mm.plugin.gamelife.a.b) g.af(com.tencent.mm.plugin.gamelife.a.b.class)).a(optString, z, optBoolean, new b.AbstractC1411b() {
                    /* class com.tencent.mm.plugin.game.luggage.b.ag.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.gamelife.a.b.AbstractC1411b
                    public final void mM(boolean z) {
                        AppMethodBeat.i(186885);
                        if (z) {
                            aVar.i(null, null);
                            AppMethodBeat.o(186885);
                            return;
                        }
                        aVar.i("setBlackList error", null);
                        AppMethodBeat.o(186885);
                    }
                });
                AppMethodBeat.o(186886);
            } catch (JSONException e2) {
                aVar.i("switch_error", null);
                AppMethodBeat.o(186886);
            }
        }
    }
}
