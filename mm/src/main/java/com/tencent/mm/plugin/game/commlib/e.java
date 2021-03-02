package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;

public final class e {
    private static final String hja = (MMApplicationContext.getPackageName() + ":tools");
    private static LinkedList<String> xvr = new LinkedList<>();
    private static final String xvs = MMApplicationContext.getPackageName();
    private static final String xvt = (MMApplicationContext.getPackageName() + ":toolsmp");

    static {
        AppMethodBeat.i(149404);
        xvr.add(hja);
        xvr.add(xvt);
        AppMethodBeat.o(149404);
    }

    public static void azp(String str) {
        AppMethodBeat.i(149402);
        if (str.equals(xvs) || xvr.contains(str)) {
            a.dSS();
        }
        AppMethodBeat.o(149402);
    }

    public static void dTe() {
        AppMethodBeat.i(149403);
        Iterator<String> it = xvr.iterator();
        while (it.hasNext()) {
            h.a(it.next(), null, a.class, null);
        }
        AppMethodBeat.o(149403);
    }

    static class a implements b {
        private a() {
        }

        @Override // com.tencent.mm.ipcinvoker.b
        public void invoke(Object obj, d dVar) {
            AppMethodBeat.i(149401);
            a.dSS();
            AppMethodBeat.o(149401);
        }
    }
}
