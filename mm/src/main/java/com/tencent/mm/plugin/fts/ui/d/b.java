package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.plugin.fts.ui.a.h;
import com.tencent.mm.plugin.fts.ui.a.q;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;

public final class b extends a {
    public b(Context context, e.b bVar, int i2) {
        super(context, bVar, i2);
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler mMHandler, HashSet<String> hashSet) {
        AppMethodBeat.i(112168);
        j jVar = new j();
        jVar.kXb = 32;
        jVar.query = this.query;
        jVar.wWX = hashSet;
        jVar.wWY = com.tencent.mm.plugin.fts.a.c.a.wXx;
        jVar.wWZ = this;
        jVar.handler = mMHandler;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.ah(n.class)).search(2, jVar);
        AppMethodBeat.o(112168);
        return search;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.tencent.mm.plugin.fts.ui.a.q */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, e.a aVar) {
        AppMethodBeat.i(112170);
        int i3 = (i2 - aVar.wXD) - 1;
        h hVar = null;
        if (i3 < aVar.mWl.size() && i3 >= 0) {
            m mVar = aVar.mWl.get(i3);
            if (mVar.wVX.equals("create_chatroom​")) {
                hVar = new h(i2);
                hVar.wWd = aVar.wWd;
            } else {
                q qVar = new q(i2);
                qVar.lqW = mVar;
                qVar.wWd = aVar.wWd;
                qVar.gE(mVar.type, mVar.wVW);
                hVar = qVar;
            }
        }
        if (hVar != null) {
            hVar.wXM = i3 + 1;
        }
        AppMethodBeat.o(112170);
        return hVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final int getType() {
        return 4128;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final void a(k kVar, HashSet<String> hashSet) {
        AppMethodBeat.i(112169);
        if (eP(kVar.wXb)) {
            e.a aVar = new e.a();
            aVar.businessType = -3;
            aVar.mWl = kVar.wXb;
            aVar.wWd = kVar.wWd;
            aVar.tuG = false;
            this.wZO.add(aVar);
        }
        AppMethodBeat.o(112169);
    }
}
