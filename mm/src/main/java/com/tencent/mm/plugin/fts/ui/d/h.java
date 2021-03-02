package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
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

public final class h extends a {
    public h(Context context, e.b bVar, int i2) {
        super(context, bVar, i2);
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler mMHandler, HashSet<String> hashSet) {
        AppMethodBeat.i(112191);
        hashSet.add("62");
        if (b.Pi((String) g.aAh().azQ().get(274436, (Object) null))) {
            hashSet.add("65");
        }
        if (((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).clc()) {
            hashSet.add("63");
        } else {
            hashSet.add("67");
        }
        if (!((com.tencent.mm.plugin.appbrand.service.e) g.af(com.tencent.mm.plugin.appbrand.service.e.class)).bVr()) {
            hashSet.add("69");
        }
        if (!((com.tencent.mm.plugin.appbrand.service.h) g.af(com.tencent.mm.plugin.appbrand.service.h.class)).bVr()) {
            hashSet.add("71");
        }
        j jVar = new j();
        jVar.query = this.query;
        jVar.handler = mMHandler;
        jVar.wWX = hashSet;
        jVar.wWZ = this;
        jVar.wWY = c.wXz;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.ah(n.class)).search(4, jVar);
        AppMethodBeat.o(112191);
        return search;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, e.a aVar) {
        AppMethodBeat.i(112193);
        int i3 = (i2 - aVar.wXD) - 1;
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i3 < aVar.mWl.size() && i3 >= 0) {
            aVar2 = a(TPMediaCodecProfileLevel.HEVCMainTierLevel52, i2, aVar.mWl.get(i3), aVar);
        }
        if (aVar2 != null) {
            aVar2.wXM = i3 + 1;
        }
        AppMethodBeat.o(112193);
        return aVar2;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final int getType() {
        return 64;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, int i3, m mVar, e.a aVar) {
        AppMethodBeat.i(112194);
        com.tencent.mm.plugin.fts.ui.a.j jVar = new com.tencent.mm.plugin.fts.ui.a.j(i3);
        jVar.lqW = mVar;
        jVar.wWd = aVar.wWd;
        jVar.gE(mVar.type, mVar.wVW);
        AppMethodBeat.o(112194);
        return jVar;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final void a(k kVar, HashSet<String> hashSet) {
        AppMethodBeat.i(112192);
        if (eP(kVar.wXb)) {
            e.a aVar = new e.a();
            aVar.businessType = -6;
            aVar.wWd = kVar.wWd;
            aVar.mWl = kVar.wXb;
            aVar.tuG = false;
            this.wZO.add(aVar);
        }
        AppMethodBeat.o(112192);
    }
}
