package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends d {
    public static final int CTRL_INDEX = 482;
    public static final String NAME = "loadVideoResource";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, int i2) {
        int a2;
        AppMethodBeat.i(234926);
        if (jSONObject == null) {
            fVar.i(i2, h("fail:data nil", null));
            Log.w("MicroMsg.JsApiLoadVideoResource", "data is null");
            AppMethodBeat.o(234926);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("resources");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            Log.w("MicroMsg.JsApiLoadVideoResource", "dataArr nil");
            fVar.i(i2, h("fail:dataArr nil", null));
            AppMethodBeat.o(234926);
            return;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            String optString = optJSONArray.optString(i4, "");
            Log.d("MicroMsg.JsApiLoadVideoResource", "preLoadVideo videoUrl:%s", optString);
            if (Util.isNullOrNil(optString)) {
                Log.w("MicroMsg.JsApiLoadVideoResource", "videoUrl i nil");
                i3++;
            } else if (!(e.M(h.class) == null || (a2 = ((h) e.M(h.class)).a(optString, new com.tencent.mm.plugin.appbrand.jsapi.video.d() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.video.d.b.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.video.d
                public final void dN(String str, String str2) {
                    AppMethodBeat.i(234924);
                    Log.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo onPreLoadSucc save_path = %s, url = %s", str2, str);
                    f fVar = fVar;
                    HashMap hashMap = new HashMap();
                    hashMap.put("resource", str);
                    new b.k().h(fVar).Zh(new JSONObject(hashMap).toString()).bEo();
                    AppMethodBeat.o(234924);
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.video.d
                public final void bO(String str, int i2) {
                    AppMethodBeat.i(234925);
                    Log.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo onPreLoadFail err_code = %s, url = %s", Integer.valueOf(i2), str);
                    b.a(fVar, str, -5, i2);
                    AppMethodBeat.o(234925);
                }
            })) == 0)) {
                Log.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo genPreLoad fail ret = %s, videoUrl = %s", Integer.valueOf(a2), optString);
                a(fVar, optString, a2, 0);
                i3++;
            }
        }
        if (i3 != 0 && i3 == optJSONArray.length()) {
            fVar.i(i2, h("fail", null));
        }
        AppMethodBeat.o(234926);
    }

    static void a(f fVar, String str, int i2, int i3) {
        AppMethodBeat.i(234927);
        String str2 = "";
        switch (i2) {
            case -5:
                str2 = "cdn download fail errCode:".concat(String.valueOf(i3));
                break;
            case -4:
                str2 = "create file fail";
                break;
            case -3:
                str2 = "start download fail";
                break;
            case -2:
                str2 = "downloading";
                break;
            case -1:
                str2 = "args illegal";
                break;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", str2);
        hashMap.put("resource", str);
        new b.j().h(fVar).Zh(new JSONObject(hashMap).toString()).bEo();
        AppMethodBeat.o(234927);
    }
}
