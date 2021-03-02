package com.tencent.mm.plugin.appbrand.g.d;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import rx.g;
import rx.schedulers.Schedulers;

public class a implements Executor {
    private static a llr;
    private final g lls = Schedulers.from(this);
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    private a() {
        AppMethodBeat.i(159030);
        AppMethodBeat.o(159030);
    }

    public static g bBF() {
        AppMethodBeat.i(159031);
        if (llr == null) {
            synchronized (a.class) {
                try {
                    if (llr == null) {
                        llr = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(159031);
                    throw th;
                }
            }
        }
        g gVar = llr.lls;
        AppMethodBeat.o(159031);
        return gVar;
    }

    public void execute(Runnable runnable) {
        AppMethodBeat.i(159032);
        this.mHandler.post(runnable);
        AppMethodBeat.o(159032);
    }
}
