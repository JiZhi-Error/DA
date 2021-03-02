package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class t extends br<s> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return JsApiGetInstallState.NAME;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final b<s>.a aVar) {
        AppMethodBeat.i(78555);
        Log.i("MicroMsg.JsApiGetInstallState", "invokeInOwn");
        a.post(new Runnable() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.t.AnonymousClass1 */

            public final void run() {
                int i2 = 0;
                AppMethodBeat.i(78554);
                JSONObject jSONObject = aVar.ctb.csi;
                Context context = aVar.cta.mContext;
                JSONArray optJSONArray = jSONObject.optJSONArray(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
                if (optJSONArray != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    boolean z = false;
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        try {
                            String optString = optJSONArray.optString(i3);
                            PackageInfo packageInfo = com.tencent.mm.plugin.appbrand.ac.b.getPackageInfo(context, optString);
                            int i4 = packageInfo == null ? 0 : packageInfo.versionCode;
                            String str = packageInfo == null ? BuildConfig.COMMAND : packageInfo.versionName;
                            Log.i("MicroMsg.JsApiGetInstallState", "getInstallState, packageName = " + optString + ", version = " + i4 + ", versionName = " + str);
                            if (!z && i4 > 0) {
                                z = true;
                            }
                            jSONObject2.put(optString, i4);
                            jSONObject3.put(optString, str);
                        } catch (Exception e2) {
                        }
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("result", jSONObject2.toString());
                    hashMap.put("versionName", jSONObject3.toString());
                    if (z) {
                        aVar.e("get_install_state:yes", hashMap);
                        AppMethodBeat.o(78554);
                        return;
                    }
                    aVar.c("get_install_state:no", null);
                    AppMethodBeat.o(78554);
                    return;
                }
                String optString2 = jSONObject.optString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
                if (Util.isNullOrNil(optString2)) {
                    Log.i("MicroMsg.JsApiGetInstallState", "packageName is null or nil");
                    aVar.c("get_install_state:no_null_packageName", null);
                    AppMethodBeat.o(78554);
                    return;
                }
                PackageInfo packageInfo2 = com.tencent.mm.plugin.appbrand.ac.b.getPackageInfo(context, optString2);
                if (packageInfo2 != null) {
                    i2 = packageInfo2.versionCode;
                }
                String str2 = packageInfo2 == null ? BuildConfig.COMMAND : packageInfo2.versionName;
                Log.i("MicroMsg.JsApiGetInstallState", "doGetInstallState, packageName = " + optString2 + ", version = " + i2 + ", versionName = " + str2);
                if (packageInfo2 == null) {
                    aVar.c("get_install_state:no", null);
                    AppMethodBeat.o(78554);
                    return;
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("versionName", str2);
                aVar.e("get_install_state:yes_".concat(String.valueOf(i2)), hashMap2);
                AppMethodBeat.o(78554);
            }
        });
        AppMethodBeat.o(78555);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
