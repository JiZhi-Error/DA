package com.tencent.xweb;

import android.content.Context;
import android.webkit.ValueCallback;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.xweb.f;
import com.tencent.xweb.x5.sdk.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class g {
    private static Map<String, Integer> lVu = new HashMap();

    static /* synthetic */ void a(Context context, String str, String str2, String str3, int i2, HashMap hashMap, ValueCallback valueCallback, ValueCallback valueCallback2) {
        AppMethodBeat.i(156754);
        a(context, str, str2, str3, i2, false, hashMap, valueCallback, valueCallback2);
        AppMethodBeat.o(156754);
    }

    static /* synthetic */ void a(String str, ValueCallback valueCallback, int i2) {
        AppMethodBeat.i(219011);
        b(str, valueCallback, TXLiteAVCode.ERR_SERVER_INFO_ALLOCATE_ACCESS_FAILED, i2);
        AppMethodBeat.o(219011);
    }

    static {
        AppMethodBeat.i(156755);
        AppMethodBeat.o(156755);
    }

    public static void e(final int i2, final Context context, final String str, final String str2, final String str3, boolean z, final HashMap<String, String> hashMap, final ValueCallback<String> valueCallback, final ValueCallback<Integer> valueCallback2) {
        AppMethodBeat.i(156748);
        if (z) {
            Log.i("XFilesReaderX5", "readFile by x5, second time, skip all report except failure, directly go to loadByMiniQB");
            a(context, str, str2, str3, i2, true, hashMap, valueCallback, valueCallback2);
            AppMethodBeat.o(156748);
            return;
        }
        Log.i("XFilesReaderX5", "readFile by x5, fileExt: " + (str2 != null ? str2 : BuildConfig.COMMAND));
        f.nY(str2, f.a.X5.name());
        f.hM(str2, i2);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("path", str);
            jSONObject.putOpt("ext", str2);
            String jSONObject2 = jSONObject.toString();
            Context applicationContext = context.getApplicationContext();
            d.disableAutoCreateX5Webview();
            d.a(applicationContext, jSONObject2, new ValueCallback<Boolean>() {
                /* class com.tencent.xweb.g.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Boolean bool) {
                    AppMethodBeat.i(156747);
                    if (!bool.booleanValue()) {
                        Log.i("XFilesReaderX5", "QbSdk not support");
                        g.a(str2, valueCallback2, i2);
                        AppMethodBeat.o(156747);
                        return;
                    }
                    g.a(context, str, str2, str3, i2, hashMap, valueCallback, valueCallback2);
                    AppMethodBeat.o(156747);
                }
            });
            AppMethodBeat.o(156748);
        } catch (JSONException e2) {
            Log.e("XFilesReaderX5", "readFile jsonObject error" + e2.getMessage());
            b(str2, valueCallback2, TXLiteAVCode.ERR_SERVER_INFO_TOKEN_ERROR, i2);
            AppMethodBeat.o(156748);
        }
    }

    public static void o(Context context, String str, String str2) {
        AppMethodBeat.i(156749);
        try {
            Integer num = lVu.get(str + str2);
            if (num == null) {
                AppMethodBeat.o(156749);
                return;
            }
            lVu.remove(str + str2);
            if (num.intValue() == 0) {
                Log.i("XFilesReaderX5", "finishReadFile");
                d.closeFileReader(context);
                AppMethodBeat.o(156749);
                return;
            }
            Log.i("XFilesReaderX5", "finishReadFile ret != 0, skip");
            AppMethodBeat.o(156749);
        } catch (Exception e2) {
            Log.e("XFilesReaderX5", "finishReadFile error: " + e2.getMessage());
            AppMethodBeat.o(156749);
        }
    }

    private static void a(Context context, String str, String str2, String str3, int i2, boolean z, HashMap<String, String> hashMap, ValueCallback<String> valueCallback, ValueCallback<Integer> valueCallback2) {
        AppMethodBeat.i(156750);
        HashMap hashMap2 = new HashMap(2);
        hashMap2.put(ImagesContract.LOCAL, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap2.put(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "1");
        if (hashMap != null) {
            try {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    hashMap2.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception e2) {
                Log.e("XFilesReaderX5", "loadByMiniQB extraParams error, isSecondTime = " + String.valueOf(z) + ", msg: " + e2.getMessage());
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("path", str);
            jSONObject.put("ext", str2);
            jSONObject.put("token", str3);
            int startMiniQBToLoadUrl = d.startMiniQBToLoadUrl(context, jSONObject.toString(), hashMap2, valueCallback);
            lVu.put(str3 + str, Integer.valueOf(startMiniQBToLoadUrl));
            Log.i("XFilesReaderX5", "loadByMiniQB, ret = " + startMiniQBToLoadUrl + ", isSecondTime = " + String.valueOf(z));
            a(str2, valueCallback2, startMiniQBToLoadUrl, i2);
            AppMethodBeat.o(156750);
        } catch (Exception e3) {
            Log.e("XFilesReaderX5", "loadByMiniQB jsonObject error, isSecondTime = " + String.valueOf(z) + ", msg: " + e3.getMessage());
            b(str2, valueCallback2, TXLiteAVCode.ERR_SERVER_INFO_TOKEN_ERROR, i2);
            AppMethodBeat.o(156750);
        }
    }

    private static void a(String str, ValueCallback<Integer> valueCallback, int i2, int i3) {
        AppMethodBeat.i(156751);
        f.b(str, i2, false, i3);
        valueCallback.onReceiveValue(Integer.valueOf(i2));
        AppMethodBeat.o(156751);
    }

    private static void b(String str, ValueCallback<Integer> valueCallback, int i2, int i3) {
        AppMethodBeat.i(156752);
        f.b(str, i2, true, i3);
        valueCallback.onReceiveValue(-102);
        AppMethodBeat.o(156752);
    }
}
