package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.menu.a.a;

public final class t {
    public final int id;
    public final ad.b lEi = new ad.b();
    public final boolean neS;
    public boolean neT;
    public final a neU;

    public t(int i2, boolean z, a aVar) {
        AppMethodBeat.i(134917);
        this.id = i2;
        this.neS = z;
        this.neU = aVar;
        AppMethodBeat.o(134917);
    }

    public final ad.b getKeyValueSet() {
        return this.lEi;
    }
}
