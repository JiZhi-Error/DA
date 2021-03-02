package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;

public final class b extends a {
    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final e a(Context context, e.b bVar, int i2) {
        AppMethodBeat.i(112134);
        com.tencent.mm.plugin.fts.ui.d.b bVar2 = new com.tencent.mm.plugin.fts.ui.d.b(context, bVar, i2);
        AppMethodBeat.o(112134);
        return bVar2;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final int getType() {
        return 4128;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final int getPriority() {
        return Integer.MAX_VALUE;
    }
}
