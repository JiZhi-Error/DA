package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public final class h extends a {
    public h(MMActivity mMActivity) {
        super(mMActivity);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.card.ui.a.a
    public final void cwv() {
        AppMethodBeat.i(113650);
        super.cwv();
        AppMethodBeat.o(113650);
    }

    @Override // com.tencent.mm.plugin.card.ui.a.a, com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwF() {
        AppMethodBeat.i(113651);
        ArrayList<r> ajt = b.ajt(this.pQV.csV());
        if ((!this.pZU.pSh || this.pZU.gwE == 4) && !TextUtils.isEmpty(this.pQV.csW())) {
            AppMethodBeat.o(113651);
            return true;
        } else if ((!this.pZU.pSh || ajt == null || ajt.size() <= 0) && (TextUtils.isEmpty(this.pQV.csW()) || !cwG())) {
            AppMethodBeat.o(113651);
            return false;
        } else {
            AppMethodBeat.o(113651);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.card.ui.a.a, com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwG() {
        return this.pZU.gwE == 3;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.a, com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwH() {
        return false;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.a, com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwM() {
        return false;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.a, com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwR() {
        return false;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.a, com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwS() {
        return false;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.a, com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwK() {
        return false;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.a, com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwT() {
        AppMethodBeat.i(113653);
        if (super.cwT()) {
            AppMethodBeat.o(113653);
            return true;
        } else if (cwU()) {
            AppMethodBeat.o(113653);
            return true;
        } else if (!this.pQV.csw() || !this.qeD) {
            AppMethodBeat.o(113653);
            return false;
        } else {
            AppMethodBeat.o(113653);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.card.ui.a.a, com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwJ() {
        return this.qeD;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.a, com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwN() {
        AppMethodBeat.i(113652);
        if (!this.qeD || !super.cwN()) {
            AppMethodBeat.o(113652);
            return false;
        }
        AppMethodBeat.o(113652);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.a, com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwU() {
        AppMethodBeat.i(113654);
        if (this.qeD || this.pQV.csQ().LeX != 1) {
            AppMethodBeat.o(113654);
            return false;
        }
        AppMethodBeat.o(113654);
        return true;
    }
}
