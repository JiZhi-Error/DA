package com.tencent.mm.plugin.product.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class e {
    int BaL;
    int BaM;

    public e(int i2, int i3) {
        this.BaM = i2;
        this.BaL = i3;
    }

    public final boolean eDA() {
        AppMethodBeat.i(66959);
        boolean z = (this.BaM & 1) > 0;
        Log.d("MicroMsg.MallProductConfig", "isFreePost, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(66959);
        return z;
    }
}
