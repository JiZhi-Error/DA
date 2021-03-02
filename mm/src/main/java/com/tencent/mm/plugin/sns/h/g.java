package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;

public final class g implements i {
    h DRF;

    public final boolean fco() {
        AppMethodBeat.i(96138);
        if (this.DRF == null || this.DRF.DRu.size() == 0) {
            AppMethodBeat.o(96138);
            return false;
        }
        AppMethodBeat.o(96138);
        return true;
    }

    public final h fcp() {
        AppMethodBeat.i(96139);
        if (this.DRF == null || this.DRF.DRu.size() == 0) {
            AppMethodBeat.o(96139);
            return null;
        }
        h hVar = this.DRF;
        AppMethodBeat.o(96139);
        return hVar;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
    }
}
