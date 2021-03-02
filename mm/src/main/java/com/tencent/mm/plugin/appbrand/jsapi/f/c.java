package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends d<com.tencent.mm.plugin.appbrand.service.c> {
    public static final int CTRL_INDEX = 903;
    public static final String NAME = "startHandoff";
    private static int jjN = -1;
    private static int jjS = 0;
    private static boolean kDf = false;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(226846);
        com.tencent.mm.plugin.appbrand.service.c cVar2 = cVar;
        Log.i("MicroMsg.JsApiStartHandoff", "invoke startHandoff");
        HashMap hashMap = new HashMap();
        int l = a.l("MicroMsg.JsApiStartHandoff", cVar2.getAppId(), cVar2.getRuntime().NA());
        if (l != 0) {
            hashMap.put("errCode", Integer.valueOf(l));
            if (l < a.lWg.length && l > 1) {
                a.ad(cVar2.getContext(), cVar2.getContext().getString(a.lWg[l]));
            }
        } else {
            String optString = jSONObject.optString("path", "");
            int optInt = jSONObject.optInt("actionId", 0);
            if (!(optInt == 1 || optInt == 2)) {
                Log.e("MicroMsg.JsApiStartHandoff", "  actionId from forehand is wrong!! it is not 1 or 2");
            }
            cVar2.getRuntime().bsq().aK(optString, optInt + 2);
            a.dQ(cVar2.getContext());
        }
        switch (l) {
            case 0:
                cVar2.i(i2, h("ok", null));
                AppMethodBeat.o(226846);
                return;
            case 1:
            default:
                hashMap.put("errCode", 0);
                cVar2.i(i2, n("fail:unknown reason", hashMap));
                AppMethodBeat.o(226846);
                return;
            case 2:
                cVar2.i(i2, n("fail:invalid login", hashMap));
                AppMethodBeat.o(226846);
                return;
            case 3:
                cVar2.i(i2, n("fail:low version", hashMap));
                AppMethodBeat.o(226846);
                return;
            case 4:
                cVar2.i(i2, n("fail:empty xclient data or pc not supported", hashMap));
                AppMethodBeat.o(226846);
                return;
        }
    }
}
