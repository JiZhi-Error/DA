package com.tencent.mm.danmaku.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.Thread;

public final class b implements Thread.UncaughtExceptionHandler {
    public final void uncaughtException(Thread thread, Throwable th) {
        AppMethodBeat.i(241755);
        e.e("DanmakuManager", "danmaku crash thread:" + thread.getName(), th);
        AppMethodBeat.o(241755);
    }
}
