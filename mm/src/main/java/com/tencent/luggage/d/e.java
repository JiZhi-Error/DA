package com.tencent.luggage.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public final class e {
    final LinkedList<Class<? extends b>> ctd = new LinkedList<>();

    public e() {
        AppMethodBeat.i(140371);
        AppMethodBeat.o(140371);
    }

    public final void E(List<Class<? extends b>> list) {
        AppMethodBeat.i(140372);
        for (Class<? extends b> cls : list) {
            this.ctd.add(cls);
        }
        AppMethodBeat.o(140372);
    }
}
