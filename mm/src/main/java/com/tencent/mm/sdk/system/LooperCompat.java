package com.tencent.mm.sdk.system;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LooperCompat {
    public static void addMainLooperIdleHandler(final MessageQueue.IdleHandler idleHandler) {
        AppMethodBeat.i(153464);
        if (idleHandler == null) {
            AppMethodBeat.o(153464);
        } else if (Build.VERSION.SDK_INT >= 23) {
            Looper.getMainLooper().getQueue().addIdleHandler(idleHandler);
            AppMethodBeat.o(153464);
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            Looper.myQueue().addIdleHandler(idleHandler);
            AppMethodBeat.o(153464);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.tencent.mm.sdk.system.LooperCompat.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(153463);
                    Looper.myQueue().addIdleHandler(idleHandler);
                    AppMethodBeat.o(153463);
                }
            });
            AppMethodBeat.o(153464);
        }
    }
}
