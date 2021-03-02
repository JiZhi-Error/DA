package com.tencent.mm.plugin.profile.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import java.lang.ref.WeakReference;

public final class a implements e.a {
    private WeakReference<e.a> cMO;

    public a(e.a aVar) {
        AppMethodBeat.i(27599);
        this.cMO = new WeakReference<>(aVar);
        AppMethodBeat.o(27599);
    }

    @Override // com.tencent.mm.aj.e.a
    public final void Mr(String str) {
        AppMethodBeat.i(27600);
        if (this.cMO.get() != null) {
            this.cMO.get().Mr(str);
        }
        AppMethodBeat.o(27600);
    }
}
