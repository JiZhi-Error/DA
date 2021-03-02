package com.tencent.mm.plugin.appbrand.jsapi.o.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.a;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.plugin.appbrand.s.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d {
    public static final int CTRL_INDEX = 270;
    public static final String NAME = "operateDownloadTask";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(179519);
        a(fVar, jSONObject, i2, fVar.getJsRuntime());
        AppMethodBeat.o(179519);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2, o oVar) {
        AppMethodBeat.i(207095);
        Log.d("MicroMsg.JsApiOperateDownloadTask", "JsApiOperateDownloadTask");
        if (jSONObject == null) {
            fVar.i(i2, h("fail:data is null", null));
            Log.e("MicroMsg.JsApiOperateDownloadTask", "data is null");
            AppMethodBeat.o(207095);
            return;
        }
        String optString = jSONObject.optString("downloadTaskId");
        if (Util.isNullOrNil(optString)) {
            Log.e("MicroMsg.JsApiOperateDownloadTask", "downloadTaskId is null");
            fVar.i(i2, h("fail:downloadTaskId is null or nil", null));
            AppMethodBeat.o(207095);
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (Util.isNullOrNil(optString2)) {
            Log.e("MicroMsg.JsApiOperateDownloadTask", "operationType is null");
            fVar.i(i2, h("fail:operationType is null or nil", null));
            AppMethodBeat.o(207095);
        } else if (optString2.equals("abort")) {
            b acV = c.bPx().acV(fVar.getAppId());
            if (acV == null) {
                fVar.i(i2, h("fail:no task", null));
                Log.w("MicroMsg.JsApiOperateDownloadTask", "download is null");
                AppMethodBeat.o(207095);
                return;
            }
            com.tencent.mm.plugin.appbrand.s.a.b acS = acV.acS(optString);
            if (acS == null) {
                fVar.i(i2, h("fail:no task", null));
                Log.w("MicroMsg.JsApiOperateDownloadTask", "downloadWorker is null %s", optString);
                AppMethodBeat.o(207095);
                return;
            }
            acV.a(acS);
            fVar.i(i2, h("ok", null));
            HashMap hashMap = new HashMap();
            hashMap.put("downloadTaskId", String.valueOf(optString));
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            new a.C0691a().h(fVar).Zh(new JSONObject(hashMap).toString()).a(oVar);
            Log.d("MicroMsg.JsApiOperateDownloadTask", "abortTask finish %s", optString);
            AppMethodBeat.o(207095);
        } else {
            fVar.i(i2, h("fail:unknown operationType", null));
            AppMethodBeat.o(207095);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.p
    public final boolean bEi() {
        return true;
    }
}
