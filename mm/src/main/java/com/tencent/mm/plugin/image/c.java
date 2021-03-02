package com.tencent.mm.plugin.image;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.m.a.a;
import com.tencent.mm.storage.bz;

public final class c extends y {
    private static c ynM;

    private c() {
        super(q.class);
    }

    public static synchronized c dZD() {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(151490);
            if (ynM == null) {
                ynM = new c();
            }
            cVar = ynM;
            AppMethodBeat.o(151490);
        }
        return cVar;
    }

    public static bz aSV() {
        AppMethodBeat.i(151491);
        g.aAf().azk();
        bz aSV = ((a) g.af(a.class)).aSV();
        AppMethodBeat.o(151491);
        return aSV;
    }
}
