package com.tencent.mm.plugin.appbrand.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.sdk.event.EventCenter;

public enum b {
    INSTANCE;

    public static b valueOf(String str) {
        AppMethodBeat.i(174718);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(174718);
        return bVar;
    }

    static {
        AppMethodBeat.i(174719);
        AppMethodBeat.o(174719);
    }

    public static void a(String str, k.a aVar, k.b bVar) {
        AppMethodBeat.i(102763);
        fz fzVar = new fz();
        fzVar.dJA.op = 1;
        fzVar.dJA.fileName = str;
        fzVar.dJA.dJC = true;
        fzVar.dJA.dtE = true;
        fzVar.dJA.dJD = aVar;
        fzVar.dJA.dJE = bVar;
        EventCenter.instance.publish(fzVar);
        AppMethodBeat.o(102763);
    }

    public static void pause() {
        AppMethodBeat.i(102764);
        fz fzVar = new fz();
        fzVar.dJA.op = 4;
        EventCenter.instance.publish(fzVar);
        AppMethodBeat.o(102764);
    }

    public static void stop() {
        AppMethodBeat.i(102765);
        fz fzVar = new fz();
        fzVar.dJA.op = 2;
        EventCenter.instance.publish(fzVar);
        AppMethodBeat.o(102765);
    }
}
