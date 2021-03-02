package com.tencent.mm.br;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    public static m KxT;
    public static l KxU;

    public static void bfQ(String str) {
        AppMethodBeat.i(133693);
        if (g.aAe().azG().aBb()) {
            c.a(str, KxT, KxU);
        }
        AppMethodBeat.o(133693);
    }

    public static void b(final String str, final y yVar) {
        AppMethodBeat.i(133694);
        new a() {
            /* class com.tencent.mm.br.b.AnonymousClass1 */

            @Override // com.tencent.mm.kernel.a.c.b
            public final void execute(com.tencent.mm.kernel.b.g gVar) {
                AppMethodBeat.i(133691);
                String str = str;
                y yVar = yVar;
                c.a(str, b.KxT, b.KxU);
                if (yVar == null) {
                    yVar = new y(b.bfR(str));
                }
                y.a("plugin.".concat(String.valueOf(str)), yVar);
                AppMethodBeat.o(133691);
            }
        }.alone();
        AppMethodBeat.o(133694);
    }

    public static y.a bfR(final String str) {
        AppMethodBeat.i(133695);
        AnonymousClass2 r0 = new y.a() {
            /* class com.tencent.mm.br.b.AnonymousClass2 */

            @Override // com.tencent.mm.model.y.a
            public final bd createSubCore() {
                AppMethodBeat.i(133692);
                bd bfT = c.bfT(str);
                AppMethodBeat.o(133692);
                return bfT;
            }
        };
        Log.i("MicroMsg.PluginCompatHelper", "CompatSubCore creator %s for plugin %s", r0, str);
        AppMethodBeat.o(133695);
        return r0;
    }
}
