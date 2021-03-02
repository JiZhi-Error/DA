package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.ui.d.g;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;

public final class i extends d implements e.b {
    private MMHandler ndA = new MMHandler();
    private boolean xbo;
    private g xbr;

    public i(e eVar, String str, String str2, String str3, int i2, int i3) {
        super(eVar);
        AppMethodBeat.i(111919);
        this.xbr = new g(eVar.getContext(), this, i2);
        this.xbr.wWT = str2;
        this.xbr.talker = str;
        this.xbr.wWS = str3;
        this.xbr.dDG = i3;
        AppMethodBeat.o(111919);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final a No(int i2) {
        AppMethodBeat.i(111920);
        a No = this.xbr.No(i2);
        if (No != null) {
            No.pageType = 5;
        }
        AppMethodBeat.o(111920);
        return No;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void dPb() {
        AppMethodBeat.i(111921);
        this.xbo = false;
        this.xbr.a(this.query, this.ndA, new HashSet<>(), 0);
        AppMethodBeat.o(111921);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final boolean a(View view, a aVar, boolean z) {
        AppMethodBeat.i(111922);
        boolean a2 = this.xbr.a(view, aVar, z);
        if (aVar.wXT && !this.xbo) {
            this.xbo = true;
            l.c(this.query, true, this.xbr.dPa(), -2);
        }
        if (a2) {
            clearCache();
            setCount(this.xbr.Nn(0));
            notifyDataSetChanged();
            ax(getCount(), true);
        }
        AppMethodBeat.o(111922);
        return a2;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e.b
    public final void a(e eVar, String str) {
        AppMethodBeat.i(111923);
        setCount(eVar.Nn(0));
        notifyDataSetChanged();
        ax(getCount(), true);
        AppMethodBeat.o(111923);
    }

    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void finish() {
        AppMethodBeat.i(111924);
        super.finish();
        if (!this.xbo) {
            this.xbo = true;
            l.c(this.query, false, this.xbr.dPa(), -2);
        }
        AppMethodBeat.o(111924);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final int dOI() {
        AppMethodBeat.i(258245);
        int dPa = this.xbr.dPa();
        AppMethodBeat.o(258245);
        return dPa;
    }
}
