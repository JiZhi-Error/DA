package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.c;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.HashSet;

public final class i extends a {
    public i(Context context, e.b bVar, int i2) {
        super(context, bVar, i2);
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler mMHandler, HashSet<String> hashSet) {
        AppMethodBeat.i(112195);
        j jVar = new j();
        jVar.query = this.query;
        jVar.handler = mMHandler;
        jVar.wWX = hashSet;
        jVar.wWZ = this;
        jVar.wWY = c.wXz;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.ah(n.class)).search(4, jVar);
        AppMethodBeat.o(112195);
        return search;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, e.a aVar) {
        AppMethodBeat.i(112197);
        int i3 = (i2 - aVar.wXD) - 1;
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i3 < aVar.mWl.size() && i3 >= 0) {
            aVar2 = a(TPMediaCodecProfileLevel.HEVCMainTierLevel52, i2, aVar.mWl.get(i3), aVar);
        }
        if (aVar2 != null) {
            aVar2.wXM = i3 + 1;
            if (i3 == aVar.mWl.size() - 1) {
                aVar2.wXK = false;
            }
        }
        AppMethodBeat.o(112197);
        return aVar2;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final int getType() {
        return 64;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, int i3, m mVar, e.a aVar) {
        AppMethodBeat.i(112198);
        com.tencent.mm.plugin.fts.ui.a.j jVar = new com.tencent.mm.plugin.fts.ui.a.j(i3);
        jVar.lqW = mVar;
        jVar.wWd = aVar.wWd;
        jVar.gE(mVar.type, mVar.wVW);
        AppMethodBeat.o(112198);
        return jVar;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.a.c b(int i2, e.a aVar) {
        AppMethodBeat.i(112199);
        com.tencent.mm.plugin.fts.a.a.c cVar = null;
        if (i2 < aVar.mWl.size() && i2 >= 0) {
            com.tencent.mm.plugin.fts.a.a.c cVar2 = new com.tencent.mm.plugin.fts.a.a.c();
            cVar2.dUb = String.valueOf(aVar.mWl.get(i2).hashCode());
            cVar2.dUm = 10;
            cVar = cVar2;
        }
        AppMethodBeat.o(112199);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final void a(k kVar, HashSet<String> hashSet) {
        AppMethodBeat.i(112196);
        if (eP(kVar.wXb)) {
            e.a aVar = new e.a();
            aVar.businessType = -6;
            aVar.wWd = kVar.wWd;
            aVar.mWl = kVar.wXb;
            if (aVar.mWl.size() > 1) {
                aVar.tuG = true;
                aVar.mWl = aVar.mWl.subList(0, 1);
            }
            this.wZO.add(aVar);
        }
        AppMethodBeat.o(112196);
    }
}
