package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.d.f;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;

public final class h extends d implements e.b {
    private MMHandler xad = new MMHandler(Looper.getMainLooper());
    private f xbn;
    private boolean xbo;

    public h(e eVar, String str, int i2) {
        super(eVar);
        AppMethodBeat.i(111906);
        Context context = eVar.getContext();
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(160);
        f fVar = (f) ((n) g.ah(n.class)).createFTSUIUnitList(hashSet, context, this, i2).get(0);
        fVar.wWS = str;
        if (ab.Eq(str)) {
            fVar.xbi = ((c) g.af(c.class)).aSX().Kd(str);
        }
        this.xbn = fVar;
        AppMethodBeat.o(111906);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e.b
    public final void a(e eVar, String str) {
        AppMethodBeat.i(111907);
        setCount(eVar.Nn(0));
        notifyDataSetChanged();
        ax(getCount(), true);
        AppMethodBeat.o(111907);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final a No(int i2) {
        AppMethodBeat.i(111908);
        a No = this.xbn.No(i2);
        if (No != null) {
            No.wXL = i2;
            No.pageType = 4;
        }
        AppMethodBeat.o(111908);
        return No;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void dPb() {
        AppMethodBeat.i(111909);
        this.xbo = false;
        this.xbn.a(this.query, this.xad, new HashSet<>(), 0);
        AppMethodBeat.o(111909);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final boolean a(View view, a aVar, boolean z) {
        AppMethodBeat.i(111910);
        this.xbn.a(view, aVar, z);
        if (aVar.wXT && !this.xbo) {
            this.xbo = true;
            l.c(this.query, true, this.xbn.dPa(), -2);
        }
        AppMethodBeat.o(111910);
        return false;
    }

    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void finish() {
        AppMethodBeat.i(111911);
        super.finish();
        if (!this.xbo) {
            this.xbo = true;
            l.c(this.query, false, this.xbn.dPa(), -2);
        }
        AppMethodBeat.o(111911);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final int dOI() {
        AppMethodBeat.i(258244);
        int dPa = this.xbn.dPa();
        AppMethodBeat.o(258244);
        return dPa;
    }
}
