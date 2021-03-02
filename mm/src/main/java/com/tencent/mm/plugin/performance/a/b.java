package com.tencent.mm.plugin.performance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static String aJR(String str) {
        AppMethodBeat.i(145999);
        if (str.isEmpty()) {
            AppMethodBeat.o(145999);
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i2 = 0; i2 < length; i2++) {
            sb.append((char) ((byte) (((((byte) str.charAt(i2)) ^ (i2 - length)) ^ 60) & 255)));
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(145999);
        return sb2;
    }
}
