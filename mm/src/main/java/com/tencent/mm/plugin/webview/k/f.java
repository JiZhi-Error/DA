package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;

public final class f {
    public static int a(Context context, e eVar, String str) {
        Exception e2;
        int i2;
        AppMethodBeat.i(82379);
        try {
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("WebViewFontUtil", 2);
            boolean z = mmkv.getBoolean("webview_key_font_use_system", false);
            Log.i("MicroMsg.WebViewFontUtil", "useSystemFont = %b", Boolean.valueOf(z));
            if (z) {
                int id = id(context);
                AppMethodBeat.o(82379);
                return id;
            }
            boolean z2 = mmkv.getBoolean("webview_key_font_has_set", false);
            if (Util.isNullOrNil(str) || !a.IJn.matcher(str).matches()) {
                int kl = eVar.kl(16384, 2);
                if (kl == 2 && !z2) {
                    int id2 = id(context);
                    AppMethodBeat.o(82379);
                    return id2;
                } else if (mmkv.getBoolean("webview_key_has_transfer_reader", false)) {
                    AppMethodBeat.o(82379);
                    return kl;
                } else {
                    int ahm = ahm(kl);
                    mmkv.putBoolean("webview_key_has_transfer_reader", true);
                    eVar.km(16384, ahm);
                    AppMethodBeat.o(82379);
                    return ahm;
                }
            } else {
                i2 = eVar.kl(16388, 2);
                if (i2 == 2 && !z2) {
                    try {
                        int id3 = id(context);
                        AppMethodBeat.o(82379);
                        return id3;
                    } catch (Exception e3) {
                        e2 = e3;
                        Log.e("MicroMsg.WebViewFontUtil", "onLoadJsApiFinished, ex = " + e2.getMessage());
                        AppMethodBeat.o(82379);
                        return i2;
                    }
                } else if (mmkv.getBoolean("webview_key_has_transfer_mp", false)) {
                    AppMethodBeat.o(82379);
                    return i2;
                } else {
                    int ahm2 = ahm(i2);
                    mmkv.putBoolean("webview_key_has_transfer_mp", true);
                    eVar.km(16388, ahm2);
                    AppMethodBeat.o(82379);
                    return ahm2;
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            i2 = 2;
            Log.e("MicroMsg.WebViewFontUtil", "onLoadJsApiFinished, ex = " + e2.getMessage());
            AppMethodBeat.o(82379);
            return i2;
        }
    }

    public static void zz(boolean z) {
        AppMethodBeat.i(160473);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("WebViewFontUtil", 2);
        mmkv.putBoolean("webview_key_font_use_system", z);
        mmkv.apply();
        AppMethodBeat.o(160473);
    }

    private static int ahm(int i2) {
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2) {
            return 2;
        }
        if (i2 == 3) {
            return 4;
        }
        if (i2 == 4) {
            return 6;
        }
        return 2;
    }

    public static int id(Context context) {
        AppMethodBeat.i(82380);
        float f2 = context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", 1.0f);
        if (f2 == com.tencent.mm.cb.a.iW(context)) {
            AppMethodBeat.o(82380);
            return 1;
        } else if (f2 == com.tencent.mm.cb.a.iX(context)) {
            AppMethodBeat.o(82380);
            return 2;
        } else if (f2 == com.tencent.mm.cb.a.iY(context)) {
            AppMethodBeat.o(82380);
            return 3;
        } else if (f2 == com.tencent.mm.cb.a.iZ(context)) {
            AppMethodBeat.o(82380);
            return 4;
        } else if (f2 == com.tencent.mm.cb.a.ja(context)) {
            AppMethodBeat.o(82380);
            return 5;
        } else if (f2 == com.tencent.mm.cb.a.jb(context)) {
            AppMethodBeat.o(82380);
            return 6;
        } else if (f2 == com.tencent.mm.cb.a.jc(context)) {
            AppMethodBeat.o(82380);
            return 7;
        } else if (f2 == com.tencent.mm.cb.a.jd(context)) {
            AppMethodBeat.o(82380);
            return 8;
        } else {
            AppMethodBeat.o(82380);
            return 2;
        }
    }
}
