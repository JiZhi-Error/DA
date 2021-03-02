package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.plugin.fts.ui.a.i;
import com.tencent.mm.plugin.fts.ui.a.m;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;

public class k extends a {
    protected boolean xeL = false;

    public k(Context context, e.b bVar, int i2) {
        super(context, bVar, i2);
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public com.tencent.mm.plugin.fts.a.a.a a(MMHandler mMHandler, HashSet<String> hashSet) {
        AppMethodBeat.i(112203);
        this.xeL = false;
        j jVar = new j();
        jVar.query = this.query;
        jVar.wWX = hashSet;
        jVar.wWZ = this;
        jVar.handler = mMHandler;
        jVar.kXb = 1;
        jVar.wWW = 3;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.ah(n.class)).search(3, jVar);
        AppMethodBeat.o(112203);
        return search;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public void a(com.tencent.mm.plugin.fts.a.a.k kVar, HashSet<String> hashSet) {
        AppMethodBeat.i(112204);
        if (eP(kVar.wXb)) {
            e.a aVar = new e.a();
            aVar.businessType = -2;
            aVar.wWd = kVar.wWd;
            aVar.mWl = kVar.wXb;
            if (aVar.mWl.size() > 3) {
                if (kVar.wXb.get(3).wVX.equals("create_talker_message​")) {
                    aVar.tuG = false;
                    aVar.mWl = aVar.mWl.subList(0, 4);
                } else {
                    aVar.tuG = true;
                    aVar.mWl = aVar.mWl.subList(0, 3);
                }
            } else if (kVar.wXb.size() == 1 && kVar.wXb.get(0).wVX.equals("create_talker_message​")) {
                aVar.wXE = false;
            }
            this.wZO.add(aVar);
        }
        AppMethodBeat.o(112204);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: com.tencent.mm.plugin.fts.ui.a.i */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.plugin.fts.ui.a
    public com.tencent.mm.plugin.fts.a.d.a.a a(int i2, e.a aVar) {
        int i3;
        AppMethodBeat.i(112205);
        int i4 = i2 - aVar.wXD;
        if (aVar.wXE) {
            i3 = i4 - 1;
        } else {
            i3 = i4;
        }
        m mVar = null;
        if (i3 < aVar.mWl.size() && i3 >= 0) {
            com.tencent.mm.plugin.fts.a.a.m mVar2 = aVar.mWl.get(i3);
            if (mVar2.wVX.equals("create_talker_message​")) {
                i iVar = new i(i2);
                iVar.xdf = aVar.mWl.size() == 1;
                this.xeL = true;
                mVar = iVar;
            } else {
                m mVar3 = new m(i2);
                mVar3.lqW = mVar2;
                mVar3.gE(mVar2.type, mVar2.wVW);
                mVar = mVar3;
            }
        }
        if (mVar != null) {
            mVar.wXM = i3 + 1;
            mVar.wWd = aVar.wWd;
            if (i3 == aVar.mWl.size() - 1) {
                mVar.wXK = false;
            }
        }
        AppMethodBeat.o(112205);
        return mVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public int getType() {
        return 112;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006a  */
    @Override // com.tencent.mm.plugin.fts.a.d.e, com.tencent.mm.plugin.fts.a.d.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.View r11, com.tencent.mm.plugin.fts.a.d.a.a r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 122
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.ui.d.k.a(android.view.View, com.tencent.mm.plugin.fts.a.d.a.a, boolean):boolean");
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final c b(int i2, e.a aVar) {
        AppMethodBeat.i(112207);
        c cVar = null;
        if (i2 < aVar.mWl.size() && i2 >= 0) {
            com.tencent.mm.plugin.fts.a.a.m mVar = aVar.mWl.get(i2);
            c cVar2 = new c();
            cVar2.dUb = String.valueOf(mVar.hashCode());
            if (mVar.wVX.equals("create_talker_message​")) {
                cVar2.dUm = 22;
                cVar = cVar2;
            } else {
                cVar2.dUm = 11;
                cVar = cVar2;
            }
        }
        AppMethodBeat.o(112207);
        return cVar;
    }

    /* access modifiers changed from: protected */
    public int dPI() {
        return 0;
    }
}
