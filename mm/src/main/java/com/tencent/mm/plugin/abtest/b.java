package com.tencent.mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.a.a;
import com.tencent.mm.model.a.d;
import com.tencent.mm.model.a.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.s;

public final class b extends y implements c {
    private static b jZc;
    private d jZd = new d();
    private a jZe = new a();

    private b() {
        super(g.class);
        AppMethodBeat.i(153136);
        AppMethodBeat.o(153136);
    }

    public static synchronized b bmZ() {
        b bVar;
        synchronized (b.class) {
            AppMethodBeat.i(153137);
            if (jZc == null) {
                jZc = new b();
            }
            bVar = jZc;
            AppMethodBeat.o(153137);
        }
        return bVar;
    }

    @Override // com.tencent.mm.model.y, com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(153138);
        super.onAccountInitialized(cVar);
        h.d.a(-1879048184, this.jZd);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("abtest", this.jZe);
        AppMethodBeat.o(153138);
    }

    @Override // com.tencent.mm.model.y, com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(153139);
        super.onAccountRelease();
        h.d.a(-1879048184, this.jZd);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("abtest", this.jZe);
        AppMethodBeat.o(153139);
    }
}
