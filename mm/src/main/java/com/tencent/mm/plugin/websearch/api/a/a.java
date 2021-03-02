package com.tencent.mm.plugin.websearch.api.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.i;
import com.tencent.mm.plugin.report.e;

public final class a {
    public static int ID = i.CTRL_INDEX;

    public static void pl(int i2) {
        AppMethodBeat.i(117834);
        e.INSTANCE.idkeyStat((long) ID, (long) i2, 1, false);
        AppMethodBeat.o(117834);
    }
}
