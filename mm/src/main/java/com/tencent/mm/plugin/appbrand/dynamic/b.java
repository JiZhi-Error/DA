package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class b {
    private static MMHandler llG = new MMHandler("DynamicPage#WorkerThread");
    private static MMHandler llH = new MMHandler("DynamicPage#IPCThread");
    private static MMHandler llI = new MMHandler(Looper.getMainLooper());

    static {
        AppMethodBeat.i(121140);
        AppMethodBeat.o(121140);
    }

    public static boolean postToWorker(Runnable runnable) {
        AppMethodBeat.i(121137);
        if (runnable == null) {
            AppMethodBeat.o(121137);
            return false;
        }
        boolean post = llG.post(runnable);
        AppMethodBeat.o(121137);
        return post;
    }

    public static boolean j(Runnable runnable, long j2) {
        AppMethodBeat.i(121138);
        if (runnable == null) {
            AppMethodBeat.o(121138);
            return false;
        }
        boolean postDelayed = llG.postDelayed(runnable, j2);
        AppMethodBeat.o(121138);
        return postDelayed;
    }

    public static boolean V(Runnable runnable) {
        AppMethodBeat.i(121139);
        boolean post = llI.post(runnable);
        AppMethodBeat.o(121139);
        return post;
    }
}
