package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.f.h;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aaz;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.wepkg.event.DownloadBigPkgCompleteNotify;
import com.tencent.mm.plugin.wepkg.event.c;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.protocal.protobuf.eya;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class q extends br<a> {
    private com.tencent.mm.plugin.wepkg.event.a xwU;

    static /* synthetic */ JSONObject azG(String str) {
        AppMethodBeat.i(186869);
        JSONObject azE = azE(str);
        AppMethodBeat.o(186869);
        return azE;
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "getWepkgFileList";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<a>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, final br.a aVar) {
        AppMethodBeat.i(186865);
        Log.i("MicroMsg.JsApiGetWepkgFileList", "invokeInMM");
        JSONObject Zc = com.tencent.mm.plugin.webview.luggage.c.b.Zc(str);
        if (Zc == null) {
            aVar.i("invalid_params", null);
            AppMethodBeat.o(186865);
            return;
        }
        final String optString = Zc.optString("wepkgId");
        final int optInt = Zc.optInt("loadType", 0);
        Log.i("MicroMsg.JsApiGetWepkgFileList", "wepkgId:[%s] loadType:[%d]", optString, Integer.valueOf(optInt));
        if (Util.isNullOrNil(optString)) {
            aVar.i("null_data", null);
            AppMethodBeat.o(186865);
            return;
        }
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.game.luggage.b.q.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(186862);
                q.a(q.this, optString, optInt, aVar);
                AppMethodBeat.o(186862);
            }
        });
        AppMethodBeat.o(186865);
    }

    private static JSONObject azE(String str) {
        AppMethodBeat.i(186866);
        JSONObject azF = azF(str);
        if (azF == null) {
            AppMethodBeat.o(186866);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", azF);
        } catch (JSONException e2) {
        }
        AppMethodBeat.o(186866);
        return jSONObject;
    }

    private static JSONObject azF(String str) {
        AppMethodBeat.i(186867);
        WepkgVersion bcI = j.bcI(str);
        if (bcI == null) {
            Log.i("MicroMsg.JsApiGetWepkgFileList", "not exist wepkg[%s]", str);
            AppMethodBeat.o(186867);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", bcI.version);
            jSONObject.put("size", bcI.JNT);
            o oVar = new o(bcI.pkgPath);
            if (!oVar.exists()) {
                AppMethodBeat.o(186867);
                return null;
            }
            eya eya = new g(oVar).JNe;
            if (eya == null) {
                AppMethodBeat.o(186867);
                return null;
            }
            if (eya.Nvh != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator<aod> it = eya.Nvh.iterator();
                while (it.hasNext()) {
                    aod next = it.next();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("rid", next.LzG);
                    jSONObject2.put("size", next.oUq);
                    jSONObject2.put("mimeType", next.LzI);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("fileList", jSONArray);
            }
            AppMethodBeat.o(186867);
            return jSONObject;
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiGetWepkgFileList", "errMsg:%s", e2.getMessage());
        }
    }

    static /* synthetic */ void a(q qVar, final String str, int i2, final br.a aVar) {
        AppMethodBeat.i(186868);
        JSONObject azE = azE(str);
        switch (i2) {
            case 1:
                aVar.i(null, azE);
                AppMethodBeat.o(186868);
                return;
            case 0:
                if (azE != null) {
                    aVar.i(null, azE);
                    AppMethodBeat.o(186868);
                    return;
                }
                break;
        }
        qVar.xwU = new com.tencent.mm.plugin.wepkg.event.a() {
            /* class com.tencent.mm.plugin.game.luggage.b.q.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.wepkg.event.a
            public final void dt(Object obj) {
                AppMethodBeat.i(186863);
                if ((obj instanceof DownloadBigPkgCompleteNotify) && str.equals(((DownloadBigPkgCompleteNotify) obj).hhD)) {
                    c.b(q.this.xwU);
                    aVar.i(null, q.azG(str));
                    h.RTc.bqo("MicroMsg.JsApiGetWepkgFileList");
                }
                AppMethodBeat.o(186863);
            }
        };
        c.a(qVar.xwU);
        h.RTc.a(new Runnable() {
            /* class com.tencent.mm.plugin.game.luggage.b.q.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(186864);
                c.b(q.this.xwU);
                aVar.i("expired", null);
                AppMethodBeat.o(186864);
            }
        }, Util.MILLSECONDS_OF_MINUTE, "MicroMsg.JsApiGetWepkgFileList");
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        aaz aaz = new aaz();
        aaz.eif.dDe = 8;
        aaz.eif.scene = 0;
        aaz.eif.eil = arrayList;
        EventCenter.instance.publish(aaz);
        AppMethodBeat.o(186868);
    }
}
