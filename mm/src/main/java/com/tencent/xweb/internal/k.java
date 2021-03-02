package com.tencent.xweb.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class k {
    private static ConcurrentMap<WebView.c, f> SDQ = new ConcurrentHashMap(3);

    static {
        AppMethodBeat.i(183531);
        AppMethodBeat.o(183531);
    }

    public static void a(WebView.c cVar, f fVar) {
        AppMethodBeat.i(183529);
        SDQ.put(cVar, fVar);
        AppMethodBeat.o(183529);
    }

    public static f f(WebView.c cVar) {
        AppMethodBeat.i(183530);
        f fVar = SDQ.get(cVar);
        AppMethodBeat.o(183530);
        return fVar;
    }
}
