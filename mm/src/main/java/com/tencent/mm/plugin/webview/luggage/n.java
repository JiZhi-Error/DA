package com.tencent.mm.plugin.webview.luggage;

import android.os.Looper;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.f.c;
import com.tencent.mm.plugin.webview.f.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;

public final class n {
    private static HashMap<String, Integer> IUH = new HashMap<>();

    static {
        AppMethodBeat.i(78406);
        AppMethodBeat.o(78406);
    }

    public static int a(p pVar, c cVar) {
        AppMethodBeat.i(210934);
        int intValue = r.a(MMApplicationContext.getContext(), pVar).intValue();
        e.a(pVar.hashCode(), cVar);
        AppMethodBeat.o(210934);
        return intValue;
    }

    public static void remove(int i2) {
        AppMethodBeat.i(78405);
        final p c2 = r.c(Integer.valueOf(i2));
        if (c2 != null) {
            e.agf(c2.hashCode());
            if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
                try {
                    c2.destroy();
                    AppMethodBeat.o(78405);
                    return;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.LuggageWebCoreStash", e2, "", new Object[0]);
                    AppMethodBeat.o(78405);
                    return;
                }
            } else {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.luggage.n.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(78403);
                        try {
                            c2.destroy();
                            AppMethodBeat.o(78403);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.LuggageWebCoreStash", e2, "", new Object[0]);
                            AppMethodBeat.o(78403);
                        }
                    }
                });
            }
        }
        AppMethodBeat.o(78405);
    }
}
