package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class an extends a {
    int UdT = 22;
    int UdU = 1;
    int UdV = 1536;

    public an() {
        this.Ucx = 24;
    }

    public final byte[] a(long j2, int i2, long j3) {
        AppMethodBeat.i(209831);
        byte[] bArr = new byte[this.UdT];
        util.ah(bArr, 0, this.UdU);
        util.ai(bArr, 2, this.UdV);
        util.ai(bArr, 6, 522017402);
        util.ai(bArr, 10, i2);
        util.ai(bArr, 14, (int) j3);
        util.ah(bArr, 18, 0);
        util.ah(bArr, 20, 0);
        super.awj(this.Ucx);
        super.ak(bArr, this.UdT);
        super.hPB();
        byte[] hPx = super.hPx();
        AppMethodBeat.o(209831);
        return hPx;
    }
}
