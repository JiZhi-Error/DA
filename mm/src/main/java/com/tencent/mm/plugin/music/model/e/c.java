package com.tencent.mm.plugin.music.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fg;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public final class c extends fg {
    public static IAutoDBItem.MAutoDBInfo info = fg.ajs();

    static {
        AppMethodBeat.i(63178);
        AppMethodBeat.o(63178);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }
}
