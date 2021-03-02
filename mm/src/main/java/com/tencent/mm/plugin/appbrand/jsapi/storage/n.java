package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.f.i.h;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.s;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class n extends d<k> {
    public static final int CTRL_INDEX = 16;
    public static final String NAME = "setStorage";
    private a mtw = new a() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.storage.n.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.jsapi.storage.n.a
        public final void a(String str, k kVar, int i2) {
            AppMethodBeat.i(147278);
            kVar.i(i2, n.this.h(str, null));
            AppMethodBeat.o(147278);
        }
    };

    /* access modifiers changed from: package-private */
    public interface a {
        void a(String str, k kVar, int i2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(147285);
        k kVar2 = kVar;
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString("data");
        String optString3 = jSONObject.optString("dataType");
        int optInt = jSONObject.optInt("storageId", 0);
        if (Util.isNullOrNil(optString)) {
            kVar2.i(i2, h("fail:key is empty", null));
            AppMethodBeat.o(147285);
        } else if (t.vU(optInt)) {
            kVar2.i(i2, h("fail:nonexistent storage space", null));
            AppMethodBeat.o(147285);
        } else {
            String e2 = e(kVar2);
            if (Util.isNullOrNil(e2)) {
                kVar2.i(i2, h("fail:appID is empty", null));
                AppMethodBeat.o(147285);
                return;
            }
            l OT = kVar2.getRuntime().OT();
            if (OT == null) {
                Log.e("MicroMsg.JsApiSetStorage", "invoke with appId[%s] callbackId[%d], NULL sysConfig", kVar2.getAppId(), Integer.valueOf(i2));
                kVar2.i(i2, h("fail:internal error", null));
                AppMethodBeat.o(147285);
                return;
            }
            if ((optString2 == null ? 0 : optString2.length()) + optString.length() > ((AppBrandSysConfigLU) OT).czd.lcN) {
                kVar2.i(i2, h("fail:entry size limit reached", null));
                AppMethodBeat.o(147285);
                return;
            }
            int i3 = OT.leF;
            if (i3 == 2) {
                a(kVar2, i2, optInt, optString, optString2, optString3, e2, this.mtw);
                AppMethodBeat.o(147285);
            } else if (i3 == 3) {
                a(kVar2, i2, optInt, optString, optString2, optString3, e2, this.mtw);
                b(kVar2, i2, optInt, optString, optString2, optString3, e2, null);
                AppMethodBeat.o(147285);
            } else {
                b(kVar2, i2, optInt, optString, optString2, optString3, e2, this.mtw);
                AppMethodBeat.o(147285);
            }
        }
    }

    public n() {
        AppMethodBeat.i(147281);
        AppMethodBeat.o(147281);
    }

    private void a(final k kVar, final int i2, final int i3, final String str, final String str2, final String str3, final String str4, final a aVar) {
        AppMethodBeat.i(147282);
        final long currentTimeMillis = System.currentTimeMillis();
        kVar.getRuntime().Q(new h() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.storage.n.AnonymousClass2 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "JsApiSetStorage";
            }

            public final void run() {
                AppMethodBeat.i(147279);
                String a2 = p.a(((com.tencent.luggage.sdk.customize.a) e.M(com.tencent.luggage.sdk.customize.a.class)).dD(kVar.getAppId()).c(i3, str4, str, str2, str3));
                if (aVar != null) {
                    aVar.a(a2, kVar, i2);
                }
                n.b(2, t.cF(str, str2), currentTimeMillis, kVar);
                AppMethodBeat.o(147279);
            }
        });
        AppMethodBeat.o(147282);
    }

    private void b(final k kVar, final int i2, int i3, final String str, final String str2, String str3, String str4, final a aVar) {
        AppMethodBeat.i(147283);
        final long currentTimeMillis = System.currentTimeMillis();
        final JsApiSetStorageTask jsApiSetStorageTask = new JsApiSetStorageTask();
        jsApiSetStorageTask.appId = str4;
        jsApiSetStorageTask.mtl = i3;
        jsApiSetStorageTask.E(str, str2, str3);
        jsApiSetStorageTask.lyv = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.storage.n.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(147280);
                if (aVar != null) {
                    aVar.a(jsApiSetStorageTask.result, kVar, i2);
                }
                n.b(1, t.cF(str, str2), currentTimeMillis, kVar);
                jsApiSetStorageTask.bDK();
                AppMethodBeat.o(147280);
            }
        };
        jsApiSetStorageTask.bDJ();
        AppBrandMainProcessService.a(jsApiSetStorageTask);
        AppMethodBeat.o(147283);
    }

    /* access modifiers changed from: protected */
    public String e(k kVar) {
        AppMethodBeat.i(147284);
        String str = kVar.getRuntime().mAppId;
        AppMethodBeat.o(147284);
        return str;
    }

    static /* synthetic */ void b(int i2, int i3, long j2, k kVar) {
        AppMethodBeat.i(147286);
        s.a(i2, 1, i3, 1, System.currentTimeMillis() - j2, kVar);
        AppMethodBeat.o(147286);
    }
}
