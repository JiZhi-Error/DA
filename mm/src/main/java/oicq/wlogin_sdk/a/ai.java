package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;
import oicq.wlogin_sdk.tools.util;

public final class ai extends a {
    public int UdP = 0;
    public int UdQ = 0;
    public int UdR = 0;

    public ai() {
        this.Ucx = TbsListener.ErrorCode.TEST_THROWABLE_IS_NULL;
    }

    @Override // oicq.wlogin_sdk.a.a
    public final Boolean hPC() {
        AppMethodBeat.i(88111);
        if (this.Udh < 12) {
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(88111);
            return bool;
        }
        int an = util.an(this.Ucr, this.Udg + 4);
        if (this.Udh < an + 12) {
            Boolean bool2 = Boolean.FALSE;
            AppMethodBeat.o(88111);
            return bool2;
        }
        this.UdP = an;
        int an2 = util.an(this.Ucr, this.Udg + 6 + this.UdP);
        if (this.Udh < this.UdP + 12 + an2) {
            Boolean bool3 = Boolean.FALSE;
            AppMethodBeat.o(88111);
            return bool3;
        }
        this.UdQ = an2;
        int an3 = util.an(this.Ucr, this.Udg + 10 + this.UdP + this.UdQ);
        if (this.Udh < this.UdP + 12 + this.UdQ + an3) {
            Boolean bool4 = Boolean.FALSE;
            AppMethodBeat.o(88111);
            return bool4;
        }
        this.UdR = an3;
        Boolean bool5 = Boolean.TRUE;
        AppMethodBeat.o(88111);
        return bool5;
    }
}
