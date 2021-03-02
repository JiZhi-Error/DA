package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public class a {
    public int Ucl = 128;
    public int Ucm = 0;
    public byte[] Ucr = new byte[this.Ucl];
    public int Ucx = 0;
    int Udf = 0;
    public int Udg = 4;
    public int Udh = 0;

    public a() {
        AppMethodBeat.i(88120);
        AppMethodBeat.o(88120);
    }

    public final byte[] hPx() {
        AppMethodBeat.i(88121);
        byte[] bArr = new byte[this.Ucm];
        System.arraycopy(this.Ucr, 0, bArr, 0, this.Ucm);
        AppMethodBeat.o(88121);
        return bArr;
    }

    public final byte[] hPA() {
        AppMethodBeat.i(88122);
        byte[] bArr = new byte[this.Udh];
        System.arraycopy(this.Ucr, this.Udg, bArr, 0, this.Udh);
        AppMethodBeat.o(88122);
        return bArr;
    }

    private void ad(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(88123);
        if (i3 > this.Ucl) {
            this.Ucl = i3 + 128;
            this.Ucr = new byte[this.Ucl];
        }
        this.Ucm = i3;
        System.arraycopy(bArr, i2, this.Ucr, 0, i3);
        this.Ucx = util.an(bArr, i2);
        this.Udh = i3 - this.Udg;
        AppMethodBeat.o(88123);
    }

    public final void awj(int i2) {
        AppMethodBeat.i(88124);
        util.ah(this.Ucr, this.Ucm, i2);
        this.Ucm += 2;
        util.ah(this.Ucr, this.Ucm, 0);
        this.Ucm += 2;
        AppMethodBeat.o(88124);
    }

    public final void hPB() {
        AppMethodBeat.i(88125);
        util.ah(this.Ucr, 2, this.Ucm - this.Udg);
        AppMethodBeat.o(88125);
    }

    public final void ak(byte[] bArr, int i2) {
        AppMethodBeat.i(88126);
        if (i2 > this.Ucl - this.Udg) {
            this.Ucl = this.Udg + i2 + 64;
            byte[] bArr2 = new byte[this.Ucl];
            System.arraycopy(this.Ucr, 0, bArr2, 0, this.Ucm);
            this.Ucr = bArr2;
        }
        this.Udh = i2;
        System.arraycopy(bArr, 0, this.Ucr, this.Ucm, i2);
        this.Ucm += i2;
        AppMethodBeat.o(88126);
    }

    private static int ae(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(88127);
        int length = bArr.length;
        int i4 = i2;
        while (true) {
            if (i4 < length && i4 + 2 <= length) {
                if (util.an(bArr, i4) == i3) {
                    break;
                }
                int i5 = i4 + 2;
                if (i5 + 2 > length) {
                    break;
                }
                i4 = i5 + util.an(bArr, i5) + 2;
            } else {
                break;
            }
        }
        i4 = -1;
        AppMethodBeat.o(88127);
        return i4;
    }

    public final int af(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(88128);
        int ae = ae(bArr, i2, this.Ucx);
        if (ae < 0) {
            AppMethodBeat.o(88128);
            return -1;
        }
        int i4 = i3 - (ae - i2);
        if (this.Udg >= i4) {
            AppMethodBeat.o(88128);
            return -1;
        }
        this.Udh = util.an(bArr, ae + 2);
        if (this.Udg + this.Udh > i4) {
            AppMethodBeat.o(88128);
            return -1;
        }
        ad(bArr, ae, this.Udg + this.Udh);
        if (!hPC().booleanValue()) {
            AppMethodBeat.o(88128);
            return -1005;
        }
        int i5 = this.Udg + ae + this.Udh;
        AppMethodBeat.o(88128);
        return i5;
    }

    private int d(byte[] bArr, int i2, byte[] bArr2) {
        AppMethodBeat.i(88129);
        if (this.Udg >= i2) {
            AppMethodBeat.o(88129);
            return -1;
        }
        this.Udh = util.an(bArr, 2);
        if (this.Udg + this.Udh > i2) {
            AppMethodBeat.o(88129);
            return -1;
        }
        byte[] decrypt = d.decrypt(bArr, this.Udg, this.Udh, bArr2);
        if (decrypt == null) {
            AppMethodBeat.o(88129);
            return -1015;
        }
        if (this.Udg + decrypt.length > this.Ucl) {
            this.Ucl = this.Udg + decrypt.length;
            this.Ucr = new byte[this.Ucl];
        }
        this.Ucm = 0;
        System.arraycopy(bArr, 0, this.Ucr, 0, this.Udg);
        this.Ucm += this.Udg;
        System.arraycopy(decrypt, 0, this.Ucr, this.Ucm, decrypt.length);
        this.Ucm += decrypt.length;
        this.Udh = decrypt.length;
        if (!hPC().booleanValue()) {
            AppMethodBeat.o(88129);
            return -1005;
        }
        AppMethodBeat.o(88129);
        return 0;
    }

    public final int c(byte[] bArr, int i2, int i3, byte[] bArr2) {
        AppMethodBeat.i(88130);
        int ae = ae(bArr, i2, this.Ucx);
        if (ae < 0) {
            AppMethodBeat.o(88130);
            return -1;
        }
        int i4 = i3 - (ae - i2);
        byte[] bArr3 = new byte[i4];
        System.arraycopy(bArr, ae, bArr3, 0, i4);
        int d2 = d(bArr3, i4, bArr2);
        AppMethodBeat.o(88130);
        return d2;
    }

    public Boolean hPC() {
        return Boolean.TRUE;
    }
}
