package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.h;
import oicq.wlogin_sdk.tools.util;

public final class z extends a {
    public int UdF = 0;
    public int UdG = 0;

    public z() {
        this.Ucx = h.CTRL_INDEX;
    }

    @Override // oicq.wlogin_sdk.a.a
    public final Boolean hPC() {
        AppMethodBeat.i(88115);
        if (this.Udh < 2) {
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(88115);
            return bool;
        }
        this.UdF = util.an(this.Ucr, this.Udg);
        if (this.Udh < this.UdF + 2 + 2) {
            Boolean bool2 = Boolean.FALSE;
            AppMethodBeat.o(88115);
            return bool2;
        }
        this.UdG = util.an(this.Ucr, this.Udg + 2 + this.UdF);
        Boolean bool3 = Boolean.TRUE;
        AppMethodBeat.o(88115);
        return bool3;
    }
}
