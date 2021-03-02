package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aaz;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends bs<i> {
    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<i>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
        JSONObject jSONObject;
        AppMethodBeat.i(83053);
        Log.i("MicroMsg.JsApiBatchUpdateWepkg", "invokeInMM");
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiBatchUpdateWepkg", "data is null");
            aVar.i("fail", null);
            AppMethodBeat.o(83053);
            return;
        }
        String optString = jSONObject.optString("pkgIdList");
        if (!Util.isNullOrNil(optString)) {
            try {
                JSONArray jSONArray = new JSONArray(optString);
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        arrayList.add(jSONArray.optString(i2));
                    }
                    if (!Util.isNullOrNil(arrayList)) {
                        aaz aaz = new aaz();
                        aaz.eif.dDe = 8;
                        aaz.eif.scene = 0;
                        aaz.eif.eil = arrayList;
                        EventCenter.instance.publish(aaz);
                        aVar.i(null, null);
                        AppMethodBeat.o(83053);
                        return;
                    }
                }
            } catch (JSONException e3) {
                Log.e("MicroMsg.JsApiBatchUpdateWepkg", "data is not json");
            }
        }
        aVar.i("fail", null);
        AppMethodBeat.o(83053);
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "batchUpdateWepkg";
    }
}
