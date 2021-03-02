package com.tencent.mm.ui.tools;

import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r extends s {
    private boolean Qwb = true;

    public r() {
        super((byte) 0);
    }

    public final void CJ(boolean z) {
        this.Qwb = z;
    }

    @Override // com.tencent.mm.ui.tools.s
    public final void c(Menu menu) {
        AppMethodBeat.i(205378);
        super.c(menu);
        AppMethodBeat.o(205378);
    }

    @Override // com.tencent.mm.ui.tools.s
    public final boolean gXO() {
        AppMethodBeat.i(205379);
        if (this.Qwb) {
            boolean gXO = super.gXO();
            AppMethodBeat.o(205379);
            return gXO;
        }
        AppMethodBeat.o(205379);
        return false;
    }
}
