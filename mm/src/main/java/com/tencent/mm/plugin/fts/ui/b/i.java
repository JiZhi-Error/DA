package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.ui.d.j;

public final class i extends a {
    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final e a(Context context, e.b bVar, int i2) {
        AppMethodBeat.i(112141);
        j jVar = new j(context, bVar, i2);
        AppMethodBeat.o(112141);
        return jVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final int getType() {
        return 4176;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final int getPriority() {
        return Integer.MAX_VALUE;
    }
}
