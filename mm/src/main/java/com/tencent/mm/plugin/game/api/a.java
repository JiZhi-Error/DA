package com.tencent.mm.plugin.game.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public final class a {
    private static LinkedList<h> xtW = new LinkedList<>();

    static {
        AppMethodBeat.i(89655);
        AppMethodBeat.o(89655);
    }

    public static void a(h hVar) {
        AppMethodBeat.i(89651);
        if (hVar != null) {
            xtW.add(hVar);
        }
        AppMethodBeat.o(89651);
    }

    public static void b(h hVar) {
        AppMethodBeat.i(89652);
        if (hVar != null) {
            xtW.remove(hVar);
        }
        AppMethodBeat.o(89652);
    }

    public static void ea(String str, int i2) {
        AppMethodBeat.i(89653);
        Iterator<h> it = xtW.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next != null) {
                next.eb(str, i2);
            }
        }
        AppMethodBeat.o(89653);
    }

    public static void e(String str, float f2) {
        AppMethodBeat.i(89654);
        Iterator<h> it = xtW.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next != null) {
                next.f(str, f2);
            }
        }
        AppMethodBeat.o(89654);
    }
}
