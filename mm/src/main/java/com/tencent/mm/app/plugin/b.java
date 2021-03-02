package com.tencent.mm.app.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.sdk.event.EventCenter;

public final class b {
    public static boolean Xm() {
        AppMethodBeat.i(19662);
        lu luVar = new lu();
        luVar.dRh.dJY = 7;
        EventCenter.instance.publish(luVar);
        boolean z = luVar.dRi.dFE;
        AppMethodBeat.o(19662);
        return z;
    }
}
