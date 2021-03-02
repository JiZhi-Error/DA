package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ao extends a {
    int UdW = 0;
    int UdX = 0;

    public ao() {
        this.Ucx = 2;
    }

    public final byte[] r(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(88109);
        this.UdW = bArr.length + 6 + bArr2.length;
        byte[] bArr3 = new byte[this.UdW];
        util.ah(bArr3, 0, this.UdX);
        util.ah(bArr3, 2, bArr.length);
        System.arraycopy(bArr, 0, bArr3, 4, bArr.length);
        int length = bArr.length + 4;
        util.ah(bArr3, length, bArr2.length);
        System.arraycopy(bArr2, 0, bArr3, length + 2, bArr2.length);
        super.awj(this.Ucx);
        super.ak(bArr3, this.UdW);
        super.hPB();
        byte[] hPx = super.hPx();
        AppMethodBeat.o(88109);
        return hPx;
    }
}
