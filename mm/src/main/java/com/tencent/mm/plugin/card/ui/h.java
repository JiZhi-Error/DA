package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;

public final class h implements a {
    private g qcz;

    public h(g gVar) {
        this.qcz = gVar;
    }

    @Override // com.tencent.mm.plugin.card.base.a
    public final void onCreate() {
        AppMethodBeat.i(113478);
        this.qcz.notifyDataSetChanged();
        AppMethodBeat.o(113478);
    }

    @Override // com.tencent.mm.plugin.card.base.a
    public final void onDestroy() {
        AppMethodBeat.i(113479);
        if (this.qcz != null) {
            g gVar = this.qcz;
            gVar.pXo.release();
            gVar.pXo = null;
            gVar.pXz.clear();
            gVar.mContext = null;
            gVar.qcx = null;
            this.qcz = null;
        }
        AppMethodBeat.o(113479);
    }

    @Override // com.tencent.mm.plugin.card.base.a
    public final void onNotify() {
        AppMethodBeat.i(113480);
        if (this.qcz != null) {
            this.qcz.notifyDataSetChanged();
        }
        AppMethodBeat.o(113480);
    }

    @Override // com.tencent.mm.plugin.card.base.a
    public final /* synthetic */ b Ed(int i2) {
        AppMethodBeat.i(113481);
        if (this.qcz != null) {
            CardInfo Ep = this.qcz.Ep(i2);
            AppMethodBeat.o(113481);
            return Ep;
        }
        AppMethodBeat.o(113481);
        return null;
    }
}
