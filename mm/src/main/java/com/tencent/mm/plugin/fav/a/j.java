package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ca;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public final class j extends ca {
    public static IAutoDBItem.MAutoDBInfo info = ca.ajs();

    static {
        AppMethodBeat.i(103405);
        AppMethodBeat.o(103405);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public static int HV(int i2) {
        return 1 << i2;
    }
}
