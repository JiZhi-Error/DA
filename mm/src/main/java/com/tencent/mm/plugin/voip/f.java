package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.q.a;

public final class f {
    public static boolean cC(Context context) {
        AppMethodBeat.i(259525);
        boolean cC = a.cC(context);
        AppMethodBeat.o(259525);
        return cC;
    }

    public static boolean hy(Context context) {
        AppMethodBeat.i(259524);
        boolean o = a.o(context, true);
        AppMethodBeat.o(259524);
        return o;
    }
}
