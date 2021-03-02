package com.tencent.mm.wallet_core.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b {
    public static boolean hhI() {
        AppMethodBeat.i(72882);
        StringBuilder sb = new StringBuilder(8);
        for (int i2 = 0; i2 < 6; i2++) {
            try {
                sb.append((char) ((int) ((57497235128533601 >> ((5 - i2) * 8)) & 255)));
            } catch (Throwable th) {
                String sb2 = sb.toString();
                sb.delete(0, sb.length());
                sb.append(((b.class.hashCode() >>> 31) | 1) ^ 1);
                if (!sb.toString().equals(jg(sb2, sb.toString()))) {
                    AppMethodBeat.o(72882);
                    return true;
                }
                AppMethodBeat.o(72882);
                return false;
            }
        }
        String sb3 = sb.toString();
        sb.delete(0, sb.length());
        sb.append(((b.class.hashCode() >>> 31) | 1) ^ 1);
        if (!sb.toString().equals(jg(sb3, sb.toString()))) {
            AppMethodBeat.o(72882);
            return true;
        }
        AppMethodBeat.o(72882);
        return false;
    }

    public static boolean hhJ() {
        AppMethodBeat.i(72883);
        StringBuilder sb = new StringBuilder(8);
        for (int i2 = 0; i2 < 6; i2++) {
            try {
                sb.append((char) ((int) ((57778710156427883 >> ((5 - i2) * 8)) & 255)));
            } catch (Throwable th) {
                String sb2 = sb.toString();
                sb.delete(0, sb.length());
                sb.append(((b.class.hashCode() >>> 31) | 1) ^ 1);
                if (!sb.toString().equals(jg(sb2, sb.toString()))) {
                    AppMethodBeat.o(72883);
                    return true;
                }
                AppMethodBeat.o(72883);
                return false;
            }
        }
        String sb3 = sb.toString();
        sb.delete(0, sb.length());
        sb.append(((b.class.hashCode() >>> 31) | 1) ^ 1);
        if (!sb.toString().equals(jg(sb3, sb.toString()))) {
            AppMethodBeat.o(72883);
            return true;
        }
        AppMethodBeat.o(72883);
        return false;
    }

    public static boolean hhK() {
        AppMethodBeat.i(72884);
        StringBuilder sb = new StringBuilder(8);
        for (int i2 = 0; i2 < 6; i2++) {
            try {
                sb.append((char) ((int) ((65941484396629365 >> ((5 - i2) * 8)) & 255)));
            } catch (Throwable th) {
                String sb2 = sb.toString();
                sb.delete(0, sb.length());
                sb.append(((b.class.hashCode() >>> 31) | 1) ^ 1);
                if (!sb.toString().equals(jg(sb2, sb.toString()))) {
                    AppMethodBeat.o(72884);
                    return true;
                }
                AppMethodBeat.o(72884);
                return false;
            }
        }
        String sb3 = sb.toString();
        sb.delete(0, sb.length());
        sb.append(((b.class.hashCode() >>> 31) | 1) ^ 1);
        if (!sb.toString().equals(jg(sb3, sb.toString()))) {
            AppMethodBeat.o(72884);
            return true;
        }
        AppMethodBeat.o(72884);
        return false;
    }

    private static String jg(String str, String str2) {
        AppMethodBeat.i(72885);
        c Fu = d.aXu().Fu("100327");
        if (!Fu.isValid()) {
            Log.w("MicroMsg.WalletPayHelper", "check point 1, explained by src code.");
            AppMethodBeat.o(72885);
            return str2;
        }
        Map<String, String> gzz = Fu.gzz();
        if (gzz == null) {
            Log.w("MicroMsg.WalletPayHelper", "check point 2, explained by src code.");
            AppMethodBeat.o(72885);
            return str2;
        }
        String str3 = gzz.get(str);
        if (str3 == null || str3.length() <= 0) {
            AppMethodBeat.o(72885);
            return str2;
        }
        AppMethodBeat.o(72885);
        return str3;
    }
}
