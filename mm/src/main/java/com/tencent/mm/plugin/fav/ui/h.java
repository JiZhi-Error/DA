package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.pluginsdk.ui.tools.k;

public final class h extends k {
    public h(int i2) {
        super(i2);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.k
    public final s i(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(106736);
        g gVar = new g(str, str2, i2, i3);
        AppMethodBeat.o(106736);
        return gVar;
    }
}
