package com.tencent.mm.plugin.appbrand.j;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;

public final class e extends a {
    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final com.tencent.mm.plugin.fts.a.d.e a(Context context, e.b bVar, int i2) {
        AppMethodBeat.i(45029);
        f fVar = new f(context, bVar, i2);
        AppMethodBeat.o(45029);
        return fVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final int getType() {
        return 4224;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final int getPriority() {
        return Integer.MAX_VALUE;
    }
}
