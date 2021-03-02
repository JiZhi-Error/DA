package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.c;

public final class u {
    private static u rDS = null;
    private c rDT;
    private f rDU;

    private static u cLw() {
        AppMethodBeat.i(23694);
        if (rDS == null) {
            rDS = new u();
        }
        u uVar = rDS;
        AppMethodBeat.o(23694);
        return uVar;
    }

    public static f cLx() {
        AppMethodBeat.i(23695);
        if (cLw().rDU == null) {
            cLw().rDU = new f();
        }
        f fVar = cLw().rDU;
        AppMethodBeat.o(23695);
        return fVar;
    }

    public static void a(m mVar) {
        AppMethodBeat.i(23696);
        cLy().rxT = mVar;
        AppMethodBeat.o(23696);
    }

    public static c cLy() {
        AppMethodBeat.i(23697);
        if (cLw().rDT == null) {
            cLw().rDT = c.cKq();
        }
        c cVar = cLw().rDT;
        AppMethodBeat.o(23697);
        return cVar;
    }
}
