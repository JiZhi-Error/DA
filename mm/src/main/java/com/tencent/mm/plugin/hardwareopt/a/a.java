package com.tencent.mm.plugin.hardwareopt.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hardwareopt.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.e;

public final class a implements com.tencent.mm.plugin.hardwareopt.a.a.a {
    @Override // com.tencent.mm.plugin.hardwareopt.a.a.a
    public final void qe(boolean z) {
        AppMethodBeat.i(55554);
        new e().H(MMApplicationContext.getContext()).e(new com.tencent.mm.plugin.hardwareopt.c.a()).d(new b(z)).a(new d.a() {
            /* class com.tencent.mm.plugin.hardwareopt.a.a.AnonymousClass2 */

            @Override // com.tencent.mm.vending.g.d.a
            public final void cn(Object obj) {
                AppMethodBeat.i(55553);
                Log.w("MicroMsg.HardwareProvider", "hy: on interrupt.");
                AppMethodBeat.o(55553);
            }
        }).a(new d.b<Boolean>() {
            /* class com.tencent.mm.plugin.hardwareopt.a.a.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.g.d.b
            public final /* synthetic */ void bz(Boolean bool) {
                AppMethodBeat.i(55552);
                Log.i("MicroMsg.HardwareProvider", "hy: on terminate");
                AppMethodBeat.o(55552);
            }
        });
        AppMethodBeat.o(55554);
    }
}
