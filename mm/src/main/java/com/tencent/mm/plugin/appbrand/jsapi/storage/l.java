package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class l extends ab<k> {
    public static final int CTRL_INDEX = 98;
    public static final String NAME = "removeStorageSync";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* synthetic */ String a(k kVar, JSONObject jSONObject) {
        AppMethodBeat.i(147272);
        k kVar2 = kVar;
        String optString = jSONObject.optString("key");
        int optInt = jSONObject.optInt("storageId", 0);
        if (Util.isNullOrNil(optString)) {
            String h2 = h("fail", null);
            AppMethodBeat.o(147272);
            return h2;
        } else if (t.vU(optInt)) {
            String h3 = h("fail:nonexistent storage space", null);
            AppMethodBeat.o(147272);
            return h3;
        } else if (Util.isNullOrNil(kVar2.getAppId())) {
            String h4 = h("fail:appID is empty", null);
            AppMethodBeat.o(147272);
            return h4;
        } else {
            int i2 = kVar2.getRuntime().OT().leF;
            if (i2 == 2) {
                b(kVar2, optString, optInt);
            } else {
                if (i2 == 3) {
                    b(kVar2, optString, optInt);
                }
                JsApiRemoveStorageTask jsApiRemoveStorageTask = new JsApiRemoveStorageTask();
                jsApiRemoveStorageTask.appId = kVar2.getAppId();
                jsApiRemoveStorageTask.mtl = optInt;
                jsApiRemoveStorageTask.key = optString;
                AppBrandMainProcessService.b(jsApiRemoveStorageTask);
            }
            String h5 = h("ok", null);
            AppMethodBeat.o(147272);
            return h5;
        }
    }

    private static void b(k kVar, String str, int i2) {
        AppMethodBeat.i(147271);
        ((a) e.M(a.class)).dD(kVar.getAppId()).m(i2, kVar.getAppId(), str);
        AppMethodBeat.o(147271);
    }
}
