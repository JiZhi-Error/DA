package com.tencent.mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.modelstat.q;

public final class a extends y {
    private static a jRs;

    public static synchronized a blX() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(151419);
            if (jRs == null) {
                jRs = new a();
            }
            aVar = jRs;
            AppMethodBeat.o(151419);
        }
        return aVar;
    }

    private a() {
        super(q.class);
    }
}
