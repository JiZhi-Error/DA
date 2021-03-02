package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class c extends a {
    int Udn = 1;
    int Udo = util.Ues;
    int Udp = 22;

    public c() {
        this.Ucx = 256;
    }

    public final byte[] t(long j2, int i2, int i3) {
        AppMethodBeat.i(209828);
        byte[] bArr = new byte[this.Udp];
        util.ah(bArr, 0, this.Udn);
        util.ai(bArr, 2, this.Udo);
        util.ai(bArr, 6, 522017402);
        util.ai(bArr, 10, 1);
        util.ai(bArr, 14, i2);
        util.ai(bArr, 18, 8256);
        super.awj(this.Ucx);
        super.ak(bArr, this.Udp);
        super.hPB();
        byte[] hPx = super.hPx();
        AppMethodBeat.o(209828);
        return hPx;
    }
}
