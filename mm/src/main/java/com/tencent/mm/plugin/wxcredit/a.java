package com.tencent.mm.plugin.wxcredit;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class a implements bd {
    static {
        AppMethodBeat.i(72241);
        com.tencent.mm.wallet_core.a.j("WXCreditOpenProcess", e.class);
        com.tencent.mm.wallet_core.a.j("WXCreditManagerProcess", d.class);
        AppMethodBeat.o(72241);
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
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
    }
}
