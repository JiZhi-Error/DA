package com.tencent.mm.plugin.game.commlib.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public final class a {
    private static LinkedList<b> ndV = new LinkedList<>();

    static {
        AppMethodBeat.i(89959);
        AppMethodBeat.o(89959);
    }

    public static void a(b bVar) {
        AppMethodBeat.i(89957);
        ndV.add(bVar);
        AppMethodBeat.o(89957);
    }

    public static void dpY() {
        AppMethodBeat.i(89958);
        Iterator<b> it = ndV.iterator();
        while (it.hasNext()) {
            it.next().awp();
        }
        AppMethodBeat.o(89958);
    }
}
