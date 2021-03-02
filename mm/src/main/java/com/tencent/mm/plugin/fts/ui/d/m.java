package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.util.c;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.ArrayList;
import java.util.HashSet;

public final class m extends a {
    private boolean xeK = false;

    public m(Context context, e.b bVar, int i2) {
        super(context, bVar, i2);
        boolean z;
        AppMethodBeat.i(112215);
        String str = (String) g.aAh().azQ().get(6, (Object) null);
        if (str == null || str.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        this.xeK = z;
        this.xeK &= Util.isOverseasUser(context);
        AppMethodBeat.o(112215);
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler mMHandler, HashSet<String> hashSet) {
        AppMethodBeat.i(112216);
        j jVar = new j();
        ArrayList arrayList = new ArrayList();
        arrayList.add(131072);
        arrayList.add(131075);
        arrayList.add(Integer.valueOf((int) TPMediaCodecProfileLevel.HEVCMainTierLevel52));
        arrayList.add(131076);
        if (this.xeK) {
            arrayList.add(131073);
            arrayList.add(131074);
        }
        b.a aVar = b.a.clicfg_fts_weapp_tophit_open_flag;
        c cVar = c.QYz;
        if (((b) g.af(b.class)).a(aVar, c.hdd()) == 1) {
            arrayList.add(393216);
        }
        int[] iArr = new int[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        jVar.wWU = iArr;
        jVar.wWW = 3;
        jVar.wWZ = this;
        jVar.handler = mMHandler;
        jVar.scene = 0;
        jVar.wWX = hashSet;
        if (this.query.startsWith("@@")) {
            jVar.query = this.query.substring(2);
            com.tencent.mm.plugin.fts.a.a.a search = ((n) g.ah(n.class)).search(10000, jVar);
            AppMethodBeat.o(112216);
            return search;
        }
        jVar.query = this.query;
        com.tencent.mm.plugin.fts.a.a.a search2 = ((n) g.ah(n.class)).search(1, jVar);
        AppMethodBeat.o(112216);
        return search2;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final void a(k kVar, HashSet<String> hashSet) {
        AppMethodBeat.i(112217);
        for (com.tencent.mm.plugin.fts.a.a.m mVar : kVar.wXb) {
            hashSet.add(mVar.wVX);
        }
        if (eP(kVar.wXb)) {
            e.a aVar = new e.a();
            aVar.businessType = -8;
            aVar.mWl = eQ(kVar.wXb);
            aVar.tuG = false;
            aVar.wWd = kVar.wWd;
            this.wZO.add(aVar);
        }
        d.eO(kVar.wXb);
        AppMethodBeat.o(112217);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0046  */
    @Override // com.tencent.mm.plugin.fts.ui.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int r10, com.tencent.mm.plugin.fts.a.d.e.a r11) {
        /*
        // Method dump skipped, instructions count: 230
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.ui.d.m.a(int, com.tencent.mm.plugin.fts.a.d.e$a):com.tencent.mm.plugin.fts.a.d.a.a");
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.a.c b(int i2, e.a aVar) {
        com.tencent.mm.plugin.fts.a.a.c cVar;
        AppMethodBeat.i(112219);
        if (i2 >= aVar.mWl.size() || i2 < 0) {
            cVar = null;
        } else {
            com.tencent.mm.plugin.fts.a.a.m mVar = aVar.mWl.get(i2);
            com.tencent.mm.plugin.fts.a.a.c cVar2 = new com.tencent.mm.plugin.fts.a.a.c();
            cVar2.dUm = 2;
            cVar2.dUb = String.valueOf(mVar.hashCode());
            if (mVar.type == 131075) {
                cVar2.wWa = 4;
                cVar = cVar2;
            } else if (mVar.type == 131072 || mVar.type == 131073 || mVar.type == 131074) {
                cVar2.wWa = 3;
                cVar = cVar2;
            } else if (mVar.type == 262144) {
                cVar2.wWa = 10;
                cVar = cVar2;
            } else if (mVar.type == 131076) {
                cVar2.wWa = 5;
                cVar = cVar2;
            } else if (mVar.type == 393216) {
                cVar2.wWa = 19;
                cVar = cVar2;
            } else {
                cVar = null;
            }
        }
        AppMethodBeat.o(112219);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final int getType() {
        return 16;
    }
}
