package com.tencent.mm.plugin.clean.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;

public final class a {
    private static final MMHandler qpF = new MMHandler();
    private static ArrayList<Object> qpG;
    private static long qpH = 0;
    private static int qpI = 0;
    private static long qpt = 0;
    private static long qpu = 0;
    private static long qpv = 0;

    static {
        AppMethodBeat.i(22808);
        AppMethodBeat.o(22808);
    }

    public static final void cyK() {
        AppMethodBeat.i(22806);
        Log.i("MicroMsg.CleanLogic", "startCleanDataNow");
        qpF.removeCallbacksAndMessages(null);
        qpt = 0;
        qpH = 0;
        Log.i("MicroMsg.CleanLogic", "set analyse data: is null? %b", Boolean.TRUE);
        qpG = null;
        qpI = 0;
        AppMethodBeat.o(22806);
    }
}
