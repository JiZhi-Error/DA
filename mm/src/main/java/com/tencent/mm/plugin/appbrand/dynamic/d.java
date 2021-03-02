package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d {
    private static volatile d llV;
    Map<String, c> llW = new ConcurrentHashMap();

    private d() {
        AppMethodBeat.i(121156);
        AppMethodBeat.o(121156);
    }

    public static d bBH() {
        AppMethodBeat.i(121157);
        if (llV == null) {
            synchronized (d.class) {
                try {
                    if (llV == null) {
                        llV = new d();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(121157);
                    throw th;
                }
            }
        }
        d dVar = llV;
        AppMethodBeat.o(121157);
        return dVar;
    }

    public final c Yi(String str) {
        AppMethodBeat.i(121158);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.DynamicPageViewIPCProxyManager", "get IPCProxy from manager failed, key is null or nil.");
            AppMethodBeat.o(121158);
            return null;
        }
        c cVar = this.llW.get(str);
        AppMethodBeat.o(121158);
        return cVar;
    }
}
