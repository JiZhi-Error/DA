package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.x;
import java.util.ArrayList;

public final class ao implements x {
    @Override // com.tencent.mm.plugin.appbrand.service.x
    public final x.a byv() {
        AppMethodBeat.i(44663);
        x.a aVar = new x.a();
        aVar.iHf = new ArrayList(0);
        aVar.nMt = -1;
        aVar.dQx = "";
        if (!g.aAf().hpY) {
            AppMethodBeat.o(44663);
        } else if (!i.bxK()) {
            AppMethodBeat.o(44663);
        } else {
            AppMethodBeat.o(44663);
        }
        return aVar;
    }
}
