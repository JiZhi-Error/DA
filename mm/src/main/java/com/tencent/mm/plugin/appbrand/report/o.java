package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.xweb.WebView;
import java.util.Locale;

public enum o {
    X5,
    Sys,
    XWalk,
    Invalid;

    public static o valueOf(String str) {
        AppMethodBeat.i(48069);
        o oVar = (o) Enum.valueOf(o.class, str);
        AppMethodBeat.o(48069);
        return oVar;
    }

    static {
        AppMethodBeat.i(48071);
        AppMethodBeat.o(48071);
    }

    public static o bUx() {
        AppMethodBeat.i(48070);
        boolean isSys = WebView.isSys();
        boolean isXWalk = WebView.isXWalk();
        boolean isX5 = WebView.isX5();
        boolean[] zArr = {isSys, isXWalk, isX5};
        int i2 = 0;
        for (int i3 = 0; i3 < 3; i3++) {
            if (zArr[i3]) {
                i2++;
            }
        }
        if (!(i2 == 1)) {
            if (BuildInfo.DEBUG) {
                IllegalStateException illegalStateException = new IllegalStateException(String.format(Locale.US, "WebViewType invalid sys[%B] xw[%B] x5[%B]", Boolean.valueOf(isSys), Boolean.valueOf(isXWalk), Boolean.valueOf(isX5)));
                AppMethodBeat.o(48070);
                throw illegalStateException;
            }
            o oVar = Invalid;
            AppMethodBeat.o(48070);
            return oVar;
        } else if (isX5) {
            o oVar2 = X5;
            AppMethodBeat.o(48070);
            return oVar2;
        } else if (isXWalk) {
            o oVar3 = XWalk;
            AppMethodBeat.o(48070);
            return oVar3;
        } else {
            o oVar4 = Sys;
            AppMethodBeat.o(48070);
            return oVar4;
        }
    }
}
