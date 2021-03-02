package com.tencent.mm.plugin.wenote.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends o {
    public a() {
        this.dLl = "";
        this.qPN = "";
        this.dUs = "";
        this.type = -2;
    }

    @Override // com.tencent.mm.plugin.wenote.model.a.c, com.tencent.mm.plugin.wenote.model.a.o
    public final String gjF() {
        AppMethodBeat.i(30373);
        String gjF = super.gjF();
        AppMethodBeat.o(30373);
        return gjF;
    }

    @Override // com.tencent.mm.plugin.wenote.model.a.c
    public final int getType() {
        return this.type;
    }
}
