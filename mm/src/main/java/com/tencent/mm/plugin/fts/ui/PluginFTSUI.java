package com.tencent.mm.plugin.fts.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.d;
import com.tencent.mm.plugin.fts.ui.b.h;
import com.tencent.mm.plugin.fts.ui.b.i;
import com.tencent.mm.plugin.fts.ui.b.j;
import com.tencent.mm.plugin.fts.ui.b.k;
import com.tencent.mm.plugin.fts.ui.b.n;

public class PluginFTSUI extends f implements b, c {
    @Override // com.tencent.mm.kernel.a.b.b
    public void parallelsDependency() {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(112049);
        registerUILogic();
        n nVar = n.UWX;
        n.onCreate();
        AppMethodBeat.o(112049);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(112050);
        n nVar = n.UWX;
        n.onDestroy();
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(16);
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(32);
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(48);
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(64);
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(112);
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4112);
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4128);
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4176);
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(8192);
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(160);
        AppMethodBeat.o(112050);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    private void registerUILogic() {
        AppMethodBeat.i(112051);
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new k());
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new com.tencent.mm.plugin.fts.ui.b.e());
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new com.tencent.mm.plugin.fts.ui.b.c());
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new h());
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new com.tencent.mm.plugin.fts.ui.b.g());
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new j());
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new d());
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new com.tencent.mm.plugin.fts.ui.b.b());
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new i());
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new a());
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new com.tencent.mm.plugin.fts.ui.b.f());
        AppMethodBeat.o(112051);
    }
}
