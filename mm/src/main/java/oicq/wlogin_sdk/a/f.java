package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f extends a {
    int Udq = 0;

    public f() {
        this.Ucx = 260;
    }

    /* renamed from: do  reason: not valid java name */
    public final byte[] m56do(byte[] bArr) {
        AppMethodBeat.i(88119);
        this.Udq = bArr.length;
        byte[] bArr2 = new byte[this.Udq];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        super.awj(this.Ucx);
        super.ak(bArr2, this.Udq);
        super.hPB();
        byte[] hPx = super.hPx();
        AppMethodBeat.o(88119);
        return hPx;
    }
}
