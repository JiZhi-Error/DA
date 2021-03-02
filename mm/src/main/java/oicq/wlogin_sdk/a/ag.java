package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public final class ag extends a {
    public int UdN = 0;

    public ag() {
        this.Ucx = aq.CTRL_INDEX;
    }

    public final byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(88113);
        if (bArr != null) {
            i3 = bArr.length + 0;
            i2 = 1;
        } else {
            i2 = 0;
            i3 = 0;
        }
        if (bArr2 != null) {
            i3 += bArr2.length;
            i2++;
        }
        if (bArr3 != null) {
            i3 += bArr3.length;
            i2++;
        }
        if (bArr4 != null) {
            i3 += bArr4.length;
            i2++;
        }
        byte[] bArr6 = new byte[(i3 + 2)];
        util.ah(bArr6, 0, i2);
        if (bArr != null) {
            System.arraycopy(bArr, 0, bArr6, 2, bArr.length);
            i4 = bArr.length + 2;
        } else {
            i4 = 2;
        }
        if (bArr2 != null) {
            System.arraycopy(bArr2, 0, bArr6, i4, bArr2.length);
            i4 += bArr2.length;
        }
        if (bArr3 != null) {
            System.arraycopy(bArr3, 0, bArr6, i4, bArr3.length);
            i4 += bArr3.length;
        }
        if (bArr4 != null) {
            System.arraycopy(bArr4, 0, bArr6, i4, bArr4.length);
        }
        byte[] a2 = d.a(bArr6, bArr6.length, bArr5);
        this.UdN = a2.length;
        super.awj(this.Ucx);
        super.ak(a2, a2.length);
        super.hPB();
        byte[] hPx = super.hPx();
        AppMethodBeat.o(88113);
        return hPx;
    }
}
