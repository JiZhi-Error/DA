package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ad {
    public static String adO(String str) {
        AppMethodBeat.i(135207);
        int indexOf = str.indexOf("<page>");
        int indexOf2 = str.indexOf("</page>");
        if (indexOf == -1 || indexOf2 == (-indexOf)) {
            AppMethodBeat.o(135207);
            return "";
        }
        String substring = str.substring(indexOf + 6, indexOf2);
        AppMethodBeat.o(135207);
        return substring;
    }

    public static String adP(String str) {
        AppMethodBeat.i(135208);
        int indexOf = str.indexOf("<style>");
        int indexOf2 = str.indexOf("</style>");
        if (indexOf == -1 || indexOf2 == (-indexOf)) {
            AppMethodBeat.o(135208);
            return "";
        }
        String substring = str.substring(indexOf + 7, indexOf2);
        AppMethodBeat.o(135208);
        return substring;
    }

    public static String adQ(String str) {
        AppMethodBeat.i(135209);
        String str2 = "";
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf("<script>", i2);
            int indexOf2 = str.indexOf("</script>", i2);
            if (indexOf == -1 || indexOf2 == -1 || indexOf2 <= indexOf) {
                AppMethodBeat.o(135209);
            } else {
                str2 = str2 + (i2 > 0 ? ";" : "") + str.substring(indexOf + 8, indexOf2);
                i2 = indexOf2 + 9;
            }
        }
        AppMethodBeat.o(135209);
        return str2;
    }
}
