package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public final class TaskExecutors {
    public static final Executor MAIN_THREAD = new zza();
    static final Executor zzagd = new zzt();

    static final class zza implements Executor {
        private final Handler mHandler = new Handler(Looper.getMainLooper());

        public zza() {
            AppMethodBeat.i(13346);
            AppMethodBeat.o(13346);
        }

        public final void execute(Runnable runnable) {
            AppMethodBeat.i(13347);
            this.mHandler.post(runnable);
            AppMethodBeat.o(13347);
        }
    }

    static {
        AppMethodBeat.i(13348);
        AppMethodBeat.o(13348);
    }

    private TaskExecutors() {
    }
}
