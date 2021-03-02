package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.e.g;

public final class b {
    private static b ysv;
    private g ysw;

    public static b eaU() {
        AppMethodBeat.i(25513);
        if (ysv == null) {
            ysv = new b();
        }
        b bVar = ysv;
        AppMethodBeat.o(25513);
        return bVar;
    }

    public final void qy(boolean z) {
        AppMethodBeat.i(25514);
        bg.azz().a(this.ysw);
        this.ysw = null;
        if (z) {
            this.ysw = new g(1);
        } else {
            this.ysw = new g(0);
        }
        bg.azz().a(this.ysw, 0);
        AppMethodBeat.o(25514);
    }
}
