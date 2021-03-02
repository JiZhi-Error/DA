package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bi extends ab<d> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getPermissionBytes";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* synthetic */ String a(d dVar, JSONObject jSONObject) {
        int i2 = 0;
        AppMethodBeat.i(147133);
        d dVar2 = dVar;
        Log.i("MicroMsg.JsApiGetPermissionBytes", "invoke jsapi: %s", NAME);
        if (jSONObject == null) {
            Log.i("MicroMsg.JsApiGetPermissionBytes", "fail:data is nil");
            String h2 = h("fail:data is nil", null);
            AppMethodBeat.o(147133);
            return h2;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("indexes");
        if (optJSONArray == null) {
            Log.i("MicroMsg.JsApiGetPermissionBytes", "fail:indexes is nil");
            String h3 = h("fail:indexes is nil", null);
            AppMethodBeat.o(147133);
            return h3;
        }
        com.tencent.luggage.sdk.d.d NP = dVar2.NP();
        if (NP == null) {
            Log.i("MicroMsg.JsApiGetPermissionBytes", "fail:runtime is nil");
            String h4 = h("fail:runtime is nil", null);
            AppMethodBeat.o(147133);
            return h4;
        }
        com.tencent.mm.plugin.appbrand.permission.d dVar3 = NP.cCn;
        if (dVar3 == null) {
            Log.e("MicroMsg.JsApiGetPermissionBytes", "invoke failed, NULL permissionController with appId:%s", NP.mAppId);
            String h5 = h("fail:internal error", null);
            AppMethodBeat.o(147133);
            return h5;
        }
        byte[] a2 = dVar3.a(dVar2, (b[]) null);
        if (a2 == null || a2.length <= 0) {
            Log.i("MicroMsg.JsApiGetPermissionBytes", "fail:ctrlBytes is empty");
            String h6 = h("fail:ctrlBytes is empty", null);
            AppMethodBeat.o(147133);
            return h6;
        }
        JSONArray jSONArray = new JSONArray();
        if (optJSONArray.length() == 0) {
            while (i2 < a2.length) {
                jSONArray.put(dVar3.H(a2, i2));
                i2++;
            }
        } else {
            while (i2 < optJSONArray.length()) {
                jSONArray.put(dVar3.H(a2, optJSONArray.optInt(i2, -1)));
                i2++;
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("permissionBytes", jSONArray);
        Log.i("MicroMsg.JsApiGetPermissionBytes", "invoke getPermissionBytes ok");
        String n = n("ok", hashMap);
        AppMethodBeat.o(147133);
        return n;
    }
}
