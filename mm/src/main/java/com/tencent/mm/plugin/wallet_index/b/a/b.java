package com.tencent.mm.plugin.wallet_index.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class b {
    public Map<String, c> mPurchaseMap = new HashMap();

    b() {
        AppMethodBeat.i(71804);
        AppMethodBeat.o(71804);
    }

    b(String str, c cVar) {
        AppMethodBeat.i(71805);
        this.mPurchaseMap.clear();
        this.mPurchaseMap.put(str, cVar);
        AppMethodBeat.o(71805);
    }
}
