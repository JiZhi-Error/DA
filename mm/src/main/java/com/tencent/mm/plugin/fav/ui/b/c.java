package com.tencent.mm.plugin.fav.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.d;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;

public final class c extends a {
    public c(Context context, e.b bVar, int i2) {
        super(context, bVar, i2);
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler mMHandler, HashSet<String> hashSet) {
        AppMethodBeat.i(107312);
        j jVar = new j();
        jVar.kXb = 2;
        jVar.query = this.query;
        jVar.wWX = hashSet;
        jVar.handler = mMHandler;
        jVar.wWZ = this;
        jVar.wWY = d.wXA;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.ah(n.class)).search(6, jVar);
        AppMethodBeat.o(107312);
        return search;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, e.a aVar) {
        AppMethodBeat.i(107314);
        int i3 = (i2 - aVar.wXD) - 1;
        a aVar2 = null;
        if (i3 < aVar.mWl.size() && i3 >= 0) {
            m mVar = aVar.mWl.get(i3);
            a aVar3 = new a(i2);
            aVar3.lqW = mVar;
            aVar3.wWd = aVar.wWd;
            aVar3.gE(mVar.type, mVar.wVW);
            aVar3.tjF = true;
            aVar2 = aVar3;
        }
        if (aVar2 != null) {
            aVar2.wXM = i3 + 1;
        }
        AppMethodBeat.o(107314);
        return aVar2;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final int getType() {
        return 4192;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final void a(k kVar, HashSet<String> hashSet) {
        AppMethodBeat.i(107313);
        if (eP(kVar.wXb)) {
            e.a aVar = new e.a();
            aVar.businessType = -1;
            aVar.wWd = kVar.wWd;
            aVar.mWl = kVar.wXb;
            this.wZO.add(aVar);
        }
        AppMethodBeat.o(107313);
    }
}
