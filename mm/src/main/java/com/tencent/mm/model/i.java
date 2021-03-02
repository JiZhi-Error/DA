package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.api.l;

public final class i implements l {
    @Override // com.tencent.mm.api.l
    public final k fB(String str) {
        AppMethodBeat.i(123954);
        k fB = ag.bal().fB(str);
        AppMethodBeat.o(123954);
        return fB;
    }

    @Override // com.tencent.mm.api.l
    public final String fC(String str) {
        AppMethodBeat.i(123955);
        String fC = ag.bal().fC(str);
        AppMethodBeat.o(123955);
        return fC;
    }
}
