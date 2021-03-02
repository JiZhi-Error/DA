package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class a extends s {
    public static final int CTRL_INDEX = 667;
    public static final String NAME = "onGameRecorderStateChange";

    /* access modifiers changed from: package-private */
    public final void e(com.tencent.mm.plugin.appbrand.s sVar) {
        AppMethodBeat.i(45136);
        g(sVar);
        Log.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch pause");
        HashMap hashMap = new HashMap(1);
        hashMap.put("state", "pause");
        L(hashMap).bEo();
        AppMethodBeat.o(45136);
    }

    /* access modifiers changed from: package-private */
    public final void f(com.tencent.mm.plugin.appbrand.s sVar) {
        AppMethodBeat.i(45137);
        g(sVar);
        Log.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch resume");
        HashMap hashMap = new HashMap(1);
        hashMap.put("state", "resume");
        L(hashMap).bEo();
        AppMethodBeat.o(45137);
    }
}
