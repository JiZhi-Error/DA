package com.tencent.mm.plugin.appbrand.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.FutureTask;

public class l implements Runnable {
    private final FutureTask<?> cPv;

    public l(Runnable runnable) {
        AppMethodBeat.i(221348);
        this.cPv = new FutureTask<>(runnable, 0);
        AppMethodBeat.o(221348);
    }

    public void run() {
        AppMethodBeat.i(221349);
        this.cPv.run();
        AppMethodBeat.o(221349);
    }
}
