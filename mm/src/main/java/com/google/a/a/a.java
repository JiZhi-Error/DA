package com.google.a.a;

import com.tencent.mm.sdk.system.MimeTypeUtil;

public final class a {
    private int bNo;
    private int bNp = 64;
    private int bNq = 67108864;
    private int bNt;
    private int bNv;
    private int bNx = Integer.MAX_VALUE;
    private final byte[] buffer;
    private int bufferSize;
    private int cbl;
    private int cbm;

    public final int yT() {
        boolean z;
        if (this.cbm == this.bufferSize) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.bNv = 0;
            return 0;
        }
        this.bNv = zi();
        if (this.bNv != 0) {
            return this.bNv;
        }
        throw d.Ib();
    }

    public final void fF(int i2) {
        if (this.bNv != i2) {
            throw d.Ic();
        }
    }

    public final boolean fG(int i2) {
        int yT;
        switch (g.gX(i2)) {
            case 0:
                zi();
                return true;
            case 1:
                zq();
                zq();
                zq();
                zq();
                zq();
                zq();
                zq();
                zq();
                return true;
            case 2:
                fJ(zi());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zq();
                zq();
                zq();
                zq();
                return true;
            default:
                throw d.Id();
        }
        do {
            yT = yT();
            if (yT != 0) {
            }
            fF(g.bA(g.gY(i2), 4));
            return true;
        } while (fG(yT));
        fF(g.bA(g.gY(i2), 4));
        return true;
    }

    public final String readString() {
        int zi = zi();
        if (zi > this.bufferSize - this.cbm || zi <= 0) {
            return new String(ha(zi), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        }
        String str = new String(this.buffer, this.cbm, zi, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        this.cbm = zi + this.cbm;
        return str;
    }

    public final void a(e eVar) {
        int zi = zi();
        if (this.bNo >= this.bNp) {
            throw d.Ie();
        }
        int fH = fH(zi);
        this.bNo++;
        eVar.a(this);
        fF(0);
        this.bNo--;
        fI(fH);
    }

    public final byte[] readBytes() {
        int zi = zi();
        if (zi > this.bufferSize - this.cbm || zi <= 0) {
            return ha(zi);
        }
        byte[] bArr = new byte[zi];
        System.arraycopy(this.buffer, this.cbm, bArr, 0, zi);
        this.cbm = zi + this.cbm;
        return bArr;
    }

    public final int zi() {
        byte zq = zq();
        if (zq >= 0) {
            return zq;
        }
        int i2 = zq & Byte.MAX_VALUE;
        byte zq2 = zq();
        if (zq2 >= 0) {
            return i2 | (zq2 << 7);
        }
        int i3 = i2 | ((zq2 & Byte.MAX_VALUE) << 7);
        byte zq3 = zq();
        if (zq3 >= 0) {
            return i3 | (zq3 << 14);
        }
        int i4 = i3 | ((zq3 & Byte.MAX_VALUE) << 14);
        byte zq4 = zq();
        if (zq4 >= 0) {
            return i4 | (zq4 << 21);
        }
        int i5 = i4 | ((zq4 & Byte.MAX_VALUE) << 21);
        byte zq5 = zq();
        int i6 = i5 | (zq5 << 28);
        if (zq5 >= 0) {
            return i6;
        }
        for (int i7 = 0; i7 < 5; i7++) {
            if (zq() >= 0) {
                return i6;
            }
        }
        throw d.Ia();
    }

    public final long zl() {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte zq = zq();
            j2 |= ((long) (zq & Byte.MAX_VALUE)) << i2;
            if ((zq & 128) == 0) {
                return j2;
            }
        }
        throw d.Ia();
    }

    a(byte[] bArr, int i2) {
        this.buffer = bArr;
        this.cbl = 0;
        this.bufferSize = i2 + 0;
        this.cbm = 0;
    }

    public final int fH(int i2) {
        if (i2 < 0) {
            throw d.HZ();
        }
        int i3 = this.cbm + i2;
        int i4 = this.bNx;
        if (i3 > i4) {
            throw d.HY();
        }
        this.bNx = i3;
        zo();
        return i4;
    }

    private void zo() {
        this.bufferSize += this.bNt;
        int i2 = this.bufferSize;
        if (i2 > this.bNx) {
            this.bNt = i2 - this.bNx;
            this.bufferSize -= this.bNt;
            return;
        }
        this.bNt = 0;
    }

    public final void fI(int i2) {
        this.bNx = i2;
        zo();
    }

    public final int zk() {
        if (this.bNx == Integer.MAX_VALUE) {
            return -1;
        }
        return this.bNx - this.cbm;
    }

    public final int getPosition() {
        return this.cbm - this.cbl;
    }

    public final void gZ(int i2) {
        if (i2 > this.cbm - this.cbl) {
            throw new IllegalArgumentException("Position " + i2 + " is beyond current " + (this.cbm - this.cbl));
        } else if (i2 < 0) {
            throw new IllegalArgumentException("Bad position ".concat(String.valueOf(i2)));
        } else {
            this.cbm = this.cbl + i2;
        }
    }

    private byte zq() {
        if (this.cbm == this.bufferSize) {
            throw d.HY();
        }
        byte[] bArr = this.buffer;
        int i2 = this.cbm;
        this.cbm = i2 + 1;
        return bArr[i2];
    }

    private byte[] ha(int i2) {
        if (i2 < 0) {
            throw d.HZ();
        } else if (this.cbm + i2 > this.bNx) {
            fJ(this.bNx - this.cbm);
            throw d.HY();
        } else if (i2 <= this.bufferSize - this.cbm) {
            byte[] bArr = new byte[i2];
            System.arraycopy(this.buffer, this.cbm, bArr, 0, i2);
            this.cbm += i2;
            return bArr;
        } else {
            throw d.HY();
        }
    }

    private void fJ(int i2) {
        if (i2 < 0) {
            throw d.HZ();
        } else if (this.cbm + i2 > this.bNx) {
            fJ(this.bNx - this.cbm);
            throw d.HY();
        } else if (i2 <= this.bufferSize - this.cbm) {
            this.cbm += i2;
        } else {
            throw d.HY();
        }
    }
}
