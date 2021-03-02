package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class d {
    private static Boolean JeG = null;

    public static boolean isEnabled() {
        AppMethodBeat.i(79674);
        if (JeG == null) {
            JeG = Boolean.valueOf(ges());
        }
        boolean booleanValue = JeG.booleanValue();
        AppMethodBeat.o(79674);
        return booleanValue;
    }

    private static boolean ges() {
        AppMethodBeat.i(211041);
        StringBuilder sb = new StringBuilder(8);
        for (int i2 = 0; i2 < 4; i2++) {
            try {
                sb.append((char) ((int) ((1074974115182 >> ((3 - i2) * 8)) & 255)));
            } catch (Throwable th) {
                String sb2 = sb.toString();
                sb.delete(0, sb.length());
                sb.append(((d.class.hashCode() >>> 31) | 1) ^ 1);
                if (!sb.toString().equals(jg(sb2, sb.toString()))) {
                    AppMethodBeat.o(211041);
                    return true;
                }
                AppMethodBeat.o(211041);
                return false;
            }
        }
        String sb3 = sb.toString();
        sb.delete(0, sb.length());
        sb.append(((d.class.hashCode() >>> 31) | 1) ^ 1);
        if (!sb.toString().equals(jg(sb3, sb.toString()))) {
            AppMethodBeat.o(211041);
            return true;
        }
        AppMethodBeat.o(211041);
        return false;
    }

    public static String geu() {
        AppMethodBeat.i(79675);
        StringBuilder sb = new StringBuilder(8);
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                sb.append((char) ((int) ((1045787241 >> ((2 - i2) * 8)) & 255)));
            } catch (Throwable th) {
                String jg = jg(sb.toString(), "");
                AppMethodBeat.o(79675);
                return jg;
            }
        }
        String jg2 = jg(sb.toString(), "");
        AppMethodBeat.o(79675);
        return jg2;
    }

    public static boolean isBlock() {
        AppMethodBeat.i(79676);
        StringBuilder sb = new StringBuilder(8);
        for (int i2 = 0; i2 < 5; i2++) {
            try {
                sb.append((char) ((int) ((222416815156331 >> ((4 - i2) * 8)) & 255)));
            } catch (Throwable th) {
                String sb2 = sb.toString();
                sb.delete(0, sb.length());
                sb.append(((d.class.hashCode() >>> 31) | 1) ^ 1);
                if (!sb.toString().equals(jg(sb2, sb.toString()))) {
                    AppMethodBeat.o(79676);
                    return true;
                }
                AppMethodBeat.o(79676);
                return false;
            }
        }
        String sb3 = sb.toString();
        sb.delete(0, sb.length());
        sb.append(((d.class.hashCode() >>> 31) | 1) ^ 1);
        if (!sb.toString().equals(jg(sb3, sb.toString()))) {
            AppMethodBeat.o(79676);
            return true;
        }
        AppMethodBeat.o(79676);
        return false;
    }

    private static String jg(String str, String str2) {
        AppMethodBeat.i(79677);
        try {
            a aVar = a.C0356a.hnM;
            c Fu = a.Fu("100460");
            if (Fu == null || !Fu.isValid()) {
                Log.w("MicroMsg.WebViewHelper", "check point 1, explained by src code.");
                AppMethodBeat.o(79677);
                return str2;
            }
            Map<String, String> gzz = Fu.gzz();
            if (gzz == null) {
                Log.w("MicroMsg.WebViewHelper", "check point 2, explained by src code.");
                AppMethodBeat.o(79677);
                return str2;
            }
            String str3 = gzz.get(str);
            if (str3 != null) {
                Log.i("MicroMsg.WebViewHelper", "st, sk: %s, val:%s", str, str3);
                AppMethodBeat.o(79677);
                return str3;
            }
            AppMethodBeat.o(79677);
            return str2;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.WebViewHelper", th, "check point 1-1, explained by src code.", new Object[0]);
            AppMethodBeat.o(79677);
            return str2;
        }
    }
}
