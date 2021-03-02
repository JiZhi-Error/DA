package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.sdk.platformtools.Util;

public final class i {
    public static void baY(String str) {
        AppMethodBeat.i(82047);
        if (!Util.isNullOrNil(str) && str.startsWith("http")) {
            q.bcQ().a(str, null);
        }
        AppMethodBeat.o(82047);
    }
}
