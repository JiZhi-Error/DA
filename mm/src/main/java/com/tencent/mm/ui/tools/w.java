package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w {
    public static String q(String str, String... strArr) {
        AppMethodBeat.i(143283);
        StringBuilder sb = new StringBuilder(str);
        sb.append(str.contains("?") ? "&" : "?");
        for (int i2 = 0; i2 <= 0; i2++) {
            sb.append(strArr[0]);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(143283);
        return sb2;
    }
}
