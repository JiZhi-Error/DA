package com.tencent.mm.plugin.appbrand.jsapi.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.jsapi.z.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;

public final class a extends s {
    private static final int CTRL_INDEX = 153;
    private static final String NAME = "onNetworkStatusChange";

    public static void m(f fVar) {
        AppMethodBeat.i(134890);
        HashMap hashMap = new HashMap();
        f.c dS = f.dS(MMApplicationContext.getContext());
        hashMap.put("isConnected", Boolean.valueOf(dS != f.c.None));
        hashMap.put("networkType", dS.value);
        Log.i("MicroMsg.AppBrandOnNetworkStatusChangeEvent", "networkType = %s", dS.value);
        new a().g(fVar).L(hashMap).bEo();
        AppMethodBeat.o(134890);
    }
}
