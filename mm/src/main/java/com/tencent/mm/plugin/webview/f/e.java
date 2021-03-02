package com.tencent.mm.plugin.webview.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

public final class e {
    private static ConcurrentHashMap<Integer, c> Jck = new ConcurrentHashMap<>();

    static {
        AppMethodBeat.i(224490);
        AppMethodBeat.o(224490);
    }

    public static void a(int i2, c cVar) {
        AppMethodBeat.i(224488);
        Jck.put(Integer.valueOf(i2), cVar);
        AppMethodBeat.o(224488);
    }

    public static c agf(int i2) {
        AppMethodBeat.i(224489);
        c remove = Jck.remove(Integer.valueOf(i2));
        AppMethodBeat.o(224489);
        return remove;
    }
}
