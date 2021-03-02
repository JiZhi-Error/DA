package com.tencent.mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.b;

public final class i {
    public static void Fq(final String str) {
        AppMethodBeat.i(158750);
        if (c.axW().Fo(str)) {
            AppMethodBeat.o(158750);
            return;
        }
        l.post(new Runnable() {
            /* class com.tencent.mm.ipcinvoker.i.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(158748);
                c axW = c.axW();
                String str = str;
                if (g.Fp(str)) {
                    b.i("IPC.IPCBridgeManager", "the same process(%s), do not need to build IPCBridge.", str);
                    AppMethodBeat.o(158748);
                    return;
                }
                axW.Fn(str);
                AppMethodBeat.o(158748);
            }
        });
        AppMethodBeat.o(158750);
    }

    public static void Fr(final String str) {
        AppMethodBeat.i(158751);
        if (c.axW().Fo(str)) {
            AppMethodBeat.o(158751);
            return;
        }
        l.post(new Runnable() {
            /* class com.tencent.mm.ipcinvoker.i.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(158749);
                c.axW().t(str, false);
                AppMethodBeat.o(158749);
            }
        });
        AppMethodBeat.o(158751);
    }
}
