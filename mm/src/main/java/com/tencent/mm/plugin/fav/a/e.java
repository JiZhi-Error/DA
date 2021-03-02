package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bw;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public final class e extends bw {
    public static IAutoDBItem.MAutoDBInfo info = bw.ajs();

    static {
        AppMethodBeat.i(103368);
        AppMethodBeat.o(103368);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }
}
