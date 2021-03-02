package com.tencent.mm.plugin.appbrand.j;

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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import java.util.List;

public final class f extends a {
    public f(Context context, e.b bVar, int i2) {
        super(context, bVar, i2);
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler mMHandler, HashSet<String> hashSet) {
        AppMethodBeat.i(45030);
        j jVar = new j();
        jVar.query = this.query;
        jVar.wWY = d.wXA;
        jVar.wWZ = this;
        jVar.handler = mMHandler;
        jVar.wWX = hashSet;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.ah(n.class)).search(7, jVar);
        AppMethodBeat.o(45030);
        return search;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final void a(k kVar, HashSet<String> hashSet) {
        AppMethodBeat.i(45031);
        List<m> list = kVar.wXb;
        if (list != null && !list.isEmpty()) {
            com.tencent.mm.modelsns.m mVar = new com.tencent.mm.modelsns.m();
            String str = this.query;
            if (str != null) {
                str = str.replaceAll(",", " ");
            }
            mVar.n("20KeyWordId", str + ",");
            mVar.n("21ViewType", "2,");
            mVar.n("22OpType", "1,");
            mVar.n("23ResultCount", list.size() + ",");
            mVar.n("24ClickPos", ",");
            mVar.n("25ClickAppUserName", ",");
            Log.i("MicroMsg.FTSWeAppDetailUIUnit", "report oreh LocalSearchWeApp(13963), %s", mVar.abW());
            h.INSTANCE.a(13963, mVar);
        }
        if (eP(kVar.wXb)) {
            e.a aVar = new e.a();
            aVar.businessType = -13;
            aVar.wWd = kVar.wWd;
            aVar.mWl = kVar.wXb;
            this.wZO.add(aVar);
        }
        AppMethodBeat.o(45031);
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, e.a aVar) {
        AppMethodBeat.i(45032);
        int i3 = (i2 - aVar.wXD) - 1;
        d dVar = null;
        if (i3 < aVar.mWl.size() && i3 >= 0) {
            m mVar = aVar.mWl.get(i3);
            d dVar2 = new d(i2);
            dVar2.lqW = mVar;
            dVar2.wWd = aVar.wWd;
            dVar2.gE(mVar.type, mVar.wVW);
            dVar = dVar2;
        }
        if (dVar != null) {
            dVar.wXM = i3 + 1;
        }
        AppMethodBeat.o(45032);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final int getType() {
        return 4224;
    }
}
