package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.ui.d.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;

public final class m extends d implements e.b {
    private MMHandler ndA = new MMHandler();
    private boolean xbo;
    private l xcl;

    public m(e eVar, String str, int i2) {
        super(eVar);
        AppMethodBeat.i(112024);
        this.xcl = new l(eVar.getContext(), this, i2);
        this.xcl.wWT = str;
        AppMethodBeat.o(112024);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final a No(int i2) {
        AppMethodBeat.i(112025);
        a No = this.xcl.No(i2);
        if (No != null) {
            No.pageType = 3;
        }
        AppMethodBeat.o(112025);
        return No;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void dPb() {
        AppMethodBeat.i(112026);
        this.xbo = false;
        this.xcl.a(this.query, this.ndA, new HashSet<>(), 0);
        AppMethodBeat.o(112026);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final boolean a(View view, a aVar, boolean z) {
        AppMethodBeat.i(112027);
        boolean a2 = this.xcl.a(view, aVar, z);
        if (aVar.wXT && !this.xbo) {
            this.xbo = true;
            l.c(this.query, true, this.xcl.dPa(), -2);
        }
        if (a2) {
            clearCache();
            setCount(this.xcl.Nn(0));
            notifyDataSetChanged();
            ax(getCount(), true);
        }
        AppMethodBeat.o(112027);
        return a2;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e.b
    public final void a(e eVar, String str) {
        AppMethodBeat.i(112028);
        setCount(eVar.Nn(0));
        notifyDataSetChanged();
        ax(getCount(), true);
        AppMethodBeat.o(112028);
    }

    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void finish() {
        AppMethodBeat.i(112029);
        super.finish();
        if (!this.xbo) {
            this.xbo = true;
            l.c(this.query, false, this.xcl.dPa(), -2);
        }
        AppMethodBeat.o(112029);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final int dOI() {
        AppMethodBeat.i(258246);
        int dPa = this.xcl.dPa();
        AppMethodBeat.o(258246);
        return dPa;
    }
}
