package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.service.o;

public final class b implements o {
    @Override // com.tencent.mm.plugin.appbrand.service.o
    public final int beL() {
        AppMethodBeat.i(231566);
        int bfc = o.bfc();
        AppMethodBeat.o(231566);
        return bfc;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.o
    public final int beM() {
        AppMethodBeat.i(231567);
        int beM = o.beM();
        AppMethodBeat.o(231567);
        return beM;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.o
    public final boolean beN() {
        AppMethodBeat.i(231568);
        bg.aVF();
        boolean azn = c.azn();
        AppMethodBeat.o(231568);
        return azn;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.o
    public final String beO() {
        return o.jjJ;
    }
}
