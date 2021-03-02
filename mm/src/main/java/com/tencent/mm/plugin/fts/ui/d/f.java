package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.d;
import com.tencent.mm.plugin.fts.ui.a.i;
import com.tencent.mm.plugin.fts.ui.a.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ah;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class f extends k {
    public String wWS;
    public ah xbi;

    public f(Context context, e.b bVar, int i2) {
        super(context, bVar, i2);
    }

    @Override // com.tencent.mm.plugin.fts.ui.d.k, com.tencent.mm.plugin.fts.a.d.e
    public final int getType() {
        return 160;
    }

    @Override // com.tencent.mm.plugin.fts.ui.d.k, com.tencent.mm.plugin.fts.ui.a
    public final a a(MMHandler mMHandler, HashSet<String> hashSet) {
        AppMethodBeat.i(112184);
        this.xeL = false;
        j jVar = new j();
        jVar.query = this.query;
        jVar.wWS = this.wWS;
        jVar.wWZ = this;
        jVar.handler = mMHandler;
        jVar.kXb = 3;
        a search = ((n) g.ah(n.class)).search(3, jVar);
        AppMethodBeat.o(112184);
        return search;
    }

    @Override // com.tencent.mm.plugin.fts.ui.d.k, com.tencent.mm.plugin.fts.ui.a
    public final void a(k kVar, HashSet<String> hashSet) {
        AppMethodBeat.i(112185);
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
        AppMethodBeat.o(112185);
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.ui.a.k c(int i2, e.a aVar) {
        AppMethodBeat.i(112186);
        com.tencent.mm.plugin.fts.ui.a.e eVar = new com.tencent.mm.plugin.fts.ui.a.e(i2);
        eVar.talker = this.wWS;
        eVar.count = aVar.mWl.size();
        AppMethodBeat.o(112186);
        return eVar;
    }

    @Override // com.tencent.mm.plugin.fts.ui.d.k, com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, e.a aVar) {
        int i3;
        AppMethodBeat.i(112187);
        int i4 = i2 - aVar.wXD;
        if (aVar.wXE) {
            i3 = i4 - 1;
        } else {
            i3 = i4;
        }
        i iVar = null;
        iVar = null;
        if (i3 < aVar.mWl.size() && i3 >= 0) {
            m mVar = aVar.mWl.get(i3);
            if (mVar.wVX.equals("create_talker_message​")) {
                i iVar2 = new i(i2);
                iVar2.wXK = false;
                iVar2.wWS = this.wWS;
                this.xeL = true;
                iVar = iVar2;
            } else if (mVar.wVX.equals("no_result​")) {
                iVar = new l(i2);
            } else {
                d dVar = new d(i3);
                dVar.lqW = mVar;
                dVar.wWd = aVar.wWd;
                dVar.xbi = this.xbi;
                dVar.gE(mVar.type, mVar.wVW);
                iVar = dVar;
            }
        }
        if (iVar != null) {
            iVar.wXM = i3 + 1;
            iVar.wWd = aVar.wWd;
        }
        AppMethodBeat.o(112187);
        return iVar;
    }
}
