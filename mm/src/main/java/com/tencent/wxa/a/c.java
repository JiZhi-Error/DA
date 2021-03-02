package com.tencent.wxa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.a;
import io.flutter.plugin.a.j;

public final class c extends a {
    @Override // com.tencent.wxa.a
    public final a.C2227a a(j jVar) {
        AppMethodBeat.i(206315);
        String str = jVar.method;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1266882492:
                if (str.equals("updatePopGestureEnable")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                boolean booleanValue = ((Boolean) jVar.SxX).booleanValue();
                com.tencent.wxa.c hrH = com.tencent.wxa.c.hrH();
                if (hrH.SxG != null) {
                    hrH.SxG.bP(booleanValue);
                }
                a.C2227a eI = eI(Boolean.TRUE);
                AppMethodBeat.o(206315);
                return eI;
            default:
                a.C2227a hrG = hrG();
                AppMethodBeat.o(206315);
                return hrG;
        }
    }
}
