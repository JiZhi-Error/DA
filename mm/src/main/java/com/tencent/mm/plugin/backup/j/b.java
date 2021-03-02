package com.tencent.mm.plugin.backup.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IListener;

public final class b {
    private static b oVl;
    IListener oVi;
    IListener oVj;
    IListener oVk;

    public static b chF() {
        AppMethodBeat.i(22162);
        if (oVl == null) {
            oVl = new b();
        }
        b bVar = oVl;
        AppMethodBeat.o(22162);
        return bVar;
    }
}
