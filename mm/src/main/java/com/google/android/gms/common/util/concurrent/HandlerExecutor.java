package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public class HandlerExecutor implements Executor {
    private final Handler handler;

    public HandlerExecutor(Handler handler2) {
        this(handler2.getLooper());
        AppMethodBeat.i(5319);
        AppMethodBeat.o(5319);
    }

    public HandlerExecutor(Looper looper) {
        AppMethodBeat.i(5320);
        this.handler = new Handler(looper);
        AppMethodBeat.o(5320);
    }

    public void execute(Runnable runnable) {
        AppMethodBeat.i(5321);
        this.handler.post(runnable);
        AppMethodBeat.o(5321);
    }
}
