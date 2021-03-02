package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class b extends a {
    int Udi = 4;
    int Udj = 14;
    int Udk = 1;
    int Udl = 20;
    byte[] Udm = new byte[2];

    public b() {
        AppMethodBeat.i(88137);
        this.Ucx = 1;
        AppMethodBeat.o(88137);
    }

    @Override // oicq.wlogin_sdk.a.a
    public final Boolean hPC() {
        if (this.Udh < 20) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public final byte[] g(long j2, byte[] bArr) {
        AppMethodBeat.i(88138);
        byte[] bArr2 = new byte[this.Udl];
        util.ah(bArr2, 0, this.Udk);
        util.ai(bArr2, 2, util.hPI());
        util.ai(bArr2, 6, (int) j2);
        util.d(bArr2, 10, util.hPK());
        System.arraycopy(bArr, 0, bArr2, 14, bArr.length);
        util.ah(bArr2, bArr.length + 14, 0);
        super.awj(this.Ucx);
        super.ak(bArr2, this.Udl);
        super.hPB();
        byte[] hPx = super.hPx();
        AppMethodBeat.o(88138);
        return hPx;
    }
}
