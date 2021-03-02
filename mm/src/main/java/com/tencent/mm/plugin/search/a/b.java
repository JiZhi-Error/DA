package com.tencent.mm.plugin.search.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.search.ui.a.a.a;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class b implements bd {
    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(28071);
        ((n) g.ah(n.class)).unregisterItemClickHandler(3);
        ((n) g.ah(n.class)).unregisterItemClickHandler(5);
        AppMethodBeat.o(28071);
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(28070);
        ((n) g.ah(n.class)).registerItemClickHandler(3, new a());
        ((n) g.ah(n.class)).registerItemClickHandler(5, new com.tencent.mm.plugin.search.ui.a.a.b());
        AppMethodBeat.o(28070);
    }
}
