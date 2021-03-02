package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k extends a {
    int UdA = 0;

    public k() {
        this.Ucx = 265;
    }

    public final byte[] dq(byte[] bArr) {
        AppMethodBeat.i(88141);
        this.UdA = bArr.length;
        byte[] bArr2 = new byte[this.UdA];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        super.awj(this.Ucx);
        super.ak(bArr2, this.UdA);
        super.hPB();
        byte[] hPx = super.hPx();
        AppMethodBeat.o(88141);
        return hPx;
    }
}
