package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;
import oicq.wlogin_sdk.tools.util;

public final class ab extends a {
    public int UdI = 0;

    public ab() {
        this.Ucx = TbsListener.ErrorCode.THROWABLE_QBSDK_INIT;
    }

    @Override // oicq.wlogin_sdk.a.a
    public final Boolean hPC() {
        AppMethodBeat.i(88110);
        if (this.Udh < 2) {
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(88110);
            return bool;
        }
        this.UdI = util.an(this.Ucr, this.Udg);
        if (this.UdI + 2 > this.Udh) {
            Boolean bool2 = Boolean.FALSE;
            AppMethodBeat.o(88110);
            return bool2;
        }
        Boolean bool3 = Boolean.TRUE;
        AppMethodBeat.o(88110);
        return bool3;
    }
}
