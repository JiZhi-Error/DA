package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class l {
    private static AtomicInteger nhX = new AtomicInteger(1);
    public HashMap<String, d> nhY;

    /* synthetic */ l(byte b2) {
        this();
    }

    static {
        AppMethodBeat.i(144424);
        AppMethodBeat.o(144424);
    }

    private l() {
        AppMethodBeat.i(144420);
        this.nhY = new HashMap<>();
        AppMethodBeat.o(144420);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static l niP = new l((byte) 0);

        static {
            AppMethodBeat.i(144419);
            AppMethodBeat.o(144419);
        }
    }

    public static l bPF() {
        AppMethodBeat.i(144421);
        l lVar = a.niP;
        AppMethodBeat.o(144421);
        return lVar;
    }

    public final d adh(String str) {
        AppMethodBeat.i(144422);
        if (this.nhY.containsKey(str)) {
            d dVar = this.nhY.get(str);
            AppMethodBeat.o(144422);
            return dVar;
        }
        AppMethodBeat.o(144422);
        return null;
    }

    public static int bPw() {
        AppMethodBeat.i(144423);
        int incrementAndGet = nhX.incrementAndGet();
        AppMethodBeat.o(144423);
        return incrementAndGet;
    }
}
