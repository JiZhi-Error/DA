package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.e;

public enum h {
    INST;
    
    e nwG = new e(Process.myPid());

    public static h valueOf(String str) {
        AppMethodBeat.i(48219);
        h hVar = (h) Enum.valueOf(h.class, str);
        AppMethodBeat.o(48219);
        return hVar;
    }

    static {
        AppMethodBeat.i(48221);
        AppMethodBeat.o(48221);
    }

    private h(String str) {
        AppMethodBeat.i(48220);
        this.nwG.bSU();
        AppMethodBeat.o(48220);
    }
}
