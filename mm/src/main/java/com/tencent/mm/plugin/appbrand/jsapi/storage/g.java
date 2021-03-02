package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.s;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class g extends d<k> {
    public static final int CTRL_INDEX = 113;
    public static final String NAME = "getStorageInfo";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(147249);
        k kVar2 = kVar;
        final int optInt = jSONObject.optInt("storageId", 0);
        if (t.vU(optInt)) {
            kVar2.i(i2, h("fail:nonexistent storage space", null));
            AppMethodBeat.o(147249);
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final WeakReference weakReference = new WeakReference(kVar2);
        if (kVar2.getRuntime().OT().leF != 1) {
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.storage.g.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(147246);
                    k kVar = (k) weakReference.get();
                    if (kVar == null) {
                        AppMethodBeat.o(147246);
                        return;
                    }
                    Object[] Z = ((a) e.M(a.class)).dD(kVar.getAppId()).Z(optInt, kVar.getAppId());
                    List list = (List) Z[0];
                    int ceil = (int) Math.ceil(((Integer) Z[1]).doubleValue() / 1000.0d);
                    g.a(g.this, list, ceil, (int) Math.ceil(((Integer) Z[2]).doubleValue() / 1000.0d), kVar, i2);
                    g.a(2, list, ceil * 1000, currentTimeMillis, kVar);
                    AppMethodBeat.o(147246);
                }
            }, "JsApiGetStorageInfo");
            AppMethodBeat.o(147249);
            return;
        }
        final JsApiGetStorageInfoTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
        jsApiGetStorageInfoTask.appId = C(kVar2);
        jsApiGetStorageInfoTask.mtl = optInt;
        jsApiGetStorageInfoTask.lyv = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.storage.g.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(147247);
                jsApiGetStorageInfoTask.bDK();
                k kVar = (k) weakReference.get();
                if (kVar == null) {
                    AppMethodBeat.o(147247);
                    return;
                }
                g.a(g.this, jsApiGetStorageInfoTask.mtq, jsApiGetStorageInfoTask.size, jsApiGetStorageInfoTask.limit, kVar, i2);
                g.a(1, jsApiGetStorageInfoTask.mtq, jsApiGetStorageInfoTask.size * 1000, currentTimeMillis, kVar);
                jsApiGetStorageInfoTask.bDK();
                AppMethodBeat.o(147247);
            }
        };
        jsApiGetStorageInfoTask.bDJ();
        AppBrandMainProcessService.a(jsApiGetStorageInfoTask);
        AppMethodBeat.o(147249);
    }

    /* access modifiers changed from: protected */
    public String C(f fVar) {
        AppMethodBeat.i(147248);
        String appId = fVar.getAppId();
        AppMethodBeat.o(147248);
        return appId;
    }

    static /* synthetic */ void a(g gVar, List list, int i2, int i3, f fVar, int i4) {
        AppMethodBeat.i(229906);
        HashMap hashMap = new HashMap();
        hashMap.put("keys", list);
        hashMap.put("currentSize", Integer.valueOf(i2));
        hashMap.put("limitSize", Integer.valueOf(i3));
        fVar.i(i4, gVar.n("ok", hashMap));
        AppMethodBeat.o(229906);
    }

    static /* synthetic */ void a(int i2, List list, int i3, long j2, k kVar) {
        int size;
        AppMethodBeat.i(229907);
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        s.a(i2, 3, i3, size, System.currentTimeMillis() - j2, kVar);
        AppMethodBeat.o(229907);
    }
}
