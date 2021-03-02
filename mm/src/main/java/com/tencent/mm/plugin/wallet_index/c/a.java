package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    public static boolean lw(String str, String str2) {
        boolean z;
        AppMethodBeat.i(71809);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(71809);
            return false;
        }
        String str3 = null;
        String[] split = str.split("&");
        int length = split.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            String[] split2 = split[i2].split("=");
            if (split2.length > 1 && split2[0].equals("prepay_id")) {
                str3 = split2[1];
                break;
            }
            i2++;
        }
        if (Util.isNullOrNil(str3)) {
            AppMethodBeat.o(71809);
            return false;
        }
        if (str3.startsWith(str2)) {
            z = true;
        } else {
            z = false;
        }
        AppMethodBeat.o(71809);
        return z;
    }
}
