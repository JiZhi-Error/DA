package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.plugin.fts.ui.a.r;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;

public final class d extends a {
    public d(Context context, e.b bVar, int i2) {
        super(context, bVar, i2);
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler mMHandler, HashSet<String> hashSet) {
        AppMethodBeat.i(112176);
        j jVar = new j();
        jVar.query = this.query;
        jVar.wWU = new int[]{131072, 131081};
        jVar.wWY = b.wXy;
        jVar.wWX = hashSet;
        jVar.wWZ = this;
        jVar.handler = mMHandler;
        jVar.kXb = 16;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.ah(n.class)).search(2, jVar);
        AppMethodBeat.o(112176);
        return search;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, e.a aVar) {
        AppMethodBeat.i(112178);
        int i3 = (i2 - aVar.wXD) - 1;
        r rVar = null;
        if (i3 < aVar.mWl.size() && i3 >= 0) {
            m mVar = aVar.mWl.get(i3);
            r rVar2 = new r(i2);
            rVar2.lqW = mVar;
            rVar2.wWd = aVar.wWd;
            rVar2.gE(mVar.type, mVar.wVW);
            rVar = rVar2;
        }
        if (rVar != null) {
            rVar.wXM = i3 + 1;
        }
        AppMethodBeat.o(112178);
        return rVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final int getType() {
        return 4112;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final void a(k kVar, HashSet<String> hashSet) {
        AppMethodBeat.i(112177);
        if (eP(kVar.wXb)) {
            e.a aVar = new e.a();
            aVar.businessType = -4;
            aVar.mWl = kVar.wXb;
            aVar.wWd = kVar.wWd;
            aVar.tuG = false;
            this.wZO.add(aVar);
        }
        AppMethodBeat.o(112177);
    }
}
