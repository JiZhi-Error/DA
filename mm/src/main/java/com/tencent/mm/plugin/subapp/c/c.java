package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.model.bd;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class c implements bd {
    private b FJM = new b();

    public c() {
        AppMethodBeat.i(28923);
        AppMethodBeat.o(28923);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(28924);
        h.d.b(38, this.FJM);
        AppMethodBeat.o(28924);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(28925);
        h.d.a(38, this.FJM);
        AppMethodBeat.o(28925);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }
}
