package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;
import oicq.wlogin_sdk.tools.util;

public final class ae extends a {
    int UdK = 0;
    int UdL = 0;

    public ae() {
        this.Ucx = TbsListener.ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02;
    }

    public final byte[] dr(byte[] bArr) {
        AppMethodBeat.i(88133);
        this.UdL = bArr.length + 4;
        byte[] bArr2 = new byte[this.UdL];
        util.ah(bArr2, 0, this.UdK);
        util.ah(bArr2, 2, bArr.length);
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        super.awj(this.Ucx);
        super.ak(bArr2, bArr2.length);
        super.hPB();
        byte[] hPx = super.hPx();
        AppMethodBeat.o(88133);
        return hPx;
    }
}
