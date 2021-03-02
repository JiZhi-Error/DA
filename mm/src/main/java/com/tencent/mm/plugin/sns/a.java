package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.i;

public final class a implements com.tencent.mm.plugin.sns.b.a {
    @Override // com.tencent.mm.plugin.sns.b.a
    public final void r(int i2, String str, int i3) {
        AppMethodBeat.i(94884);
        i iVar = new i(i2, str, i3);
        g.aAi();
        g.aAg().hqi.a(iVar, 0);
        AppMethodBeat.o(94884);
    }
}
