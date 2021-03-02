package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xy;
import com.tencent.mm.sdk.event.EventCenter;

public final class am {
    public static void dl(int i2, String str) {
        AppMethodBeat.i(141491);
        if (EventCenter.instance != null) {
            xy xyVar = new xy();
            xyVar.eem.className = str;
            xyVar.eem.een = i2;
            EventCenter.instance.publish(xyVar);
        }
        AppMethodBeat.o(141491);
    }
}
