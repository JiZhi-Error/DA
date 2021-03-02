package com.tencent.mm.plugin.product.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class a implements bd {
    private c AYT = null;
    private d AYU = null;
    private com.tencent.mm.plugin.product.b.a AYV = new com.tencent.mm.plugin.product.b.a();

    public a() {
        AppMethodBeat.i(66847);
        AppMethodBeat.o(66847);
    }

    public static a eDb() {
        AppMethodBeat.i(66848);
        a aVar = (a) y.at(a.class);
        AppMethodBeat.o(66848);
        return aVar;
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
        AppMethodBeat.i(66849);
        this.AYT = null;
        EventCenter.instance.addListener(this.AYV);
        AppMethodBeat.o(66849);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(66850);
        EventCenter.instance.removeListener(this.AYV);
        AppMethodBeat.o(66850);
    }

    public static c eDc() {
        AppMethodBeat.i(66851);
        g.aAf().azk();
        if (eDb().AYT == null) {
            eDb().AYT = new c();
        }
        c cVar = eDb().AYT;
        AppMethodBeat.o(66851);
        return cVar;
    }

    public final d eDd() {
        AppMethodBeat.i(66852);
        g.aAf().azk();
        if (this.AYU == null) {
            this.AYU = new d();
        }
        d dVar = this.AYU;
        AppMethodBeat.o(66852);
        return dVar;
    }
}
