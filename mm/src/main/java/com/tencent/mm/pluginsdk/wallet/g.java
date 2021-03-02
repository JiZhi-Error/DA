package com.tencent.mm.pluginsdk.wallet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class g {
    public HashMap<String, Object> KxR;

    /* synthetic */ g(byte b2) {
        this();
    }

    private g() {
        AppMethodBeat.i(117596);
        this.KxR = new HashMap<>();
        AppMethodBeat.o(117596);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static final g KxS = new g((byte) 0);

        static {
            AppMethodBeat.i(117595);
            AppMethodBeat.o(117595);
        }
    }

    public static synchronized g gsU() {
        g gVar;
        synchronized (g.class) {
            AppMethodBeat.i(117597);
            gVar = a.KxS;
            AppMethodBeat.o(117597);
        }
        return gVar;
    }

    public final Object get(String str, Object obj) {
        AppMethodBeat.i(117598);
        if (this.KxR.containsKey(str)) {
            Object obj2 = this.KxR.get(str);
            AppMethodBeat.o(117598);
            return obj2;
        }
        AppMethodBeat.o(117598);
        return obj;
    }
}
