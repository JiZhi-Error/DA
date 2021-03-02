package com.google.android.gms.common.util;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ThreadUtils {
    private ThreadUtils() {
    }

    public static boolean isMainThread() {
        AppMethodBeat.i(5296);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            AppMethodBeat.o(5296);
            return true;
        }
        AppMethodBeat.o(5296);
        return false;
    }
}
