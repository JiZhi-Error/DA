package com.tencent.mm.danmaku.a;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    public static boolean gNA;
    private static Application gNz;

    public static Application arU() {
        AppMethodBeat.i(241600);
        if (gNz == null) {
            RuntimeException runtimeException = new RuntimeException("Danmaku not init, please call DanmakuConfig.init()");
            AppMethodBeat.o(241600);
            throw runtimeException;
        }
        Application application = gNz;
        AppMethodBeat.o(241600);
        return application;
    }
}
