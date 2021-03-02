package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m extends n {
    Class<? extends Activity> nQi;
    private g nQj;

    m(Class<? extends Activity> cls, Class cls2, Class cls3, Class cls4, Class cls5, Class cls6, Class<? extends Activity> cls7) {
        super(cls, cls2, cls3, cls4, cls5, cls6);
        this.nQi = cls7;
    }

    public final Class<? extends Activity> bWm() {
        return this.nQi;
    }

    public final void y(g gVar) {
        AppMethodBeat.i(227512);
        if (this.nQj != null) {
            IllegalStateException illegalStateException = new IllegalStateException("const field");
            AppMethodBeat.o(227512);
            throw illegalStateException;
        }
        this.nQj = gVar;
        AppMethodBeat.o(227512);
    }

    public final g bWn() {
        return this.nQj;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.task.n
    public final boolean c(g gVar) {
        AppMethodBeat.i(227513);
        if (this.nQj == null) {
            boolean c2 = super.c(gVar);
            AppMethodBeat.o(227513);
            return c2;
        } else if (this.nQj == gVar) {
            AppMethodBeat.o(227513);
            return true;
        } else {
            AppMethodBeat.o(227513);
            return false;
        }
    }
}
