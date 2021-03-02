package com.tencent.mm.plugin.appbrand.j;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.d;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import java.util.List;

public final class h extends a {
    public h(Context context, e.b bVar, int i2) {
        super(context, bVar, i2);
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler mMHandler, HashSet<String> hashSet) {
        AppMethodBeat.i(45034);
        j jVar = new j();
        jVar.query = this.query;
        jVar.wWY = d.wXA;
        jVar.wWZ = this;
        jVar.handler = mMHandler;
        jVar.wWX = hashSet;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.ah(n.class)).search(7, jVar);
        AppMethodBeat.o(45034);
        return search;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final void a(k kVar, HashSet<String> hashSet) {
        AppMethodBeat.i(45035);
        List<m> list = kVar.wXb;
        if (list != null && !list.isEmpty()) {
            com.tencent.mm.modelsns.m mVar = new com.tencent.mm.modelsns.m();
            String str = this.query;
            if (str != null) {
                str = str.replaceAll(",", " ");
            }
            mVar.n("20KeyWordId", str + ",");
            mVar.n("21ViewType", "1,");
            mVar.n("22OpType", "1,");
            mVar.n("23ResultCount", list.size() + ",");
            mVar.n("24ClickPos", ",");
            mVar.n("25ClickAppUserName", ",");
            Log.i("MicroMsg.FTSWeAppUIUnit", "report oreh LocalSearchWeApp(13963), %s", mVar.abW());
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13963, mVar);
        }
        if (eP(kVar.wXb)) {
            e.a aVar = new e.a();
            aVar.businessType = -13;
            aVar.mWl = kVar.wXb;
            aVar.wWd = kVar.wWd;
            if (aVar.mWl.size() > 1) {
                aVar.tuG = true;
                aVar.mWl = aVar.mWl.subList(0, 1);
            }
            this.wZO.add(aVar);
        }
        AppMethodBeat.o(45035);
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, e.a aVar) {
        AppMethodBeat.i(45036);
        int i3 = (i2 - aVar.wXD) - 1;
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i3 < aVar.mWl.size() && i3 >= 0) {
            aVar2 = a(393216, i2, aVar.mWl.get(i3), aVar);
        }
        if (aVar2 != null) {
            aVar2.wXM = i3 + 1;
            if (i3 == aVar.mWl.size() - 1) {
                aVar2.wXK = false;
            }
        }
        AppMethodBeat.o(45036);
        return aVar2;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, int i3, m mVar, e.a aVar) {
        AppMethodBeat.i(45037);
        d dVar = new d(i3);
        dVar.lqW = mVar;
        dVar.wWd = aVar.wWd;
        dVar.gE(mVar.type, mVar.wVW);
        AppMethodBeat.o(45037);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final int getType() {
        return 144;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final c b(int i2, e.a aVar) {
        AppMethodBeat.i(45038);
        c cVar = null;
        if (i2 < aVar.mWl.size() && i2 >= 0) {
            c cVar2 = new c();
            cVar2.dUb = String.valueOf(aVar.mWl.get(i2).hashCode());
            cVar2.dUm = 19;
            cVar = cVar2;
        }
        AppMethodBeat.o(45038);
        return cVar;
    }
}
