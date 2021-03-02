package com.tencent.mm.plugin.sight.encode.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class b {

    public interface a {
        void onError(int i2);
    }

    public static void a(final a aVar, final int i2) {
        AppMethodBeat.i(116211);
        if (aVar == null) {
            AppMethodBeat.o(116211);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.sight.encode.a.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(116207);
                aVar.onError(i2);
                AppMethodBeat.o(116207);
            }
        });
        AppMethodBeat.o(116211);
    }
}
