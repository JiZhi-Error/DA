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
import com.tencent.mm.plugin.fts.ui.a.q;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;

public final class c extends a {
    public c(Context context, e.b bVar, int i2) {
        super(context, bVar, i2);
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler mMHandler, HashSet<String> hashSet) {
        AppMethodBeat.i(112171);
        j jVar = new j();
        jVar.kXb = 96;
        jVar.wWW = 3;
        jVar.query = this.query;
        jVar.wWX = hashSet;
        jVar.wWY = com.tencent.mm.plugin.fts.a.c.a.wXx;
        jVar.wWZ = this;
        jVar.handler = mMHandler;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.ah(n.class)).search(2, jVar);
        AppMethodBeat.o(112171);
        return search;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0038  */
    @Override // com.tencent.mm.plugin.fts.ui.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int r8, com.tencent.mm.plugin.fts.a.d.e.a r9) {
        /*
            r7 = this;
            r6 = 131075(0x20003, float:1.83675E-40)
            r5 = 112173(0x1b62d, float:1.57188E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            int r0 = r9.wXD
            int r0 = r8 - r0
            int r2 = r0 + -1
            r1 = 0
            java.util.List<com.tencent.mm.plugin.fts.a.a.m> r0 = r9.mWl
            int r0 = r0.size()
            if (r2 >= r0) goto L_0x005e
            if (r2 < 0) goto L_0x005e
            java.util.List<com.tencent.mm.plugin.fts.a.a.m> r0 = r9.mWl
            java.lang.Object r0 = r0.get(r2)
            com.tencent.mm.plugin.fts.a.a.m r0 = (com.tencent.mm.plugin.fts.a.a.m) r0
            java.lang.String r3 = r0.wVX
            java.lang.String r4 = "create_chatroom​"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x004d
            com.tencent.mm.plugin.fts.ui.a.h r0 = new com.tencent.mm.plugin.fts.ui.a.h
            r0.<init>(r8)
            com.tencent.mm.plugin.fts.a.a.h r1 = r9.wWd
            r0.wWd = r1
        L_0x0036:
            if (r0 == 0) goto L_0x0049
            int r1 = r2 + 1
            r0.wXM = r1
            java.util.List<com.tencent.mm.plugin.fts.a.a.m> r1 = r9.mWl
            int r1 = r1.size()
            int r1 = r1 + -1
            if (r2 != r1) goto L_0x0049
            r1 = 0
            r0.wXK = r1
        L_0x0049:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            return r0
        L_0x004d:
            int r3 = r0.type
            if (r3 != r6) goto L_0x005e
            com.tencent.mm.plugin.fts.a.d.a.a r1 = r7.a(r6, r8, r0, r9)
            int r3 = r0.type
            int r0 = r0.wVW
            r1.gE(r3, r0)
            r0 = r1
            goto L_0x0036
        L_0x005e:
            r0 = r1
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.ui.d.c.a(int, com.tencent.mm.plugin.fts.a.d.e$a):com.tencent.mm.plugin.fts.a.d.a.a");
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.a.c b(int i2, e.a aVar) {
        com.tencent.mm.plugin.fts.a.a.c cVar;
        AppMethodBeat.i(112174);
        if (i2 >= aVar.mWl.size() || i2 < 0) {
            cVar = null;
        } else {
            m mVar = aVar.mWl.get(i2);
            com.tencent.mm.plugin.fts.a.a.c cVar2 = new com.tencent.mm.plugin.fts.a.a.c();
            if (mVar.wVX.equals("create_chatroom​")) {
                cVar2.dUm = 20;
                cVar2.dUb = String.valueOf(mVar.hashCode());
                cVar = cVar2;
            } else if (mVar.type == 131075) {
                cVar2.dUm = 4;
                cVar2.dUb = String.valueOf(mVar.hashCode());
                cVar = cVar2;
            } else {
                cVar = null;
            }
        }
        AppMethodBeat.o(112174);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final int getType() {
        return 48;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, int i3, m mVar, e.a aVar) {
        AppMethodBeat.i(112175);
        q qVar = new q(i3);
        qVar.lqW = mVar;
        qVar.wWd = aVar.wWd;
        qVar.gE(mVar.type, mVar.wVW);
        AppMethodBeat.o(112175);
        return qVar;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final void a(k kVar, HashSet<String> hashSet) {
        AppMethodBeat.i(112172);
        if (eP(kVar.wXb)) {
            e.a aVar = new e.a();
            aVar.mWl = kVar.wXb;
            aVar.businessType = -3;
            aVar.wWd = kVar.wWd;
            if (aVar.mWl.size() > 3) {
                if (aVar.mWl.get(3).wVX.equals("create_chatroom​")) {
                    aVar.tuG = aVar.mWl.size() > 4;
                    aVar.mWl = aVar.mWl.subList(0, 4);
                } else {
                    aVar.tuG = true;
                    aVar.mWl = aVar.mWl.subList(0, 3);
                }
            }
            this.wZO.add(aVar);
        }
        AppMethodBeat.o(112172);
    }
}
