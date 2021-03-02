package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class g implements bd {
    private c iGE = null;

    private static g aWS() {
        AppMethodBeat.i(153100);
        g gVar = (g) y.at(g.class);
        AppMethodBeat.o(153100);
        return gVar;
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
        AppMethodBeat.i(153101);
        c aWT = aWT();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            aWT.KS((String) com.tencent.mm.kernel.g.aAh().azQ().get(328193, (Object) null));
            if (aWT.aWR()) {
                f.KU(aWT.iGz.iGw);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", e2.toString());
        }
        Log.i("MicroMsg.abtest.AbTestManager", "[Abtest] init use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(153101);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(153102);
        c aWT = aWT();
        aWT.iGA = null;
        aWT.iGz = null;
        AppMethodBeat.o(153102);
    }

    public static c aWT() {
        AppMethodBeat.i(153103);
        com.tencent.mm.kernel.g.aAf().azk();
        if (aWS().iGE == null) {
            aWS().iGE = new c();
        }
        c cVar = aWS().iGE;
        AppMethodBeat.o(153103);
        return cVar;
    }
}
