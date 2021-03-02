package com.tencent.mm.danmaku.f;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    @SuppressLint({"HandlerLeak"})
    public static final Handler sHandler = new Handler(Looper.getMainLooper()) {
        /* class com.tencent.mm.danmaku.f.b.AnonymousClass1 */

        public final void handleMessage(Message message) {
            AppMethodBeat.i(241780);
            if (message.obj instanceof Runnable) {
                ((Runnable) message.obj).run();
            }
            super.handleMessage(message);
            AppMethodBeat.o(241780);
        }
    };

    static {
        AppMethodBeat.i(241782);
        AppMethodBeat.o(241782);
    }

    public static void post(Runnable runnable) {
        AppMethodBeat.i(241781);
        sHandler.post(runnable);
        AppMethodBeat.o(241781);
    }
}
