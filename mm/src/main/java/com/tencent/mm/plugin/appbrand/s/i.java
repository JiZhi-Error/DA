package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class i {
    private static AtomicInteger nhX = new AtomicInteger(1);
    public HashMap<String, g> nhY;

    /* synthetic */ i(byte b2) {
        this();
    }

    static {
        AppMethodBeat.i(144363);
        AppMethodBeat.o(144363);
    }

    private i() {
        AppMethodBeat.i(144359);
        this.nhY = new HashMap<>();
        AppMethodBeat.o(144359);
    }

    public static int bPw() {
        AppMethodBeat.i(144360);
        int incrementAndGet = nhX.incrementAndGet();
        AppMethodBeat.o(144360);
        return incrementAndGet;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static i niJ = new i((byte) 0);

        static {
            AppMethodBeat.i(144358);
            AppMethodBeat.o(144358);
        }
    }

    public static i bPC() {
        AppMethodBeat.i(144361);
        i iVar = a.niJ;
        AppMethodBeat.o(144361);
        return iVar;
    }

    public final g adb(String str) {
        AppMethodBeat.i(144362);
        if (this.nhY.containsKey(str)) {
            g gVar = this.nhY.get(str);
            AppMethodBeat.o(144362);
            return gVar;
        }
        AppMethodBeat.o(144362);
        return null;
    }
}
