package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.e;
import com.tencent.mm.sdk.platformtools.Log;

public final class n {
    public static d m(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(107690);
        Log.i("MicroMsg.ThumbFetcherFactory", "get thumb fetcher, ish265: %s", Boolean.valueOf(e.QW(str)));
        k kVar = new k();
        kVar.init(str, i2, i3, i4);
        AppMethodBeat.o(107690);
        return kVar;
    }
}
