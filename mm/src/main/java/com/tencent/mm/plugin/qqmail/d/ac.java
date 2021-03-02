package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class ac implements bd {
    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
        AppMethodBeat.i(122792);
        if ((i2 & 1) != 0) {
            eGs();
        }
        AppMethodBeat.o(122792);
    }

    public static void eGs() {
        AppMethodBeat.i(122793);
        bp.Kx("qqmail");
        ((l) g.af(l.class)).aST().bjW("qqmail");
        ((k) g.ah(k.class)).getNormalMailAppService().clearData();
        AppMethodBeat.o(122793);
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }
}
