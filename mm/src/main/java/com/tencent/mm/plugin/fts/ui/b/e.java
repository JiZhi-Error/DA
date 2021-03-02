package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;

public final class e extends a {
    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final com.tencent.mm.plugin.fts.a.d.e a(Context context, e.b bVar, int i2) {
        AppMethodBeat.i(112137);
        com.tencent.mm.plugin.fts.ui.d.e eVar = new com.tencent.mm.plugin.fts.ui.d.e(context, bVar, i2);
        AppMethodBeat.o(112137);
        return eVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final int getType() {
        return 32;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final int getPriority() {
        return 32;
    }
}
