package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ad extends a {
    public int UdJ = 0;

    public ad() {
        this.Ucx = 312;
    }

    @Override // oicq.wlogin_sdk.a.a
    public final Boolean hPC() {
        AppMethodBeat.i(88116);
        if (this.Udh < 4) {
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(88116);
            return bool;
        }
        this.UdJ = util.ao(this.Ucr, this.Udg);
        if (this.Udh < (this.UdJ * 10) + 4) {
            Boolean bool2 = Boolean.FALSE;
            AppMethodBeat.o(88116);
            return bool2;
        }
        Boolean bool3 = Boolean.TRUE;
        AppMethodBeat.o(88116);
        return bool3;
    }

    public final int hPE() {
        AppMethodBeat.i(88117);
        for (int i2 = 0; i2 < this.UdJ; i2++) {
            if (util.an(this.Ucr, this.Udg + 4 + (i2 * 10)) == 266) {
                int ao = util.ao(this.Ucr, (i2 * 10) + this.Udg + 4 + 2);
                AppMethodBeat.o(88117);
                return ao;
            }
        }
        AppMethodBeat.o(88117);
        return 0;
    }
}
