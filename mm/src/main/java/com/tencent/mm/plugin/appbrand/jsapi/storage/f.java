package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.appstorage.s;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.HashMap;
import org.json.JSONObject;

public class f extends d<k> {
    public static final int CTRL_INDEX = 17;
    public static final String NAME = "getStorage";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(147243);
        final k kVar2 = kVar;
        final long currentTimeMillis = System.currentTimeMillis();
        final String optString = jSONObject.optString("key");
        final int optInt = jSONObject.optInt("storageId", 0);
        if (t.vU(optInt)) {
            kVar2.i(i2, h("fail:nonexistent storage space", null));
            AppMethodBeat.o(147243);
        } else if (Util.isNullOrNil(optString)) {
            kVar2.i(i2, h("fail:key is empty", null));
            AppMethodBeat.o(147243);
        } else {
            final String C = C(kVar2);
            if (Util.isNullOrNil(C)) {
                kVar2.i(i2, h("fail:appID is empty", null));
                AppMethodBeat.o(147243);
                return;
            }
            final long currentTimeMillis2 = System.currentTimeMillis();
            l OT = kVar2.getRuntime().OT();
            if (OT == null) {
                Log.e("MicroMsg.JsApiGetStorage", "invoke with appId[%s] callbackId[%d], NULL sysConfig", kVar2.getAppId(), Integer.valueOf(i2));
                kVar2.i(i2, h("fail:internal error", null));
                AppMethodBeat.o(147243);
            } else if (OT.leF != 1) {
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.storage.f.AnonymousClass1 */

                    public final void run() {
                        String str = null;
                        AppMethodBeat.i(147240);
                        Object[] l = ((a) e.M(a.class)).dD(kVar2.getAppId()).l(optInt, C, optString);
                        p.a aVar = (p.a) l[0];
                        String str2 = aVar == p.a.NONE ? (String) l[1] : null;
                        if (aVar == p.a.NONE) {
                            str = (String) l[2];
                        }
                        f.a(f.this, str2 == null ? "fail:data not found" : "ok", str2, str, kVar2, i2);
                        f.a(2, t.cF(optString, str2), currentTimeMillis2, kVar2);
                        AppMethodBeat.o(147240);
                    }
                }, "JsApiGetStorage");
                AppMethodBeat.o(147243);
            } else {
                final JsApiGetStorageTask jsApiGetStorageTask = new JsApiGetStorageTask();
                jsApiGetStorageTask.appId = C;
                jsApiGetStorageTask.key = optString;
                jsApiGetStorageTask.mtl = optInt;
                jsApiGetStorageTask.lyv = new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.storage.f.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(147241);
                        f.a(f.this, jsApiGetStorageTask.value == null ? "fail:data not found" : "ok", jsApiGetStorageTask.value, jsApiGetStorageTask.type, kVar2, i2);
                        f.a(1, t.cF(optString, jsApiGetStorageTask.value), currentTimeMillis2, kVar2);
                        jsApiGetStorageTask.bDK();
                        Log.i("MicroMsg.JsApiGetStorage", "getStorage: %s, time: %d", jsApiGetStorageTask.key, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.o(147241);
                    }
                };
                jsApiGetStorageTask.bDJ();
                AppBrandMainProcessService.a(jsApiGetStorageTask);
                AppMethodBeat.o(147243);
            }
        }
    }

    /* access modifiers changed from: protected */
    public String C(com.tencent.mm.plugin.appbrand.jsapi.f fVar) {
        AppMethodBeat.i(147242);
        String appId = fVar.getAppId();
        AppMethodBeat.o(147242);
        return appId;
    }

    static /* synthetic */ void a(f fVar, String str, String str2, String str3, com.tencent.mm.plugin.appbrand.jsapi.f fVar2, int i2) {
        AppMethodBeat.i(147244);
        HashMap hashMap = new HashMap();
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("data", str2);
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("dataType", str3);
        fVar2.i(i2, fVar.n(str, hashMap));
        AppMethodBeat.o(147244);
    }

    static /* synthetic */ void a(int i2, int i3, long j2, k kVar) {
        AppMethodBeat.i(147245);
        s.a(i2, 2, i3, 1, System.currentTimeMillis() - j2, kVar);
        AppMethodBeat.o(147245);
    }
}
