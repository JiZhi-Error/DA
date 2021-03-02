package com.tencent.mm.plugin.appbrand.jsapi.o.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.c.a;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d {
    public static final int CTRL_INDEX = 273;
    public static final String NAME = "operateUploadTask";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(179549);
        a(fVar, jSONObject, i2, fVar.getJsRuntime());
        AppMethodBeat.o(179549);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2, o oVar) {
        AppMethodBeat.i(207099);
        Log.d("MicroMsg.JsApiOperateUploadTask", "JsApiOperateUploadTask");
        if (jSONObject == null) {
            fVar.i(i2, h("fail:data is null", null));
            Log.e("MicroMsg.JsApiOperateUploadTask", "data is null");
            AppMethodBeat.o(207099);
            return;
        }
        String optString = jSONObject.optString("uploadTaskId");
        if (Util.isNullOrNil(optString)) {
            Log.e("MicroMsg.JsApiOperateUploadTask", "uploadTaskId is null");
            fVar.i(i2, h("fail:uploadTaskId is null or nil", null));
            AppMethodBeat.o(207099);
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (Util.isNullOrNil(optString2)) {
            Log.e("MicroMsg.JsApiOperateUploadTask", "operationType is null");
            fVar.i(i2, h("fail:operationType is null or nil", null));
            AppMethodBeat.o(207099);
        } else if (optString2.equals("abort")) {
            g adb = i.bPC().adb(fVar.getAppId());
            if (adb == null) {
                Log.i("MicroMsg.JsApiOperateUploadTask", "upload is null");
                fVar.i(i2, h("fail:no task", null));
                AppMethodBeat.o(207099);
                return;
            }
            h ada = adb.ada(optString);
            if (ada == null) {
                Log.i("MicroMsg.JsApiOperateUploadTask", "uploadInfo is null %s", optString);
                fVar.i(i2, h("fail:no task", null));
                AppMethodBeat.o(207099);
                return;
            }
            adb.a(ada);
            fVar.i(i2, h("ok", null));
            HashMap hashMap = new HashMap();
            hashMap.put("uploadTaskId", String.valueOf(optString));
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            new a.C0693a().h(fVar).Zh(new JSONObject(hashMap).toString()).a(oVar);
            Log.d("MicroMsg.JsApiOperateUploadTask", "abortTask finish %s", optString);
            AppMethodBeat.o(207099);
        } else {
            fVar.i(i2, h("fail:unknown operationType", null));
            AppMethodBeat.o(207099);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.p
    public final boolean bEi() {
        return true;
    }
}
