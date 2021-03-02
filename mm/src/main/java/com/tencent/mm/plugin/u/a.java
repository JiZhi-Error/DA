package com.tencent.mm.plugin.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.modelcontrol.d;

public final class a extends y {
    private static a AXO;

    public static synchronized a eCP() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(151531);
            if (AXO == null) {
                AXO = new a();
            }
            aVar = AXO;
            AppMethodBeat.o(151531);
        }
        return aVar;
    }

    private a() {
        super(d.class);
    }
}
