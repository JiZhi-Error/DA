package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataParcel;
import com.tencent.mm.plugin.appbrand.backgroundfetch.k;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends d {
    public static final int CTRL_INDEX = 522;
    public static final String NAME = "getBackgroundFetchData";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46819);
        if (fVar == null) {
            Log.w("MicroMsg.JsApiGetBackgroundFetchData", "fail:component is null");
            AppMethodBeat.o(46819);
        } else if (jSONObject == null) {
            Log.w("MicroMsg.JsApiGetBackgroundFetchData", "fail:data is null");
            fVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(46819);
        } else {
            String optString = jSONObject.optString("fetchType");
            if (Util.isNullOrNil(optString)) {
                Log.w("MicroMsg.JsApiGetBackgroundFetchData", "fail:fetchType is null");
                fVar.i(i2, h("fail:invalid data", null));
                AppMethodBeat.o(46819);
                return;
            }
            String appId = fVar.getAppId();
            if (Util.isNullOrNil(appId)) {
                Log.w("MicroMsg.JsApiGetBackgroundFetchData", "fail:appid is null");
                fVar.i(i2, h("fail:appID is empty", null));
                AppMethodBeat.o(46819);
                return;
            }
            int i3 = optString.equals("periodic") ? 1 : 0;
            if (g.af(k.class) == null) {
                Log.w("MicroMsg.JsApiGetBackgroundFetchData", "worker fail:IAppBrandBackgroundFetchDataStorage is null");
                fVar.i(i2, h("fail:internal error", null));
                AppMethodBeat.o(46819);
                return;
            }
            AppBrandBackgroundFetchDataParcel bv = ((k) g.af(k.class)).bv(appId, i3);
            if (bv == null) {
                Log.w("MicroMsg.JsApiGetBackgroundFetchData", "worker fail:record is null");
                fVar.i(i2, h("fail:record is null", null));
                AppMethodBeat.o(46819);
            } else if (bv.data == null) {
                Log.w("MicroMsg.JsApiGetBackgroundFetchData", "worker fail:fetched data is null");
                fVar.i(i2, h("fail:fetched data is null", null));
                AppMethodBeat.o(46819);
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("fetchedData", bv.data);
                hashMap.put("path", bv.path);
                hashMap.put(SearchIntents.EXTRA_QUERY, bv.query);
                hashMap.put("scene", Integer.valueOf(bv.scene));
                hashMap.put("timeStamp", Long.valueOf(bv.crj));
                Log.i("MicroMsg.JsApiGetBackgroundFetchData", "JsApiGetBackgroundFetchData, app(%s_%d)", appId, Integer.valueOf(i3));
                fVar.i(i2, n("ok", hashMap));
                AppMethodBeat.o(46819);
            }
        }
    }
}
