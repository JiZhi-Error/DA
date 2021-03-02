package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bx;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public final class f extends bx {
    public static IAutoDBItem.MAutoDBInfo info = bx.ajs();

    static {
        AppMethodBeat.i(103369);
        AppMethodBeat.o(103369);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }
}
