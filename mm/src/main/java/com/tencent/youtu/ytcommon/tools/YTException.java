package com.tencent.youtu.ytcommon.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YTException {
    public static void report(Exception exc) {
        AppMethodBeat.i(73373);
        YTLogger.e("YTException", "[YTException.report] ");
        AppMethodBeat.o(73373);
    }

    public static void report(Exception exc, String str, String str2) {
        AppMethodBeat.i(73374);
        YTLogger.w("YTException".concat(String.valueOf(str)), str2);
        AppMethodBeat.o(73374);
    }
}
