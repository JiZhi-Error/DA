package com.tencent.mm.aa.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.e;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class g {
    private final Map<String, e> hpv = new HashMap();

    public g() {
        AppMethodBeat.i(144820);
        AppMethodBeat.o(144820);
    }

    public final void a(e eVar) {
        AppMethodBeat.i(144821);
        this.hpv.put(eVar.getName(), eVar);
        AppMethodBeat.o(144821);
    }

    public final e Fy(String str) {
        AppMethodBeat.i(144822);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(144822);
            return null;
        }
        e eVar = this.hpv.get(str);
        AppMethodBeat.o(144822);
        return eVar;
    }
}
