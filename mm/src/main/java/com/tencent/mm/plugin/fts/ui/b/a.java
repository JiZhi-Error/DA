package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e;

public final class a extends com.tencent.mm.plugin.fts.a.d.a {
    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final e a(Context context, e.b bVar, int i2) {
        AppMethodBeat.i(112133);
        com.tencent.mm.plugin.fts.ui.d.a aVar = new com.tencent.mm.plugin.fts.ui.d.a(context, bVar, i2);
        AppMethodBeat.o(112133);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final int getType() {
        return 8192;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final int getPriority() {
        return Integer.MAX_VALUE;
    }
}
