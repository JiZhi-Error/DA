package com.tencent.mm.plugin.fav.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;

public final class e extends a {
    public e(Context context, e.b bVar, int i2) {
        super(context, bVar, i2);
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler mMHandler, HashSet<String> hashSet) {
        AppMethodBeat.i(107316);
        j jVar = new j();
        jVar.kXb = 1;
        jVar.query = this.query;
        jVar.wWW = 1;
        jVar.wWX = hashSet;
        jVar.handler = mMHandler;
        jVar.wWZ = this;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.ah(n.class)).search(6, jVar);
        AppMethodBeat.o(107316);
        return search;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, e.a aVar) {
        AppMethodBeat.i(107318);
        int i3 = (i2 - aVar.wXD) - 1;
        a aVar2 = null;
        if (i3 < aVar.mWl.size() && i3 >= 0) {
            m mVar = aVar.mWl.get(i3);
            a aVar3 = new a(i2);
            aVar3.lqW = mVar;
            aVar3.wWd = aVar.wWd;
            aVar3.gE(mVar.type, mVar.wVW);
            aVar3.tjF = false;
            aVar2 = aVar3;
        }
        if (aVar2 != null) {
            aVar2.wXM = i3 + 1;
        }
        AppMethodBeat.o(107318);
        return aVar2;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final int getType() {
        return 128;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final c b(int i2, e.a aVar) {
        AppMethodBeat.i(107319);
        c cVar = null;
        if (i2 < aVar.mWl.size() && i2 >= 0) {
            c cVar2 = new c();
            cVar2.dUb = String.valueOf(aVar.mWl.get(i2).hashCode());
            cVar2.dUm = 12;
            cVar = cVar2;
        }
        AppMethodBeat.o(107319);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final void a(k kVar, HashSet<String> hashSet) {
        AppMethodBeat.i(107317);
        if (eP(kVar.wXb)) {
            e.a aVar = new e.a();
            aVar.businessType = -1;
            aVar.wWd = kVar.wWd;
            aVar.mWl = kVar.wXb;
            if (aVar.mWl.size() > 1) {
                aVar.tuG = true;
                aVar.mWl = aVar.mWl.subList(0, 1);
            }
            this.wZO.add(aVar);
        }
        AppMethodBeat.o(107317);
    }
}
