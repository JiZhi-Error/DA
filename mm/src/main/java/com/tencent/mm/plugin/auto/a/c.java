package com.tencent.mm.plugin.auto.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class c implements bd {
    private a oIH = new a();

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    public c() {
        AppMethodBeat.i(21158);
        AppMethodBeat.o(21158);
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(21159);
        Log.i("MicroMsg.auto.SubCoreAuto", "onAccountPostReset");
        EventCenter.instance.addListener(this.oIH.oID);
        AppMethodBeat.o(21159);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(21160);
        Log.i("MicroMsg.auto.SubCoreAuto", "onAccountRelease");
        EventCenter.instance.removeListener(this.oIH.oID);
        AppMethodBeat.o(21160);
    }
}
