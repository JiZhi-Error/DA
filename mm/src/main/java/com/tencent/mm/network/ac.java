package com.tencent.mm.network;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;

public final class ac extends q.a {
    @Override // com.tencent.mm.network.q
    public final void a(final long j2, final String str, final boolean z, final boolean z2) {
        AppMethodBeat.i(143768);
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.network.ac.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(143766);
                if (z) {
                    SmcLogic.writeImportKvData(j2, str, z2, false);
                    AppMethodBeat.o(143766);
                    return;
                }
                SmcLogic.writeKvData(j2, str, z2, false);
                AppMethodBeat.o(143766);
            }

            public final String toString() {
                AppMethodBeat.i(143767);
                String str = super.toString() + "|reportKV";
                AppMethodBeat.o(143767);
                return str;
            }
        });
        AppMethodBeat.o(143768);
    }
}
