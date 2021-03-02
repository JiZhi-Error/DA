package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import org.json.JSONObject;

public class k extends d<com.tencent.mm.plugin.appbrand.jsapi.k> {
    public static final int CTRL_INDEX = 98;
    public static final String NAME = "removeStorage";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.k kVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(147270);
        com.tencent.mm.plugin.appbrand.jsapi.k kVar2 = kVar;
        String optString = jSONObject.optString("key");
        int optInt = jSONObject.optInt("storageId", 0);
        if (Util.isNullOrNil(optString)) {
            kVar2.i(i2, h("fail", null));
            AppMethodBeat.o(147270);
        } else if (t.vU(optInt)) {
            kVar2.i(i2, h("fail:nonexistent storage space", null));
            AppMethodBeat.o(147270);
        } else {
            AppBrandRuntime runtime = kVar2.getRuntime();
            if (runtime == null || runtime.OT() == null) {
                kVar2.i(i2, h("fail:internal error", null));
                AppMethodBeat.o(147270);
                return;
            }
            int i3 = runtime.OT().leF;
            if (i3 == 2) {
                b(kVar2, optString, optInt);
            } else if (i3 == 3) {
                a(kVar2, optString, optInt);
                b(kVar2, optString, optInt);
            } else {
                a(kVar2, optString, optInt);
            }
            kVar2.i(i2, h("ok", null));
            AppMethodBeat.o(147270);
        }
    }

    private void a(com.tencent.mm.plugin.appbrand.jsapi.k kVar, String str, int i2) {
        AppMethodBeat.i(147267);
        JsApiRemoveStorageTask jsApiRemoveStorageTask = new JsApiRemoveStorageTask();
        jsApiRemoveStorageTask.appId = C(kVar);
        jsApiRemoveStorageTask.mtl = i2;
        jsApiRemoveStorageTask.key = str;
        AppBrandMainProcessService.a(jsApiRemoveStorageTask);
        AppMethodBeat.o(147267);
    }

    private void b(final com.tencent.mm.plugin.appbrand.jsapi.k kVar, final String str, final int i2) {
        AppMethodBeat.i(147268);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.storage.k.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(147266);
                ((a) e.M(a.class)).dD(kVar.getAppId()).m(i2, k.this.C(kVar), str);
                AppMethodBeat.o(147266);
            }
        }, "JsApiRemoveStorage");
        AppMethodBeat.o(147268);
    }

    /* access modifiers changed from: protected */
    public String C(f fVar) {
        AppMethodBeat.i(147269);
        String appId = fVar.getAppId();
        AppMethodBeat.o(147269);
        return appId;
    }
}
