package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class g extends a {
    public int Udr = 0;
    public int Uds = 0;
    public int Udt = 0;
    public int Udu = 0;

    public g() {
        this.Ucx = 261;
    }

    @Override // oicq.wlogin_sdk.a.a
    public final Boolean hPC() {
        AppMethodBeat.i(88108);
        if (this.Udh < 2) {
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(88108);
            return bool;
        }
        this.Uds = util.an(this.Ucr, this.Udg);
        if (this.Udh < this.Uds + 2 + 2) {
            Boolean bool2 = Boolean.FALSE;
            AppMethodBeat.o(88108);
            return bool2;
        }
        this.Udr = util.an(this.Ucr, this.Udg + 2 + this.Uds);
        if (this.Udh < this.Uds + 2 + 2 + this.Udr) {
            Boolean bool3 = Boolean.FALSE;
            AppMethodBeat.o(88108);
            return bool3;
        }
        this.Udu = this.Udg + 2;
        this.Udt = this.Uds + 2 + 2 + this.Udg;
        Boolean bool4 = Boolean.TRUE;
        AppMethodBeat.o(88108);
        return bool4;
    }
}
