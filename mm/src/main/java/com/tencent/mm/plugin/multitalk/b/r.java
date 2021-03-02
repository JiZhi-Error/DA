package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* access modifiers changed from: package-private */
public final class r {
    final Map<String, q> qva = new ConcurrentHashMap(1);

    public interface a {
        void a(int i2, int i3, q qVar);
    }

    static /* synthetic */ void a(r rVar, int i2, int i3, String str, q qVar, boolean z, a aVar) {
        AppMethodBeat.i(239306);
        rVar.a(i2, i3, str, qVar, z, aVar);
        AppMethodBeat.o(239306);
    }

    r() {
        AppMethodBeat.i(239303);
        AppMethodBeat.o(239303);
    }

    /* access modifiers changed from: package-private */
    public final void a(final int i2, final int i3, final String str, final q qVar, final boolean z, final a aVar) {
        AppMethodBeat.i(239304);
        p.INSTANCE.aj(new Runnable() {
            /* class com.tencent.mm.plugin.multitalk.b.r.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(239301);
                aVar.a(i2, i3, qVar);
                AppMethodBeat.o(239301);
            }
        });
        AppMethodBeat.o(239304);
    }

    public final void akH(String str) {
        AppMethodBeat.i(239305);
        Log.i("MicroMsg.Multitalk.ILinkSessionMgr", "hy: on exit");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(239305);
            return;
        }
        this.qva.remove(str);
        AppMethodBeat.o(239305);
    }
}
