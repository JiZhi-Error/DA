package com.tencent.mm.plugin.appbrand.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a;

public final class c extends a {
    @Override // com.tencent.mm.plugin.fts.a.a
    public final void awY() {
        AppMethodBeat.i(45022);
        if (awZ()) {
            W(-104, 3);
        }
        AppMethodBeat.o(45022);
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final String getTableName() {
        return "WeApp";
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final String getName() {
        return "FTS5WeAppStorage";
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final int getType() {
        return 512;
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final int getPriority() {
        return 512;
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final boolean awZ() {
        AppMethodBeat.i(45023);
        if (!gD(-104, 3)) {
            AppMethodBeat.o(45023);
            return true;
        }
        AppMethodBeat.o(45023);
        return false;
    }
}
