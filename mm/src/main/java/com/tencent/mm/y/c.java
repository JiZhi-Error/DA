package com.tencent.mm.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class c implements bd {
    private static c hmh;
    private a hmi;

    private c() {
        AppMethodBeat.i(150086);
        if (a.hlO == null) {
            a.hlO = new a();
        }
        this.hmi = a.hlO;
        AppMethodBeat.o(150086);
    }

    private static synchronized c axU() {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(150087);
            if (hmh == null) {
                c cVar2 = new c();
                hmh = cVar2;
                cVar2.hmi.init();
            }
            cVar = hmh;
            AppMethodBeat.o(150087);
        }
        return cVar;
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(150088);
        a aVar = this.hmi;
        aVar.listeners.clear();
        b bVar = aVar.hlP;
        Log.d("MicroMsg.NewBadgeDecoder", "[carl] decoder.clear()");
        bVar.hlX.clear();
        bVar.hlZ.clear();
        bVar.hlY.clear();
        bVar.hma.clear();
        aVar.initialized = false;
        AppMethodBeat.o(150088);
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(150089);
        this.hmi.init();
        AppMethodBeat.o(150089);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    public static a axV() {
        AppMethodBeat.i(150090);
        g.aAf().azk();
        a aVar = axU().hmi;
        AppMethodBeat.o(150090);
        return aVar;
    }
}
