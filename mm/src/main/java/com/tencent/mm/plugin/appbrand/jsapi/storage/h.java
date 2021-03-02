package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.text.TextUtils;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.s;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public final class h extends ab<k> {
    public static final int CTRL_INDEX = 113;
    public static final String NAME = "getStorageInfoSync";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* synthetic */ String a(k kVar, JSONObject jSONObject) {
        int i2;
        int i3;
        int i4;
        ArrayList<String> arrayList;
        int size;
        AppMethodBeat.i(147252);
        k kVar2 = kVar;
        int optInt = jSONObject.optInt("storageId", 0);
        if (t.vU(optInt)) {
            String h2 = h("fail:nonexistent storage space", null);
            AppMethodBeat.o(147252);
            return h2;
        } else if (!kVar2.isRunning() || TextUtils.isEmpty(kVar2.getAppId())) {
            Log.e("Luggage.FULL.JsApiGetStorageInfoSync", "invoke with storageId(%s) but service destroyed", Integer.valueOf(optInt));
            AppMethodBeat.o(147252);
            return "fail:internal error";
        } else {
            HashMap hashMap = new HashMap();
            long currentTimeMillis = System.currentTimeMillis();
            if (kVar2.getRuntime().OT().leF != 1) {
                Object[] Z = ((a) e.M(a.class)).dD(kVar2.getAppId()).Z(optInt, kVar2.getAppId());
                ArrayList<String> arrayList2 = (ArrayList) Z[0];
                i3 = (int) Math.ceil(((Integer) Z[1]).doubleValue() / 1000.0d);
                i4 = (int) Math.ceil(((Integer) Z[2]).doubleValue() / 1000.0d);
                i2 = 2;
                arrayList = arrayList2;
            } else {
                i2 = 1;
                JsApiGetStorageInfoTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
                jsApiGetStorageInfoTask.appId = kVar2.getAppId();
                jsApiGetStorageInfoTask.mtl = optInt;
                AppBrandMainProcessService.b(jsApiGetStorageInfoTask);
                ArrayList<String> arrayList3 = jsApiGetStorageInfoTask.mtq;
                i3 = jsApiGetStorageInfoTask.size;
                i4 = jsApiGetStorageInfoTask.limit;
                arrayList = arrayList3;
            }
            int i5 = i3 * 1000;
            if (arrayList == null) {
                size = 0;
            } else {
                size = arrayList.size();
            }
            s.a(i2, 3, i5, size, System.currentTimeMillis() - currentTimeMillis, kVar2);
            hashMap.put("keys", arrayList);
            hashMap.put("currentSize", Integer.valueOf(i3));
            hashMap.put("limitSize", Integer.valueOf(i4));
            String n = n("ok", hashMap);
            AppMethodBeat.o(147252);
            return n;
        }
    }
}
