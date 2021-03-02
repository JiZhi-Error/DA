package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
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
        AppMethodBeat.i(5830);
        hashSet.add("gh_3dfda90e39d6");
        hashSet.add("gh_43f2581f6fd6");
        hashSet.add("gh_f0a92aa7146c");
        if (1 == ((b) g.af(b.class)).a(b.a.clicfg_minishop_plugin_enabled, 0)) {
            hashSet.add("gh_579db1f2cf89");
        }
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.ah(n.class)).search(2, j.a(this.query, new int[]{131076}, null, 4, hashSet, com.tencent.mm.plugin.fts.a.c.b.wXy, this, mMHandler));
        AppMethodBeat.o(5830);
        return search;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, e.a aVar) {
        AppMethodBeat.i(5832);
        int i3 = (i2 - aVar.wXD) - 1;
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i3 < aVar.mWl.size() && i3 >= 0) {
            m mVar = aVar.mWl.get(i3);
            com.tencent.mm.plugin.fts.a.d.a.a a2 = a(131076, i2, mVar, aVar);
            a2.gE(mVar.type, mVar.wVW);
            aVar2 = a2;
        }
        if (aVar2 != null) {
            aVar2.wXM = i3 + 1;
            if (i3 == aVar.mWl.size() - 1) {
                aVar2.wXK = false;
            }
        }
        AppMethodBeat.o(5832);
        return aVar2;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final int getType() {
        return 96;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, int i3, m mVar, e.a aVar) {
        AppMethodBeat.i(5833);
        a aVar2 = new a(i3);
        aVar2.lqW = mVar;
        aVar2.wWd = aVar.wWd;
        aVar2.gE(mVar.type, mVar.wVW);
        AppMethodBeat.o(5833);
        return aVar2;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final c b(int i2, e.a aVar) {
        AppMethodBeat.i(5834);
        c cVar = null;
        if (i2 < aVar.mWl.size() && i2 >= 0) {
            c cVar2 = new c();
            cVar2.dUb = String.valueOf(aVar.mWl.get(i2).hashCode());
            cVar2.dUm = 5;
            cVar = cVar2;
        }
        AppMethodBeat.o(5834);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final void a(k kVar, HashSet<String> hashSet) {
        AppMethodBeat.i(5831);
        if (eP(kVar.wXb)) {
            e.a aVar = new e.a();
            aVar.businessType = -7;
            aVar.mWl = kVar.wXb;
            aVar.wWd = kVar.wWd;
            if (aVar.mWl.size() > 1) {
                aVar.tuG = true;
                aVar.mWl = aVar.mWl.subList(0, 1);
            }
            this.wZO.add(aVar);
        }
        AppMethodBeat.o(5831);
    }
}
