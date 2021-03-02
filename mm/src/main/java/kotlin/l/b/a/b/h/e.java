package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.ArrayList;

public final class e {
    private final boolean TDt;
    private int TDu;
    private a TDv;
    int bNo;
    int bNp;
    private int bNq;
    private int bNt;
    private int bNv;
    private boolean bNw;
    private int bNx;
    final byte[] buffer;
    int bufferSize;
    int cbm;
    private final InputStream input;

    interface a {
    }

    public static e V(InputStream inputStream) {
        AppMethodBeat.i(59376);
        e eVar = new e(inputStream);
        AppMethodBeat.o(59376);
        return eVar;
    }

    static e a(p pVar) {
        AppMethodBeat.i(59377);
        e eVar = new e(pVar);
        try {
            eVar.fH(pVar.size());
            AppMethodBeat.o(59377);
            return eVar;
        } catch (k e2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(e2);
            AppMethodBeat.o(59377);
            throw illegalArgumentException;
        }
    }

    public final int yT() {
        AppMethodBeat.i(59378);
        if (eww()) {
            this.bNv = 0;
            AppMethodBeat.o(59378);
            return 0;
        }
        this.bNv = zi();
        if (z.gY(this.bNv) == 0) {
            k hJG = k.hJG();
            AppMethodBeat.o(59378);
            throw hJG;
        }
        int i2 = this.bNv;
        AppMethodBeat.o(59378);
        return i2;
    }

    public final void fF(int i2) {
        AppMethodBeat.i(59379);
        if (this.bNv != i2) {
            k hJH = k.hJH();
            AppMethodBeat.o(59379);
            throw hJH;
        }
        AppMethodBeat.o(59379);
    }

    public final boolean a(int i2, f fVar) {
        int yT;
        AppMethodBeat.i(59380);
        switch (z.gX(i2)) {
            case 0:
                long zl = zl();
                fVar.hc(i2);
                fVar.aJ(zl);
                AppMethodBeat.o(59380);
                return true;
            case 1:
                long zn = zn();
                fVar.hc(i2);
                fVar.Pj(zn);
                AppMethodBeat.o(59380);
                return true;
            case 2:
                d hJt = hJt();
                fVar.hc(i2);
                fVar.b(hJt);
                AppMethodBeat.o(59380);
                return true;
            case 3:
                fVar.hc(i2);
                do {
                    yT = yT();
                    if (yT != 0) {
                    }
                    int bA = z.bA(z.gY(i2), 4);
                    fF(bA);
                    fVar.hc(bA);
                    AppMethodBeat.o(59380);
                    return true;
                } while (a(yT, fVar));
                int bA2 = z.bA(z.gY(i2), 4);
                fF(bA2);
                fVar.hc(bA2);
                AppMethodBeat.o(59380);
                return true;
            case 4:
                AppMethodBeat.o(59380);
                return false;
            case 5:
                int zm = zm();
                fVar.hc(i2);
                fVar.avB(zm);
                AppMethodBeat.o(59380);
                return true;
            default:
                k hJI = k.hJI();
                AppMethodBeat.o(59380);
                throw hJI;
        }
    }

    public final boolean yZ() {
        AppMethodBeat.i(59381);
        if (zl() != 0) {
            AppMethodBeat.o(59381);
            return true;
        }
        AppMethodBeat.o(59381);
        return false;
    }

    public final <T extends q> T a(s<T> sVar, g gVar) {
        AppMethodBeat.i(59382);
        int zi = zi();
        if (this.bNo >= this.bNp) {
            k hJJ = k.hJJ();
            AppMethodBeat.o(59382);
            throw hJJ;
        }
        int fH = fH(zi);
        this.bNo++;
        T a2 = sVar.a(this, gVar);
        fF(0);
        this.bNo--;
        fI(fH);
        AppMethodBeat.o(59382);
        return a2;
    }

    public final d hJt() {
        AppMethodBeat.i(59383);
        int zi = zi();
        if (zi <= this.bufferSize - this.cbm && zi > 0) {
            d V = (!this.TDt || !this.bNw) ? d.V(this.buffer, this.cbm, zi) : new c(this.buffer, this.cbm, zi);
            this.cbm = zi + this.cbm;
            AppMethodBeat.o(59383);
            return V;
        } else if (zi == 0) {
            d dVar = d.TDp;
            AppMethodBeat.o(59383);
            return dVar;
        } else {
            p pVar = new p(avz(zi));
            AppMethodBeat.o(59383);
            return pVar;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008b, code lost:
        if (r3[r2] < 0) goto L_0x008d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zi() {
        /*
        // Method dump skipped, instructions count: 152
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.h.e.zi():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c5, code lost:
        if (((long) r4[r3]) < 0) goto L_0x00c7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zl() {
        /*
        // Method dump skipped, instructions count: 211
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.h.e.zl():long");
    }

    private long zj() {
        AppMethodBeat.i(59386);
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte zq = zq();
            j2 |= ((long) (zq & Byte.MAX_VALUE)) << i2;
            if ((zq & 128) == 0) {
                AppMethodBeat.o(59386);
                return j2;
            }
        }
        k hJF = k.hJF();
        AppMethodBeat.o(59386);
        throw hJF;
    }

    public final int zm() {
        AppMethodBeat.i(59387);
        int i2 = this.cbm;
        if (this.bufferSize - i2 < 4) {
            avx(4);
            i2 = this.cbm;
        }
        byte[] bArr = this.buffer;
        this.cbm = i2 + 4;
        int i3 = ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        AppMethodBeat.o(59387);
        return i3;
    }

    public final long zn() {
        AppMethodBeat.i(59388);
        int i2 = this.cbm;
        if (this.bufferSize - i2 < 8) {
            avx(8);
            i2 = this.cbm;
        }
        byte[] bArr = this.buffer;
        this.cbm = i2 + 8;
        long j2 = ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
        AppMethodBeat.o(59388);
        return j2;
    }

    public static long Ph(long j2) {
        return (j2 >>> 1) ^ (-(1 & j2));
    }

    private e(InputStream inputStream) {
        AppMethodBeat.i(59389);
        this.bNw = false;
        this.bNx = Integer.MAX_VALUE;
        this.bNp = 64;
        this.bNq = 67108864;
        this.TDv = null;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.cbm = 0;
        this.TDu = 0;
        this.input = inputStream;
        this.TDt = false;
        AppMethodBeat.o(59389);
    }

    private e(p pVar) {
        AppMethodBeat.i(59390);
        this.bNw = false;
        this.bNx = Integer.MAX_VALUE;
        this.bNp = 64;
        this.bNq = 67108864;
        this.TDv = null;
        this.buffer = pVar.zy;
        this.cbm = pVar.yR();
        this.bufferSize = this.cbm + pVar.size();
        this.TDu = -this.cbm;
        this.input = null;
        this.TDt = true;
        AppMethodBeat.o(59390);
    }

    public final int fH(int i2) {
        AppMethodBeat.i(59391);
        if (i2 < 0) {
            k hJE = k.hJE();
            AppMethodBeat.o(59391);
            throw hJE;
        }
        int i3 = this.TDu + this.cbm + i2;
        int i4 = this.bNx;
        if (i3 > i4) {
            k hJD = k.hJD();
            AppMethodBeat.o(59391);
            throw hJD;
        }
        this.bNx = i3;
        zo();
        AppMethodBeat.o(59391);
        return i4;
    }

    private void zo() {
        this.bufferSize += this.bNt;
        int i2 = this.TDu + this.bufferSize;
        if (i2 > this.bNx) {
            this.bNt = i2 - this.bNx;
            this.bufferSize -= this.bNt;
            return;
        }
        this.bNt = 0;
    }

    public final void fI(int i2) {
        AppMethodBeat.i(59392);
        this.bNx = i2;
        zo();
        AppMethodBeat.o(59392);
    }

    public final int zk() {
        if (this.bNx == Integer.MAX_VALUE) {
            return -1;
        }
        return this.bNx - (this.TDu + this.cbm);
    }

    private boolean eww() {
        AppMethodBeat.i(59393);
        if (this.cbm != this.bufferSize || avy(1)) {
            AppMethodBeat.o(59393);
            return false;
        }
        AppMethodBeat.o(59393);
        return true;
    }

    private void avx(int i2) {
        AppMethodBeat.i(59394);
        if (!avy(i2)) {
            k hJD = k.hJD();
            AppMethodBeat.o(59394);
            throw hJD;
        }
        AppMethodBeat.o(59394);
    }

    private boolean avy(int i2) {
        AppMethodBeat.i(59395);
        while (this.cbm + i2 > this.bufferSize) {
            if (this.TDu + this.cbm + i2 > this.bNx) {
                AppMethodBeat.o(59395);
                return false;
            }
            if (this.input != null) {
                int i3 = this.cbm;
                if (i3 > 0) {
                    if (this.bufferSize > i3) {
                        byte[] bArr = this.buffer;
                        System.arraycopy(bArr, i3, bArr, 0, this.bufferSize - i3);
                    }
                    this.TDu += i3;
                    this.bufferSize -= i3;
                    this.cbm = 0;
                }
                int read = this.input.read(this.buffer, this.bufferSize, this.buffer.length - this.bufferSize);
                if (read == 0 || read < -1 || read > this.buffer.length) {
                    IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(102).append("InputStream#read(byte[]) returned invalid result: ").append(read).append("\nThe InputStream implementation is buggy.").toString());
                    AppMethodBeat.o(59395);
                    throw illegalStateException;
                } else if (read > 0) {
                    this.bufferSize = read + this.bufferSize;
                    if ((this.TDu + i2) - this.bNq > 0) {
                        k hJK = k.hJK();
                        AppMethodBeat.o(59395);
                        throw hJK;
                    }
                    zo();
                    if (this.bufferSize >= i2) {
                        AppMethodBeat.o(59395);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(59395);
            return false;
        }
        IllegalStateException illegalStateException2 = new IllegalStateException(new StringBuilder(77).append("refillBuffer() called when ").append(i2).append(" bytes were already available in buffer").toString());
        AppMethodBeat.o(59395);
        throw illegalStateException2;
    }

    private byte zq() {
        AppMethodBeat.i(59396);
        if (this.cbm == this.bufferSize) {
            avx(1);
        }
        byte[] bArr = this.buffer;
        int i2 = this.cbm;
        this.cbm = i2 + 1;
        byte b2 = bArr[i2];
        AppMethodBeat.o(59396);
        return b2;
    }

    /* access modifiers changed from: package-private */
    public final byte[] avz(int i2) {
        AppMethodBeat.i(59397);
        if (i2 <= 0) {
            if (i2 == 0) {
                byte[] bArr = j.EMPTY_BYTE_ARRAY;
                AppMethodBeat.o(59397);
                return bArr;
            }
            k hJE = k.hJE();
            AppMethodBeat.o(59397);
            throw hJE;
        } else if (this.TDu + this.cbm + i2 > this.bNx) {
            fJ((this.bNx - this.TDu) - this.cbm);
            k hJD = k.hJD();
            AppMethodBeat.o(59397);
            throw hJD;
        } else if (i2 < 4096) {
            byte[] bArr2 = new byte[i2];
            int i3 = this.bufferSize - this.cbm;
            System.arraycopy(this.buffer, this.cbm, bArr2, 0, i3);
            this.cbm = this.bufferSize;
            int i4 = i2 - i3;
            if (this.bufferSize - this.cbm < i4) {
                avx(i4);
            }
            System.arraycopy(this.buffer, 0, bArr2, i3, i2 - i3);
            this.cbm = i2 - i3;
            AppMethodBeat.o(59397);
            return bArr2;
        } else {
            int i5 = this.cbm;
            int i6 = this.bufferSize;
            this.TDu += this.bufferSize;
            this.cbm = 0;
            this.bufferSize = 0;
            ArrayList<byte[]> arrayList = new ArrayList();
            int i7 = i2 - (i6 - i5);
            while (i7 > 0) {
                byte[] bArr3 = new byte[Math.min(i7, 4096)];
                int i8 = 0;
                while (i8 < bArr3.length) {
                    int read = this.input == null ? -1 : this.input.read(bArr3, i8, bArr3.length - i8);
                    if (read == -1) {
                        k hJD2 = k.hJD();
                        AppMethodBeat.o(59397);
                        throw hJD2;
                    }
                    this.TDu += read;
                    i8 += read;
                }
                arrayList.add(bArr3);
                i7 -= bArr3.length;
            }
            byte[] bArr4 = new byte[i2];
            int i9 = i6 - i5;
            System.arraycopy(this.buffer, i5, bArr4, 0, i9);
            for (byte[] bArr5 : arrayList) {
                System.arraycopy(bArr5, 0, bArr4, i9, bArr5.length);
                i9 = bArr5.length + i9;
            }
            AppMethodBeat.o(59397);
            return bArr4;
        }
    }

    private void fJ(int i2) {
        AppMethodBeat.i(59398);
        if (i2 > this.bufferSize - this.cbm || i2 < 0) {
            avA(i2);
            AppMethodBeat.o(59398);
            return;
        }
        this.cbm += i2;
        AppMethodBeat.o(59398);
    }

    private void avA(int i2) {
        AppMethodBeat.i(59399);
        if (i2 < 0) {
            k hJE = k.hJE();
            AppMethodBeat.o(59399);
            throw hJE;
        } else if (this.TDu + this.cbm + i2 > this.bNx) {
            fJ((this.bNx - this.TDu) - this.cbm);
            k hJD = k.hJD();
            AppMethodBeat.o(59399);
            throw hJD;
        } else {
            int i3 = this.bufferSize - this.cbm;
            this.cbm = this.bufferSize;
            avx(1);
            while (i2 - i3 > this.bufferSize) {
                i3 += this.bufferSize;
                this.cbm = this.bufferSize;
                avx(1);
            }
            this.cbm = i2 - i3;
            AppMethodBeat.o(59399);
        }
    }
}
