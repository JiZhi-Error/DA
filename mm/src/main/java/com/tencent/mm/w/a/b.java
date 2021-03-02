package com.tencent.mm.w.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;

public final class b extends a {
    public b(Context context, e.b bVar, int i2) {
        super(context, bVar, i2);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final int getType() {
        return 33;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler mMHandler, HashSet<String> hashSet) {
        return null;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final void a(k kVar, HashSet<String> hashSet) {
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, e.a aVar) {
        return null;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, int i3, m mVar, e.a aVar) {
        AppMethodBeat.i(127651);
        c cVar = new c(i3);
        cVar.lqW = mVar;
        cVar.wWd = aVar.wWd;
        cVar.gE(mVar.type, mVar.wVW);
        AppMethodBeat.o(127651);
        return cVar;
    }
}
