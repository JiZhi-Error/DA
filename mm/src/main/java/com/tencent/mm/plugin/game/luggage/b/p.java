package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.f.h;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.protocal.protobuf.eya;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class p extends br<a> {
    static /* synthetic */ JSONObject y(String str, List list) {
        AppMethodBeat.i(186861);
        JSONObject x = x(str, list);
        AppMethodBeat.o(186861);
        return x;
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "getWepkgFileInfo";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final b<a>.a aVar) {
        AppMethodBeat.i(186859);
        Log.i("MicroMsg.JsApiGetWepkgFileInfo", "invokeInOwn");
        JSONObject jSONObject = aVar.ctb.csi;
        if (jSONObject == null) {
            aVar.c("invalid_params", null);
            AppMethodBeat.o(186859);
            return;
        }
        final String optString = jSONObject.optString("wepkgId");
        JSONArray optJSONArray = jSONObject.optJSONArray("files");
        if (Util.isNullOrNil(optString) || optJSONArray == null || optJSONArray.length() == 0) {
            aVar.c("null_data", null);
            AppMethodBeat.o(186859);
            return;
        }
        Log.i("MicroMsg.JsApiGetWepkgFileInfo", "wepkgId:[%s] files:[%s]", optString, optJSONArray.toString());
        final ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                arrayList.add(optJSONArray.getString(i2));
            } catch (JSONException e2) {
            }
        }
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.game.luggage.b.p.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(186858);
                JSONObject y = p.y(optString, arrayList);
                if (y == null) {
                    aVar.c("fail", null);
                    AppMethodBeat.o(186858);
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("data", y);
                } catch (JSONException e2) {
                }
                aVar.c("", jSONObject);
                AppMethodBeat.o(186858);
            }
        });
        AppMethodBeat.o(186859);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    private static JSONObject x(String str, List list) {
        AppMethodBeat.i(186860);
        WepkgVersion bcI = j.bcI(str);
        if (bcI == null) {
            Log.i("MicroMsg.JsApiGetWepkgFileInfo", "not exist wepkg[%s]", str);
            AppMethodBeat.o(186860);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", bcI.version);
            o oVar = new o(bcI.pkgPath);
            if (!oVar.exists()) {
                AppMethodBeat.o(186860);
                return null;
            }
            g gVar = new g(oVar);
            eya eya = gVar.JNe;
            if (eya == null) {
                AppMethodBeat.o(186860);
                return null;
            }
            if (eya.Nvh != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator<aod> it = eya.Nvh.iterator();
                while (it.hasNext()) {
                    aod next = it.next();
                    if (list.contains(next.LzG)) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("rid", next.LzG);
                        jSONObject2.put("size", next.oUq);
                        jSONObject2.put("mimeType", next.LzI);
                        jSONObject2.put("data", gVar.bcD(next.LzG));
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("fileList", jSONArray);
            }
            AppMethodBeat.o(186860);
            return jSONObject;
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiGetWepkgFileInfo", "errMsg:%s", e2.getMessage());
        }
    }
}
