package com.tencent.mm.plugin.order.c;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class c {
    public static boolean isNumeric(String str) {
        AppMethodBeat.i(66840);
        boolean matches = Pattern.compile("[0-9]*").matcher(str).matches();
        AppMethodBeat.o(66840);
        return matches;
    }

    private static HashMap<String, String> aJI(String str) {
        AppMethodBeat.i(66841);
        if (str == null) {
            AppMethodBeat.o(66841);
            return null;
        }
        int indexOf = str.indexOf(NativeProtocol.WEB_DIALOG_ACTION);
        if (indexOf <= 0) {
            AppMethodBeat.o(66841);
            return null;
        }
        String substring = str.substring(indexOf, str.length());
        if (TextUtils.isEmpty(substring)) {
            AppMethodBeat.o(66841);
            return null;
        }
        String[] split = substring.split("&");
        if (split == null) {
            AppMethodBeat.o(66841);
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str2 : split) {
            String[] split2 = str2.split("=");
            if (split2 != null && split2.length == 2) {
                hashMap.put(split2[0], split2[1]);
            }
        }
        AppMethodBeat.o(66841);
        return hashMap;
    }

    public static boolean bl(Context context, String str) {
        AppMethodBeat.i(66842);
        Log.v("MicroMsg.MallUtil", "jumpToUrl:".concat(String.valueOf(str)));
        Intent intent = new Intent();
        HashMap<String, String> aJI = aJI(str);
        if (aJI != null && !aJI.isEmpty()) {
            String str2 = aJI.get(NativeProtocol.WEB_DIALOG_ACTION);
            if (!TextUtils.isEmpty(str2) && isNumeric(str2)) {
                switch (Util.getInt(str2, 0)) {
                    case 1:
                        intent.putExtra("rawUrl", aJI.get("3rdurl"));
                        intent.putExtra("showShare", false);
                        intent.putExtra("pay_channel", 1);
                        f.aA(context, intent);
                        break;
                    case 2:
                        f.am(context, aJI.get(ch.COL_USERNAME));
                        break;
                    case 3:
                        intent.putExtra("key_func_id", aJI.get("functionid"));
                        intent.putExtra("key_scene", 1);
                        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_android_walletv2_open_config, true);
                        Log.i("MicroMsg.MallUtil", " walletMallV2 switch is ：%s", Boolean.valueOf(a2));
                        if (!a2) {
                            com.tencent.mm.br.c.b(context, "mall", ".ui.MallIndexUI", intent);
                            break;
                        } else {
                            com.tencent.mm.br.c.b(context, "mall", ".ui.MallIndexUIv2", intent);
                            break;
                        }
                    case 4:
                        intent.putExtra("key_product_id", aJI.get("productid"));
                        intent.putExtra("key_product_scene", 5);
                        com.tencent.mm.br.c.b(context, "product", ".ui.MallProductUI", intent);
                        break;
                }
            } else {
                Log.e("MicroMsg.MallUtil", "jumpToUrl illegal action:".concat(String.valueOf(str2)));
                AppMethodBeat.o(66842);
                return false;
            }
        } else if (!TextUtils.isEmpty(str)) {
            bn(context, str);
        } else {
            Log.e("MicroMsg.MallUtil", "jumpToUrl illegal url:".concat(String.valueOf(str)));
            AppMethodBeat.o(66842);
            return false;
        }
        AppMethodBeat.o(66842);
        return true;
    }

    public static void bm(Context context, String str) {
        AppMethodBeat.i(66843);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(66843);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("key_product_id", str);
        intent.putExtra("key_product_scene", 5);
        com.tencent.mm.br.c.b(context, "product", ".ui.MallProductUI", intent);
        AppMethodBeat.o(66843);
    }

    public static void bn(Context context, String str) {
        AppMethodBeat.i(66844);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("pay_channel", 1);
        f.aA(context, intent);
        AppMethodBeat.o(66844);
    }

    public static void a(Boolean bool, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(66845);
        if (bool.booleanValue()) {
            h.INSTANCE.a(11030, str, "", str3, str4);
            AppMethodBeat.o(66845);
            return;
        }
        h.INSTANCE.a(11030, str, str2, str3, str4);
        AppMethodBeat.o(66845);
    }
}
