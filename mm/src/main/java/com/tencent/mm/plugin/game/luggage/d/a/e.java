package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends b {
    @Override // com.tencent.mm.plugin.lite.jsapi.b
    public final int dTw() {
        return 0;
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void a(String str, final JSONObject jSONObject) {
        AppMethodBeat.i(186906);
        a.post(new Runnable() {
            /* class com.tencent.mm.plugin.game.luggage.d.a.e.AnonymousClass1 */

            public final void run() {
                int i2 = 0;
                AppMethodBeat.i(186905);
                Context context = MMApplicationContext.getContext();
                JSONArray optJSONArray = jSONObject.optJSONArray(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
                if (optJSONArray != null) {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    boolean z = false;
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        try {
                            String optString = optJSONArray.optString(i3);
                            PackageInfo packageInfo = com.tencent.mm.plugin.appbrand.ac.b.getPackageInfo(context, optString);
                            int i4 = packageInfo == null ? 0 : packageInfo.versionCode;
                            String str = packageInfo == null ? BuildConfig.COMMAND : packageInfo.versionName;
                            Log.i("LiteAppJsApiGetInstallState", "getInstallState, packageName = " + optString + ", version = " + i4 + ", versionName = " + str);
                            if (!z && i4 > 0) {
                                z = true;
                            }
                            jSONObject.put(optString, i4);
                            jSONObject2.put(optString, str);
                        } catch (Exception e2) {
                        }
                    }
                    HashMap hashMap = new HashMap();
                    if (z) {
                        hashMap.put(AssistantStore.DownloadInfos.DownloadInfoColumns.VERSIONCODE, jSONObject);
                        hashMap.put("versionName", jSONObject2);
                    }
                    hashMap.put("state", Boolean.valueOf(z));
                    e.this.yEn.aq(hashMap);
                    AppMethodBeat.o(186905);
                    return;
                }
                String optString2 = jSONObject.optString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
                if (Util.isNullOrNil(optString2)) {
                    Log.i("LiteAppJsApiGetInstallState", "packageName is null or nil");
                    e.this.yEn.aCS("get_install_state:no_null_packageName");
                    AppMethodBeat.o(186905);
                    return;
                }
                PackageInfo packageInfo2 = com.tencent.mm.plugin.appbrand.ac.b.getPackageInfo(context, optString2);
                if (packageInfo2 != null) {
                    i2 = packageInfo2.versionCode;
                }
                String str2 = packageInfo2 == null ? BuildConfig.COMMAND : packageInfo2.versionName;
                Log.i("LiteAppJsApiGetInstallState", "doGetInstallState, packageName = " + optString2 + ", version = " + i2 + ", versionName = " + str2);
                if (packageInfo2 == null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("state", Boolean.FALSE);
                    e.this.yEn.aq(hashMap2);
                    AppMethodBeat.o(186905);
                    return;
                }
                HashMap hashMap3 = new HashMap();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject3.put(optString2, i2);
                    jSONObject4.put(optString2, str2);
                } catch (JSONException e3) {
                }
                hashMap3.put(AssistantStore.DownloadInfos.DownloadInfoColumns.VERSIONCODE, jSONObject3);
                hashMap3.put("versionName", jSONObject4);
                hashMap3.put("state", Boolean.TRUE);
                e.this.yEn.aq(hashMap3);
                AppMethodBeat.o(186905);
            }
        });
        AppMethodBeat.o(186906);
    }
}
