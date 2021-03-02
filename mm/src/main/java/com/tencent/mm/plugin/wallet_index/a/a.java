package com.tencent.mm.plugin.wallet_index.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.wallet_index.c.o;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class a implements bd {
    private o Iqz = new o();

    public a() {
        AppMethodBeat.i(71797);
        AppMethodBeat.o(71797);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(71798);
        EventCenter.instance.addListener(this.Iqz.IqX);
        EventCenter.instance.addListener(this.Iqz.IqY);
        AppMethodBeat.o(71798);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(71799);
        EventCenter.instance.removeListener(this.Iqz.IqX);
        EventCenter.instance.removeListener(this.Iqz.IqY);
        AppMethodBeat.o(71799);
    }
}
