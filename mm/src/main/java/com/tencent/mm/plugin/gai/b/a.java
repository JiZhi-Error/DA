package com.tencent.mm.plugin.gai.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class a implements bd {
    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(25276);
        Log.i("MicroMsg.SubCoreGai", "SubCoreGai onAccountPostReset!");
        AppMethodBeat.o(25276);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(25277);
        Log.i("MicroMsg.SubCoreGai", "SubCoreGai onAccountRelease!");
        AppMethodBeat.o(25277);
    }
}
