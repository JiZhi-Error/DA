package com.google.android.exoplayer2.i;

import com.google.android.exoplayer2.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.nio.charset.Charset;

public final class m {
    public byte[] data;
    public int limit;
    public int position;

    public m() {
    }

    public m(int i2) {
        AppMethodBeat.i(93165);
        this.data = new byte[i2];
        this.limit = i2;
        AppMethodBeat.o(93165);
    }

    public m(byte[] bArr) {
        AppMethodBeat.i(93166);
        this.data = bArr;
        this.limit = bArr.length;
        AppMethodBeat.o(93166);
    }

    public m(byte[] bArr, int i2) {
        this.data = bArr;
        this.limit = i2;
    }

    public final void reset(int i2) {
        AppMethodBeat.i(93167);
        n(capacity() < i2 ? new byte[i2] : this.data, i2);
        AppMethodBeat.o(93167);
    }

    public final void n(byte[] bArr, int i2) {
        this.data = bArr;
        this.limit = i2;
        this.position = 0;
    }

    public final void reset() {
        this.position = 0;
        this.limit = 0;
    }

    public final int xd() {
        return this.limit - this.position;
    }

    public final void eY(int i2) {
        AppMethodBeat.i(93168);
        a.checkArgument(i2 >= 0 && i2 <= this.data.length);
        this.limit = i2;
        AppMethodBeat.o(93168);
    }

    public final int capacity() {
        if (this.data == null) {
            return 0;
        }
        return this.data.length;
    }

    public final void setPosition(int i2) {
        boolean z = true;
        AppMethodBeat.i(93169);
        if (i2 < 0 || i2 > this.limit) {
            b.i("ExoPlayer", "position%d, limit:%d", Integer.valueOf(i2), Integer.valueOf(this.limit));
        }
        if (i2 < 0 || i2 > this.limit) {
            z = false;
        }
        a.checkArgument(z);
        this.position = i2;
        AppMethodBeat.o(93169);
    }

    public final void eZ(int i2) {
        AppMethodBeat.i(93170);
        setPosition(this.position + i2);
        AppMethodBeat.o(93170);
    }

    public final void c(l lVar, int i2) {
        AppMethodBeat.i(93171);
        readBytes(lVar.data, 0, i2);
        lVar.setPosition(0);
        AppMethodBeat.o(93171);
    }

    public final void readBytes(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(93172);
        System.arraycopy(this.data, this.position, bArr, i2, i3);
        this.position += i3;
        AppMethodBeat.o(93172);
    }

    public final int readUnsignedByte() {
        byte[] bArr = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        return bArr[i2] & 255;
    }

    public final int readUnsignedShort() {
        byte[] bArr = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        return ((bArr[i2] & 255) << 8) | (bArr2[i3] & 255);
    }

    public final int xe() {
        byte[] bArr = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        return (bArr[i2] & 255) | ((bArr2[i3] & 255) << 8);
    }

    public final int xf() {
        byte[] bArr = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        int i4 = ((bArr[i2] & 255) << 16) | ((bArr2[i3] & 255) << 8);
        byte[] bArr3 = this.data;
        int i5 = this.position;
        this.position = i5 + 1;
        return i4 | (bArr3[i5] & 255);
    }

    public final long dE() {
        byte[] bArr = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        long j2 = ((((long) bArr[i2]) & 255) << 24) | ((((long) bArr2[i3]) & 255) << 16);
        byte[] bArr3 = this.data;
        int i4 = this.position;
        this.position = i4 + 1;
        long j3 = j2 | ((((long) bArr3[i4]) & 255) << 8);
        byte[] bArr4 = this.data;
        int i5 = this.position;
        this.position = i5 + 1;
        return j3 | (((long) bArr4[i5]) & 255);
    }

    public final long xg() {
        byte[] bArr = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        long j2 = (((long) bArr[i2]) & 255) | ((((long) bArr2[i3]) & 255) << 8);
        byte[] bArr3 = this.data;
        int i4 = this.position;
        this.position = i4 + 1;
        long j3 = j2 | ((((long) bArr3[i4]) & 255) << 16);
        byte[] bArr4 = this.data;
        int i5 = this.position;
        this.position = i5 + 1;
        return j3 | ((((long) bArr4[i5]) & 255) << 24);
    }

    public final int readInt() {
        byte[] bArr = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        int i4 = ((bArr[i2] & 255) << 24) | ((bArr2[i3] & 255) << 16);
        byte[] bArr3 = this.data;
        int i5 = this.position;
        this.position = i5 + 1;
        int i6 = i4 | ((bArr3[i5] & 255) << 8);
        byte[] bArr4 = this.data;
        int i7 = this.position;
        this.position = i7 + 1;
        return i6 | (bArr4[i7] & 255);
    }

    public final int xh() {
        byte[] bArr = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        int i4 = (bArr[i2] & 255) | ((bArr2[i3] & 255) << 8);
        byte[] bArr3 = this.data;
        int i5 = this.position;
        this.position = i5 + 1;
        int i6 = i4 | ((bArr3[i5] & 255) << 16);
        byte[] bArr4 = this.data;
        int i7 = this.position;
        this.position = i7 + 1;
        return i6 | ((bArr4[i7] & 255) << 24);
    }

    public final long readLong() {
        byte[] bArr = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        long j2 = ((((long) bArr[i2]) & 255) << 56) | ((((long) bArr2[i3]) & 255) << 48);
        byte[] bArr3 = this.data;
        int i4 = this.position;
        this.position = i4 + 1;
        long j3 = j2 | ((((long) bArr3[i4]) & 255) << 40);
        byte[] bArr4 = this.data;
        int i5 = this.position;
        this.position = i5 + 1;
        long j4 = j3 | ((((long) bArr4[i5]) & 255) << 32);
        byte[] bArr5 = this.data;
        int i6 = this.position;
        this.position = i6 + 1;
        long j5 = j4 | ((((long) bArr5[i6]) & 255) << 24);
        byte[] bArr6 = this.data;
        int i7 = this.position;
        this.position = i7 + 1;
        long j6 = j5 | ((((long) bArr6[i7]) & 255) << 16);
        byte[] bArr7 = this.data;
        int i8 = this.position;
        this.position = i8 + 1;
        long j7 = j6 | ((((long) bArr7[i8]) & 255) << 8);
        byte[] bArr8 = this.data;
        int i9 = this.position;
        this.position = i9 + 1;
        return j7 | (((long) bArr8[i9]) & 255);
    }

    public final long xi() {
        byte[] bArr = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        long j2 = (((long) bArr[i2]) & 255) | ((((long) bArr2[i3]) & 255) << 8);
        byte[] bArr3 = this.data;
        int i4 = this.position;
        this.position = i4 + 1;
        long j3 = j2 | ((((long) bArr3[i4]) & 255) << 16);
        byte[] bArr4 = this.data;
        int i5 = this.position;
        this.position = i5 + 1;
        long j4 = j3 | ((((long) bArr4[i5]) & 255) << 24);
        byte[] bArr5 = this.data;
        int i6 = this.position;
        this.position = i6 + 1;
        long j5 = j4 | ((((long) bArr5[i6]) & 255) << 32);
        byte[] bArr6 = this.data;
        int i7 = this.position;
        this.position = i7 + 1;
        long j6 = j5 | ((((long) bArr6[i7]) & 255) << 40);
        byte[] bArr7 = this.data;
        int i8 = this.position;
        this.position = i8 + 1;
        long j7 = j6 | ((((long) bArr7[i8]) & 255) << 48);
        byte[] bArr8 = this.data;
        int i9 = this.position;
        this.position = i9 + 1;
        return j7 | ((((long) bArr8[i9]) & 255) << 56);
    }

    public final int xj() {
        AppMethodBeat.i(93173);
        int readUnsignedByte = (readUnsignedByte() << 21) | (readUnsignedByte() << 14) | (readUnsignedByte() << 7) | readUnsignedByte();
        AppMethodBeat.o(93173);
        return readUnsignedByte;
    }

    public final int xk() {
        AppMethodBeat.i(93174);
        int readInt = readInt();
        if (readInt < 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Top bit not zero: ".concat(String.valueOf(readInt)));
            AppMethodBeat.o(93174);
            throw illegalStateException;
        }
        AppMethodBeat.o(93174);
        return readInt;
    }

    public final int xl() {
        AppMethodBeat.i(93175);
        int xh = xh();
        if (xh < 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Top bit not zero: ".concat(String.valueOf(xh)));
            AppMethodBeat.o(93175);
            throw illegalStateException;
        }
        AppMethodBeat.o(93175);
        return xh;
    }

    public final long xm() {
        AppMethodBeat.i(93176);
        long readLong = readLong();
        if (readLong < 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Top bit not zero: ".concat(String.valueOf(readLong)));
            AppMethodBeat.o(93176);
            throw illegalStateException;
        }
        AppMethodBeat.o(93176);
        return readLong;
    }

    public final String readString(int i2) {
        AppMethodBeat.i(93177);
        String a2 = a(i2, Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        AppMethodBeat.o(93177);
        return a2;
    }

    public final String a(int i2, Charset charset) {
        AppMethodBeat.i(93178);
        String str = new String(this.data, this.position, i2, charset);
        this.position += i2;
        AppMethodBeat.o(93178);
        return str;
    }

    public final String fa(int i2) {
        int i3;
        AppMethodBeat.i(93179);
        if (i2 == 0) {
            AppMethodBeat.o(93179);
            return "";
        }
        int i4 = (this.position + i2) - 1;
        if (i4 >= this.limit || this.data[i4] != 0) {
            i3 = i2;
        } else {
            i3 = i2 - 1;
        }
        String str = new String(this.data, this.position, i3);
        this.position += i2;
        AppMethodBeat.o(93179);
        return str;
    }

    public final String xn() {
        AppMethodBeat.i(93180);
        if (xd() == 0) {
            AppMethodBeat.o(93180);
            return null;
        }
        int i2 = this.position;
        while (i2 < this.limit && this.data[i2] != 0) {
            i2++;
        }
        String str = new String(this.data, this.position, i2 - this.position);
        this.position = i2;
        if (this.position < this.limit) {
            this.position++;
        }
        AppMethodBeat.o(93180);
        return str;
    }

    public final String readLine() {
        AppMethodBeat.i(93181);
        if (xd() == 0) {
            AppMethodBeat.o(93181);
            return null;
        }
        int i2 = this.position;
        while (i2 < this.limit && !x.fd(this.data[i2])) {
            i2++;
        }
        if (i2 - this.position >= 3 && this.data[this.position] == -17 && this.data[this.position + 1] == -69 && this.data[this.position + 2] == -65) {
            this.position += 3;
        }
        String str = new String(this.data, this.position, i2 - this.position);
        this.position = i2;
        if (this.position == this.limit) {
            AppMethodBeat.o(93181);
            return str;
        }
        if (this.data[this.position] == 13) {
            this.position++;
            if (this.position == this.limit) {
                AppMethodBeat.o(93181);
                return str;
            }
        }
        if (this.data[this.position] == 10) {
            this.position++;
        }
        AppMethodBeat.o(93181);
        return str;
    }
}
