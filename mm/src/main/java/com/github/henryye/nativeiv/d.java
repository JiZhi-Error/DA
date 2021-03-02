package com.github.henryye.nativeiv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

enum d {
    INSTANCE;
    
    private static int baD = (Runtime.getRuntime().availableProcessors() + 1);
    ExecutorService baE = null;
    ExecutorService baF = null;

    public static d valueOf(String str) {
        AppMethodBeat.i(127346);
        d dVar = (d) Enum.valueOf(d.class, str);
        AppMethodBeat.o(127346);
        return dVar;
    }

    static {
        AppMethodBeat.i(127348);
        AppMethodBeat.o(127348);
    }

    private d(String str) {
        AppMethodBeat.i(127347);
        int max = Math.max(baD, 5);
        this.baE = new ThreadPoolExecutor(1, Math.max(max / 2, 4), 500, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
            /* class com.github.henryye.nativeiv.d.AnonymousClass1 */

            public final Thread newThread(Runnable runnable) {
                AppMethodBeat.i(127343);
                Thread thread = new Thread(runnable, "native_image_decode_net");
                AppMethodBeat.o(127343);
                return thread;
            }
        });
        this.baF = new ThreadPoolExecutor(max - 1, max, 500, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
            /* class com.github.henryye.nativeiv.d.AnonymousClass2 */

            public final Thread newThread(Runnable runnable) {
                AppMethodBeat.i(127344);
                Thread thread = new Thread(runnable, "native_image_decode_local");
                AppMethodBeat.o(127344);
                return thread;
            }
        });
        AppMethodBeat.o(127347);
    }
}
