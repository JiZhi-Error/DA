package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class c {
    private static AtomicInteger nhX = new AtomicInteger(1);
    public HashMap<String, b> nhY;

    /* synthetic */ c(byte b2) {
        this();
    }

    static {
        AppMethodBeat.i(144315);
        AppMethodBeat.o(144315);
    }

    private c() {
        AppMethodBeat.i(144311);
        this.nhY = new HashMap<>();
        AppMethodBeat.o(144311);
    }

    public static int bPw() {
        AppMethodBeat.i(144312);
        int incrementAndGet = nhX.incrementAndGet();
        AppMethodBeat.o(144312);
        return incrementAndGet;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static c nhZ = new c((byte) 0);

        static {
            AppMethodBeat.i(144310);
            AppMethodBeat.o(144310);
        }
    }

    public static c bPx() {
        AppMethodBeat.i(144313);
        c cVar = a.nhZ;
        AppMethodBeat.o(144313);
        return cVar;
    }

    public final b acV(String str) {
        AppMethodBeat.i(144314);
        if (this.nhY.containsKey(str)) {
            b bVar = this.nhY.get(str);
            AppMethodBeat.o(144314);
            return bVar;
        }
        AppMethodBeat.o(144314);
        return null;
    }
}
