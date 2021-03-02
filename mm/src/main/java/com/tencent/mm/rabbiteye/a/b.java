package com.tencent.mm.rabbiteye.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static String gut() {
        AppMethodBeat.i(186315);
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : Looper.getMainLooper().getThread().getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\n");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(186315);
        return sb2;
    }
}
