package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class r {
    private static String[][] ogW = {new String[]{"\\", "\\\\"}, new String[]{"'", "\\'"}, new String[]{"\"", "\\\""}, new String[]{"\n", "\\n"}, new String[]{"\t", "\\t"}, new String[]{"\b", "\\b"}, new String[]{"\f", "\\f"}, new String[]{"\r", "\\r"}, new String[]{" ", "\\u2028"}, new String[]{" ", "\\u2029"}};

    public static String afJ(String str) {
        AppMethodBeat.i(135365);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(135365);
        } else {
            String[][] strArr = ogW;
            for (String[] strArr2 : strArr) {
                str = str.replace(strArr2[0], strArr2[1]);
            }
            AppMethodBeat.o(135365);
        }
        return str;
    }
}
