package com.tencent.mm.plugin.expt.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    public static c GM(int i2) {
        AppMethodBeat.i(220293);
        if (i2 == 1) {
            com.tencent.mm.plugin.expt.d.a.a.b bVar = new com.tencent.mm.plugin.expt.d.a.a.b();
            AppMethodBeat.o(220293);
            return bVar;
        } else if (i2 == 2) {
            a aVar = new a();
            AppMethodBeat.o(220293);
            return aVar;
        } else {
            Log.e("EdgeComputingDataCacheFactory", "[EdgeComputingDataCacheFactory] createCache error type : ".concat(String.valueOf(i2)));
            AppMethodBeat.o(220293);
            return null;
        }
    }
}
