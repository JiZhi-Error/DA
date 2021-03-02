package com.tencent.mm.plugin.cdndownloader.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class a {
    private static volatile MMHandler dgG;
    private static final Object ogA = new Object();

    static {
        AppMethodBeat.i(120817);
        AppMethodBeat.o(120817);
    }

    public static MMHandler cyh() {
        AppMethodBeat.i(184035);
        if (dgG == null) {
            synchronized (ogA) {
                try {
                    if (dgG == null) {
                        dgG = new MMHandler("CDNDownloader#WorkThread");
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(184035);
                    throw th;
                }
            }
        }
        MMHandler mMHandler = dgG;
        AppMethodBeat.o(184035);
        return mMHandler;
    }
}
