package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public final class h extends a {
    int Udv = 1;
    int Udw = 1;
    int Udx = 69;

    public h() {
        AppMethodBeat.i(88135);
        this.Ucx = 262;
        this.Udw = util.Ues;
        if (util.Ues <= 2) {
            this.Udv = 1;
            this.Udx = 69;
            AppMethodBeat.o(88135);
            return;
        }
        this.Udv = 2;
        this.Udx = 90;
        AppMethodBeat.o(88135);
    }

    public final byte[] a(long j2, int i2, long j3, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i3, byte[] bArr5) {
        AppMethodBeat.i(209829);
        if (util.Ues <= 2) {
            byte[] bArr6 = new byte[this.Udx];
            util.ah(bArr6, 0, this.Udv);
            util.ai(bArr6, 2, util.hPI());
            util.ai(bArr6, 6, this.Udw);
            util.ai(bArr6, 10, 522017402);
            util.ai(bArr6, 14, i2);
            util.c(bArr6, 18, j3);
            System.arraycopy(bArr, 0, bArr6, 26, bArr.length);
            int length = bArr.length + 26;
            System.arraycopy(bArr2, 0, bArr6, length, bArr2.length);
            int length2 = length + bArr2.length;
            util.ag(bArr6, length2, 1);
            int i4 = length2 + 1;
            System.arraycopy(bArr3, 0, bArr6, i4, bArr3.length);
            System.arraycopy(bArr4, 0, bArr6, i4 + bArr3.length, bArr4.length);
            byte[] bArr7 = new byte[24];
            System.arraycopy(bArr3, 0, bArr7, 0, bArr3.length);
            util.c(bArr7, 16, j3);
            byte[] a2 = d.a(bArr6, bArr6.length, c.du(bArr7));
            this.Udx = a2.length;
            super.awj(this.Ucx);
            super.ak(a2, this.Udx);
            super.hPB();
            byte[] hPx = super.hPx();
            AppMethodBeat.o(209829);
            return hPx;
        }
        byte[] bArr8 = new byte[this.Udx];
        util.ah(bArr8, 0, this.Udv);
        util.ai(bArr8, 2, util.hPI());
        util.ai(bArr8, 6, this.Udw);
        util.ai(bArr8, 10, 522017402);
        util.ai(bArr8, 14, i2);
        util.c(bArr8, 18, j3);
        System.arraycopy(bArr, 0, bArr8, 26, bArr.length);
        int length3 = bArr.length + 26;
        System.arraycopy(bArr2, 0, bArr8, length3, bArr2.length);
        int length4 = length3 + bArr2.length;
        util.ag(bArr8, length4, 1);
        int i5 = length4 + 1;
        System.arraycopy(bArr3, 0, bArr8, i5, bArr3.length);
        int length5 = i5 + bArr3.length;
        System.arraycopy(bArr4, 0, bArr8, length5, bArr4.length);
        int length6 = length5 + bArr4.length;
        util.ai(bArr8, length6, 0);
        int i6 = length6 + 4;
        util.ag(bArr8, i6, i3);
        int i7 = i6 + 1;
        if (bArr5 == null || bArr5.length <= 0) {
            byte[] bArr9 = new byte[16];
            util.ai(bArr9, 0, util.hPI());
            util.ai(bArr9, 4, util.hPI());
            util.ai(bArr9, 8, util.hPI());
            util.ai(bArr9, 12, util.hPI());
        } else {
            System.arraycopy(bArr5, 0, bArr8, i7, bArr5.length);
        }
        byte[] bArr10 = new byte[24];
        System.arraycopy(bArr3, 0, bArr10, 0, bArr3.length);
        util.c(bArr10, 16, j3);
        byte[] a3 = d.a(bArr8, bArr8.length, c.du(bArr10));
        this.Udx = a3.length;
        super.awj(this.Ucx);
        super.ak(a3, this.Udx);
        super.hPB();
        byte[] hPx2 = hPx();
        AppMethodBeat.o(209829);
        return hPx2;
    }
}
