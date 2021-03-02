package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.ui.d.a;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;

public final class c extends d implements e.b {
    private a xab;
    protected boolean xac;
    private MMHandler xad = new MMHandler(Looper.getMainLooper());

    public c(e eVar) {
        super(eVar);
        AppMethodBeat.i(111813);
        this.xab = new a(eVar.getContext(), this, 0);
        AppMethodBeat.o(111813);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final com.tencent.mm.plugin.fts.a.d.a.a No(int i2) {
        AppMethodBeat.i(111814);
        com.tencent.mm.plugin.fts.a.d.a.a No = this.xab.No(i2);
        AppMethodBeat.o(111814);
        return No;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void dPb() {
        AppMethodBeat.i(111815);
        this.xac = false;
        this.xab.a(this.query, this.xad, new HashSet<>(), 0);
        AppMethodBeat.o(111815);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final boolean a(View view, com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z) {
        return false;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e.b
    public final void a(e eVar, String str) {
        AppMethodBeat.i(111816);
        int Nn = this.xab.Nn(0);
        setCount(Nn);
        notifyDataSetChanged();
        ax(Nn, true);
        AppMethodBeat.o(111816);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final int dOI() {
        AppMethodBeat.i(111817);
        int dPa = this.xab.dPa();
        AppMethodBeat.o(111817);
        return dPa;
    }
}
