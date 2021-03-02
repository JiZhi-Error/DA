package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class aj extends bs<i> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "startGameLifeConversation";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<i>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
        AppMethodBeat.i(186888);
        Log.i("MicroMsg.GameLife.JsApiStartGameLifeConversation", "invokeInMM");
        JSONObject Zc = com.tencent.mm.plugin.webview.luggage.c.b.Zc(str);
        if (Zc == null) {
            aVar.i("invalid_params", null);
            AppMethodBeat.o(186888);
            return;
        }
        String optString = Zc.optString("fromUserName");
        String optString2 = Zc.optString("toUserName");
        int optInt = Zc.optInt("scene", 0);
        String optString3 = Zc.optString("ext_info");
        Log.i("MicroMsg.GameLife.JsApiStartGameLifeConversation", "fromUserName:[%s] toUserName:[%s], scene:[%d], extInfo:[%s]", optString, optString2, Integer.valueOf(optInt), optString3);
        if (Util.isNullOrNil(optString) || Util.isNullOrNil(optString2)) {
            aVar.i("null_data", null);
            AppMethodBeat.o(186888);
            return;
        }
        ((PluginGameLife) g.ah(PluginGameLife.class)).enterChattingUI(context, optString, optString2, optInt, Util.isNullOrNil(optString3) ? null : new com.tencent.mm.bw.b(optString3.getBytes()));
        aVar.i(null, null);
        AppMethodBeat.o(186888);
    }
}
