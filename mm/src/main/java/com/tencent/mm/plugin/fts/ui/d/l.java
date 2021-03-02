package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.c;
import com.tencent.mm.plugin.fts.ui.a.o;
import com.tencent.mm.plugin.fts.ui.a.p;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class l extends k {
    public String wWT;

    public l(Context context, e.b bVar, int i2) {
        super(context, bVar, i2);
    }

    @Override // com.tencent.mm.plugin.fts.ui.d.k, com.tencent.mm.plugin.fts.a.d.e
    public int getType() {
        return TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6;
    }

    @Override // com.tencent.mm.plugin.fts.ui.d.k, com.tencent.mm.plugin.fts.ui.a
    public a a(MMHandler mMHandler, HashSet<String> hashSet) {
        AppMethodBeat.i(112208);
        this.xeL = false;
        j jVar = new j();
        jVar.query = this.query;
        jVar.wWY = com.tencent.mm.plugin.fts.a.c.e.wXB;
        jVar.wWT = this.wWT;
        jVar.wWZ = this;
        jVar.handler = mMHandler;
        jVar.kXb = 10;
        a search = ((n) g.ah(n.class)).search(3, jVar);
        AppMethodBeat.o(112208);
        return search;
    }

    @Override // com.tencent.mm.plugin.fts.ui.d.k, com.tencent.mm.plugin.fts.ui.a
    public final void a(k kVar, HashSet<String> hashSet) {
        AppMethodBeat.i(112209);
        switch (kVar.resultCode) {
            case 0:
                if (kVar.wXb.size() <= 0) {
                    e.a aVar = new e.a();
                    aVar.businessType = -2;
                    aVar.wWd = kVar.wWd;
                    aVar.wXE = false;
                    m mVar = new m();
                    mVar.wVX = "no_result​";
                    aVar.mWl = new ArrayList();
                    aVar.mWl.add(mVar);
                    this.wZO.add(aVar);
                    break;
                } else {
                    for (int i2 = 0; i2 < kVar.wXb.size(); i2++) {
                        e.a aVar2 = new e.a();
                        aVar2.wXE = true;
                        aVar2.wXH = kVar.wXb.get(i2);
                        aVar2.wWd = kVar.wWd;
                        aVar2.mWl = (List) aVar2.wXH.userData;
                        if (aVar2.mWl.size() <= 3 || i2 == kVar.wXb.size() - 1) {
                            aVar2.wXG = false;
                            aVar2.tuG = false;
                        } else {
                            aVar2.wXG = true;
                            aVar2.tuG = true;
                        }
                        this.wZO.add(aVar2);
                    }
                    AppMethodBeat.o(112209);
                    return;
                }
                break;
        }
        AppMethodBeat.o(112209);
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public com.tencent.mm.plugin.fts.ui.a.k c(int i2, e.a aVar) {
        AppMethodBeat.i(112211);
        o oVar = new o(i2);
        oVar.xcP = aVar.wXH;
        oVar.wWd = oVar.xcP.wWd;
        AppMethodBeat.o(112211);
        return oVar;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.ui.a.n d(int i2, e.a aVar) {
        AppMethodBeat.i(112212);
        c cVar = new c(i2);
        cVar.resId = R.string.djo;
        cVar.wke = aVar.wXG;
        AppMethodBeat.o(112212);
        return cVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.tencent.mm.plugin.fts.ui.a.p */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.plugin.fts.ui.d.k, com.tencent.mm.plugin.fts.ui.a
    public com.tencent.mm.plugin.fts.a.d.a.a a(int i2, e.a aVar) {
        int i3;
        AppMethodBeat.i(112213);
        com.tencent.mm.plugin.fts.ui.a.l lVar = null;
        if (aVar.wXE) {
            i3 = (i2 - aVar.wXD) - 1;
        } else {
            i3 = i2 - aVar.wXD;
        }
        if (i3 >= 0 && i3 < aVar.mWl.size()) {
            m mVar = aVar.mWl.get(i3);
            if (mVar.wVX.equals("no_result​")) {
                lVar = new com.tencent.mm.plugin.fts.ui.a.l(i2);
            } else {
                p pVar = new p(i2);
                pVar.lqW = mVar;
                pVar.xcP = aVar.wXH;
                pVar.wWd = pVar.lqW.wWd;
                pVar.rjr = -14;
                pVar.dDG = 2;
                pVar.gE(mVar.type, mVar.wVW);
                lVar = pVar;
            }
        }
        AppMethodBeat.o(112213);
        return lVar;
    }

    @Override // com.tencent.mm.plugin.fts.ui.d.k, com.tencent.mm.plugin.fts.a.d.e, com.tencent.mm.plugin.fts.a.d.b
    public final boolean a(View view, com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(112214);
        super.a(view, aVar, z);
        if (aVar instanceof c) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.wZO.size()) {
                    break;
                }
                e.a aVar2 = this.wZO.get(i2);
                if (aVar2.wXF == aVar.position) {
                    if (!aVar2.wXG) {
                        z2 = true;
                    }
                    aVar2.wXG = z2;
                } else {
                    i2++;
                }
            }
        }
        AppMethodBeat.o(112214);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d.k
    public int dPI() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e, com.tencent.mm.plugin.fts.ui.a
    public final int Nn(int i2) {
        AppMethodBeat.i(112210);
        int size = this.wZO.size();
        int i3 = i2;
        for (int i4 = 0; i4 < size; i4++) {
            e.a aVar = this.wZO.get(i4);
            aVar.wXD = i3;
            if (aVar.wXE) {
                i3++;
            }
            if (aVar.mWl.size() > 3) {
                if (aVar.wXG) {
                    i3 += 3;
                } else {
                    i3 += aVar.mWl.size();
                }
                aVar.wXF = i3;
                if (aVar.tuG) {
                    i3++;
                }
            } else {
                i3 += aVar.mWl.size();
                aVar.wXF = i3;
            }
        }
        AppMethodBeat.o(112210);
        return i3;
    }
}
