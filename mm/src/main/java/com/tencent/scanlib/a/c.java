package com.tencent.scanlib.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class c {
    private static c ROq;
    public ExecutorService ROp = Executors.newSingleThreadExecutor();
    private Handler handler = new Handler(Looper.getMainLooper());

    private c() {
        AppMethodBeat.i(174600);
        AppMethodBeat.o(174600);
    }

    public static c hkZ() {
        AppMethodBeat.i(174601);
        if (ROq == null) {
            synchronized (c.class) {
                try {
                    if (ROq == null) {
                        ROq = new c();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(174601);
                    throw th;
                }
            }
        }
        c cVar = ROq;
        AppMethodBeat.o(174601);
        return cVar;
    }
}
