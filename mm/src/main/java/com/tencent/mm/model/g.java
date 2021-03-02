package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.c;
import com.tencent.mm.al.ag;
import com.tencent.mm.api.k;

public final class g implements k {
    @Override // com.tencent.mm.api.k
    public final c bs(long j2) {
        AppMethodBeat.i(123953);
        c bs = ag.baj().bs(j2);
        AppMethodBeat.o(123953);
        return bs;
    }
}
