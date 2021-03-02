package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.LinkedBlockingQueue;

public final class b {
    private static volatile b JLX;
    public static Object lock = new Object();
    h JLY = new h("WePkgDownloadExcutor", new LinkedBlockingQueue(24));

    static {
        AppMethodBeat.i(110591);
        AppMethodBeat.o(110591);
    }

    public static b gkJ() {
        AppMethodBeat.i(110589);
        if (JLX == null) {
            synchronized (lock) {
                try {
                    if (JLX == null) {
                        JLX = new b();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(110589);
                    throw th;
                }
            }
        }
        b bVar = JLX;
        AppMethodBeat.o(110589);
        return bVar;
    }

    private b() {
        AppMethodBeat.i(110590);
        AppMethodBeat.o(110590);
    }
}
