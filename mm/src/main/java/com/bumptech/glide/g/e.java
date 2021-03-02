package com.bumptech.glide.g;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public final class e {
    private static final Executor aNQ = new Executor() {
        /* class com.bumptech.glide.g.e.AnonymousClass1 */
        private final Handler handler = new Handler(Looper.getMainLooper());

        {
            AppMethodBeat.i(204493);
            AppMethodBeat.o(204493);
        }

        public final void execute(Runnable runnable) {
            AppMethodBeat.i(204494);
            this.handler.post(runnable);
            AppMethodBeat.o(204494);
        }
    };
    private static final Executor aNR = new Executor() {
        /* class com.bumptech.glide.g.e.AnonymousClass2 */

        public final void execute(Runnable runnable) {
            AppMethodBeat.i(204495);
            runnable.run();
            AppMethodBeat.o(204495);
        }
    };

    static {
        AppMethodBeat.i(204496);
        AppMethodBeat.o(204496);
    }

    public static Executor qr() {
        return aNQ;
    }

    public static Executor qs() {
        return aNR;
    }
}
