package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j extends a {
    int Udz = 0;

    public j() {
        this.Ucx = 264;
    }

    public final byte[] dp(byte[] bArr) {
        AppMethodBeat.i(88132);
        this.Udz = bArr.length;
        byte[] bArr2 = new byte[this.Udz];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        super.awj(this.Ucx);
        super.ak(bArr2, this.Udz);
        super.hPB();
        byte[] hPx = super.hPx();
        AppMethodBeat.o(88132);
        return hPx;
    }
}
