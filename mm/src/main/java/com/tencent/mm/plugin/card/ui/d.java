package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;

public final class d implements a {
    private c pYV;

    public d(c cVar) {
        this.pYV = cVar;
    }

    @Override // com.tencent.mm.plugin.card.base.a
    public final void onCreate() {
        AppMethodBeat.i(113185);
        if (this.pYV != null) {
            am.ctQ().add(this.pYV);
        }
        AppMethodBeat.o(113185);
    }

    @Override // com.tencent.mm.plugin.card.base.a
    public final void onDestroy() {
        AppMethodBeat.i(113186);
        if (this.pYV != null) {
            am.ctQ().remove(this.pYV);
            this.pYV.release();
            this.pYV = null;
        }
        AppMethodBeat.o(113186);
    }

    @Override // com.tencent.mm.plugin.card.base.a
    public final void onNotify() {
        AppMethodBeat.i(113187);
        if (this.pYV != null) {
            this.pYV.onNotifyChange(null, null);
        }
        AppMethodBeat.o(113187);
    }

    @Override // com.tencent.mm.plugin.card.base.a
    public final /* synthetic */ b Ed(int i2) {
        AppMethodBeat.i(113188);
        if (this.pYV != null) {
            CardInfo cardInfo = (CardInfo) this.pYV.getItem(i2);
            AppMethodBeat.o(113188);
            return cardInfo;
        }
        AppMethodBeat.o(113188);
        return null;
    }
}
