package com.tencent.mm.api;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ad {
    public static a djd;

    public interface a {
        ac VL();

        int bD(Context context);

        SmileyPanel bE(Context context);

        SmileyPanel m(Context context, boolean z);
    }

    public static SmileyPanel bC(Context context) {
        AppMethodBeat.i(131332);
        SmileyPanel bE = djd.bE(context);
        AppMethodBeat.o(131332);
        return bE;
    }

    public static SmileyPanel l(Context context, boolean z) {
        AppMethodBeat.i(131333);
        SmileyPanel m = djd.m(context, z);
        AppMethodBeat.o(131333);
        return m;
    }

    public static int bD(Context context) {
        AppMethodBeat.i(131334);
        int bD = djd.bD(context);
        AppMethodBeat.o(131334);
        return bD;
    }

    public static ac VK() {
        AppMethodBeat.i(131335);
        ac VL = djd.VL();
        AppMethodBeat.o(131335);
        return VL;
    }
}
