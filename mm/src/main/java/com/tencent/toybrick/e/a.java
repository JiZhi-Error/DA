package com.tencent.toybrick.e;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static a Sol = new a();
    private AbstractC2221a Som;
    private Handler Son;
    private HandlerThread mThread;

    /* renamed from: com.tencent.toybrick.e.a$a  reason: collision with other inner class name */
    public interface AbstractC2221a {
    }

    static {
        AppMethodBeat.i(159964);
        AppMethodBeat.o(159964);
    }

    public static a hpK() {
        return Sol;
    }

    public final void execute(Runnable runnable) {
        AppMethodBeat.i(159963);
        if (this.Som == null) {
            if (this.mThread == null || !this.mThread.isAlive()) {
                this.mThread = new HandlerThread("WhenHandler");
                this.mThread.start();
                this.Son = new Handler(this.mThread.getLooper());
            }
            this.Son.post(runnable);
        }
        AppMethodBeat.o(159963);
    }
}
