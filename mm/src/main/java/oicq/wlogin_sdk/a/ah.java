package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;

public final class ah extends a {
    public int UdO = 0;

    public ah() {
        this.Ucx = TbsListener.ErrorCode.THROWABLE_INITX5CORE;
    }

    public final byte[] ds(byte[] bArr) {
        int i2;
        AppMethodBeat.i(88118);
        if (bArr != null) {
            i2 = bArr.length + 0;
        } else {
            i2 = 0;
        }
        byte[] bArr2 = new byte[i2];
        if (bArr2.length > 0) {
            System.arraycopy(bArr, 0, bArr2, 0, i2);
        }
        this.UdO = bArr2.length;
        super.awj(this.Ucx);
        super.ak(bArr2, bArr2.length);
        super.hPB();
        byte[] hPx = super.hPx();
        AppMethodBeat.o(88118);
        return hPx;
    }
}
