package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;

enum f {
    ;

    public static f valueOf(String str) {
        AppMethodBeat.i(131500);
        f fVar = (f) Enum.valueOf(f.class, str);
        AppMethodBeat.o(131500);
        return fVar;
    }

    public static boolean cbc() {
        return true;
    }

    public static boolean cbd() {
        return Build.VERSION.SDK_INT >= 19;
    }
}
