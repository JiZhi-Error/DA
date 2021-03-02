package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.thread.ThreadPool;
import org.json.JSONObject;

public final class a extends d<k> {
    public static final int CTRL_INDEX = 18;
    public static final String NAME = "clearStorage";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(147230);
        k kVar2 = kVar;
        int i3 = kVar2.getRuntime().OT().leF;
        int optInt = jSONObject.optInt("storageId", 0);
        if (t.vU(optInt)) {
            kVar2.i(i2, h("fail:nonexistent storage space", null));
            AppMethodBeat.o(147230);
            return;
        }
        if (i3 == 2) {
            a(kVar2, optInt);
        } else {
            if (i3 == 3) {
                a(kVar2, optInt);
            }
            JsApiClearStorageTask jsApiClearStorageTask = new JsApiClearStorageTask();
            jsApiClearStorageTask.appId = kVar2.getAppId();
            jsApiClearStorageTask.mtl = optInt;
            AppBrandMainProcessService.a(jsApiClearStorageTask);
        }
        kVar2.i(i2, h("ok", null));
        AppMethodBeat.o(147230);
    }

    private void a(final k kVar, final int i2) {
        AppMethodBeat.i(147229);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.storage.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(147228);
                ((com.tencent.luggage.sdk.customize.a) e.M(com.tencent.luggage.sdk.customize.a.class)).dD(kVar.getAppId()).Y(i2, kVar.getAppId());
                AppMethodBeat.o(147228);
            }
        }, "JsApiClearStorage");
        AppMethodBeat.o(147229);
    }
}
