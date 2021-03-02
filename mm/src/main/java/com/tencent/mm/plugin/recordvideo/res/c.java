package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class c implements bd {
    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(237202);
        e.BYn.init();
        f.BYo.init();
        d dVar = d.BYj;
        d.init();
        g.BYp.init();
        AppMethodBeat.o(237202);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(237203);
        e.BYn.iUx.dead();
        f.BYo.iUx.dead();
        d dVar = d.BYj;
        g.BYp.iUx.dead();
        AppMethodBeat.o(237203);
    }
}
