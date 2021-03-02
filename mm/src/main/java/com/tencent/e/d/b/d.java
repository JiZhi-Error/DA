package com.tencent.e.d.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class d {
    private static Object RMt;
    private static Method RMu;
    private static boolean RMv;

    static {
        AppMethodBeat.i(138362);
        RMt = null;
        RMu = null;
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                RMt = f.nH("libcore.io.Libcore", "os");
                RMu = f.a("libcore.io.Os", "stat", String.class);
                RMv = true;
                AppMethodBeat.o(138362);
                return;
            } catch (Throwable th) {
            }
        }
        RMv = false;
        AppMethodBeat.o(138362);
    }

    public static boolean isAvailable() {
        return RMv;
    }

    public static int bqb(String str) {
        AppMethodBeat.i(138361);
        if (!RMv) {
            AppMethodBeat.o(138361);
            return 0;
        }
        Object invoke = RMu.invoke(RMt, str);
        if (invoke == null) {
            AppMethodBeat.o(138361);
            return 0;
        }
        int intValue = ((Integer) f.c(invoke.getClass(), "st_mode", invoke)).intValue();
        AppMethodBeat.o(138361);
        return intValue;
    }
}
