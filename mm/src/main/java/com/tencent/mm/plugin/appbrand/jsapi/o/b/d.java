package com.tencent.mm.plugin.appbrand.jsapi.o.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.b.a;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d {
    public static final int CTRL_INDEX = 243;
    public static final String NAME = "operateRequestTask";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(179534);
        a(fVar, jSONObject, i2, fVar.getJsRuntime());
        AppMethodBeat.o(179534);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2, o oVar) {
        boolean acW;
        AppMethodBeat.i(207098);
        Log.d("MicroMsg.JsApiOperateRequestTask", "JsApiOperateRequestTask");
        if (jSONObject == null) {
            fVar.i(i2, h("fail:data is null", null));
            Log.e("MicroMsg.JsApiOperateRequestTask", "data is null");
            AppMethodBeat.o(207098);
            return;
        }
        String optString = jSONObject.optString("requestTaskId");
        if (Util.isNullOrNil(optString)) {
            Log.e("MicroMsg.JsApiOperateRequestTask", "requestTaskId is null");
            fVar.i(i2, h("fail:requestTaskId is null or nil", null));
            AppMethodBeat.o(207098);
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (Util.isNullOrNil(optString2)) {
            Log.e("MicroMsg.JsApiOperateRequestTask", "operationType is null");
            fVar.i(i2, h("fail:operationType is null or nil", null));
            AppMethodBeat.o(207098);
        } else if (optString2.equals("abort")) {
            com.tencent.mm.plugin.appbrand.s.d acZ = com.tencent.mm.plugin.appbrand.s.f.bPA().acZ(fVar.getAppId());
            if (acZ == null) {
                fVar.i(i2, h("fail:no task", null));
                Log.w("MicroMsg.JsApiOperateRequestTask", "request is null");
                AppMethodBeat.o(207098);
                return;
            }
            e acY = acZ.acY(optString);
            if (acY != null) {
                acZ.b(acY);
                acW = true;
            } else {
                acW = acZ.acW(optString);
            }
            if (!acW) {
                fVar.i(i2, h("fail:no task", null));
                Log.w("MicroMsg.JsApiOperateRequestTask", "requestInfo is null requestTaskId:%s, appId:%s", optString, fVar.getAppId());
                AppMethodBeat.o(207098);
                return;
            }
            fVar.i(i2, h("ok", null));
            HashMap hashMap = new HashMap();
            hashMap.put("requestTaskId", optString);
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            new a.C0692a().h(fVar).Zh(new JSONObject(hashMap).toString()).a(oVar);
            Log.i("MicroMsg.JsApiOperateRequestTask", "abortTask finish requestId:%s, appId:%s", optString, fVar.getAppId());
            AppMethodBeat.o(207098);
        } else {
            fVar.i(i2, h("fail:unknown operationType", null));
            AppMethodBeat.o(207098);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.p
    public final boolean bEi() {
        return true;
    }
}
