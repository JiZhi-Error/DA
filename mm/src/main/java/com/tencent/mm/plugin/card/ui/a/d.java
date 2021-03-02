package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public final class d extends a {
    public d(MMActivity mMActivity) {
        super(mMActivity);
    }

    @Override // com.tencent.mm.plugin.card.ui.a.a, com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwM() {
        return false;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.a, com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwO() {
        return false;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.a, com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwP() {
        AppMethodBeat.i(113640);
        if (this.pQV.csR().LcB == null || !this.qeD || !cwq() || !cwr()) {
            AppMethodBeat.o(113640);
            return false;
        }
        AppMethodBeat.o(113640);
        return true;
    }
}
