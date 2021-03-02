package com.tencent.mm.plugin.wenote.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h extends o {
    public h() {
        this.dLl = "";
        this.qPN = "";
        this.dUs = "";
        this.type = -1;
    }

    @Override // com.tencent.mm.plugin.wenote.model.a.c, com.tencent.mm.plugin.wenote.model.a.o
    public final String gjF() {
        AppMethodBeat.i(30375);
        String gjF = super.gjF();
        AppMethodBeat.o(30375);
        return gjF;
    }

    @Override // com.tencent.mm.plugin.wenote.model.a.c
    public final int getType() {
        return this.type;
    }
}
