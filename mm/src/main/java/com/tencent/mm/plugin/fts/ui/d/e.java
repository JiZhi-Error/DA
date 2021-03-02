package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.c;
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

public final class e extends a {
    public e(Context context, e.b bVar, int i2) {
        super(context, bVar, i2);
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler mMHandler, HashSet<String> hashSet) {
        AppMethodBeat.i(112179);
        j jVar = new j();
        jVar.kXb = 64;
        jVar.query = this.query;
        jVar.wWU = new int[]{131072, 131081};
        jVar.wWW = 3;
        jVar.wWY = b.wXy;
        jVar.wWX = hashSet;
        jVar.wWZ = this;
        jVar.handler = mMHandler;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.ah(n.class)).search(2, jVar);
        AppMethodBeat.o(112179);
        return search;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, e.a aVar) {
        int i3;
        AppMethodBeat.i(112181);
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (aVar.wXE) {
            int i4 = (i2 - aVar.wXD) - 1;
            if (i4 < aVar.mWl.size() && i4 >= 0) {
                m mVar = aVar.mWl.get(i4);
                aVar2 = a(mVar.type, i2, mVar, aVar);
                if (aVar2 != null) {
                    aVar2.gE(mVar.type, mVar.wVW);
                }
            }
            i3 = i4;
        } else {
            i3 = 0;
        }
        if (aVar2 != null) {
            aVar2.wXM = i3 + 1;
            if (i3 == aVar.mWl.size() - 1) {
                aVar2.wXK = false;
            }
        }
        AppMethodBeat.o(112181);
        return aVar2;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final int getType() {
        return 32;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, int i3, m mVar, e.a aVar) {
        AppMethodBeat.i(112182);
        r rVar = null;
        if (mVar.type == 131072 || mVar.type == 131081) {
            r rVar2 = new r(i3);
            rVar2.lqW = mVar;
            rVar2.wWd = aVar.wWd;
            rVar2.gE(mVar.type, mVar.wVW);
            rVar = rVar2;
        } else if (mVar.type == 131073 || mVar.type == 131074) {
            rVar = ((a) ((n) g.ah(n.class)).createFTSUIUnit(33, this.context, this.wXC, this.mve)).a(i2, i3, mVar, aVar);
        }
        AppMethodBeat.o(112182);
        return rVar;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final c b(int i2, e.a aVar) {
        c cVar;
        AppMethodBeat.i(112183);
        if (i2 >= aVar.mWl.size() || i2 < 0) {
            cVar = null;
        } else {
            m mVar = aVar.mWl.get(i2);
            c cVar2 = new c();
            cVar2.dUb = String.valueOf(mVar.hashCode());
            if (mVar.type == 131072 || mVar.type == 131081 || mVar.type == 131073 || mVar.type == 131074) {
                cVar2.dUm = 3;
                cVar = cVar2;
            } else {
                cVar = null;
            }
        }
        AppMethodBeat.o(112183);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final void a(k kVar, HashSet<String> hashSet) {
        AppMethodBeat.i(112180);
        e.a aVar = new e.a();
        aVar.businessType = -4;
        aVar.mWl = kVar.wXb;
        aVar.wXE = eP(kVar.wXb);
        aVar.wWd = kVar.wWd;
        if (aVar.mWl.size() > 3) {
            aVar.tuG = true;
            aVar.mWl = aVar.mWl.subList(0, 3);
        }
        if (eP(kVar.wXb)) {
            this.wZO.add(aVar);
        }
        AppMethodBeat.o(112180);
    }
}
