package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.reader.ITbsReaderCallback;
import com.tencent.tbs.reader.ReaderEngine;
import com.tencent.tbs.reader.TbsFileInterfaceImpl;
import com.tencent.xweb.f;
import java.util.HashMap;
import java.util.Map;

public final class au {
    private static Map<String, Integer> lVu = new HashMap();

    static /* synthetic */ void c(int i2, Context context, String str, String str2, String str3, boolean z, HashMap hashMap, ValueCallback valueCallback, ValueCallback valueCallback2) {
        AppMethodBeat.i(226782);
        b(i2, context, str, str2, str3, z, hashMap, valueCallback, valueCallback2);
        AppMethodBeat.o(226782);
    }

    static /* synthetic */ void q(Context context, String str, String str2) {
        AppMethodBeat.i(226783);
        p(context, str, str2);
        AppMethodBeat.o(226783);
    }

    static {
        AppMethodBeat.i(226784);
        AppMethodBeat.o(226784);
    }

    public static void a(final int i2, final Context context, final String str, final String str2, final String str3, final boolean z, final HashMap<String, String> hashMap, final ValueCallback<String> valueCallback, final ValueCallback<Integer> valueCallback2) {
        AppMethodBeat.i(226775);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            m.runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.file.au.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(226772);
                    au.c(i2, context, str, str2, str3, z, hashMap, valueCallback, valueCallback2);
                    AppMethodBeat.o(226772);
                }
            });
            AppMethodBeat.o(226775);
            return;
        }
        b(i2, context, str, str2, str3, z, hashMap, valueCallback, valueCallback2);
        AppMethodBeat.o(226775);
    }

    public static void o(final Context context, final String str, final String str2) {
        AppMethodBeat.i(226776);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            m.runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.file.au.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(226773);
                    au.q(context, str, str2);
                    AppMethodBeat.o(226773);
                }
            });
            AppMethodBeat.o(226776);
            return;
        }
        p(context, str, str2);
        AppMethodBeat.o(226776);
    }

    private static void b(int i2, Context context, String str, String str2, String str3, boolean z, HashMap<String, String> hashMap, ValueCallback<String> valueCallback, ValueCallback<Integer> valueCallback2) {
        String str4;
        AppMethodBeat.i(226777);
        if (TBSOneManager.getDefaultInstance(context).isComponentInstalled("file")) {
            av dP = av.dP(context);
            ReaderEngine.getInstance().initReaderEntry(context);
            if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
                Log.e("MiniQbFileLoader", "open file without necessary param");
                b(str2, valueCallback2, TXLiteAVCode.ERR_SERVER_INFO_TOKEN_ERROR, i2);
                AppMethodBeat.o(226777);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("filePath", str);
            bundle.putString("fileExt", str2);
            bundle.putString("token", str3);
            bundle.putInt(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, 1);
            bundle.putString("menuData", hashMap.get("menuData"));
            bundle.putString("update_menu_param", hashMap.get("update_menu_param"));
            if (hashMap.get("hide_title_bar_right_button") == null) {
                str4 = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            } else {
                str4 = hashMap.get("hide_title_bar_right_button");
            }
            bundle.putBoolean("hide_title_bar_right_button", Boolean.parseBoolean(str4));
            Log.i("MiniQbFileLoader", "readFile by x5, fileExt: ".concat(String.valueOf(str2)));
            if (z) {
                a(dP, i2, context, str, str2, str3, true, bundle, valueCallback, valueCallback2);
            }
            f.nY(str2, f.a.X5.name());
            f.hM(str2, i2);
            if (!str.endsWith(".".concat(String.valueOf(str2)))) {
                new StringBuilder().append(str).append(".").append(str2);
            }
            boolean canOpenFile = TbsFileInterfaceImpl.canOpenFile(str2);
            Log.i("MiniQbFileLoader", "canOpen=".concat(String.valueOf(canOpenFile)));
            if (!canOpenFile) {
                Log.e("MiniQbFileLoader", "miniqb sdk not support");
                b(str2, valueCallback2, TXLiteAVCode.ERR_SERVER_INFO_ALLOCATE_ACCESS_FAILED, i2);
                AppMethodBeat.o(226777);
                return;
            }
            a(dP, i2, context, str, str2, str3, false, bundle, valueCallback, valueCallback2);
        }
        AppMethodBeat.o(226777);
    }

    private static void p(Context context, String str, String str2) {
        AppMethodBeat.i(226778);
        av dP = av.dP(context);
        try {
            Integer num = lVu.get(str + str2);
            if (num == null) {
                Log.i("MiniQbFileLoader", "finishReadFile, can't find file open record");
                AppMethodBeat.o(226778);
                return;
            }
            lVu.remove(str + str2);
            if (num.intValue() == 0) {
                Log.i("MiniQbFileLoader", "finishReadFile");
                dP.closeFileReader();
                AppMethodBeat.o(226778);
                return;
            }
            Log.i("MiniQbFileLoader", "finishReadFile ret != 0, skip");
            AppMethodBeat.o(226778);
        } catch (Exception e2) {
            Log.e("MiniQbFileLoader", "finishReadFile error: " + e2.getMessage());
            AppMethodBeat.o(226778);
        }
    }

    private static void a(av avVar, int i2, Context context, String str, String str2, String str3, boolean z, Bundle bundle, final ValueCallback<String> valueCallback, ValueCallback<Integer> valueCallback2) {
        AppMethodBeat.i(226779);
        int a2 = avVar.a(context, bundle, new ITbsReaderCallback() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.file.au.AnonymousClass3 */

            @Override // com.tencent.tbs.reader.ITbsReaderCallback
            public final void onCallBackAction(Integer num, Object obj, Object obj2) {
                AppMethodBeat.i(226774);
                Log.i("MiniQbFileLoader", "code: %d", num);
                if (10 == num.intValue()) {
                    valueCallback.onReceiveValue("plugin success");
                } else if (11 == num.intValue()) {
                    valueCallback.onReceiveValue("plugin failed");
                }
                if (13 == num.intValue() && !obj.equals("fileReaderClosed")) {
                    valueCallback.onReceiveValue((String) obj);
                }
                if (15 == num.intValue() && (obj instanceof Bundle) && ((Bundle) obj).getInt("typeId") == 1) {
                    valueCallback.onReceiveValue("fileReaderClosed");
                }
                AppMethodBeat.o(226774);
            }
        });
        lVu.put(str3 + str, Integer.valueOf(a2));
        Log.i("MiniQbFileLoader", "loadByMiniQB, ret = " + a2 + ", isSecondTime = " + String.valueOf(z));
        a(str2, valueCallback2, a2, i2);
        AppMethodBeat.o(226779);
    }

    private static void a(String str, ValueCallback<Integer> valueCallback, int i2, int i3) {
        AppMethodBeat.i(226780);
        f.b(str, i2, false, i3);
        valueCallback.onReceiveValue(Integer.valueOf(i2));
        AppMethodBeat.o(226780);
    }

    private static void b(String str, ValueCallback<Integer> valueCallback, int i2, int i3) {
        AppMethodBeat.i(226781);
        f.b(str, i2, true, i3);
        valueCallback.onReceiveValue(-102);
        AppMethodBeat.o(226781);
    }
}
