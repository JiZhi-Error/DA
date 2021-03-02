package com.tencent.mm.plugin.sns.ad.i;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class d {
    public static int aNT(String str) {
        AppMethodBeat.i(202352);
        int i2 = -352965;
        try {
            if (!TextUtils.isEmpty(str)) {
                i2 = Color.parseColor(str);
            }
        } catch (Throwable th) {
            Log.w("SnsAd.ColorUtil", "parse color from string failed, return default value!");
        }
        AppMethodBeat.o(202352);
        return i2;
    }

    public static String jV(String str, String str2) {
        AppMethodBeat.i(202353);
        try {
            str2 = c(Float.parseFloat(str), str2);
            AppMethodBeat.o(202353);
        } catch (Throwable th) {
            Log.w("SnsAd.ColorUtil", "parse color from string failed");
            AppMethodBeat.o(202353);
        }
        return str2;
    }

    private static String c(float f2, String str) {
        AppMethodBeat.i(202354);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append('#').append(Integer.toHexString((int) (255.0f * f2)));
            if (str.startsWith("#")) {
                sb.append(str.substring(1));
            } else {
                sb.append(str);
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(202354);
            return sb2;
        } catch (Throwable th) {
            AppMethodBeat.o(202354);
            return "";
        }
    }
}
