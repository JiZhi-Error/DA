package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class f {
    private static Map<Integer, h> ADt;
    static Map<Integer, j> ADu;
    private static f ADv;

    public static f exq() {
        AppMethodBeat.i(127218);
        if (ADv == null) {
            ADv = new f();
        }
        f fVar = ADv;
        AppMethodBeat.o(127218);
        return fVar;
    }

    private f() {
        AppMethodBeat.i(127219);
        ADt = new HashMap();
        ADu = new HashMap();
        AppMethodBeat.o(127219);
    }

    public static h Tz(int i2) {
        AppMethodBeat.i(127220);
        h hVar = ADt.get(Integer.valueOf(i2));
        if (hVar == null) {
            hVar = null;
            Log.i("MicroMsg.NewTips.NewTipsFilterPool", "Invalid tipsId:%s", Integer.valueOf(i2));
        }
        AppMethodBeat.o(127220);
        return hVar;
    }
}
