package com.tencent.mm.plugin.appbrand.utils;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ag {
    public static boolean LB() {
        AppMethodBeat.i(185648);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            AppMethodBeat.o(185648);
            return true;
        } else if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            AppMethodBeat.o(185648);
            return true;
        } else {
            AppMethodBeat.o(185648);
            return false;
        }
    }
}
