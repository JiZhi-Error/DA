package com.tencent.mm.w.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e;

public final class a extends com.tencent.mm.plugin.fts.a.d.a {
    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final e a(Context context, e.b bVar, int i2) {
        AppMethodBeat.i(127650);
        b bVar2 = new b(context, bVar, i2);
        AppMethodBeat.o(127650);
        return bVar2;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final int getType() {
        return 33;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.d
    public final int getPriority() {
        return 33;
    }
}
