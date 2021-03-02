package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;

public final class h implements a {
    private g pXA;

    public h(g gVar) {
        this.pXA = gVar;
    }

    @Override // com.tencent.mm.plugin.card.base.a
    public final void onCreate() {
        AppMethodBeat.i(113096);
        this.pXA.notifyDataSetChanged();
        AppMethodBeat.o(113096);
    }

    @Override // com.tencent.mm.plugin.card.base.a
    public final void onDestroy() {
        AppMethodBeat.i(113097);
        if (this.pXA != null) {
            g gVar = this.pXA;
            gVar.pXo.release();
            gVar.pXo = null;
            gVar.pXz.clear();
            gVar.mContext = null;
            this.pXA = null;
        }
        AppMethodBeat.o(113097);
    }

    @Override // com.tencent.mm.plugin.card.base.a
    public final void onNotify() {
        AppMethodBeat.i(113098);
        if (this.pXA != null) {
            this.pXA.notifyDataSetChanged();
        }
        AppMethodBeat.o(113098);
    }

    @Override // com.tencent.mm.plugin.card.base.a
    public final b Ed(int i2) {
        AppMethodBeat.i(113099);
        if (this.pXA != null) {
            b Ed = this.pXA.Ed(i2);
            AppMethodBeat.o(113099);
            return Ed;
        }
        AppMethodBeat.o(113099);
        return null;
    }
}
