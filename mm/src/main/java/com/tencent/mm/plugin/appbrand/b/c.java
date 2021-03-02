package com.tencent.mm.plugin.appbrand.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class c {
    public HashMap<String, a> lbc = new HashMap<>();

    public c() {
        AppMethodBeat.i(44824);
        AppMethodBeat.o(44824);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(44825);
        if (aVar == null || Util.isNullOrNil(aVar.dJX)) {
            Log.e("MicroMsg.AppbrandMediaCdnItemManager", "item is null or local id is null, ignore this add");
            AppMethodBeat.o(44825);
            return;
        }
        Log.i("MicroMsg.AppbrandMediaCdnItemManager", "add cdn item, local id : %s, file path : %s", aVar.dJX, aVar.laR);
        this.lbc.put(aVar.dJX, aVar);
        AppMethodBeat.o(44825);
    }

    public final a WH(String str) {
        AppMethodBeat.i(44826);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.AppbrandMediaCdnItemManager", "get by local id error, local id is null or nil");
            AppMethodBeat.o(44826);
            return null;
        }
        a aVar = this.lbc.get(str);
        AppMethodBeat.o(44826);
        return aVar;
    }
}
