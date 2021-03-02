package com.tencent.mm.plugin.lite.jsapi.a;

import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.b.f;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.plugin.lite.storage.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class d extends b {
    @Override // com.tencent.mm.plugin.lite.jsapi.b
    public final int dTw() {
        return 0;
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void a(String str, JSONObject jSONObject) {
        AppMethodBeat.i(198843);
        f.ecC();
        WxaLiteAppInfo aCT = f.aCT(str);
        if (aCT == null) {
            Log.w("LiteAppJsApiSession", "get LiteAppInfo fail");
            this.yEn.aCS("can not find liteApp from local storage");
            AppMethodBeat.o(198843);
            return;
        }
        String str2 = null;
        try {
            if (jSONObject.has("url")) {
                str2 = jSONObject.getString("url");
            }
            if (str2 == null) {
                str2 = LiteAppCenter.getAuthUrl(aCT.path, aCT.appId, aCT.crh);
            }
            if (str2 == null || str2.isEmpty()) {
                Log.w("LiteAppJsApiSession", "get authurl fail");
                this.yEn.aCS("get authUrl fail, please make sure config authUrl in config file");
                AppMethodBeat.o(198843);
                return;
            }
            f.ecC();
            c aCU = f.aCU(str2);
            if (aCU == null) {
                this.yEn.aCS("auth info is not existed");
                AppMethodBeat.o(198843);
                return;
            }
            JSONObject jSONObject2 = new JSONObject(aCU.field_headerMap);
            Iterator<String> keys = jSONObject2.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject2.getString(next));
            }
            JSONObject jSONObject3 = new JSONObject(aCU.field_paramMap);
            Iterator<String> keys2 = jSONObject3.keys();
            HashMap hashMap2 = new HashMap();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                hashMap2.put(next2, jSONObject3.getString(next2));
            }
            LiteAppCenter.setAuthInfo(str, aCU.field_param, hashMap, hashMap2);
            jSONObject3.put(ch.COL_UPDATETIME, aCU.field_updateTime);
            this.yEn.aW(jSONObject3);
            AppMethodBeat.o(198843);
        } catch (Exception e2) {
            this.yEn.aCS("exception");
            AppMethodBeat.o(198843);
        }
    }
}
