package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public final class c extends a {
    public c(MMActivity mMActivity) {
        super(mMActivity);
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
    public final boolean cwJ() {
        return this.qeD;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.a, com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwN() {
        AppMethodBeat.i(113639);
        if (!this.qeD || !super.cwN()) {
            AppMethodBeat.o(113639);
            return false;
        }
        AppMethodBeat.o(113639);
        return true;
    }
}
