package com.tencent.mm.plugin.appbrand.ab;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface b {
    String[] getKeys();

    public static class a {
        public static String t(String[] strArr) {
            AppMethodBeat.i(146130);
            String str = " PRIMARY KEY ( ";
            for (int i2 = 0; i2 < strArr.length; i2++) {
                str = str + ", " + strArr[i2];
            }
            String str2 = "" + "," + (str.replaceFirst(",", "") + " )");
            AppMethodBeat.o(146130);
            return str2;
        }
    }
}
