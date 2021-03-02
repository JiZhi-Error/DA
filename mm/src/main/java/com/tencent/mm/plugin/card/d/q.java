package com.tencent.mm.plugin.card.d;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q {
    public static void TF(String str) {
        AppMethodBeat.i(113870);
        if (Build.VERSION.SDK_INT >= 11) {
            new o();
            o.TF(str);
            AppMethodBeat.o(113870);
            return;
        }
        new p();
        p.TF(str);
        AppMethodBeat.o(113870);
    }
}
