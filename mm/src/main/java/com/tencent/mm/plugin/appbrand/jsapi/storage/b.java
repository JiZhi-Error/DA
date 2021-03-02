package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import org.json.JSONObject;

public final class b extends ab<k> {
    public static final int CTRL_INDEX = 18;
    public static final String NAME = "clearStorageSync";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* synthetic */ String a(k kVar, JSONObject jSONObject) {
        AppMethodBeat.i(147233);
        k kVar2 = kVar;
        int i2 = kVar2.getRuntime().OT().leF;
        int optInt = jSONObject.optInt("storageId", 0);
        if (t.vU(optInt)) {
            String h2 = h("fail:nonexistent storage space", null);
            AppMethodBeat.o(147233);
            return h2;
        } else if (i2 == 2) {
            String c2 = c(kVar2, optInt);
            AppMethodBeat.o(147233);
            return c2;
        } else if (i2 == 3) {
            b(kVar2, optInt);
            String c3 = c(kVar2, optInt);
            AppMethodBeat.o(147233);
            return c3;
        } else {
            String b2 = b(kVar2, optInt);
            AppMethodBeat.o(147233);
            return b2;
        }
    }

    private String b(k kVar, int i2) {
        AppMethodBeat.i(147231);
        JsApiClearStorageTask jsApiClearStorageTask = new JsApiClearStorageTask();
        jsApiClearStorageTask.appId = kVar.getAppId();
        jsApiClearStorageTask.mtl = i2;
        AppBrandMainProcessService.b(jsApiClearStorageTask);
        String h2 = h("ok", null);
        AppMethodBeat.o(147231);
        return h2;
    }

    private String c(k kVar, int i2) {
        AppMethodBeat.i(147232);
        ((a) e.M(a.class)).dD(kVar.getAppId()).Y(i2, kVar.getAppId());
        String h2 = h("ok", null);
        AppMethodBeat.o(147232);
        return h2;
    }
}
