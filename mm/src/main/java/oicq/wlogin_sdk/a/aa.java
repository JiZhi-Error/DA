package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class aa extends a {
    int UdH = 0;

    public aa() {
        this.Ucx = 296;
    }

    private static int al(byte[] bArr, int i2) {
        if (bArr == null) {
            return 0;
        }
        if (bArr.length > i2) {
            return i2;
        }
        return bArr.length;
    }

    public final byte[] a(int i2, int i3, int i4, byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(88134);
        int al = al(bArr, 32);
        int al2 = al(bArr2, 16);
        this.UdH = al + 11 + 2 + al2 + 2;
        byte[] bArr3 = new byte[this.UdH];
        util.ah(bArr3, 0, 0);
        util.ag(bArr3, 2, i2);
        util.ag(bArr3, 3, i3);
        util.ag(bArr3, 4, i4);
        util.ai(bArr3, 5, 0);
        util.ah(bArr3, 9, al);
        System.arraycopy(bArr, 0, bArr3, 11, al);
        int i5 = al + 11;
        util.ah(bArr3, i5, al2);
        int i6 = i5 + 2;
        System.arraycopy(bArr2, 0, bArr3, i6, al2);
        util.ah(bArr3, i6 + al2, 0);
        super.awj(this.Ucx);
        super.ak(bArr3, this.UdH);
        super.hPB();
        byte[] hPx = super.hPx();
        AppMethodBeat.o(88134);
        return hPx;
    }
}
