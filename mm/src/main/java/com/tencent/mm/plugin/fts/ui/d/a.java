package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class a extends com.tencent.mm.plugin.fts.ui.a {
    private boolean xeK;

    public a(Context context, e.b bVar, int i2) {
        super(context, bVar, i2);
        boolean z;
        AppMethodBeat.i(112163);
        String str = (String) g.aAh().azQ().get(6, (Object) null);
        if (str == null || str.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        this.xeK = z;
        Log.d("MicroMsg.FTS.FTSAddFriendUIUnit", "[FTSAddFriendUIUnit doSearchMobile : %s]", Boolean.valueOf(this.xeK));
        AppMethodBeat.o(112163);
    }

    private int[] dPH() {
        AppMethodBeat.i(112165);
        ArrayList arrayList = new ArrayList();
        if (this.xeK) {
            arrayList.add(16);
        }
        int[] iArr = new int[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        AppMethodBeat.o(112165);
        return iArr;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final void a(k kVar, HashSet<String> hashSet) {
        AppMethodBeat.i(112166);
        List<m> list = kVar.wXb;
        this.wZO.clear();
        e.a aVar = new e.a();
        aVar.businessType = -4;
        aVar.wXE = false;
        aVar.wXI = 1;
        aVar.wWd = kVar.wWd;
        aVar.mWl = new LinkedList();
        this.wZO.add(aVar);
        if (eP(list)) {
            List<m> a2 = d.a(list, c.wUQ);
            if (eP(a2)) {
                e.a aVar2 = new e.a();
                aVar2.businessType = -11;
                aVar2.mWl = a2;
                aVar2.wWd = kVar.wWd;
                this.wZO.add(aVar2);
            }
        }
        AppMethodBeat.o(112166);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i2, e.a aVar) {
        com.tencent.mm.plugin.fts.a.d.a.a aVar2;
        AppMethodBeat.i(112167);
        int i3 = (i2 - aVar.wXD) - 1;
        com.tencent.mm.plugin.fts.ui.a.a aVar3 = null;
        if (i3 < aVar.mWl.size() && i3 >= 0) {
            m mVar = aVar.mWl.get(i3);
            if (mVar.type == 131073 || mVar.type == 131074) {
                aVar2 = ((com.tencent.mm.plugin.fts.ui.a) ((n) g.ah(n.class)).createFTSUIUnit(33, this.context, this.wXC, this.mve)).a(mVar.type, i2, mVar, aVar);
            } else {
                aVar2 = null;
            }
            aVar3 = aVar2;
        } else if (!aVar.wXE && i2 == 0) {
            aVar3 = new com.tencent.mm.plugin.fts.ui.a.a(i2);
            aVar3.wWd = aVar.wWd;
        }
        if (aVar3 != null) {
            aVar3.wXM = i3 + 1;
        }
        AppMethodBeat.o(112167);
        return aVar3;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final int getType() {
        return 8192;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a
    public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler mMHandler, HashSet<String> hashSet) {
        AppMethodBeat.i(112164);
        String str = this.query;
        ArrayList arrayList = new ArrayList();
        if (this.xeK) {
            arrayList.add(131073);
            arrayList.add(131074);
        }
        int[] iArr = new int[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.ah(n.class)).search(9, j.a(str, iArr, dPH(), -1, hashSet, b.wXy, this, mMHandler));
        AppMethodBeat.o(112164);
        return search;
    }
}
