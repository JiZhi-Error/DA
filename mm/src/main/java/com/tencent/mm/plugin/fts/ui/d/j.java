package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.i;
import com.tencent.mm.plugin.fts.ui.a.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class j extends k {
    public j(Context context, e.b bVar, int i2) {
        super(context, bVar, i2);
    }

    @Override // com.tencent.mm.plugin.fts.ui.d.k, com.tencent.mm.plugin.fts.ui.a
    public final a a(MMHandler mMHandler, HashSet<String> hashSet) {
        AppMethodBeat.i(112200);
        this.xeL = false;
        com.tencent.mm.plugin.fts.a.a.j jVar = new com.tencent.mm.plugin.fts.a.a.j();
        jVar.query = this.query;
        jVar.wWX = hashSet;
        jVar.wWZ = this;
        jVar.handler = mMHandler;
        a search = ((n) g.ah(n.class)).search(3, jVar);
        AppMethodBeat.o(112200);
        return search;
    }

    @Override // com.tencent.mm.plugin.fts.ui.d.k, com.tencent.mm.plugin.fts.ui.a
    public final void a(k kVar, HashSet<String> hashSet) {
        AppMethodBeat.i(112201);
        List<m> list = kVar.wXb;
        if (eP(list)) {
            if (list.size() > 0) {
                m mVar = list.get(0);
                if (mVar.wVX.equals("create_talker_message​")) {
                    e.a aVar = new e.a();
                    aVar.wXE = false;
                    aVar.mWl = new ArrayList();
                    aVar.mWl.add(mVar);
                    aVar.wWd = kVar.wWd;
                    aVar.businessType = -2;
                    this.wZO.add(aVar);
                    list.remove(0);
                }
            }
            e.a aVar2 = new e.a();
            aVar2.businessType = -2;
            aVar2.wWd = kVar.wWd;
            if (list.size() == 0) {
                aVar2.wXE = false;
                m mVar2 = new m();
                mVar2.wVX = "no_result​";
                aVar2.mWl = new ArrayList();
                aVar2.mWl.add(mVar2);
            } else {
                aVar2.mWl = list;
            }
            this.wZO.add(aVar2);
        }
        AppMethodBeat.o(112201);
    }

    @Override // com.tencent.mm.plugin.fts.ui.d.k, com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, e.a aVar) {
        int i3;
        AppMethodBeat.i(112202);
        int i4 = i2 - aVar.wXD;
        if (aVar.wXE) {
            i3 = i4 - 1;
        } else {
            i3 = i4;
        }
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i3 < aVar.mWl.size() && i3 >= 0) {
            m mVar = aVar.mWl.get(i3);
            if (mVar.wVX.equals("create_talker_message​")) {
                aVar2 = new i(i2);
                aVar2.wXK = false;
                this.xeL = true;
            } else if (mVar.wVX.equals("no_result​")) {
                aVar2 = new l(i2);
            } else {
                com.tencent.mm.plugin.fts.ui.a.m mVar2 = new com.tencent.mm.plugin.fts.ui.a.m(i2);
                mVar2.lqW = mVar;
                mVar2.gE(mVar.type, mVar.wVW);
                aVar2 = mVar2;
            }
        }
        if (aVar2 != null) {
            aVar2.wXM = i3 + 1;
            aVar2.wWd = aVar.wWd;
        }
        AppMethodBeat.o(112202);
        return aVar2;
    }

    @Override // com.tencent.mm.plugin.fts.ui.d.k, com.tencent.mm.plugin.fts.a.d.e
    public final int getType() {
        return 4176;
    }
}
