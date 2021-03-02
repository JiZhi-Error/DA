package com.tencent.mm.plugin.address.e;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public static void TF(String str) {
        AppMethodBeat.i(21056);
        if (Build.VERSION.SDK_INT >= 11) {
            new b();
            b.TF(str);
            AppMethodBeat.o(21056);
            return;
        }
        new c();
        c.TF(str);
        AppMethodBeat.o(21056);
    }
}
