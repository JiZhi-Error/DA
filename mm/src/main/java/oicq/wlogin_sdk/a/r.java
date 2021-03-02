package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class r extends a {
    int UdB = 0;
    int UdC = 0;

    public r() {
        this.Ucx = 278;
    }

    public final byte[] nj(int i2, int i3) {
        AppMethodBeat.i(88140);
        this.UdB = 10;
        byte[] bArr = new byte[this.UdB];
        util.ag(bArr, 0, this.UdC);
        util.ai(bArr, 1, i2);
        util.ai(bArr, 5, i3);
        util.ag(bArr, 9, 0);
        super.awj(this.Ucx);
        super.ak(bArr, this.UdB);
        super.hPB();
        byte[] hPx = super.hPx();
        AppMethodBeat.o(88140);
        return hPx;
    }
}
