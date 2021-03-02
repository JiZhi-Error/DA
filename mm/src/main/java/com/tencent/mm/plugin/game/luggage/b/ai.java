package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g.f;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class ai extends bs<i> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "setGameTab";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<i>.a aVar) {
        AppMethodBeat.i(186887);
        Log.i("MicroMsg.JsApiSetGameTab", "invokeInOwn");
        JSONObject jSONObject = aVar.ctb.csi;
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiSetGameTab", "data is null");
            aVar.c("null_data", null);
            AppMethodBeat.o(186887);
            return;
        }
        f fVar = aVar.cta.xyT;
        if (fVar == null) {
            Log.e("MicroMsg.JsApiSetGameTab", "is not tab page");
            aVar.c("not_tab", null);
            AppMethodBeat.o(186887);
            return;
        }
        if (jSONObject.has("isShowTab")) {
            int optInt = jSONObject.optInt("isShowTab", -1);
            Log.i("MicroMsg.JsApiSetGameTab", "isShowTab:%d", Integer.valueOf(optInt));
            if (fVar.xxS != null) {
                fVar.xxS.Oa(optInt);
            }
        }
        if (jSONObject.has("isSwitchEnable")) {
            int optInt2 = jSONObject.optInt("isSwitchEnable", -1);
            Log.i("MicroMsg.JsApiSetGameTab", "isSwitchEnable:%d", Integer.valueOf(optInt2));
            if (fVar.xxS != null) {
                fVar.xxS.Ob(optInt2);
            }
        }
        aVar.c("", null);
        AppMethodBeat.o(186887);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
