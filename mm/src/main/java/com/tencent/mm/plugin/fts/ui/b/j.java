package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.ui.d.k;

public final class j extends a {
    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final e a(Context context, e.b bVar, int i2) {
        AppMethodBeat.i(112142);
        k kVar = new k(context, bVar, i2);
        AppMethodBeat.o(112142);
        return kVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final int getType() {
        return 112;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final int getPriority() {
        return 112;
    }
}
