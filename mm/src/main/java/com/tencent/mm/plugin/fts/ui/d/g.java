package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.f;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.plugin.fts.ui.a.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;

public final class g extends l {
    public int dDG;
    public String talker;
    public String wWS;

    public g(Context context, e.b bVar, int i2) {
        super(context, bVar, i2);
    }

    @Override // com.tencent.mm.plugin.fts.ui.d.k, com.tencent.mm.plugin.fts.ui.d.l, com.tencent.mm.plugin.fts.a.d.e
    public final int getType() {
        return 192;
    }

    @Override // com.tencent.mm.plugin.fts.ui.d.k, com.tencent.mm.plugin.fts.ui.d.l, com.tencent.mm.plugin.fts.ui.a
    public final a a(MMHandler mMHandler, HashSet<String> hashSet) {
        AppMethodBeat.i(112188);
        this.xeL = false;
        j jVar = new j();
        jVar.query = this.query;
        jVar.wWY = com.tencent.mm.plugin.fts.a.c.e.wXB;
        jVar.wWS = this.wWS;
        jVar.wWT = this.wWT;
        jVar.talker = this.talker;
        jVar.wWZ = this;
        jVar.handler = mMHandler;
        jVar.kXb = 11;
        a search = ((n) com.tencent.mm.kernel.g.ah(n.class)).search(3, jVar);
        AppMethodBeat.o(112188);
        return search;
    }

    @Override // com.tencent.mm.plugin.fts.ui.d.l, com.tencent.mm.plugin.fts.ui.a
    public final k c(int i2, e.a aVar) {
        AppMethodBeat.i(112189);
        f fVar = new f(i2);
        fVar.xcP = aVar.wXH;
        fVar.wWS = this.wWS;
        AppMethodBeat.o(112189);
        return fVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.tencent.mm.plugin.fts.ui.a.g */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.plugin.fts.ui.d.k, com.tencent.mm.plugin.fts.ui.d.l, com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, e.a aVar) {
        int i3;
        AppMethodBeat.i(112190);
        l lVar = null;
        if (aVar.wXE) {
            i3 = (i2 - aVar.wXD) - 1;
        } else {
            i3 = i2 - aVar.wXD;
        }
        if (i3 >= 0 && i3 < aVar.mWl.size()) {
            m mVar = aVar.mWl.get(i3);
            if (mVar.wVX.equals("no_result​")) {
                lVar = new l(i2);
            } else {
                com.tencent.mm.plugin.fts.ui.a.g gVar = new com.tencent.mm.plugin.fts.ui.a.g(i2);
                gVar.lqW = mVar;
                gVar.wWd = gVar.lqW.wWd;
                gVar.gE(mVar.type, mVar.wVW);
                lVar = gVar;
            }
        }
        AppMethodBeat.o(112190);
        return lVar;
    }

    @Override // com.tencent.mm.plugin.fts.ui.d.k, com.tencent.mm.plugin.fts.ui.d.l
    public final int dPI() {
        return this.dDG;
    }
}
