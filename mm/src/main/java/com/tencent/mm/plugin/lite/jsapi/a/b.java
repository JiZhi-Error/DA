package com.tencent.mm.plugin.lite.jsapi.a;

import android.os.Bundle;
import com.tencent.f.h;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.b.f;
import com.tencent.mm.plugin.lite.c;
import com.tencent.mm.plugin.lite.jsapi.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends com.tencent.mm.plugin.lite.jsapi.b {
    @Override // com.tencent.liteapp.jsapi.a
    public final void a(final String str, JSONObject jSONObject) {
        AppMethodBeat.i(198840);
        f.ecC();
        WxaLiteAppInfo aCT = f.aCT(str);
        if (aCT == null) {
            Log.w("LiteAppJsApiLogin", "get LiteAppInfo fail");
            this.yEn.aCS("can not find liteApp from local storage");
            AppMethodBeat.o(198840);
            return;
        }
        final boolean[] zArr = {false};
        final String[] strArr = {null};
        try {
            if (jSONObject.has("url")) {
                strArr[0] = jSONObject.getString("url");
            }
            if (strArr[0] == null) {
                strArr[0] = LiteAppCenter.getAuthUrl(aCT.path, aCT.appId, aCT.crh);
            }
            if (strArr[0] == null || strArr[0].isEmpty()) {
                Log.w("LiteAppJsApiLogin", "get authurl fail");
                this.yEn.aCS("get authUrl fail, please make sure config authUrl in config file");
                AppMethodBeat.o(198840);
                return;
            }
            long j2 = Util.MILLSECONDS_OF_MINUTE;
            if (jSONObject.has("timeout")) {
                j2 = jSONObject.getLong("timeout");
            }
            h.RTc.o(new Runnable() {
                /* class com.tencent.mm.plugin.lite.jsapi.a.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(198837);
                    synchronized (zArr) {
                        try {
                            if (!zArr[0]) {
                                Log.w("LiteAppJsApiLogin", "geta8key timeout");
                                zArr[0] = true;
                                b.this.yEn.aCS("getA8Key timeout");
                            }
                        } finally {
                            AppMethodBeat.o(198837);
                        }
                    }
                }
            }, j2);
            a.INSTANCE.a(strArr[0], new a.b() {
                /* class com.tencent.mm.plugin.lite.jsapi.a.b.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.lite.jsapi.a.b
                public final void onError() {
                    AppMethodBeat.i(198838);
                    synchronized (zArr) {
                        try {
                            if (!zArr[0]) {
                                Log.w("LiteAppJsApiLogin", "geta8key fail");
                                zArr[0] = true;
                                b.this.yEn.aCS("getA8Key fail");
                            }
                        } finally {
                            AppMethodBeat.o(198838);
                        }
                    }
                }

                @Override // com.tencent.mm.plugin.lite.jsapi.a.b
                public final void a(a.C1460a aVar) {
                    AppMethodBeat.i(198839);
                    synchronized (zArr) {
                        try {
                            if (!zArr[0]) {
                                Log.i("LiteAppJsApiLogin", "geta8key:" + str);
                                zArr[0] = true;
                                if (str != null && c.yDV.contains(str)) {
                                    aVar.mHeaders.put("referer", "https://game.weixin.qq.com/");
                                }
                                LiteAppCenter.setAuthInfo(str, aVar.yEk, aVar.mHeaders, aVar.yEl);
                                com.tencent.mm.plugin.lite.storage.c cVar = new com.tencent.mm.plugin.lite.storage.c();
                                cVar.field_host = strArr[0];
                                JSONObject jSONObject = new JSONObject();
                                if (aVar.yEl != null) {
                                    for (Map.Entry<String, String> entry : aVar.yEl.entrySet()) {
                                        try {
                                            jSONObject.put(entry.getKey(), entry.getValue());
                                        } catch (JSONException e2) {
                                        }
                                    }
                                }
                                cVar.field_param = aVar.yEk;
                                cVar.field_paramMap = jSONObject.toString();
                                cVar.field_updateTime = System.currentTimeMillis() / 1000;
                                cVar.field_headerMap = new JSONObject(aVar.mHeaders).toString();
                                f.ecC();
                                Bundle bundle = new Bundle();
                                bundle.putString("host", cVar.field_host);
                                bundle.putString("param", cVar.field_param);
                                bundle.putString("paramMap", cVar.field_paramMap);
                                bundle.putString("headerMap", cVar.field_headerMap);
                                bundle.putLong(ch.COL_UPDATETIME, cVar.field_updateTime);
                                try {
                                    MMApplicationContext.getContext().getContentResolver().call(f.getUri(), "insertLiteAppAuthInfo", cVar.field_host, bundle);
                                } catch (Exception e3) {
                                    Log.printErrStackTrace("MicroMsg.LiteApp.LiteAppLogic", e3, "", new Object[0]);
                                }
                                b.this.yEn.aW(jSONObject);
                            }
                        } finally {
                            AppMethodBeat.o(198839);
                        }
                    }
                }
            });
            AppMethodBeat.o(198840);
        } catch (JSONException e2) {
            this.yEn.aCS("json exception");
        }
    }
}
