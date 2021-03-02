package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.f;

public final class a {
    public static String afX(String str) {
        AppMethodBeat.i(49863);
        if (str != null) {
            try {
                if (f.bnP(str) <= 12) {
                    AppMethodBeat.o(49863);
                    return str;
                }
                char[] charArray = str.toCharArray();
                int length = charArray.length;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (i2 < length) {
                    i4 += f.bnP(String.valueOf(charArray[i2]));
                    if (i4 >= 12) {
                        String str2 = str.substring(0, i3) + (char) 8230;
                        AppMethodBeat.o(49863);
                        return str2;
                    }
                    i2++;
                    i3++;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(49863);
                return str;
            }
        }
        AppMethodBeat.o(49863);
        return str;
    }
}
