package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    public static String Sh(String str) {
        AppMethodBeat.i(132967);
        if (str == null || "".equals(str.trim())) {
            AppMethodBeat.o(132967);
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char c2 : charArray) {
            String x = SpellMap.x(c2);
            if (x != null) {
                stringBuffer.append(x);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(132967);
        return stringBuffer2;
    }

    public static String Si(String str) {
        String x;
        AppMethodBeat.i(132968);
        if (str == null || "".equals(str.trim())) {
            AppMethodBeat.o(132968);
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isSpace(charArray[i2]) && (x = SpellMap.x(charArray[i2])) != null && x.length() > 0) {
                stringBuffer.append(x.charAt(0));
            }
        }
        String upperCase = stringBuffer.toString().toUpperCase();
        AppMethodBeat.o(132968);
        return upperCase;
    }
}
