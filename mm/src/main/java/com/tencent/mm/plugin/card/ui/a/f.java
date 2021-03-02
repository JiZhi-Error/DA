package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class f extends a {
    public f(MMActivity mMActivity) {
        super(mMActivity);
    }

    @Override // com.tencent.mm.plugin.card.ui.a.a, com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwK() {
        AppMethodBeat.i(113648);
        if (!this.pQV.csM() || !super.cwK() || (!this.pQV.csK() && Util.isNullOrNil(this.pQV.csR().code))) {
            AppMethodBeat.o(113648);
            return false;
        }
        AppMethodBeat.o(113648);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.a, com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwL() {
        return true;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.a, com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwO() {
        AppMethodBeat.i(113649);
        if (!this.pQV.csM() || !super.cwO()) {
            AppMethodBeat.o(113649);
            return false;
        }
        AppMethodBeat.o(113649);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.a, com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwJ() {
        return this.qeD;
    }
}
