package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.l;
import oicq.wlogin_sdk.tools.util;

public final class y extends a {
    int UdE = 0;

    public y() {
        this.Ucx = l.CTRL_INDEX;
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

    public final byte[] a(byte[] bArr, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        AppMethodBeat.i(88112);
        int al = al(bArr, 16);
        int al2 = al(bArr2, 16);
        int al3 = al(bArr3, 16);
        int al4 = al(bArr4, 32);
        int al5 = al(bArr5, 16);
        this.UdE = al + 2 + 2 + al2 + 2 + 2 + al3 + 2 + al4 + 2 + al5;
        byte[] bArr6 = new byte[this.UdE];
        util.ah(bArr6, 0, al);
        System.arraycopy(bArr, 0, bArr6, 2, al);
        int i3 = al + 2;
        util.ah(bArr6, i3, al2);
        int i4 = i3 + 2;
        System.arraycopy(bArr2, 0, bArr6, i4, al2);
        int i5 = i4 + al2;
        util.ah(bArr6, i5, i2);
        int i6 = i5 + 2;
        util.ah(bArr6, i6, al3);
        int i7 = i6 + 2;
        System.arraycopy(bArr3, 0, bArr6, i7, al3);
        int i8 = i7 + al3;
        util.ah(bArr6, i8, al4);
        int i9 = i8 + 2;
        System.arraycopy(bArr4, 0, bArr6, i9, al4);
        int i10 = i9 + al4;
        util.ah(bArr6, i10, al5);
        System.arraycopy(bArr5, 0, bArr6, i10 + 2, al5);
        super.awj(this.Ucx);
        super.ak(bArr6, this.UdE);
        super.hPB();
        byte[] hPx = super.hPx();
        AppMethodBeat.o(88112);
        return hPx;
    }
}
