package com.tencent.mm.pluginsdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xi;
import com.tencent.mm.sdk.event.EventCenter;

public final class e {
    public static xi bdh(String str) {
        AppMethodBeat.i(151625);
        xi xiVar = new xi();
        xiVar.edC.dJY = 1;
        xiVar.edC.edD = str;
        EventCenter.instance.publish(xiVar);
        AppMethodBeat.o(151625);
        return xiVar;
    }

    public static void bdi(String str) {
        AppMethodBeat.i(151626);
        xi xiVar = new xi();
        xiVar.edC.dJY = 2;
        xiVar.edC.edD = str;
        EventCenter.instance.publish(xiVar);
        AppMethodBeat.o(151626);
    }
}
