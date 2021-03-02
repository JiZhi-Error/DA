package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class f {
    private static AtomicInteger nhX = new AtomicInteger(1);
    public HashMap<String, d> nhY;

    /* synthetic */ f(byte b2) {
        this();
    }

    static {
        AppMethodBeat.i(144343);
        AppMethodBeat.o(144343);
    }

    private f() {
        AppMethodBeat.i(144339);
        this.nhY = new HashMap<>();
        AppMethodBeat.o(144339);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static f niB = new f((byte) 0);

        static {
            AppMethodBeat.i(144338);
            AppMethodBeat.o(144338);
        }
    }

    public static int bPw() {
        AppMethodBeat.i(144340);
        int incrementAndGet = nhX.incrementAndGet();
        AppMethodBeat.o(144340);
        return incrementAndGet;
    }

    public static f bPA() {
        AppMethodBeat.i(144341);
        f fVar = a.niB;
        AppMethodBeat.o(144341);
        return fVar;
    }

    public final d acZ(String str) {
        AppMethodBeat.i(144342);
        if (this.nhY.containsKey(str)) {
            d dVar = this.nhY.get(str);
            AppMethodBeat.o(144342);
            return dVar;
        }
        AppMethodBeat.o(144342);
        return null;
    }
}
