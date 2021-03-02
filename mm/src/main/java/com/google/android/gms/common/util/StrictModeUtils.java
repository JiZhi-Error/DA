package com.google.android.gms.common.util;

import android.os.StrictMode;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class StrictModeUtils {
    public static StrictMode.ThreadPolicy setDynamiteThreadPolicy() {
        AppMethodBeat.i(5289);
        StrictMode.noteSlowCall("gcore.dynamite");
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        AppMethodBeat.o(5289);
        return threadPolicy;
    }
}
