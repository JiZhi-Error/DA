package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.fts.a.n;

public final class a extends y implements b {
    private static a AHc;

    public static synchronized a eyT() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(231769);
            if (AHc == null) {
                AHc = new a();
            }
            aVar = AHc;
            AppMethodBeat.o(231769);
        }
        return aVar;
    }

    private a() {
        super(com.tencent.mm.br.b.bfR("notification"));
        AppMethodBeat.i(26743);
        AppMethodBeat.o(26743);
    }

    @Override // com.tencent.mm.kernel.a.b.b
    public final void parallelsDependency() {
        AppMethodBeat.i(26744);
        com.tencent.mm.kernel.a.b.a.a(this, c.class).bI(g.ah(n.class));
        AppMethodBeat.o(26744);
    }
}
