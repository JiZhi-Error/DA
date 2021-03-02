package com.tencent.mm.plugin.wenote.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e extends o {
    public long JHM;

    public e(long j2) {
        this.JHM = j2;
        this.dLl = "";
        this.qPN = "";
        this.dUs = "";
        this.type = -3;
    }

    @Override // com.tencent.mm.plugin.wenote.model.a.c, com.tencent.mm.plugin.wenote.model.a.o
    public final String gjF() {
        AppMethodBeat.i(30374);
        String gjF = super.gjF();
        AppMethodBeat.o(30374);
        return gjF;
    }

    @Override // com.tencent.mm.plugin.wenote.model.a.c
    public final int getType() {
        return this.type;
    }
}
