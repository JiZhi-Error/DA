package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    public String dQx;
    public String lHA;
    public String lHB;
    public String qwt;

    public final boolean fPZ() {
        AppMethodBeat.i(70205);
        if (Util.isNullOrNil(this.dQx) || Util.isNullOrNil(this.lHA) || Util.isNullOrNil(this.lHB) || Util.isNullOrNil(this.qwt)) {
            AppMethodBeat.o(70205);
            return false;
        }
        AppMethodBeat.o(70205);
        return true;
    }
}
