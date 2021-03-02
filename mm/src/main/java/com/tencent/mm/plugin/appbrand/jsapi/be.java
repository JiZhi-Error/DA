package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class be extends d<c> {
    public static final int CTRL_INDEX = 101;
    public static final String NAME = "getAppConfig";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(45482);
        final c cVar2 = cVar;
        if (jSONObject == null) {
            cVar2.i(i2, h("fail", null));
            Log.e("MicroMsg.JsApiGetAppConfig", "data is null");
            AppMethodBeat.o(45482);
            return;
        }
        String appId = cVar2.getAppId();
        final int optInt = jSONObject.optInt("type", 0);
        Log.i("MicroMsg.JsApiGetAppConfig", "getAppConfig app_id:%s,type:%d", appId, Integer.valueOf(optInt));
        if (optInt <= 0) {
            cVar2.i(i2, h("fail", null));
            Log.e("MicroMsg.JsApiGetAppConfig", "type %d is invalid", Integer.valueOf(optInt));
            AppMethodBeat.o(45482);
            return;
        }
        final JsApiGetAppConfigTask jsApiGetAppConfigTask = new JsApiGetAppConfigTask();
        jsApiGetAppConfigTask.appId = appId;
        jsApiGetAppConfigTask.type = optInt;
        jsApiGetAppConfigTask.scene = cVar2.getRuntime().ON().cyA.scene;
        jsApiGetAppConfigTask.lyv = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.be.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(45481);
                HashMap hashMap = new HashMap();
                hashMap.put("type", new StringBuilder().append(optInt).toString());
                hashMap.put("data", jsApiGetAppConfigTask.value);
                Log.i("MicroMsg.JsApiGetAppConfig", "getAppConfig type:%d,data:\n%s", Integer.valueOf(optInt), jsApiGetAppConfigTask.value);
                if (Util.isNullOrNil(jsApiGetAppConfigTask.value)) {
                    cVar2.i(i2, be.this.h("fail", null));
                } else {
                    cVar2.i(i2, be.this.n("ok", hashMap));
                }
                jsApiGetAppConfigTask.bDK();
                AppMethodBeat.o(45481);
            }
        };
        jsApiGetAppConfigTask.bDJ();
        AppBrandMainProcessService.a(jsApiGetAppConfigTask);
        AppMethodBeat.o(45482);
    }
}
