package com.tencent.mm.plugin.fav.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;

public final class d extends a {
    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final e a(Context context, e.b bVar, int i2) {
        AppMethodBeat.i(107315);
        e eVar = new e(context, bVar, i2);
        AppMethodBeat.o(107315);
        return eVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final int getType() {
        return 128;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final int getPriority() {
        return 128;
    }
}
