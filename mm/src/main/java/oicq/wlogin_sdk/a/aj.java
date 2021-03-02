package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;
import oicq.wlogin_sdk.tools.util;

public final class aj extends a {
    public aj() {
        this.Ucx = TbsListener.ErrorCode.TEST_THROWABLE_ISNOT_NULL;
    }

    private static int dt(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        if (bArr.length > 32) {
            return 32;
        }
        return bArr.length;
    }

    public final byte[] a(long j2, byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(209830);
        int dt = dt(bArr);
        int dt2 = dt(bArr2);
        byte[] bArr3 = new byte[(dt + 6 + 2 + dt2)];
        util.d(bArr3, 0, 522017402);
        util.ah(bArr3, 4, dt);
        System.arraycopy(bArr, 0, bArr3, 6, dt);
        int i2 = dt + 6;
        util.ah(bArr3, i2, dt2);
        System.arraycopy(bArr2, 0, bArr3, i2 + 2, dt2);
        super.awj(this.Ucx);
        super.ak(bArr3, bArr3.length);
        super.hPB();
        byte[] hPx = super.hPx();
        AppMethodBeat.o(209830);
        return hPx;
    }
}
