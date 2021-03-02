package com.tencent.mm.plugin.appbrand.jsapi.ag.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.HashMap;

public final class c extends bc {
    private static final int CTRL_INDEX = 675;
    private static final String NAME = "onXWebCanvasSurfaceChange";
    private static final c mJG = new c();

    static {
        AppMethodBeat.i(139463);
        AppMethodBeat.o(139463);
    }

    public static synchronized void e(f fVar, int i2) {
        synchronized (c.class) {
            AppMethodBeat.i(139462);
            HashMap hashMap = new HashMap(1);
            hashMap.put("viewId", Integer.valueOf(i2));
            mJG.L(hashMap);
            fVar.a(mJG, (int[]) null);
            AppMethodBeat.o(139462);
        }
    }
}
