package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class t extends a {
    public int UdD = 0;

    public t() {
        this.Ucx = 282;
    }

    @Override // oicq.wlogin_sdk.a.a
    public final Boolean hPC() {
        AppMethodBeat.i(88142);
        if (this.Udh < 5) {
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(88142);
            return bool;
        }
        int am = util.am(this.Ucr, this.Udg + 2 + 1 + 1);
        if (this.Udh < am + 5) {
            Boolean bool2 = Boolean.FALSE;
            AppMethodBeat.o(88142);
            return bool2;
        }
        this.UdD = am;
        Boolean bool3 = Boolean.TRUE;
        AppMethodBeat.o(88142);
        return bool3;
    }
}
