package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class t {
    public int iAk;
    public int iAl;

    public static final t HI(String str) {
        Map<String, String> map;
        AppMethodBeat.i(20241);
        t tVar = new t();
        k.b aD = k.b.aD(str, null);
        if (!(aD == null || (map = aD.izF) == null)) {
            tVar.iAk = Util.getInt(map.get(".msg.appmsg.xmlfulllen"), 0);
            tVar.iAl = Util.getInt(map.get(".msg.appmsg.realinnertype"), 0);
        }
        AppMethodBeat.o(20241);
        return tVar;
    }
}
