package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.gamelife.a.a;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import org.json.JSONObject;

public class r extends bs<i> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "initGameLifeContact";
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
        AppMethodBeat.i(186871);
        Log.i("MicroMsg.GameLife.JsApiInitGameLifeContact", "invokeInMM");
        JSONObject Zc = com.tencent.mm.plugin.webview.luggage.c.b.Zc(str);
        if (Zc == null) {
            aVar.i("invalid_params", null);
            AppMethodBeat.o(186871);
            return;
        }
        String optString = Zc.optString("userName");
        Log.i("MicroMsg.GameLife.JsApiInitGameLifeContact", "userName:[%s]", optString);
        if (Util.isNullOrNil(optString)) {
            aVar.i("null_data", null);
            AppMethodBeat.o(186871);
            return;
        }
        ((com.tencent.mm.plugin.gamelife.a.b) g.af(com.tencent.mm.plugin.gamelife.a.b.class)).a(optString, new b.c() {
            /* class com.tencent.mm.plugin.game.luggage.b.r.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.gamelife.a.b.c
            public final void aj(Map<String, a> map) {
                AppMethodBeat.i(186870);
                aVar.i(null, null);
                AppMethodBeat.o(186870);
            }
        });
        AppMethodBeat.o(186871);
    }
}
